package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用前の指定席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedReservedSeatSuperExpressSurcharge {

  @Getter
  private final Amount amount;

  public static NotDiscountedReservedSeatSuperExpressSurcharge from(Amount amount) {
    return new NotDiscountedReservedSeatSuperExpressSurcharge(amount);
  }
}
