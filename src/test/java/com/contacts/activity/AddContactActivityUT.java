package com.contacts.activity;

import com.contacts.activity.AddContactActivity;
import com.contacts.dao.ContactDao;
import com.contacts.exception.InvalidContactFormatException;
import com.contacts.model.Contact;
import com.contacts.model.requests.AddContactRequest;
import com.contacts.model.responses.AddContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.verify;

public class AddContactActivityUT {
    private final String firstName = "James";
    private final String lasName = "Daniel";
    private final String phoneNumber = "123-234-4321";
    private final String email = "JamesDaniel@gmail.com";

    @Mock
    private ContactDao contactDao;
    @InjectMocks
    private AddContactActivity activity;

    @BeforeEach
    public void setup() {
        initMocks(this);
    }

    @Test
    public void execute_addContact_returnsContact() throws InvalidContactFormatException {
        // GIVEN
        AddContactRequest request = AddContactRequest
                .builder()
                .withFirstName(firstName)
                .withLastName(lasName)
                .withPhoneNumber(phoneNumber)
                .withEmail(email)
                .build();

        // WHEN
        AddContactResponse response = activity.execute(request);

        // THEN
        verify(contactDao).saveContact(any(Contact.class));
        assertNotNull(response, "Expected request to return a non-null response");
        assertEquals(response.getContactModel().getPhoneNumber(), phoneNumber, "Expected contact's phone number to be: " + phoneNumber + " " + "yet got: " + response.getContactModel().getPhoneNumber());
        assertEquals(response.getContactModel().getFirstName(), firstName, "Expected contact;s first name to be: " + firstName + " " + "yet got: " + response.getContactModel().getFirstName());
        assertEquals(response.getContactModel().getLastName(), lasName, "Expected contact's last name to be: " + lasName + " " + "yet got: " + response.getContactModel().getLastName());
        assertEquals(response.getContactModel().getEmail(), email, "Expected contact's email to be: " + email + " " + "yet got: " + response.getContactModel().getEmail());
    }
}
