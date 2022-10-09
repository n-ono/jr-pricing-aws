package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引を適用した特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountAppliedSuperExpressSurcharge {

  @Getter
  private final Amount amount;

  public static DiscountAppliedSuperExpressSurcharge from(Amount amount) {
    return new DiscountAppliedSuperExpressSurcharge(amount);
  }
}
