package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TotalChildPriceTest {
  @Test
  public void plus() {
    assertEquals(
        FixtureTotalPriceValue.get(50),
        FixtureTotalChildPriceValue.get(10).plus(FixtureTotalAdultPriceValue.get(40)));
  }
}
