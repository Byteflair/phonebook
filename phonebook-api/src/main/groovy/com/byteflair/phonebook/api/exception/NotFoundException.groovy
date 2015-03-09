package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class NotFoundException extends RestApiException {

    private static final long serialVersionUID = 6647074164892871120L

    NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message)
    }

    NotFoundException(String message, Exception e) {
        super(HttpStatus.NOT_FOUND, message, e)
    }
}
