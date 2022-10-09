package io.nology.jobschallenge.job;

import io.nology.jobschallenge.exceptions.TempNotFoundException;
import io.nology.jobschallenge.temp.Temp;
import io.nology.jobschallenge.temp.TempRepository;
import java.sql.Date;
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
    Date startDate = data.getStartDate();
    Date endDate = data.getEndDate();

    if (tempId == null) {
      Job unassignedJob = new Job(name, startDate, endDate, null);
      this.jobRepository.save(unassignedJob);
      return unassignedJob;
    }

    Optional<Temp> maybeTemp = this.tempRepository.findById(tempId);
    if (maybeTemp.isEmpty()) {
      throw new TempNotFoundException();
    }

    System.out.println(maybeTemp.get());
    Job assignedJob = new Job(name, startDate, endDate, maybeTemp.get());
    this.jobRepository.save(assignedJob);
    return assignedJob;
  }

  public List<Job> index() {
    return this.jobRepository.findAll();
  }

  public Optional<Job> findById(Long id) {
    return this.jobRepository.findById(id);
  }
}
