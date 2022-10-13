package io.nology.jobschallenge.job;

import io.nology.jobschallenge.constraints.ValidEndDate;
import java.time.LocalDate;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

@ValidEndDate
public class JobUpdateDTO {

  String name;

  @FutureOrPresent
  LocalDate startDate;

  @FutureOrPresent
  LocalDate endDate;

  @Min(1)
  Long tempId;

  public JobUpdateDTO(
    String name,
    @FutureOrPresent LocalDate startDate,
    @FutureOrPresent LocalDate endDate,
    @Min(1) Long tempId
  ) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tempId = tempId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Long getTempId() {
    return tempId;
  }

  public void setTempId(Long tempId) {
    this.tempId = tempId;
  }
}
