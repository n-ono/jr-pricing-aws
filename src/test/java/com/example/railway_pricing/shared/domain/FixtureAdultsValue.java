package com.example.railway_pricing.shared.domain;

public class FixtureAdultsValue {
  public static Adults get(int n) {
    return Adults.from(Numbers.from(n));
  }
}
