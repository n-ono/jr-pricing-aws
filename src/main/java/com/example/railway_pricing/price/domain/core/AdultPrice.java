package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Amount;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 大人 1 人分の料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdultPrice {

  @Getter
  private final Amount amount;

  public static AdultPrice from(Amount amount) {
    return new AdultPrice(amount);
  }

  public AdultPrice forRoundTrip() {
    return new AdultPrice(amount.twice());
  }

  public TotalAdultPrice multiply(Adults adults) {
    return TotalAdultPrice.from(amount.multiply(adults.getNumbers()));
  }
}
