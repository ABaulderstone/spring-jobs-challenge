package io.nology.jobschallenge.temp;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Query(
    "SELECT DISTINCT t FROM Temp t " +
    "LEFT JOIN t.jobs j " +
    "WHERE t NOT IN (" +
        "SELECT t2 FROM Temp t2 " +
        "JOIN t2.jobs j2 " +
        "WHERE " +
        "(:jobStartDate < j2.endDate AND :jobEndDate > j2.startDate)" +
    ")"
)
List<Temp> availableForJob(
    @Param("jobStartDate") LocalDate jobStartDate, 
    @Param("jobEndDate") LocalDate jobEndDate
);
// @Query("SELECT j FROM Job j WHERE j.temp <> null")
// List<Job> findAllAssigned();
