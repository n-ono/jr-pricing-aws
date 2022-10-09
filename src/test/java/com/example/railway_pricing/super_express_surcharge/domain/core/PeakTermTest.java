package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PeakTermTest {
  @ParameterizedTest
  @CsvSource({"12, 25", "1, 10", "1, 1"})
  public void include(int month, int dayOfMonth) {
    assertTrue(PeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }

  @ParameterizedTest
  @CsvSource({"12, 24", "1, 11"})
  public void notInclude(int month, int dayOfMonth) {
    assertFalse(PeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}
