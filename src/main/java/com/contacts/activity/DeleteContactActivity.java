package com.contacts.activity;

import com.contacts.dao.ContactDao;
import com.contacts.model.requests.DeleteContactRequest;
import com.contacts.model.responses.DeleteContactResponse;

import javax.inject.Inject;

public class DeleteContactActivity {
    private final ContactDao contactDao;

    @Inject
    public DeleteContactActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public DeleteContactResponse execute(DeleteContactRequest request) {
        contactDao.deleteContact(request.getFirstName(), request.getLastName());
        return new DeleteContactResponse();
    }
}
