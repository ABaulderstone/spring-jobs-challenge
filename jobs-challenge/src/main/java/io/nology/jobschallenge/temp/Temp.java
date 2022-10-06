package io.nology.jobschallenge.temp;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.nology.jobschallenge.job.Job;

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
  
}
