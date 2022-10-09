package com.example.railway_pricing.super_express_surcharge.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureAmountValue;
import com.example.railway_pricing.shared.domain.FixtureDepartureMonthDayValue;
import com.example.railway_pricing.shared.domain.SeatType;
import org.junit.jupiter.api.Test;

class NotDiscountedSuperExpressSurchargeCalculationDomainServiceTest {
  @Test
  public void calculateForFreeSeat() {
    assertEquals(
        FixtureNotDiscountedSuperExpressSurchargeValue
            .fromNotDiscountedFreeSeatSuperExpressSurcharge(5490),
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            FixtureAmountValue.get(5490),
            SeatType.FREE,
            FixtureDepartureMonthDayValue.get(12, 25)));
  }

  @Test
  public void calculateForReservedSeat() {
    assertEquals(
        FixtureNotDiscountedSuperExpressSurchargeValue
            .fromNotDiscountedReservedSeatSuperExpressSurcharge(6010),
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            FixtureAmountValue.get(5810),
            SeatType.RESERVED,
            FixtureDepartureMonthDayValue.get(12, 25)));
  }
}