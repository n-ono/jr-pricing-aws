package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import com.example.railway_pricing.shared.domain.FixtureTripTypeValue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DiscountApplicationDomainServiceTest {
  @ParameterizedTest
  @CsvSource({
      "8910, one-way, 553, 1, 2, 9, 4, 8910",
      "8910, round, 553, 1, 2, 9, 4, 8910",
      "8910, round, 553, 3, 5, 9, 4, 7570",
      "8910, round, 553, 3, 5, 12, 21, 8010",
      "10010, one-way, 644, 1, 2, 9, 4, 10010",
      "10010, round, 644, 3, 5, 9, 4, 7650",
      "10010, round, 644, 3, 5, 1, 10, 8100"
  })
  public void fare(
      int amount,
      String tripType,
      int kilometer,
      int children,
      int adults,
      int month,
      int dayOfMonth,
      int expectedAmount) {
    DiscountAppliedFare actual =
        DiscountApplicationDomainService.apply(
            FixtureDiscountNotAppliedFareValue.get(amount),
            FixtureTripTypeValue.get(tripType),
            FixtureBusinessKilometerValue.get(kilometer),
            FixtureGroupValue.get(children, adults),
            FixtureDepartureMonthDayValue.get(month, dayOfMonth));

    assertEquals(DiscountAppliedFare.from(Amount.from(expectedAmount)), actual);
  }

  @ParameterizedTest
  @CsvSource({"5490, 2, 5, 9, 4, 5490", "5490, 3, 5, 9, 4, 4660", "5490, 3, 5, 12, 21, 4940"})
  public void superExpressSurcharge(
      int amount, int children, int adults, int month, int dayOfMonth, int expectedAmount) {
    DiscountAppliedSuperExpressSurcharge actual =
        DiscountApplicationDomainService.apply(
            FixtureDiscountNotAppliedSuperExpressSurchargeValue.get(amount),
            FixtureGroupValue.get(children, adults),
            FixtureDepartureMonthDayValue.get(month, dayOfMonth));

    assertEquals(DiscountAppliedSuperExpressSurcharge.from(Amount.from(expectedAmount)), actual);
  }
}