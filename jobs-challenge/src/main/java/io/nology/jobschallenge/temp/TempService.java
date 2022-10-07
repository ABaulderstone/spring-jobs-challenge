package io.nology.jobschallenge.temp;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempService {

  @Autowired
  private TempRepository tempRepository;

  public String create() {
    this.tempRepository.count();
    return "Hello";
  }
}
