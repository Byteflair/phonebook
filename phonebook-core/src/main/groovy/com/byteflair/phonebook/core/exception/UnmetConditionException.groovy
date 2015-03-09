package com.byteflair.phonebook.core.exception

class UnmetConditionException extends BusinessException {

    private static final long serialVersionUID = -151228143416518333L

    UnmetConditionException(String message) {
        super(BusinessErrorCode.UNMET_CONDITION, message)
    }
}
