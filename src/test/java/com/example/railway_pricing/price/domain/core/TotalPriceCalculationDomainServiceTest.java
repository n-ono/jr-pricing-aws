package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureTripTypeValue;
import org.junit.jupiter.api.Test;

class TotalPriceCalculationDomainServiceTest {
  @Test
  public void calculateForOneWayTrip() {
    TotalPrice actual =
        TotalPriceCalculationDomainService.calculate(
            FixtureFareValue.get(8910),
            FixtureSuperExpressSurchargeValue.get(5490),
            FixturePassengerValue.get(1, 2),
            FixtureComplimentaryPassengerValue.get(0, 0),
            FixtureTripTypeValue.get("one-way"));

    assertEquals(FixtureTotalPriceValue.get(36000), actual);
  }

  @Test
  public void calculateForRoundTrip() {
    TotalPrice actual =
        TotalPriceCalculationDomainService.calculate(
            FixtureFareValue.get(8910),
            FixtureSuperExpressSurchargeValue.get(5490),
            FixturePassengerValue.get(1, 2),
            FixtureComplimentaryPassengerValue.get(0, 0),
            FixtureTripTypeValue.get("round"));

    assertEquals(FixtureTotalPriceValue.get(72000), actual);
  }
}