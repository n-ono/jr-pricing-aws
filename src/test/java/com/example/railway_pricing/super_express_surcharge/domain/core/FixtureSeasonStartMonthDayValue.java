package com.example.railway_pricing.super_express_surcharge.domain.core;

import java.time.MonthDay;

public class FixtureSeasonStartMonthDayValue {
  public static SeasonStartMonthDay get(int month, int dayOfMonth) {
    return SeasonStartMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
