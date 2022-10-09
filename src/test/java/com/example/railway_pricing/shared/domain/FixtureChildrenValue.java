package com.example.railway_pricing.shared.domain;

public class FixtureChildrenValue {
  public static Children get(int n) {
    return Children.from(Numbers.from(n));
  }
}
