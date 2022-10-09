package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureGroupDiscountNotAppliedFareValue {
  public static GroupDiscountNotAppliedFare get(int n) {
    return GroupDiscountNotAppliedFare.from(Amount.from(n));
  }
}
