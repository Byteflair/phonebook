package com.byteflair.phonebook.api.exception

import org.springframework.http.HttpStatus

class InternalServerErrorException extends RestApiException {

  private static final long serialVersionUID = 499540406539933354L

    public InternalServerErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message)
    }

    public InternalServerErrorException(String message, Exception e) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message, e)
    }
}
