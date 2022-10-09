package com.example.railway_pricing.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.discount.domain.core.Percent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AmountTest {
  @ParameterizedTest
  @CsvSource({"10010, 10010", "10011, 10010"})
  public void adjust(int src, int expectedAmount) {
    assertEquals(
        FixtureAmountValue.get(expectedAmount),
        FixtureAmountValue.get(src));
  }

  @Test
  public void plus() {
    assertEquals(
        FixtureAmountValue.get(100),
        FixtureAmountValue.get(50).plus(FixtureAmountValue.get(50)));
  }

  @Test
  public void minus() {
    assertEquals(
        FixtureAmountValue.get(90),
        FixtureAmountValue.get(100).minus(FixtureAmountValue.get(10)));
  }

  @Test
  public void half() {
    assertEquals(
        FixtureAmountValue.get(50),
        FixtureAmountValue.get(100).half());
  }

  @Test
  public void twice() {
    assertEquals(
        FixtureAmountValue.get(100),
        FixtureAmountValue.get(50).twice());
  }

  @Test
  public void percentOf() {
    assertEquals(
        FixtureAmountValue.get(1000),
        FixtureAmountValue.get(10000).percentOf(Percent.ten()));
  }

}