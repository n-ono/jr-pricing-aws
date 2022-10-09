package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureFareValue {
  public static Fare get(int n) {
    return Fare.from(Amount.from(n));
  }
}
