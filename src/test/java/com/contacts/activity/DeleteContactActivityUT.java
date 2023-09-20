package com.contacts.activity;

import com.contacts.activity.DeleteContactActivity;
import com.contacts.dao.ContactDao;
import com.contacts.model.requests.DeleteContactRequest;
import com.contacts.model.responses.DeleteContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class DeleteContactActivityUT {
    private final String firstName = "";
    private final String lastName = "";

    @Mock
    private ContactDao contactDao;
    @InjectMocks
    private DeleteContactActivity activity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void execute_deleteContact_returnEmptyResponse() {
        // GIVEN
        DeleteContactRequest request = DeleteContactRequest.builder()
                .withFirstName(firstName)
                .withLastname(lastName)
                .build();

        // WHEN
        DeleteContactResponse response = activity.execute(request);

        // THEN
        verify(contactDao).deleteContact(firstName, lastName);
        assertNotNull(response);
    }
}
