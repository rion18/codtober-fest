package com.rion18.stackbuilders.codtoberfest.exception;

public class ApiException extends RuntimeException {

  public ApiException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public ApiException(String message) {
    super(message);
  }

}
