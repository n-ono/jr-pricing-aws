package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 申込があった乗客数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Passenger {

  @Getter
  private final Children children;
  @Getter
  private final Adults adults;

  public ChargedPassenger exclude(ComplimentaryPassenger complimentaryPassenger) {
    return new ChargedPassenger(
        children.minus(complimentaryPassenger.getChildren()),
        adults.minus(complimentaryPassenger.getAdults()));
  }
}
