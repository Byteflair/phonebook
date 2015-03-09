package com.byteflair.phonebook.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestApiExceptionHandler.class)

    @ExceptionHandler(RestApiException.class)
    static ResponseEntity<RestApiException> handleException(RestApiException exception) {
        logger.error("{} {}", exception.status, exception.message);

        new ResponseEntity<RestApiException>(exception, exception.status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    static ResponseEntity<RestApiException> handleException (MethodArgumentNotValidException notValidException) {
        RestApiException exception = new RestApiException(HttpStatus.PRECONDITION_FAILED, notValidException.getBindingResult())
        exception.setStackTrace(notValidException.getStackTrace())

        handleException(exception)
    }

    @ExceptionHandler([ HttpMessageNotWritableException.class, HttpMessageNotReadableException.class ])
    static ResponseEntity<RestApiException> handleException (HttpMessageConversionException badRequest) {
        RestApiException exception = new RestApiException(HttpStatus.BAD_REQUEST, badRequest.getMessage(), badRequest)
        exception.setStackTrace(badRequest.getStackTrace())

        handleException(exception)
    }

    @ExceptionHandler(IllegalArgumentException.class)
    static ResponseEntity<RestApiException> handleException (IllegalArgumentException illegalArgument) {
        RestApiException exception = new RestApiException(HttpStatus.PRECONDITION_FAILED, illegalArgument.getMessage(), illegalArgument)
        exception.setStackTrace(illegalArgument.getStackTrace())

        handleException(exception)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    static ResponseEntity<RestApiException> handleException (HttpRequestMethodNotSupportedException requestNotSupported) {
        RestApiException exception = new RestApiException(HttpStatus.METHOD_NOT_ALLOWED, requestNotSupported.getMessage(), requestNotSupported)
        exception.setStackTrace(requestNotSupported.getStackTrace())

        handleException(exception)
    }

    @ExceptionHandler(Throwable.class)
    static ResponseEntity<RestApiException> handleException (Throwable throwable) {
        RestApiException exception = new RestApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Some internal error happened when processing your request", throwable)
        exception.setStackTrace(throwable.getStackTrace())

        handleException(exception)
    }

    /*
        Security exceptions

    @ExceptionHandler([ AccessDeniedException.class, AccessControlException.class ])
    static ResponseEntity<RestApiException> handleException (AccessDeniedException accessDenied) {
        RestApiException exception = new RestApiException(HttpStatus.UNAUTHORIZED, accessDenied.getMessage(), accessDenied)
        exception.setStackTrace(accessDenied.getStackTrace())

        handleException(exception)
    }*/
}
