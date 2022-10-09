package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SeasonStartMonthDayTest {
  @Test
  public void isAfter() {
    assertTrue(
        FixtureSeasonStartMonthDayValue.get(9, 4).isAfter(FixtureDepartureMonthDayValue.get(9, 3)));
  }

  @ParameterizedTest
  @CsvSource({"9, 4", "9, 5"})
  public void isNotAfter(int month, int dayOfMonth) {
    assertFalse(
        FixtureSeasonStartMonthDayValue.get(9, 4)
            .isAfter(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}