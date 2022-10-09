package com.example.railway_pricing.shared.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.railway_pricing.shared.api.validation.DestinationValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DestinationValidator.class)
public @interface AllowedDestination {

  String message() default "目的地は shinosaka または himeji を選択してください";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
