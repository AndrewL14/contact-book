package com.contacts.model.requests;

import java.util.Objects;
import java.util.Optional;

public class UpdateContactRequest {
    private String newFirstName;
    private String newLastName;
    private String oldFirstName;
    private String oldLastName;
    private String phoneNumber;
    private String email;

    public UpdateContactRequest(String newFirstName , String newLastName
            ,String oldFirstName , String oldLastName , String phoneNumber , String email) {
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.oldFirstName = oldFirstName;
        this.oldLastName = oldLastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UpdateContactRequest(Builder builder) {
        this.newFirstName = builder.newFirstName;
        this.newLastName = builder.newLastName;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    public Optional<String> getNewFirstName() {
        return Optional.ofNullable(newFirstName);
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public Optional<String> getNewLastName() {
        return Optional.ofNullable(newLastName);
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getOldFirstName() {
        return oldFirstName;
    }

    public void setOldFirstName(String oldFirstName) {
        this.oldFirstName = oldFirstName;
    }

    public String getOldLastName() {
        return oldLastName;
    }

    public void setOldLastName(String oldLastName) {
        this.oldLastName = oldLastName;
    }

    public Optional<String> getPhoneNumber() {
        return Optional.ofNullable(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateContactRequest that = (UpdateContactRequest) o;
        return newFirstName.equals(that.newFirstName) && newLastName.equals(that.newLastName)
                && oldFirstName.equals(that.oldFirstName)
                && oldLastName.equals(that.oldLastName)
                && phoneNumber.equals(that.phoneNumber)
                && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newFirstName , newLastName , oldFirstName , oldLastName , phoneNumber , email);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String newFirstName;
        private String newLastName;
        private String oldFirstName;
        private String oldLastName;
        private String phoneNumber;
        private String email;

        public Builder withNewFirstName(String firstName) {
            this.newFirstName = firstName;
            return this;
        }

        public Builder withNewLastName(String lastName) {
            this.newLastName = lastName;
            return this;
        }

        public Builder withOldFirstName(String firstName) {
            this.oldFirstName = firstName;
            return this;
        }

        public Builder withOldLastName(String lastName) {
            this.oldLastName = lastName;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UpdateContactRequest build() {
            return new UpdateContactRequest(this);
        }
    }
}
