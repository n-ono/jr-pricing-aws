package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureDiscountNotAppliedSuperExpressSurchargeValue {
  public static DiscountNotAppliedSuperExpressSurcharge get(int n) {
    return DiscountNotAppliedSuperExpressSurcharge.from(Amount.from(n));
  }
}
