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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
