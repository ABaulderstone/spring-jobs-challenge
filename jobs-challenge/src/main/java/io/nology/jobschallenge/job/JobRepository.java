package io.nology.jobschallenge.job;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job, Long> {
  @Query("SELECT j FROM Job j WHERE j.temp = null")
  List<Job> findAllUnassigned();

  @Query("SELECT j FROM Job j WHERE j.temp <> null")
  List<Job> findAllAssigned();
}
