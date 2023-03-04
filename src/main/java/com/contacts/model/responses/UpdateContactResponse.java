package com.contacts.model.responses;

import com.contacts.dao.model.ContactModel;

import java.util.Objects;

public class UpdateContactResponse {

    private ContactModel contactModel;

    public UpdateContactResponse(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public UpdateContactResponse(Builder builder) {
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
        UpdateContactResponse that = (UpdateContactResponse) o;
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

        public UpdateContactResponse build() {
            return new UpdateContactResponse(this);
        }
    }
}
