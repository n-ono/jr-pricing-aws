package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 季節変動料金調整前の指定席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge {

  private final Amount amount;

  public static SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge from(Amount amount) {
    return new SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge(amount);
  }

  public NotDiscountedReservedSeatSuperExpressSurcharge adjust(
      SeasonalVariationAmount seasonalVariationAmount) {
    return NotDiscountedReservedSeatSuperExpressSurcharge.from(
        amount.plus(seasonalVariationAmount.getAmount()));
  }
}
