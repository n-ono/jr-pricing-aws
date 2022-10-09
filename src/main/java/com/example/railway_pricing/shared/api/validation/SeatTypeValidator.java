package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedSeatType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeatTypeValidator implements ConstraintValidator<AllowedSeatType, String> {

  @Override
  public void initialize(AllowedSeatType allowedSeatType) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.equals("free") || value.equals("reserved");
  }
}
