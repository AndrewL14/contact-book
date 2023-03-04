package com.contacts.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.contacts.dao.ContactDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoM {

    @Provides
    @Singleton
    public ContactDao provideContactDao(DynamoDBMapper provideDynamoDBMapper) {
        return new ContactDao(provideDynamoDBMapper);
    }
}
