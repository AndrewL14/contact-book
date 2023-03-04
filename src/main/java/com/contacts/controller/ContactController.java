package com.contacts.controller;

import com.contacts.ContactBookApplication;
import com.contacts.activity.*;
import com.contacts.dependency.ServiceComponent;
import com.contacts.model.requests.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    private static final ServiceComponent component = ContactBookApplication.component;

    @PutMapping(value="/add/contact", produces = {"application/json"})
    public ResponseEntity<?> addContactProvider(@RequestParam String firstName, String lastName,
                                      String phoneNumber, String email) {
        AddContactActivity contactActivity = component.provideAddContactActivity();
        AddContactRequest request = AddContactRequest.builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPhoneNumber(phoneNumber)
                .withEmail(email)
                .build();

        return new ResponseEntity<>(contactActivity.execute(request), HttpStatus.OK);
    }

    @PostMapping(value = "/update/contact", produces = {"application/json"})
    public ResponseEntity<?> UpdateContactProvider(@RequestParam String newFirstName, String newLastName, String oldFirstName,
                                        String oldLastName, String phoneNumber, String email) {
        UpdateContactActivity contactActivity = component.provideUpdateContactActivity();
        UpdateContactRequest request = UpdateContactRequest.builder()
                .withNewFirstName(newFirstName)
                .withNewLastName(newLastName)
                .withOldFirstName(oldFirstName)
                .withOldLastName(oldLastName)
                .withPhoneNumber(phoneNumber)
                .withEmail(email)
                .build();
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
    public ResponseEntity<?> getContact(@RequestParam  String firstName, String lastName) {
        GetContactActivity contactActivity = component.provideGetContactActivity();
        GetContactRequest request = GetContactRequest.builder()
                .withFirstName(firstName)
                .withLastname(lastName)
                .build();
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
