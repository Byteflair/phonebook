package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class BadRequestException extends RestApiException {

    private static final long serialVersionUID = -2072519535724461405L

    BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message)
    }

    BadRequestException(String message, Exception cause) {
        super(HttpStatus.BAD_REQUEST, message, cause)
    }
}
