package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用前の特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedSuperExpressSurcharge {

  @Getter
  private final Amount amount;

  public static NotDiscountedSuperExpressSurcharge from(
      NotDiscountedFreeSeatSuperExpressSurcharge notDiscountedFreeSeatSuperExpressSurcharge) {
    return new NotDiscountedSuperExpressSurcharge(
        notDiscountedFreeSeatSuperExpressSurcharge.getAmount());
  }

  public static NotDiscountedSuperExpressSurcharge from(
      NotDiscountedReservedSeatSuperExpressSurcharge
          notDiscountedReservedSeatSuperExpressSurcharge) {
    return new NotDiscountedSuperExpressSurcharge(
        notDiscountedReservedSeatSuperExpressSurcharge.getAmount());
  }
}
