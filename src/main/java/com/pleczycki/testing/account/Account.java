package com.pleczycki.testing.account;

import org.apache.commons.validator.routines.EmailValidator;

class Account {

    private boolean active;
    private Address defaultDeliveryAddress;
    private String email;

    Account() {
        this.active = false;
    }

    Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if(defaultDeliveryAddress != null) {
            activate();
        } else {
            this.active = false;
        }
    }

    void activate() {
        this.active = true;
    }

    boolean isActive() {
        return this.active;
    }

    Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    String getEmail() {
        return email;
    }

    void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    void setEmail(String email) {
        if(EmailValidator.getInstance().isValid(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Wrong email format");
        }
    }
}
