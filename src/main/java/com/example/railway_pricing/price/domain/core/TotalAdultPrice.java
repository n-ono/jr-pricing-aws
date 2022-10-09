package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * トータルの大人料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class TotalAdultPrice {

  @Getter
  private final Amount amount;

  public static TotalAdultPrice from(Amount amount) {
    return new TotalAdultPrice(amount);
  }
}
