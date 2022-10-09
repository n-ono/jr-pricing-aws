package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 子供 1 人分の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChildPrice {

  @Getter
  private final Amount amount;

  public static ChildPrice from(Amount amount) {
    return new ChildPrice(amount);
  }

  public ChildPrice forRoundTrip() {
    return new ChildPrice(amount.twice());
  }

  public TotalChildPrice multiply(Children children) {
    return TotalChildPrice.from(amount.multiply(children.getNumbers()));
  }
}
