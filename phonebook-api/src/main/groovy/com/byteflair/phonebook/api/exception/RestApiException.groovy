package com.byteflair.phonebook.api.exception

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError

@JsonIgnoreProperties (value = [ "cause", "stackTrace", "localizedMessage", "suppressed" ])
class RestApiException extends Exception {

    private static final long serialVersionUID = 5726439321553988580L

    private HttpStatus status = null

    private String message = null

    @JsonIgnoreProperties(value = [ "stackTrace", "localizedMessage", "suppressed" ])
    private Throwable reason = null

    protected RestApiException(HttpStatus status, String message) {
        this.status = status
        this.message = message
    }

    protected RestApiException(HttpStatus status, BindingResult result) {
        this.status = status
        StringBuilder buffer = new StringBuilder()

        boolean isFirst = true
        for (ObjectError error : result.getAllErrors()) {
            if (isFirst) {
                isFirst = false
            } else {
                buffer.append("; and,\n")
            }
            buffer.append(error.getDefaultMessage())
        }

        message = buffer.toString();
    }

    protected RestApiException(HttpStatus status, String message, Throwable reason) {
        this.status = status
        this.message = message
        this.reason = reason
    }

    HttpStatus getStatus() {

        status
    }

    int getCode() {

        status.value()
    }

    String getMessage() {

        message
    }

    @JsonIgnore
    Throwable getReason() {

        reason
    }

    @JsonIgnore
    String getStackTraceAsString() {
        StringBuffer buffer = new StringBuffer()
        boolean isFirst = true
        for (StackTraceElement trace : this.getStackTrace()) {
            if (isFirst) {
                isFirst = false
            } else {
                buffer.append("\n")
            }

            buffer.append(trace.getClassName()).append("::")
            .append(trace.getMethodName()).append(" @ line ")
            .append(trace.getLineNumber())
        }

        buffer.toString()
    }
}
