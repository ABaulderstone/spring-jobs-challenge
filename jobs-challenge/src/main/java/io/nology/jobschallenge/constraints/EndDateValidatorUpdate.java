import io.nology.jobschallenge.job.JobCreateDTO;
import io.nology.jobschallenge.job.JobUpdateDTO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EndDateValidatorUpdate
  implements ConstraintValidator<ValidEndDate, JobUpdateDTO> {

  @Override
  public void initialize(ValidEndDate constraintAnnotation) {
    // TODO Auto-generated method stub
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(
    JobUpdateDTO value,
    ConstraintValidatorContext context
  ) {
    return !(value.getEndDate().isBefore(value.getStartDate()));
  }
}
