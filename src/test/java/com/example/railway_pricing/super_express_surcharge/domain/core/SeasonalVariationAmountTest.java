package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureAmountValue;
import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import org.junit.jupiter.api.Test;

class SeasonalVariationAmountTest {
  @Test
  public void peak() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(12, 25));

    assertEquals(FixtureAmountValue.get(200), actual.getAmount());
  }

  @Test
  public void offPeak() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(1, 20));

    assertEquals(FixtureAmountValue.get(-200), actual.getAmount());
  }

  @Test
  public void other() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(9, 4));

    assertEquals(FixtureAmountValue.zero(), actual.getAmount());
  }
}