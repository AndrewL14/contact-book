package com.contacts.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.contacts.activity.AddContactActivity;
import com.contacts.activity.AddContactActivity_Factory;
import com.contacts.activity.DeleteContactActivity;
import com.contacts.activity.DeleteContactActivity_Factory;
import com.contacts.activity.GetContactActivity;
import com.contacts.activity.GetContactActivity_Factory;
import com.contacts.activity.GetContactsActivity;
import com.contacts.activity.GetContactsActivity_Factory;
import com.contacts.activity.UpdateContactActivity;
import com.contacts.activity.UpdateContactActivity_Factory;
import com.contacts.dao.ContactDao;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerServiceComponent implements ServiceComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private Provider<ContactDao> provideContactDaoProvider;

  private Provider<AddContactActivity> addContactActivityProvider;

  private Provider<DeleteContactActivity> deleteContactActivityProvider;

  private Provider<GetContactActivity> getContactActivityProvider;

  private Provider<GetContactsActivity> getContactsActivityProvider;

  private Provider<UpdateContactActivity> updateContactActivityProvider;

  private DaggerServiceComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ServiceComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(
            MapperModule_ProvideDynamoDBMapperFactory.create(builder.mapperModule));

    this.provideContactDaoProvider =
        DoubleCheck.provider(
            DaoM_ProvideContactDaoFactory.create(builder.daoM, provideDynamoDBMapperProvider));

    this.addContactActivityProvider = AddContactActivity_Factory.create(provideContactDaoProvider);

    this.deleteContactActivityProvider =
        DeleteContactActivity_Factory.create(provideContactDaoProvider);

    this.getContactActivityProvider = GetContactActivity_Factory.create(provideContactDaoProvider);

    this.getContactsActivityProvider =
        GetContactsActivity_Factory.create(provideContactDaoProvider);

    this.updateContactActivityProvider =
        UpdateContactActivity_Factory.create(provideContactDaoProvider);
  }

  @Override
  public AddContactActivity provideAddContactActivity() {
    return new AddContactActivity(provideContactDaoProvider.get());
  }

  @Override
  public DeleteContactActivity provideDeleteContactActivity() {
    return new DeleteContactActivity(provideContactDaoProvider.get());
  }

  @Override
  public GetContactActivity provideGetContactActivity() {
    return new GetContactActivity(provideContactDaoProvider.get());
  }

  @Override
  public GetContactsActivity provideGetContactsActivity() {
    return new GetContactsActivity(provideContactDaoProvider.get());
  }

  @Override
  public UpdateContactActivity provideUpdateContactActivity() {
    return new UpdateContactActivity(provideContactDaoProvider.get());
  }

  @Override
  public ContactDao provideContactDao() {
    return provideContactDaoProvider.get();
  }

  public static final class Builder {
    private MapperModule mapperModule;

    private DaoM daoM;

    private Builder() {}

    public ServiceComponent build() {
      if (mapperModule == null) {
        this.mapperModule = new MapperModule();
      }
      if (daoM == null) {
        this.daoM = new DaoM();
      }
      return new DaggerServiceComponent(this);
    }

    public Builder mapperModule(MapperModule mapperModule) {
      this.mapperModule = Preconditions.checkNotNull(mapperModule);
      return this;
    }

    public Builder daoM(DaoM daoM) {
      this.daoM = Preconditions.checkNotNull(daoM);
      return this;
    }
  }
}
