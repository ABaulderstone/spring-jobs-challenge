package io.nology.jobschallenge.constraints;

import io.nology.jobschallenge.job.JobCreateDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndDateValidator
  implements ConstraintValidator<ValidEndDate, JobCreateDTO> {

  @Override
  public void initialize(ValidEndDate constraintAnnotation) {
    // TODO Auto-generated method stub
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(
    JobCreateDTO value,
    ConstraintValidatorContext context
  ) {
    return !(value.getEndDate().isBefore(value.getStartDate()));
  }
}
