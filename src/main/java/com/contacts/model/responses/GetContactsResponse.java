package com.contacts.model.responses;

import java.util.SortedMap;

public class GetContactsResponse {
    private SortedMap<?, ?> contacts;

    public GetContactsResponse(SortedMap<?, ?> contacts) {
        this.contacts = contacts;
    }

    public GetContactsResponse(Builder builder) {
        this.contacts = builder.contacts;
    }

    public SortedMap<?, ?> getContacts() {
        return contacts;
    }

    public void setContacts(SortedMap<?, ?> contacts) {
        this.contacts = contacts;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private SortedMap<?, ?> contacts;

        public Builder withContacts(SortedMap<?, ?> contacts) {
            this.contacts = contacts;
            return this;
        }

        public GetContactsResponse build() {
            return new GetContactsResponse(this);
        }
    }
}
