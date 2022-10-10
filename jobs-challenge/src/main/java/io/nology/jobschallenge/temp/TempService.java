package io.nology.jobschallenge.temp;

import io.nology.jobschallenge.exceptions.JobNotExistException;
import io.nology.jobschallenge.job.Job;
import io.nology.jobschallenge.job.JobRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempService {

  @Autowired
  private TempRepository tempRepository;

  @Autowired
  private JobRepository jobRepository;

  public Temp create(TempCreateDTO data) {
    Temp newTemp = new Temp(data.getFirstName(), data.getLastName(), null);
    this.tempRepository.save(newTemp);
    return newTemp;
  }

  public List<Temp> index(Long jobId) {
    if (jobId == null) {
      return this.tempRepository.findAll();
    }
    Optional<Job> maybeJob = this.jobRepository.findById(jobId);

    if (maybeJob.isEmpty()) {
      throw new JobNotExistException();
    }

    Date startDate = maybeJob.get().getStartDate();

    return this.tempRepository.availableOn(startDate);
  }
}

@Service
@Transactional
public class TempService {

  @Autowired
  private TempRepository tempRepository;

  @Autowired
  private JobRepository jobRepository;

  public Temp create(TempCreateDTO data) {
    Temp newTemp = new Temp(data.getFirstName(), data.getLastName(), null);
    this.tempRepository.save(newTemp);
    return newTemp;
  }

  public List<Temp> index(Long jobId) {
    if (jobId == null) {
      return this.tempRepository.findAll();
    }
    Optional<Job> maybeJob = this.jobRepository.findById(jobId);

    if (maybeJob.isEmpty()) {
      throw new JobNotExistException();
    }

    Date startDate = maybeJob.get().getStartDate();

    return this.tempRepository.availableOn(startDate);
  }
}
