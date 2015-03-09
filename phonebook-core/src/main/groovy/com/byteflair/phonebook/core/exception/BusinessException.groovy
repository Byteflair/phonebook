package com.byteflair.phonebook.core.exception

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(value = [ "cause", "stackTrace", "localizedMessage", "suppressed" ])
public class BusinessException extends Exception {

  private static final long serialVersionUID = -6340612656391848684L
  private BusinessErrorCode error = null
  private String message = null

  protected BusinessException(BusinessErrorCode error) {
    this.error = error
  }

  protected BusinessException(BusinessErrorCode error, String message) {
    this.error = error
    this.message = message
  }

  BusinessErrorCode getCode() {
    return this.error
  }

  String getMessage() {
    return this.message
  }
}
