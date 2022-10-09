package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AdultsValidator implements ConstraintValidator<AllowedAdults, Integer> {

  @Override
  public void initialize(AllowedAdults allowedAdults) {
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return value != null && 0 <= value;
  }
}
