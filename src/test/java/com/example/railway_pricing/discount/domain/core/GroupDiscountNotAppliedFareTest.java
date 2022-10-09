package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.Amount;
import org.junit.jupiter.api.Test;

public class GroupDiscountNotAppliedFareTest {
  @Test
  public void applied() {
    assertEquals(
        DiscountAppliedFare.from(Amount.from(900)),
        FixtureGroupDiscountNotAppliedFareValue.get(1000).applied(Percent.ten()));
  }
}
