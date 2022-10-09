package com.example.railway_pricing.fare.domain.discount;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用後の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountedAmount {

  @Getter
  private final Amount amount;

  public static DiscountedAmount from(Amount amount) {
    return new DiscountedAmount(amount);
  }
}
