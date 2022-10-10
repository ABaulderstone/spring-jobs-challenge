package io.nology.jobschallenge.job;

import io.nology.jobschallenge.exceptions.TempNotAvailableException;
import io.nology.jobschallenge.exceptions.TempNotExistException;
import io.nology.jobschallenge.temp.Temp;
import io.nology.jobschallenge.temp.TempRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobService {

  @Autowired
  private JobRepository jobRepository;

  @Autowired
  private TempRepository tempRepository;

  public Job create(JobCreateDTO data) {
    Long tempId = data.getTempId();
    String name = data.getName();
    LocalDate startDate = data.getStartDate();
    LocalDate endDate = data.getEndDate();

    if (tempId == null) {
      Job unassignedJob = new Job(name, startDate, endDate, null);
      this.jobRepository.save(unassignedJob);
      return unassignedJob;
    }

    Optional<Temp> maybeTemp = this.tempRepository.findById(tempId);
    if (maybeTemp.isEmpty()) {
      throw new TempNotExistException();
    }

    Temp foundTemp = maybeTemp.get();
    System.out.println(startDate);
    if (!foundTemp.isAvailableOnSpecificedDate(startDate)) {
      throw new TempNotAvailableException();
    }

    Job assignedJob = new Job(name, startDate, endDate, foundTemp);
    this.jobRepository.save(assignedJob);
    return assignedJob;
  }

  public List<Job> index(Boolean assigned) {
    if (assigned == null) {
      return this.jobRepository.findAll();
    }
    if (assigned == true) {
      return this.jobRepository.findAllAssigned();
    }
    return this.jobRepository.findAllUnassigned();
  }

  public Optional<Job> findById(Long id) {
    return this.jobRepository.findById(id);
  }
}
