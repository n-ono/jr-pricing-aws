package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureDiscountNotAppliedFareValue {
  public static DiscountNotAppliedFare get(int n) {
    return DiscountNotAppliedFare.from(Amount.from(n));
  }
}
