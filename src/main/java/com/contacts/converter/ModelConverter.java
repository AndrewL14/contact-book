package com.contacts.converter;

import com.contacts.dao.model.ContactModel;
import com.contacts.model.Contact;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ModelConverter {
    public static ContactModel toContactModel(Contact contact) {
        return new ContactModel.Builder()
                .withFirstName(contact.getFirstName())
                .withLastName(contact.getLastName())
                .withEmail(contact.getEmail())
                .withPhoneNumber(contact.getPhoneNumber())
                .build();
    }

    public static SortedMap<String, ContactModel> toSortedContactModels(SortedMap<String, Contact> contacts) {
        //TODO replace NullPointer with A custom exception
        if (contacts.isEmpty()) {
            throw new NullPointerException("no");
        }

        return contacts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey ,
                        contact -> toContactModel(contact.getValue()),
                        (u, v) -> u,
                        TreeMap::new
                ));
    }
}
