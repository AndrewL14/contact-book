package com.contacts.activity;

import com.contacts.activity.validator.ContactValidator;
import com.contacts.converter.ModelConverter;
import com.contacts.dao.ContactDao;
import com.contacts.exception.InvalidContactFormatException;
import com.contacts.model.Contact;
import com.contacts.model.requests.AddContactRequest;
import com.contacts.model.responses.AddContactResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import javax.inject.Inject;

public class AddContactActivity {
    private final ContactDao contactDao;

    @Inject
    public AddContactActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public AddContactResponse execute(AddContactRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setEmail(request.getEmail());

        contactDao.saveContact(contact);

        return new AddContactResponse.Builder()
                .withContactModel(ModelConverter.toContactModel(contact))
                .build();
    }
}
