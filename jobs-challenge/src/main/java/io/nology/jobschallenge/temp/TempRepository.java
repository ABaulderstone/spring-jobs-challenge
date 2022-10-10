package io.nology.jobschallenge.temp;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TempRepository extends JpaRepository<Temp, Long> {
  @Query(
    "SELECT t FROM Temp as t  LEFT JOIN t.jobs as j WHERE(j.endDate < :startDate or j is null)"
  )
  List<Temp> availableOn(@Param("startDate") Date startDate);
}
// @Query("SELECT j FROM Job j WHERE j.temp <> null")
// List<Job> findAllAssigned();
