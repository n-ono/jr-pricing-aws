package com.example.railway_pricing.shared.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 人数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Numbers {

  @Getter
  private final int value;

  public static Numbers from(int value) {
    return new Numbers(value);
  }

  public static Numbers zero() {
    return new Numbers(0);
  }

  public static Numbers one() {
    return new Numbers(1);
  }

  public Numbers plus(Numbers other) {
    return new Numbers(value + other.value);
  }

  public Numbers minus(Numbers other) {
    return new Numbers(value - other.value);
  }

  public Numbers divide(Numbers other) {
    return new Numbers(value / other.value);
  }

  public boolean isGreaterThanOrEqual(Numbers other) {
    return other.value <= value;
  }

  public boolean isLessThan(Numbers other) {
    return value < other.value;
  }

  public boolean isLessThanOrEqual(Numbers other) {
    return value <= other.value;
  }
}
