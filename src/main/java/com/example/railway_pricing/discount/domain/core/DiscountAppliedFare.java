package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用済み運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountAppliedFare {

  @Getter
  private final Amount amount;

  public static DiscountAppliedFare from(Amount amount) {
    return new DiscountAppliedFare(amount);
  }
}
