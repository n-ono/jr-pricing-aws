package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChildrenValidator implements ConstraintValidator<AllowedChildren, Integer> {

  @Override
  public void initialize(AllowedChildren allowedChildren) {
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return value != null && 0 <= value;
  }
}
