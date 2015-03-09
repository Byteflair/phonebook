package com.byteflair.phonebook.api.exception

import com.byteflair.phonebook.core.exception.BusinessErrorCode
import com.byteflair.phonebook.core.exception.BusinessException
import org.springframework.http.HttpStatus

class RestApiExceptionFactory {

    static RestApiException getException(BusinessException e) {
        RestApiException translated

        switch (e.getCode()) {
            case BusinessErrorCode.DELETED:
            case BusinessErrorCode.NOT_FOUND:
                translated = new NotFoundException(e.getMessage(), e)
                break

            case BusinessErrorCode.RACE_CONDITION:
            case BusinessErrorCode.UNMET_CONDITION:
                translated = new ConflictException(e.getMessage(), e)
                break

            default:
                translated = new RestApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Something unexpected happened!", e);
                break
        }

        translated
    }
}
