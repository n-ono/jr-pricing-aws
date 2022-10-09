package com.example.railway_pricing.discount.domain.core;

public class FixtureBusinessKilometerValue {
  public static BusinessKilometer get(int n) {
    return BusinessKilometer.from(n);
  }

  public static BusinessKilometer himeji() {
    return BusinessKilometer.from(644);
  }
}
