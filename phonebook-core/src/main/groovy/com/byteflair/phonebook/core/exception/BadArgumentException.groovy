package com.byteflair.phonebook.core.exception

class BadArgumentException extends BusinessException {
    private static final long serialVersionUID = -1192337458543303724L

    BadArgumentException(String message) {
        super(BusinessErrorCode.BAD_ARGUMENT, message)
    }
}
