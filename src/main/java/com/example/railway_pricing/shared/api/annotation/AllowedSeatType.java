package com.example.railway_pricing.shared.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.railway_pricing.shared.api.validation.SeatTypeValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = SeatTypeValidator.class)
public @interface AllowedSeatType {

  String message() default "座席は free または reserved を選択してください";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
