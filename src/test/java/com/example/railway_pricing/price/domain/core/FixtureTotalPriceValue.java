package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureTotalPriceValue {
  public static TotalPrice get(int n) {
    return TotalPrice.from(Amount.from(n));
  }
}
