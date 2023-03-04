package com.contacts.activity;

import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateContactActivity_Factory implements Factory<UpdateContactActivity> {
  private final Provider<ContactDao> contactDaoProvider;

  public UpdateContactActivity_Factory(Provider<ContactDao> contactDaoProvider) {
    assert contactDaoProvider != null;
    this.contactDaoProvider = contactDaoProvider;
  }

  @Override
  public UpdateContactActivity get() {
    return new UpdateContactActivity(contactDaoProvider.get());
  }

  public static Factory<UpdateContactActivity> create(Provider<ContactDao> contactDaoProvider) {
    return new UpdateContactActivity_Factory(contactDaoProvider);
  }
}
