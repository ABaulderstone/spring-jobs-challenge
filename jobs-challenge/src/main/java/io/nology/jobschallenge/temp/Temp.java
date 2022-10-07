package io.nology.jobschallenge.temp;

import io.nology.jobschallenge.job.Job;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Temp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column
  String firstName;

  @Column
  String lastName;

  @OneToMany(mappedBy = "temp")
  Set<Job> jobs;

  public String getFirstName() {
    return firstName;
  }

  public Long getId() {
    return id;
  }

  public Set<Job> getJobs() {
    return jobs;
  }

  public String getLastName() {
    return lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setJobs(Set<Job> jobs) {
    this.jobs = jobs;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
