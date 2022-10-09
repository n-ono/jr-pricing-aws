package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割引適用前の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DiscountNotAppliedFare {

  @Getter
  private final Amount amount;

  public static DiscountNotAppliedFare from(Amount amount) {
    return new DiscountNotAppliedFare(amount);
  }

  public GroupDiscountNotAppliedFare applied(Percent percent) {
    return GroupDiscountNotAppliedFare.from(amount.percentOf(percent.rest()));
  }
}
