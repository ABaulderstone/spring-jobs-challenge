package io.nology.jobschallenge.exceptions;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TempExceptionController {

  @ExceptionHandler(value = TempNotFoundException.class)
  public ResponseEntity<Object> notFoundException(
    TempNotFoundException exception
  ) {
    return new ResponseEntity<>("Temp not found", HttpStatus.NOT_FOUND);
  }
}
