package com.example.railway_pricing.shared.domain;

import java.time.MonthDay;

public class FixtureDepartureMonthDayValue {
  public static DepartureMonthDay get(int month, int dayOfMonth) {
    return DepartureMonthDay.from(MonthDay.of(month, dayOfMonth));
  }

  public static DepartureMonthDay regular() {
    return DepartureMonthDay.from(MonthDay.of(9, 4));
  }

  public static DepartureMonthDay peak() {
    return DepartureMonthDay.from(MonthDay.of(12, 25));
  }

  public static DepartureMonthDay offPeak() {
    return DepartureMonthDay.from(MonthDay.of(1, 16));
  }
}
