package io.nology.jobschallenge.exceptions;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  public String message;

  public NotFoundException(String message) {
    this.message = message;
  }
}
