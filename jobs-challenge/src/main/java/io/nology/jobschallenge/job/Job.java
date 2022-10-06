package io.nology.jobschallenge.job;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.nology.jobschallenge.temp.Temp;

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

  @ManyToOne
  @JoinColumn(name="temp_id", nullable = true)
  Temp temp;
}
