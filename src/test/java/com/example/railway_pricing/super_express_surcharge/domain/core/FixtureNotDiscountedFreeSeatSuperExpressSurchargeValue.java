package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureNotDiscountedFreeSeatSuperExpressSurchargeValue {
  public static NotDiscountedFreeSeatSuperExpressSurcharge get(int n) {
    return NotDiscountedFreeSeatSuperExpressSurcharge.from(Amount.from(n));
  }
}
