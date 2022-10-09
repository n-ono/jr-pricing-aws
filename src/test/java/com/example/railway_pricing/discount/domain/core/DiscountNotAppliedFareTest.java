package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiscountNotAppliedFareTest {
  @Test
  public void applied() {
    GroupDiscountNotAppliedFare actual =
        FixtureDiscountNotAppliedFareValue.get(8090).applied(Percent.ten());

    assertEquals(FixtureGroupDiscountNotAppliedFareValue.get(7280), actual);
  }
}
