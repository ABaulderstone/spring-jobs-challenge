package io.nology.jobschallenge.temp;

import javax.validation.constraints.NotBlank;

public class TempCreateDTO {

  @NotBlank
  String firstName;

  @NotBlank
  String lastName;

  public TempCreateDTO(@NotBlank String firstName, @NotBlank String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
