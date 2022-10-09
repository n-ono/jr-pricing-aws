package com.example.railway_pricing.shared.api.validation;

import com.example.railway_pricing.shared.api.annotation.AllowedDepartureMonthDay;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartureMonthDayValidator implements
    ConstraintValidator<AllowedDepartureMonthDay, String> {

  private String format;

  @Override
  public void initialize(AllowedDepartureMonthDay allowedDepartureMonthDay) {
    format = allowedDepartureMonthDay.format();
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    try {
      MonthDay.parse(value, DateTimeFormatter.ofPattern(format));
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

}
