package com.contacts.activity;

import com.contacts.converter.ModelConverter;
import com.contacts.dao.ContactDao;
import com.contacts.model.Contact;
import com.contacts.model.requests.UpdateContactRequest;
import com.contacts.model.responses.UpdateContactResponse;

import javax.inject.Inject;

public class UpdateContactActivity {

    private final ContactDao contactDao;

    @Inject
    public UpdateContactActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public UpdateContactResponse execute(UpdateContactRequest request) {
        Contact contact = contactDao.getContact(request.getOldFirstName(), request.getOldLastName());
        //TODO create Exception
        contact.setFirstName(request.getNewFirstName().orElse(contact.getFirstName()));
        contact.setLastName(request.getNewLastName().orElse(contact.getFirstName()));
        contact.setPhoneNumber(request.getPhoneNumber().orElse(contact.getPhoneNumber()));
        contact.setEmail(request.getEmail().orElse(contact.getEmail()));

        contactDao.saveContact(contact);

        return new UpdateContactResponse.Builder()
                .withContactModel(ModelConverter.toContactModel(contact))
                .build();
    }
}
