package com.contacts.activity;

import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetContactActivity_Factory implements Factory<GetContactActivity> {
  private final Provider<ContactDao> contactDaoProvider;

  public GetContactActivity_Factory(Provider<ContactDao> contactDaoProvider) {
    assert contactDaoProvider != null;
    this.contactDaoProvider = contactDaoProvider;
  }

  @Override
  public GetContactActivity get() {
    return new GetContactActivity(contactDaoProvider.get());
  }

  public static Factory<GetContactActivity> create(Provider<ContactDao> contactDaoProvider) {
    return new GetContactActivity_Factory(contactDaoProvider);
  }
}
