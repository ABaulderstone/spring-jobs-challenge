package io.nology.jobschallenge.job;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobService {

  @Autowired
  private JobRepository jobRepository;

  public String create(JobCreateDTO data) {
    return data.toString();
  }
}
