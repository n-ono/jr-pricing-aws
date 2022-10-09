package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OffPeakTermTest {
  @ParameterizedTest
  @CsvSource({"1, 16", "1, 20", "1, 30"})
  public void include(int month, int dayOfMonth) {
    assertTrue(OffPeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }

  @ParameterizedTest
  @CsvSource({"1, 15", "1, 31"})
  public void notInclude(int month, int dayOfMonth) {
    assertFalse(OffPeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}