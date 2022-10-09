package io.nology.jobschallenge.temp;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temps")
public class TempController {

  @Autowired
  private TempService tempService;

  @GetMapping
  public ResponseEntity<List<Temp>> index(
    @RequestParam(required = false) Long jobId
  ) {
    List<Temp> temps = this.tempService.index(jobId);
    return new ResponseEntity<>(temps, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public String show(@PathVariable Integer id) {
    return "temp with ID: " + id;
  }

  @PostMapping
  public ResponseEntity<Temp> create(@Valid @RequestBody TempCreateDTO data) {
    Temp createdTemp = this.tempService.create(data);
    return new ResponseEntity<>(createdTemp, HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public String update(@PathVariable Integer id) {
    return "Update temp " + id;
  }
}
