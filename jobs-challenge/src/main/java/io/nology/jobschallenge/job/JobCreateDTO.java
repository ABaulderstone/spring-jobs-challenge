package io.nology.jobschallenge.job;

import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class JobCreateDTO {

  @NotBlank
  String name;

  @FutureOrPresent
  LocalDate startDate;

  @FutureOrPresent
  LocalDate endDate;

  @Min(1)
  Long tempId;

  public JobCreateDTO(
    @NotBlank String name,
    @FutureOrPresent LocalDate startDate,
    @FutureOrPresent LocalDate endDate,
    @Min(1) Long tempId
  ) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tempId = tempId;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public String getName() {
    return name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public Long getTempId() {
    return tempId;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setTempId(Long tempId) {
    this.tempId = tempId;
  }
}
