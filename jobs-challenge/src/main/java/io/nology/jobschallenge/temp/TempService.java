package io.nology.jobschallenge.temp;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TempService {

  @Autowired
  private TempRepository tempRepository;

  public Temp create(TempCreateDTO data) {
    Temp newTemp = new Temp(data.getFirstName(), data.getLastName());
    this.tempRepository.save(newTemp);
    return newTemp;
  }
}
