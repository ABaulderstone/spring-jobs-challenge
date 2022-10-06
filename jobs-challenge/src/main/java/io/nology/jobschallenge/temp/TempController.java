package io.nology.jobschallenge.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/temps")
public class TempController {
  @GetMapping 
  public String index() {
    return "All temps";
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id) {
    return "temp with ID: " + id; 
  }

  @PostMapping 
  public String create() {
    return "Creates a temp";
  } 

  @PatchMapping("/{id}")
  public String update(@PathVariable Integer id) {
    return "Update temp " + id;
  }
}
