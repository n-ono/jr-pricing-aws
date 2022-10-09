package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.*;

import com.example.railway_pricing.shared.domain.FixtureChildrenValue;
import org.junit.jupiter.api.Test;

class ChildPriceTest {
  @Test
  public void multiply() {
    assertEquals(
        FixtureTotalChildPriceValue.get(30),
        FixtureChildPriceValue.get(10).multiply(FixtureChildrenValue.get(3)));
  }
}