package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class ForbiddenException extends RestApiException {

    private static final long serialVersionUID = -1234406325595024615L

    ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message)
    }

    ForbiddenException(String message, Exception e) {
        super(HttpStatus.FORBIDDEN, message, e)
    }
}
