package com.example.railway_pricing.discount.domain.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 営業キロ
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessKilometer {

  private final int value;

  public static BusinessKilometer from(int value) {
    return new BusinessKilometer(value);
  }

  public boolean isGreaterThanOrEqual(BusinessKilometer other) {
    return other.value <= value;
  }
}
