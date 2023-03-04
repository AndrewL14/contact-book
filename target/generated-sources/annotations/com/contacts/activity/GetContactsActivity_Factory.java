package com.contacts.activity;

import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetContactsActivity_Factory implements Factory<GetContactsActivity> {
  private final Provider<ContactDao> contactDaoProvider;

  public GetContactsActivity_Factory(Provider<ContactDao> contactDaoProvider) {
    assert contactDaoProvider != null;
    this.contactDaoProvider = contactDaoProvider;
  }

  @Override
  public GetContactsActivity get() {
    return new GetContactsActivity(contactDaoProvider.get());
  }

  public static Factory<GetContactsActivity> create(Provider<ContactDao> contactDaoProvider) {
    return new GetContactsActivity_Factory(contactDaoProvider);
  }
}
