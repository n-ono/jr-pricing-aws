package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 季節変動料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonalVariationAmount {

  @Getter
  private final Amount amount;

  public static SeasonalVariationAmount from(DepartureMonthDay departureMonthDay) {
    return OffPeakTerm.include(departureMonthDay)
        ? new SeasonalVariationAmount(Amount.from(-200))
        : PeakTerm.include(departureMonthDay)
            ? new SeasonalVariationAmount(Amount.from(200))
            : new SeasonalVariationAmount(Amount.from(0));
  }
}
