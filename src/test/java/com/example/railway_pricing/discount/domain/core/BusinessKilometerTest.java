package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BusinessKilometerTest {
  @ParameterizedTest
  @CsvSource({"601, 600", "601, 601"})
  public void isGreaterThanOrEqual(int src1, int src2) {
    BusinessKilometer longer = FixtureBusinessKilometerValue.get(src1);
    BusinessKilometer shorter = FixtureBusinessKilometerValue.get(src2);
    assertTrue(longer.isGreaterThanOrEqual(shorter));
  }

  @Test
  public void isNotGreaterThanOrEqual() {
    BusinessKilometer shorter = FixtureBusinessKilometerValue.get(601);
    BusinessKilometer longer = FixtureBusinessKilometerValue.get(602);
    assertFalse(shorter.isGreaterThanOrEqual(longer));
  }
}