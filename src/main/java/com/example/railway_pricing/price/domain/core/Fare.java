package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 1 人分の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Fare {

  @Getter
  private final Amount amount;

  public static Fare from(Amount amount) {
    return new Fare(amount);
  }

  public Price plus(SuperExpressSurcharge superExpressSurcharge) {
    return Price.from(amount.plus(superExpressSurcharge.getAmount()));
  }
}
