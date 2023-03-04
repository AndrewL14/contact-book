package com.contacts.activity;

import com.contacts.converter.ModelConverter;
import com.contacts.dao.ContactDao;
import com.contacts.model.Contact;
import com.contacts.model.requests.GetContactsRequest;
import com.contacts.model.responses.GetContactsResponse;

import javax.inject.Inject;
import java.util.SortedMap;
import java.util.TreeMap;

public class GetContactsActivity {
    private final ContactDao contactDao;

    @Inject
    public GetContactsActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public GetContactsResponse execute(GetContactsRequest request) {
        SortedMap<String, Contact> contacts = new TreeMap<>();
        if (request.isRun()) {
            contacts = contactDao.getAllContacts();
        }


        return new GetContactsResponse.Builder()
                .withContacts(ModelConverter.toSortedContactModels(contacts))
                .build();
    }
}
