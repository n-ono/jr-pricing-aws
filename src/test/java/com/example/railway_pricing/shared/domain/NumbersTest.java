package com.example.railway_pricing.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersTest {
  @Test
  public void zero() {
    assertEquals(Numbers.from(0), Numbers.zero());
  }

  @Test
  public void one() {
    assertEquals(Numbers.from(1), Numbers.one());
  }

  @Test
  public void plus() {
    assertEquals(Numbers.from(100), FixtureNumbersValue.get(1).plus(FixtureNumbersValue.get(99)));
  }

  @Test
  public void minus() {
    assertEquals(Numbers.from(90), FixtureNumbersValue.get(100).minus(FixtureNumbersValue.get(10)));
  }

  @Test
  public void divide() {
    assertEquals(
        Numbers.from(10), FixtureNumbersValue.get(100).divide(FixtureNumbersValue.get(10)));
  }

  @ParameterizedTest
  @CsvSource({"2, 1", "2, 2"})
  public void isGreaterThanOrEqual(int x, int y) {
    assertTrue(Numbers.from(x).isGreaterThanOrEqual(FixtureNumbersValue.get(y)));
  }

  @Test
  public void isNotGreaterThanOrEqual() {
    assertFalse(Numbers.from(1).isGreaterThanOrEqual(FixtureNumbersValue.get(2)));
  }

  @Test
  public void isLessThan() {
    assertTrue(Numbers.from(1).isLessThan(FixtureNumbersValue.get(2)));
  }

  @ParameterizedTest
  @CsvSource({"2, 1", "2, 2"})
  public void isNotLessThan(int x, int y) {
    assertFalse(Numbers.from(x).isLessThan(FixtureNumbersValue.get(y)));
  }

  @Test
  public void isLessThanOrEqual() {
    assertTrue(Numbers.from(2).isLessThan(FixtureNumbersValue.get(3)));
  }

  @ParameterizedTest
  @CsvSource({"2, 1", "2, 2"})
  public void isNotLessThanOrEqual(int x, int y) {
    assertFalse(Numbers.from(x).isLessThan(FixtureNumbersValue.get(y)));
  }

}