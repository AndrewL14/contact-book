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
        contactDao.deleteContact(request.getOldFirstName() , request.getOldLastName());
        //TODO create Exception
        Contact newContact = new Contact();

        newContact.setFirstName(request.getNewFirstName().orElse(request.getOldFirstName()));
        newContact.setLastName(request.getNewLastName().orElse(request.getOldLastName()));
        newContact.setPhoneNumber(request.getPhoneNumber());
        newContact.setEmail(request.getEmail());
        contactDao.saveContact(newContact);

        return new UpdateContactResponse.Builder()
                .withContactModel(ModelConverter.toContactModel(newContact))
                .build();
    }
}
