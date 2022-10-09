package com.example.railway_pricing.shared.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.railway_pricing.shared.api.validation.DepartureDateValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DepartureDateValidator.class)
public @interface AllowedDepartureDate {

  String message() default "出発日は {format} 形式で指定してください";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String format() default "yyyyMMdd";
}
