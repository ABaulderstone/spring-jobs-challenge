package io.nology.jobschallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TempExceptionController {

  @ExceptionHandler(value = TempNotExistException.class)
  public ResponseEntity<Object> notFoundException(
    TempNotExistException exception
  ) {
    return new ResponseEntity<>("Temp not found", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = TempNotAvailableException.class)
  public ResponseEntity<Object> notAvailableException(
    TempNotAvailableException exception
  ) {
    return new ResponseEntity<>(
      "Temp is not available on that date",
      HttpStatus.BAD_REQUEST
    );
  }
}
