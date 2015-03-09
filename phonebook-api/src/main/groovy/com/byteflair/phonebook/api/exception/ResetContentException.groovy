package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class ResetContentException extends RestApiException {

    private static final long serialVersionUID = -2072519535724461405L

    ResetContentException(String message) {
        super(HttpStatus.RESET_CONTENT, message)
    }

    ResetContentException(String message, Exception cause) {
        super(HttpStatus.RESET_CONTENT, message, cause)
    }
}
