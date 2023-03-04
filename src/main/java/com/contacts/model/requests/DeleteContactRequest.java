package com.contacts.model.requests;

import java.util.Objects;

public class DeleteContactRequest {
    private String firstName;
    private String lastName;

    public DeleteContactRequest(String firstName , String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public DeleteContactRequest(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteContactRequest that = (DeleteContactRequest) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName , lastName);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String firstName;
        private String lastName;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastname(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DeleteContactRequest build() {
            return new DeleteContactRequest(this);
        }
    }
}
