package com.example.railway_pricing.super_express_surcharge.domain.core;

import java.time.MonthDay;

public class FixtureSeasonEndMonthDayValue {
  public static SeasonEndMonthDay get(int month, int dayOfMonth) {
    return SeasonEndMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
