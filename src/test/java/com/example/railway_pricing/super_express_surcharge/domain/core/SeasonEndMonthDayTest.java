package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SeasonEndMonthDayTest {
  @Test
  public void isBefore() {
    assertTrue(
        FixtureSeasonEndMonthDayValue.get(9, 4).isBefore(FixtureDepartureMonthDayValue.get(9, 5)));
  }

  @ParameterizedTest
  @CsvSource({"9, 3", "9, 4"})
  public void isNotBefore(int month, int dayOfMonth) {
    assertFalse(
        FixtureSeasonEndMonthDayValue.get(9, 4)
            .isBefore(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}