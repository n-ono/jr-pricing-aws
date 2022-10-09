package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 団体割引適用前の運賃
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDiscountNotAppliedFare {

  @Getter
  private final Amount amount;

  public static GroupDiscountNotAppliedFare from(Amount amount) {
    return new GroupDiscountNotAppliedFare(amount);
  }

  public DiscountAppliedFare applied(Percent percent) {
    return DiscountAppliedFare.from(amount.percentOf(percent.rest()));
  }
}
