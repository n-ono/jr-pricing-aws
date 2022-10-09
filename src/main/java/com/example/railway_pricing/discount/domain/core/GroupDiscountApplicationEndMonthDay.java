package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import java.time.MonthDay;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 団体割引適用終了月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDiscountApplicationEndMonthDay {

  private final MonthDay value;

  public static GroupDiscountApplicationEndMonthDay from(MonthDay monthDay) {
    return new GroupDiscountApplicationEndMonthDay(monthDay);
  }

  public boolean isBefore(DepartureMonthDay departureMonthDay) {
    return value.isBefore(departureMonthDay.getValue());
  }
}
