package io.nology.jobschallenge.job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.nology.jobschallenge.temp.Temp;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String name;

  @Column
  Date startDate;

  @Column
  Date endDate;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "temp_id", nullable = true)
  @JsonIgnoreProperties("jobs")
  Temp temp;

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void setTemp(Temp temp) {
    this.temp = temp;
  }

  public Date getEndDate() {
    return endDate;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Temp getTemp() {
    return temp;
  }

  public Job(String name, Date startDate, Date endDate, Temp temp) {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.temp = temp;
  }

  public Job() {}
}
