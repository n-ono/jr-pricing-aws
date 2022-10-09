package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureTotalChildPriceValue {
  public static TotalChildPrice get(int n) {
    return TotalChildPrice.from(Amount.from(n));
  }
}
