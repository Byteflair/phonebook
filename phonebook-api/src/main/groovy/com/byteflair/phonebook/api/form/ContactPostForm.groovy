package com.byteflair.phonebook.api.form

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
class ContactPostForm {

    private String name
    private String phoneNumber
    private String email

    String getName() {
        name
    }

    void setName(String name) {
        this.name = name
    }

    String getPhoneNumber() {
        phoneNumber
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber
    }

    String getEmail() {
        email
    }

    void setEmail(String email) {
        this.email = email
    }
}
