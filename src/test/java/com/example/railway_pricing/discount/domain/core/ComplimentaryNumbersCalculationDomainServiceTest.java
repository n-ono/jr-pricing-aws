package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComplimentaryNumbersCalculationDomainServiceTest {
  @ParameterizedTest
  @CsvSource({
      "0, 3, 0, 0",
      "3, 5, 0, 0",
      "31, 0, 1, 0",
      "31, 2, 0, 1",
      "151, 10, 0, 3",
      "151, 2, 1, 2"
  })
  public void calculate(int children, int adults, int expectedChildren, int expectedAdults) {
    Group group = FixtureGroupValue.get(children, adults);

    assertEquals(
        FixtureComplimentaryNumbersValue.get(expectedChildren, expectedAdults),
        ComplimentaryNumbersCalculationDomainService.calculate(group));
  }
}