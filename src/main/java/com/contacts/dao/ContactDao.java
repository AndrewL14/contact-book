package com.contacts.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.contacts.model.Contact;

import javax.inject.Inject;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContactDao {

    private final DynamoDBMapper mapper;

    @Inject
    public ContactDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Saves a new or updated Contact to the sql database.
     * @param contact A new or updated contact ot save.
     */
    public void saveContact(Contact contact) {
        mapper.save(contact);
    }

    /**
     *  Finds a specific contact using the first and last names which are the Hashkey and range key.
     * @param firstName DB HashKey
     * @param lastName DB RangeKey
     * @return returns a contact object
     */
    public Contact getContact(String firstName, String lastName) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        return mapper.load(contact);
    }

    /**
     *  Deletes an existing contact from the database
     * @param firstName DB HashKey
     * @param lastName DB RangeKey
     */
    public void deleteContact(String firstName, String lastName) {
        Contact contact = getContact(firstName, lastName);
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
