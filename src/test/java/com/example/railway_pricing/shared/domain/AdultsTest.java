package com.example.railway_pricing.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdultsTest {
  @Test
  public void minus() {
    Adults fiveAdults = FixtureAdultsValue.get(5);
    Adults threeAdults = FixtureAdultsValue.get(3);

    Adults twoAdults = fiveAdults.minus(threeAdults);

    assertEquals(twoAdults.getNumbers().getValue(), 2);
  }

  @Test
  public void zero() {
    assertEquals(Adults.from(Numbers.from(0)), Adults.zero());
  }
}