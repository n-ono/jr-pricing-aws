package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引を適用する前の特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountNotAppliedSuperExpressSurcharge {

  @Getter
  private final Amount amount;

  public static DiscountNotAppliedSuperExpressSurcharge from(Amount amount) {
    return new DiscountNotAppliedSuperExpressSurcharge(amount);
  }

  public DiscountAppliedSuperExpressSurcharge applied(Percent percent) {
    return DiscountAppliedSuperExpressSurcharge.from(amount.percentOf(percent.rest()));
  }
}
