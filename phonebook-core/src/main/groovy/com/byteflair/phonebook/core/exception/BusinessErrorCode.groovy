package com.byteflair.phonebook.core.exception

enum BusinessErrorCode {
    RACE_CONDITION(1),
    DELETED(2),
    NOT_FOUND(3),
    UNMET_CONDITION(4),
    BAD_ARGUMENT(5),
    DUPLICATE_ENTITY(6),
    DATA_REFRESH(7)

    private int code = -1;

    BusinessErrorCode(int code) {
        this.code = code;
    }

    int getCode() {
        code;
    }
}
