package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureChildPriceValue {
  public static ChildPrice get(int n) {
    return ChildPrice.from(Amount.from(n));
  }
}
