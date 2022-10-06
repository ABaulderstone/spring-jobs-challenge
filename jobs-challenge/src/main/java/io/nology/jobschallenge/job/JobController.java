package io.nology.jobschallenge.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @GetMapping 
  public String index() {
    return "All Jobs";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id) {
    return "Job with ID: " + id; 
  }

  @PostMapping 
  public String create() {
    return "Creates a job";
  } 

  @PatchMapping("/{id}")
  public String update(@PathVariable Integer id) {
    return "Update job " + id;
  }
}
