package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixturePriceValue {
  public static Price get(int n) {
    return Price.from(Amount.from(n));
  }
}
