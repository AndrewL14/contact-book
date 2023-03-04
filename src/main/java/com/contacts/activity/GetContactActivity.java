package com.contacts.activity;

import com.contacts.converter.ModelConverter;
import com.contacts.dao.ContactDao;
import com.contacts.model.Contact;
import com.contacts.model.requests.GetContactRequest;
import com.contacts.model.responses.GetContactResponse;

import javax.inject.Inject;

public class GetContactActivity {
    private final ContactDao contactDao;

    @Inject
    public GetContactActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public GetContactResponse execute(GetContactRequest request) {
        Contact contact = contactDao.getContact(request.getFirstName(), request.getLastName());

        return new GetContactResponse.Builder()
                .withContactModel(ModelConverter.toContactModel(contact))
                .build();
    }
}
