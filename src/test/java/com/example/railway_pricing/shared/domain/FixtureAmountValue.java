package com.example.railway_pricing.shared.domain;

public class FixtureAmountValue {
  public static Amount get(int n) {
    return Amount.from(n);
  }

  public static Amount zero() {
    return Amount.from(0);
  }
}
