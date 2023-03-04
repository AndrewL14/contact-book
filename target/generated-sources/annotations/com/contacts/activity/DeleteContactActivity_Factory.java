package com.contacts.activity;

import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DeleteContactActivity_Factory implements Factory<DeleteContactActivity> {
  private final Provider<ContactDao> contactDaoProvider;

  public DeleteContactActivity_Factory(Provider<ContactDao> contactDaoProvider) {
    assert contactDaoProvider != null;
    this.contactDaoProvider = contactDaoProvider;
  }

  @Override
  public DeleteContactActivity get() {
    return new DeleteContactActivity(contactDaoProvider.get());
  }

  public static Factory<DeleteContactActivity> create(Provider<ContactDao> contactDaoProvider) {
    return new DeleteContactActivity_Factory(contactDaoProvider);
  }
}
