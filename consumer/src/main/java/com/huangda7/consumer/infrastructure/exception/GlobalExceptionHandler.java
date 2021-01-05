package com.huangda7.consumer.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomizeException.class)
  public ResponseEntity handleCustomizeException(CustomizeException customizeException) {
    String str = "出现错误，请检查服务！";
    return ResponseEntity.badRequest().body(str);
  }

}
