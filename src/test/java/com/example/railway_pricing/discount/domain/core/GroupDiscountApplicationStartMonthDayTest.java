package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GroupDiscountApplicationStartMonthDayTest {
  @Test
  public void isBefore() {
    assertTrue(
        FixtureGroupDiscountApplicationEndMonthDayValue.get(9, 3)
            .isBefore(FixtureDepartureMonthDayValue.get(9, 4)));
  }

  @ParameterizedTest
  @CsvSource({"9, 4, 9, 3", "9, 4, 9, 4"})
  public void isNotBefore(int month, int dayOfMonth, int expectedMonth, int expectedDayOfMonth) {
    assertFalse(
        FixtureGroupDiscountApplicationEndMonthDayValue.get(month, dayOfMonth)
            .isBefore(FixtureDepartureMonthDayValue.get(expectedMonth, expectedDayOfMonth)));
  }
}