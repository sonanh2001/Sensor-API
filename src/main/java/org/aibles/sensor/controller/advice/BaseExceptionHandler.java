package org.aibles.sensor.controller.advice;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aibles.sensor.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {
  @ExceptionHandler({BaseException.class})
  public ResponseEntity<Map<String, Object>> handle(BaseException exception) {
    log.info("(handle)exception: {}", exception.getClass().getName());
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("status", exception.getStatus());
    errorMap.put("code", exception.getCode());
    if(exception.getParams() != null) {
      errorMap.putAll(exception.getParams());
    }
    return ResponseEntity.status(HttpStatus.valueOf(exception.getStatus())).body(errorMap);
  }
}
