package com.example.railway_pricing.shared.domain;

import java.time.MonthDay;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 出発月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartureMonthDay {

  @Getter
  private final MonthDay value;

  public static DepartureMonthDay from(MonthDay monthDay) {
    return new DepartureMonthDay(monthDay);
  }

  public int getMonthValue() {
    return value.getMonthValue();
  }

  public int getDayOfMonth() {
    return value.getDayOfMonth();
  }
}
