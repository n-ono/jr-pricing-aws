package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiscountNotAppliedSuperExpressSurchargeTest {
  @Test
  public void applied() {
    DiscountAppliedSuperExpressSurcharge actual =
        FixtureDiscountNotAppliedSuperExpressSurchargeValue.get(5810).applied(Percent.fifteen());

    assertEquals(FixtureDiscountAppliedSuperExpressSurchargeValue.get(4930), actual);
  }
}
