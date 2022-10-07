package org.aibles.sensor.exception;

import org.springframework.http.HttpStatus;

public class InternalServerError extends BaseException {

  public InternalServerError() {
    setCode("org.aibles.sensor.exception.InternalServerError");
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
  }
}
