package io.nology.jobschallenge.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(
  validatedBy = { EndDateValidatorCreate.class, EndDateValidatorUpdate.class }
)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEndDate {
  String message() default "End Date cannot be earlier than Start Date";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
