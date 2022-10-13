package io.nology.jobschallenge.job;

import io.nology.jobschallenge.exceptions.NotFoundException;
import io.nology.jobschallenge.exceptions.TempNotAvailableException;
import io.nology.jobschallenge.exceptions.TempNotExistException;
import io.nology.jobschallenge.temp.Temp;
import io.nology.jobschallenge.temp.TempService;
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
  private TempService tempService;

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

    Optional<Temp> maybeTemp = this.tempService.findById(tempId);
    if (maybeTemp.isEmpty()) {
      throw new TempNotExistException();
    }

    Temp foundTemp = maybeTemp.get();
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

  public Job updateJob(Long id, JobUpdateDTO data) {
    Optional<Job> maybeJob = this.findById(id);

    if (maybeJob.isEmpty()) {
      throw new NotFoundException(
        String.format("Job with id: %d not found", id)
      );
    }

    Job foundJob = maybeJob.get();

    String name = data.getName();
    LocalDate startDate = data.getStartDate();
    LocalDate endDate = data.getEndDate();
    Long tempId = data.getTempId();

    if (tempId != null) {
      Optional<Temp> maybeTemp = this.tempService.findById(tempId);
      if (maybeTemp.isEmpty()) {
        throw new TempNotExistException();
      }

      Temp foundTemp = maybeTemp.get();
      if (!foundTemp.isAvailableOnSpecificedDate(startDate)) {
        throw new TempNotAvailableException();
      }

      foundJob.setTemp(foundTemp);
    }

    if (name.trim().length() > 0) {
      foundJob.setName(data.name);
    }

    if (startDate != null) {
      foundJob.setStartDate(startDate);
    }

    if (endDate != null) {
      foundJob.setEndDate(endDate);
    }

    System.out.println(foundJob.toString());

    return this.jobRepository.save(foundJob);
  }
}
