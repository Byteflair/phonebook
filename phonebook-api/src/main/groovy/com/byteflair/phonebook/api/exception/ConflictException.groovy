package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class ConflictException extends RestApiException {

    private static final long serialVersionUID = 8641674827960644641L

    ConflictException(String message) {
        super(HttpStatus.CONFLICT, message)
    }

    ConflictException(String message, Exception e) {
        super(HttpStatus.CONFLICT, message, e)
    }

}