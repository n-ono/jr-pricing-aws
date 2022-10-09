package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

public class FixtureSuperExpressSurchargeValue {
  public static SuperExpressSurcharge get(int n) {
    return SuperExpressSurcharge.from(Amount.from(n));
  }
}
