package com.contacts.activity;

import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AddContactActivity_Factory implements Factory<AddContactActivity> {
  private final Provider<ContactDao> contactDaoProvider;

  public AddContactActivity_Factory(Provider<ContactDao> contactDaoProvider) {
    assert contactDaoProvider != null;
    this.contactDaoProvider = contactDaoProvider;
  }

  @Override
  public AddContactActivity get() {
    return new AddContactActivity(contactDaoProvider.get());
  }

  public static Factory<AddContactActivity> create(Provider<ContactDao> contactDaoProvider) {
    return new AddContactActivity_Factory(contactDaoProvider);
  }
}
