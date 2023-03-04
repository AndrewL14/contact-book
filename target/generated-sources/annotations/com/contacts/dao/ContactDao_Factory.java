package com.contacts.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ContactDao_Factory implements Factory<ContactDao> {
  private final Provider<DynamoDBMapper> mapperProvider;

  public ContactDao_Factory(Provider<DynamoDBMapper> mapperProvider) {
    assert mapperProvider != null;
    this.mapperProvider = mapperProvider;
  }

  @Override
  public ContactDao get() {
    return new ContactDao(mapperProvider.get());
  }

  public static Factory<ContactDao> create(Provider<DynamoDBMapper> mapperProvider) {
    return new ContactDao_Factory(mapperProvider);
  }
}
