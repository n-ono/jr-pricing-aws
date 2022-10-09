package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureAdultsValue;
import org.junit.jupiter.api.Test;

class AdultPriceTest {
  @Test
  public void multiply() {
    assertEquals(
        FixtureTotalAdultPriceValue.get(30),
        FixtureAdultPriceValue.get(10).multiply(FixtureAdultsValue.get(3)));
  }
}