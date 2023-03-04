package com.contacts.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.contacts.dao.ContactDao;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaoM_ProvideContactDaoFactory implements Factory<ContactDao> {
  private final DaoM module;

  private final Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  public DaoM_ProvideContactDaoFactory(
      DaoM module, Provider<DynamoDBMapper> provideDynamoDBMapperProvider) {
    assert module != null;
    this.module = module;
    assert provideDynamoDBMapperProvider != null;
    this.provideDynamoDBMapperProvider = provideDynamoDBMapperProvider;
  }

  @Override
  public ContactDao get() {
    return Preconditions.checkNotNull(
        module.provideContactDao(provideDynamoDBMapperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ContactDao> create(
      DaoM module, Provider<DynamoDBMapper> provideDynamoDBMapperProvider) {
    return new DaoM_ProvideContactDaoFactory(module, provideDynamoDBMapperProvider);
  }
}
