package com.contacts.dependency;

import com.contacts.activity.*;
import com.contacts.dao.ContactDao;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { MapperModule.class, DaoM.class })
public interface ServiceComponent {
    AddContactActivity provideAddContactActivity();
    DeleteContactActivity provideDeleteContactActivity();
    GetContactActivity provideGetContactActivity();
    GetContactsActivity provideGetContactsActivity();
    UpdateContactActivity provideUpdateContactActivity();
    ContactDao provideContactDao();
}

