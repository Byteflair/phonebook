package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class GoneException extends RestApiException {

    private static final long serialVersionUID = -3398316730303185072L

    GoneException(String message) {
        super(HttpStatus.GONE, message)
    }

    GoneException(String message, Exception e) {
        super(HttpStatus.GONE, message, e)
    }

}
