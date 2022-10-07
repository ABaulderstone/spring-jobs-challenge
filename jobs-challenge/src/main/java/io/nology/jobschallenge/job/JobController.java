package io.nology.jobschallenge.job;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping
  public ResponseEntity<List<Job>> index() {
    List<Job> jobs = this.jobService.index();
    return new ResponseEntity<>(jobs, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id) {
    return "Job with ID: " + id;
  }

  @PostMapping
  public ResponseEntity<Job> create(@Valid @RequestBody JobCreateDTO data) {
    Job createdJob = this.jobService.create(data);
    return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public String update(@PathVariable Integer id) {
    return "Update job " + id;
  }
}
