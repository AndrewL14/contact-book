package com.contacts.model.responses;

import com.contacts.dao.model.ContactModel;

import java.util.Objects;

public class GetContactResponse {
    private ContactModel contact;

    public GetContactResponse(ContactModel contact) {
        this.contact = contact;
    }

    public GetContactResponse(Builder builder) {
        this.contact = builder.contact;
    }

    public ContactModel getContact() {
        return contact;
    }

    public void setContact(ContactModel contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetContactResponse that = (GetContactResponse) o;
        return contact.equals(that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ContactModel contact;

        public Builder withContactModel(ContactModel contact) {
            this.contact = contact;
            return this;
        }

        public GetContactResponse build() {
            return new GetContactResponse(this);
        }
    }
}
