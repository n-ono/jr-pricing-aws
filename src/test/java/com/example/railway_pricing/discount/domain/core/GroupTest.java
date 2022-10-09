package com.example.railway_pricing.discount.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.domain.FixtureNumbersValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GroupTest {
  @ParameterizedTest
  @CsvSource({"3, 5", "4, 5"})
  public void meetGroupDiscountAppliedCondition(int children, int adults) {
    assertTrue(FixtureGroupValue.get(children, adults).meetGroupDiscountAppliedCondition());
  }

  @ParameterizedTest
  @CsvSource({"0, 3", "2, 5"})
  public void notMeetGroupDiscountAppliedCondition(int children, int adults) {
    assertFalse(FixtureGroupValue.get(children, adults).meetGroupDiscountAppliedCondition());
  }

  @ParameterizedTest
  @CsvSource({"3, 2, 4", "3, 2, 5"})
  public void isGreaterThanOrEqual(int children, int adults, int numbers) {
    assertTrue(
        FixtureGroupValue.get(children, adults)
            .isGreaterThanOrEqual(FixtureNumbersValue.get(numbers)));
  }

  @Test
  public void isNotGreaterThanOrEqual() {
    assertFalse(FixtureGroupValue.get(3, 2).isGreaterThanOrEqual(FixtureNumbersValue.get(6)));
  }

  @ParameterizedTest
  @CsvSource({"3, 2, 5", "3, 2, 6"})
  public void isLessThanOrEqual(int children, int adults, int numbers) {
    assertTrue(
        FixtureGroupValue.get(children, adults)
            .isLessThanOrEqual(FixtureNumbersValue.get(numbers)));
  }

  @Test
  public void isNotLessThanOrEqual() {
    assertFalse(FixtureGroupValue.get(3, 2).isLessThanOrEqual(FixtureNumbersValue.get(4)));
  }

  @Test
  public void total() {
    assertEquals(FixtureNumbersValue.get(5), FixtureGroupValue.get(2, 3).total());
  }
}
