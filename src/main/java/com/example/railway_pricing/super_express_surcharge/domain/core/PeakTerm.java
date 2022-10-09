package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import java.time.Month;
import java.time.MonthDay;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 繁忙期間
 */
@EqualsAndHashCode
@ToString
public class PeakTerm {

  private static final SeasonStartMonthDay SEASON_START_MONTH_DAY =
      SeasonStartMonthDay.from(MonthDay.of(Month.DECEMBER, 25));
  private static final SeasonEndMonthDay SEASON_END_MONTH_DAY =
      SeasonEndMonthDay.from(MonthDay.of(Month.JANUARY, 10));

  public static boolean include(DepartureMonthDay departureMonthDay) {
    return !(SEASON_START_MONTH_DAY.isAfter(departureMonthDay)
        && SEASON_END_MONTH_DAY.isBefore(departureMonthDay));
  }
}
