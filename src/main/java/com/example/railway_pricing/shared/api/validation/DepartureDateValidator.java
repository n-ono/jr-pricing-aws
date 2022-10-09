package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedDepartureDate;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartureDateValidator implements ConstraintValidator<AllowedDepartureDate, String> {

  private String format;

  @Override
  public void initialize(AllowedDepartureDate allowedDepartureDate) {
    format = allowedDepartureDate.format();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
      LocalDate.parse(value, formatter);
      return true;
    } catch (DateTimeException e) {
      return false;
    }
  }

}
