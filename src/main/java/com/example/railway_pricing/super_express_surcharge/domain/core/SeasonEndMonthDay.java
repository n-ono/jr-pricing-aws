package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import java.time.MonthDay;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * シーズン終了月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonEndMonthDay {

  private final MonthDay value;

  public static SeasonEndMonthDay from(MonthDay monthDay) {
    return new SeasonEndMonthDay(monthDay);
  }

  public boolean isBefore(DepartureMonthDay departureMonthDay) {
    return value.isBefore(departureMonthDay.getValue());
  }
}
