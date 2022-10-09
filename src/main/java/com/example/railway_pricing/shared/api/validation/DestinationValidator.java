package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DestinationValidator implements ConstraintValidator<AllowedDestination, String> {

  @Override
  public void initialize(AllowedDestination allowedDestination) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.equals("shinosaka") || value.equals("himeji");
  }
}
