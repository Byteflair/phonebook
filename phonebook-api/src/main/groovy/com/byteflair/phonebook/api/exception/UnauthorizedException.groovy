package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class UnauthorizedException extends RestApiException {

    private static final long serialVersionUID = 6379061529188630235L

    UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message)
    }

    UnauthorizedException(String message, Exception e) {
        super(HttpStatus.UNAUTHORIZED, message, e)
    }
}
