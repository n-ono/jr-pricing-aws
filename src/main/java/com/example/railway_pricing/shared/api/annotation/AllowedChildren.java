package com.example.railway_pricing.shared.api.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.example.railway_pricing.shared.api.validation.ChildrenValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({PARAMETER, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ChildrenValidator.class)
public @interface AllowedChildren {

  String message() default "子供の人数は 0 人以上で指定してください";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
