package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureAmountValue;
import org.junit.jupiter.api.Test;

class NotDiscountedFreeSeatSuperExpressSurchargeTest {
  @Test
  public void adjust() {
    assertEquals(
        FixtureAmountValue.get(4960),
        FixtureNotDiscountedFreeSeatSuperExpressSurchargeValue.get(5490).getAmount());
  }
}