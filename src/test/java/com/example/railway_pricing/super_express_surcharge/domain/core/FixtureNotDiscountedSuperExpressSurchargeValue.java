package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureNotDiscountedSuperExpressSurchargeValue {
  public static NotDiscountedSuperExpressSurcharge fromNotDiscountedFreeSeatSuperExpressSurcharge(int n) {
    return NotDiscountedSuperExpressSurcharge.from(
        NotDiscountedFreeSeatSuperExpressSurcharge.from(Amount.from(n)));
  }

  public static NotDiscountedSuperExpressSurcharge fromNotDiscountedReservedSeatSuperExpressSurcharge(int n) {
    return NotDiscountedSuperExpressSurcharge.from(
        NotDiscountedReservedSeatSuperExpressSurcharge.from((Amount.from(n))));
  }
}
