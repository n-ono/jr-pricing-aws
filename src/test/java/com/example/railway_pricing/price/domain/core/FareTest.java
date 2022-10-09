package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FareTest {
  @Test
  public void plus() {
    assertEquals(
        FixturePriceValue.get(30),
        FixtureFareValue.get(10).plus(FixtureSuperExpressSurchargeValue.get(20)));
  }
}
