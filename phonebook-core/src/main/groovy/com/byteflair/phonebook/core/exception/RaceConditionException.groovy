package com.byteflair.phonebook.core.exception

class RaceConditionException extends BusinessException {

    private static final long serialVersionUID = 6442151370471847763L

    RaceConditionException(String message) {
        super(BusinessErrorCode.RACE_CONDITION, message)
    }
}
