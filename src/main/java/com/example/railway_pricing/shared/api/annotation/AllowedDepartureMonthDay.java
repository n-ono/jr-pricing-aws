package com.example.railway_pricing.shared.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.railway_pricing.shared.api.validation.DepartureMonthDayValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DepartureMonthDayValidator.class)
public @interface AllowedDepartureMonthDay {

  String message() default "出発月日は {format} 形式で指定してください";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String format() default "MMdd";
}
