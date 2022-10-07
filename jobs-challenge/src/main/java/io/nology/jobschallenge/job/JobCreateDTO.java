package io.nology.jobschallenge.job;

import java.sql.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class JobCreateDTO {

  @NotBlank
  String name;

  @FutureOrPresent
  Date startDate;

  @FutureOrPresent
  Date endDate;

  @Min(1)
  Long tempId;

  public JobCreateDTO(
    @NotBlank String name,
    @FutureOrPresent Date startDate,
    @FutureOrPresent Date endDate,
    @Min(1) Long tempId
  ) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.tempId = tempId;
  }

  public Date getEndDate() {
    return endDate;
  }

  public String getName() {
    return name;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Long getTempId() {
    return tempId;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void setTempId(Long tempId) {
    this.tempId = tempId;
  }
}
