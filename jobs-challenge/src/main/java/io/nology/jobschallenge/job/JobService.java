package io.nology.jobschallenge.job;

import io.nology.jobschallenge.exceptions.NotFoundException;
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

  public Job findById(Long id) {
    Optional<Job> maybeJob = this.jobRepository.findById(id);

    if (maybeJob.isEmpty()) {
      throw new NotFoundException(
        String.format("Job with id: %d does not exist", id)
      );
    }
    return maybeJob.get();
  }

  public Job updateJob(Long id, JobUpdateDTO data) {
    Job foundJob = this.findById(id);

    String name = data.getName();
    LocalDate startDate = data.getStartDate();
    LocalDate endDate = data.getEndDate();
    Long tempId = data.getTempId();

    Optional<Temp> maybeTemp = this.tempRepository.findById(tempId);
    if (maybeTemp.isEmpty()) {
      throw new TempNotExistException();
    }

    Temp foundTemp = maybeTemp.get();
    if (!foundTemp.isAvailableOnSpecificedDate(startDate)) {
      throw new TempNotAvailableException();
    }

    foundJob.setTemp(foundTemp);

    if (name.trim().length() > 0) {
      foundJob.setName(data.name);
    }

    if (startDate != null) {
      foundJob.setStartDate(startDate);
    }

    if (endDate != null) {
      foundJob.setEndDate(endDate);
    }

    this.jobRepository.save(foundJob);
    return foundJob;
  }
}
