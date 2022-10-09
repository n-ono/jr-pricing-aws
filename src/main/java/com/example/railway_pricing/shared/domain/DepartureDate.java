package com.example.railway_pricing.shared.domain;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 出発日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartureDate {

  private final LocalDate value;

  public static DepartureDate from(LocalDate localDate) {
    return new DepartureDate(localDate);
  }

  public int getMonthValue() {
    return value.getMonthValue();
  }

  public int getDayOfMonth() {
    return value.getDayOfMonth();
  }
}
