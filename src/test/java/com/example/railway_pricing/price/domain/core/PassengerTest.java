package com.example.railway_pricing.price.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PassengerTest {
  @Test
  public void exclude() {
    assertEquals(
        FixtureChargedPassengerValue.get(0, 1),
        FixturePassengerValue.get(1, 2).exclude(FixtureComplimentaryPassengerValue.get(1, 1)));
  }
}