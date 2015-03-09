package com.byteflair.phonebook.core.exception

class DataRefreshException extends BusinessException {

    private static final long serialVersionUID = -144428143416518574L

    DataRefreshException(String message) {
        super(BusinessErrorCode.DATA_REFRESH, message)
    }
}
