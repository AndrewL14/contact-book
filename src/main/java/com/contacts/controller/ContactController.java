package com.contacts.controller;

import com.contacts.ContactBookApplication;
import com.contacts.activity.*;
import com.contacts.activity.validator.ContactValidator;
import com.contacts.dependency.ServiceComponent;
import com.contacts.exception.InvalidContactFormatException;
import com.contacts.model.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    private static final ServiceComponent component = ContactBookApplication.component;

    @PutMapping(value="/add/contact", produces = {"application/json"})
    public ResponseEntity<?> addContactProvider(@RequestBody AddContactRequest request) throws InvalidContactFormatException {
        if (ContactValidator.isValidPhoneNumber(request.getPhoneNumber())) {
            throw new InvalidContactFormatException("Invalid phone number format: " + request.getPhoneNumber());
        }
        if (ContactValidator.isValidEmail(request.getEmail())) {
            throw new InvalidContactFormatException("Invalid email format: " + request.getEmail());
        }
        AddContactActivity contactActivity = component.provideAddContactActivity();

        return new ResponseEntity<>(contactActivity.execute(request), HttpStatus.OK);
    }

    @PutMapping(value = "/update/contact", produces = {"application/json"})
    public ResponseEntity<?> UpdateContactProvider(@RequestBody UpdateContactRequest request) throws InvalidContactFormatException {
        if (ContactValidator.isValidPhoneNumber(request.getPhoneNumber())) {
            throw new InvalidContactFormatException("Invalid phone number format: " + request.getPhoneNumber());
        }
        if (ContactValidator.isValidEmail(request.getEmail())) {
            throw new InvalidContactFormatException("Invalid email format: " + request.getEmail());
        }
        UpdateContactActivity contactActivity = component.provideUpdateContactActivity();

        return new ResponseEntity<>(contactActivity.execute(request), HttpStatus.OK);
    }

    //temporarily changing the params to Strings to test
    @GetMapping(value = "/get/contacts", produces = {"application/json"})
    public ResponseEntity<?> getContactsProvider() {
        GetContactsActivity contactsActivity = component.provideGetContactsActivity();
        GetContactsRequest request = new GetContactsRequest.Builder()
                .withRun(true)
                .build();
        return new ResponseEntity<>(contactsActivity.execute(request) , HttpStatus.OK);
    }

    @GetMapping(value = "/get/contact", produces = {"application/json"})
    public ResponseEntity<?> getContact(@RequestBody GetContactRequest request) {
        GetContactActivity contactActivity = component.provideGetContactActivity();

        return new ResponseEntity<>(contactActivity.execute(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/contact")
    public ResponseEntity<?> deleteContact(@RequestParam  String firstName, String lastName) {
        DeleteContactActivity contactActivity = component.provideDeleteContactActivity();
        DeleteContactRequest request = DeleteContactRequest.builder()
                .withFirstName(firstName)
                .withLastname(lastName)
                .build();
        contactActivity.execute(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
