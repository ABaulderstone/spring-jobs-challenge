package io.nology.jobschallenge.job;

import io.nology.jobschallenge.exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping
  public ResponseEntity<List<Job>> index(
    @RequestParam(required = false) Boolean assigned
  ) {
    List<Job> jobs = this.jobService.index(assigned);
    return new ResponseEntity<>(jobs, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Job> show(@PathVariable Long id) {
    Optional<Job> maybeJob = this.jobService.findById(id);

    if (maybeJob.isEmpty()) {
      throw new NotFoundException(
        String.format("Job with id: %d not found", id)
      );
    }
    return new ResponseEntity<>(maybeJob.get(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Job> create(@Valid @RequestBody JobCreateDTO data) {
    Job createdJob = this.jobService.create(data);
    return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public Job update(
    @PathVariable Long id,
    @Valid @RequestBody JobUpdateDTO data
  ) {
    return this.jobService.updateJob(id, data);
  }
}
