package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * トータルの子供料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class TotalChildPrice {

  private final Amount amount;

  public static TotalChildPrice from(Amount amount) {
    return new TotalChildPrice(amount);
  }

  public TotalPrice plus(TotalAdultPrice totalAdultPrice) {
    return TotalPrice.from(amount.plus(totalAdultPrice.getAmount()));
  }
}
