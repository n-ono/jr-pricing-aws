package com.example.railway_pricing.fare.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用前の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class NotDiscountedFare {

  @Getter
  private final Amount amount;

  public static NotDiscountedFare from(Amount amount) {
    return new NotDiscountedFare(amount);
  }
}
