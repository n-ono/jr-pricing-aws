package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import java.time.MonthDay;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * シーズン開始月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonStartMonthDay {

  private final MonthDay value;

  public static SeasonStartMonthDay from(MonthDay monthDay) {
    return new SeasonStartMonthDay(monthDay);
  }

  public boolean isAfter(DepartureMonthDay departureMonthDay) {
    return value.isAfter(departureMonthDay.getValue());
  }
}
