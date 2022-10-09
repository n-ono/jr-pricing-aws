package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用前の自由席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedFreeSeatSuperExpressSurcharge {

  private static final Amount YEARLY_FIXED_AMOUNT = Amount.from(530);
  @Getter
  private final Amount amount;

  public static NotDiscountedFreeSeatSuperExpressSurcharge from(Amount amount) {
    return new NotDiscountedFreeSeatSuperExpressSurcharge(adjust(amount));
  }

  private static Amount adjust(Amount amount) {
    return amount.minus(YEARLY_FIXED_AMOUNT);
  }
}
