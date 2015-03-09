package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class ServiceUnavailableException extends RestApiException {

    private static final long serialVersionUID = 745105939406211125L

    ServiceUnavailableException(String message) {
        super(HttpStatus.SERVICE_UNAVAILABLE, message)
    }

    ServiceUnavailableException(String message, Exception e) {
        super(HttpStatus.SERVICE_UNAVAILABLE, message, e)
    }
}
