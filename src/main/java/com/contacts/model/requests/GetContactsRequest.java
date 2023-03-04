package com.contacts.model.requests;


import java.util.Objects;

public class GetContactsRequest {
    private boolean run;
    public GetContactsRequest(boolean run) {
        this.run = run;
    }

    public GetContactsRequest(Builder builder) {
        this.run = builder.run;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetContactsRequest request = (GetContactsRequest) o;
        return run == request.run;
    }

    @Override
    public int hashCode() {
        return Objects.hash(run);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private boolean run;

        public Builder withRun(boolean run) {
            this.run = run;
            return this;
        }

        public GetContactsRequest build() {
            return new GetContactsRequest(this);
        }
    }
}
