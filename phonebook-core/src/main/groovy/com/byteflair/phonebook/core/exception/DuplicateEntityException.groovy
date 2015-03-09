package com.byteflair.phonebook.core.exception

class DuplicateEntityException extends BusinessException {

    private static final long serialVersionUID = -7862768306181253606L

    DuplicateEntityException(String message) {
        super(BusinessErrorCode.DUPLICATE_ENTITY, message)
    }
}
