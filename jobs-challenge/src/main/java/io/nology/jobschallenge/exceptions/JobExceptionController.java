package io.nology.jobschallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class JobExceptionController {

  @ExceptionHandler(value = JobNotExistException.class)
  public ResponseEntity<Object> notExistException(
    JobNotExistException exception
  ) {
    return new ResponseEntity<>("Job does not exist", HttpStatus.BAD_REQUEST);
  }
}
