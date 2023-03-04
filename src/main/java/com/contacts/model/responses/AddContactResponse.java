package com.contacts.model.responses;

import com.contacts.dao.model.ContactModel;

import java.util.Objects;

public class AddContactResponse {
    private ContactModel contactModel;

    public AddContactResponse(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public AddContactResponse(Builder builder) {
        this.contactModel = builder.contactModel;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddContactResponse that = (AddContactResponse) o;
        return contactModel.equals(that.contactModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactModel);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ContactModel contactModel;

        public Builder withContactModel(ContactModel contactModel) {
            this.contactModel = contactModel;
            return this;
        }

        public AddContactResponse build() {
            return new AddContactResponse(this);
        }
    }
}
