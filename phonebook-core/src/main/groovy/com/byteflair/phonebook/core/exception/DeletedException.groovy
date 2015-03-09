package com.byteflair.phonebook.core.exception

class DeletedException extends BusinessException {

    private static final long serialVersionUID = -151228143416518333L

    DeletedException(String message) {
        super(BusinessErrorCode.DELETED, message)
    }
}
