package com.contacts.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.contacts.model.Contact;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContactDao {

    private final DynamoDBMapper mapper;

    @Inject
    public ContactDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Contact saveContact(Contact contact) {
        mapper.save(contact);
        return contact;
    }

    public Contact getContact(String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return mapper.load(contact);
    }

    public void deleteContact(String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        mapper.delete(contact);
    }

    public SortedMap<String, Contact> getAllContacts() {
        TreeMap<String, Contact> tree = new TreeMap<>();;
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<Contact> result = mapper.scan(Contact.class, scanExpression);
            for (Contact contact : result) {
                tree.put(contact.getFirstName() , contact);
            }
        return tree.descendingMap();
    }
}
