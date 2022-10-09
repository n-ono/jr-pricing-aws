package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureAdultPriceValue {
  public static AdultPrice get(int n) {
    return AdultPrice.from(Amount.from(n));
  }
}
