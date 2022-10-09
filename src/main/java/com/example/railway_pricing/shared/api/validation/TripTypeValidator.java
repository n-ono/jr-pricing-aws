package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedTripType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TripTypeValidator implements ConstraintValidator<AllowedTripType, String> {

  @Override
  public void initialize(AllowedTripType allowedTripType) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.equals("one-way") || value.equals("round");
  }
}
