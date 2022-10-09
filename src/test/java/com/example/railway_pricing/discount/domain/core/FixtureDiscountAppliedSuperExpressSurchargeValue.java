package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureDiscountAppliedSuperExpressSurchargeValue {
  public static DiscountAppliedSuperExpressSurcharge get(int n) {
    return DiscountAppliedSuperExpressSurcharge.from(Amount.from(n));
  }
}
