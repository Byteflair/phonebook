package com.byteflair.phonebook.core.exception

class EntityNotFoundException extends BusinessException {

    private static final long serialVersionUID = -151228143416518333L

    EntityNotFoundException(String message) {
        super(BusinessErrorCode.NOT_FOUND, message)
    }
}
