package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureTotalAdultPriceValue {
  public static TotalAdultPrice get(int n) {
    return TotalAdultPrice.from(Amount.from(n));
  }
}
