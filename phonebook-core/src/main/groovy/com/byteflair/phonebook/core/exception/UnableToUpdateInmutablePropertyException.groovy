package com.byteflair.phonebook.core.exception

public class UnableToUpdateInmutablePropertyException extends BusinessException {

    private static final long serialVersionUID = 5442108273396274465L

    UnableToUpdateInmutablePropertyException(String message) {
        super(BusinessErrorCode.RACE_CONDITION, message)
    }
}
