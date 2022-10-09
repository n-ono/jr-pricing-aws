package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedTrainType;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TrainTypeValidator implements ConstraintValidator<AllowedTrainType, String> {

  @Override
  public void initialize(AllowedTrainType allowedTrainType) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.equals("nozomi") || value.equals("hikari");
  }
}
