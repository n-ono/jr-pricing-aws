package com.example.railway_pricing.shared.domain;

import com.example.railway_pricing.discount.domain.core.Percent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 料金 10 円未満は切り捨てる
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount {

  @Getter
  private final int value;

  public static Amount from(int value) {
    return new Amount(adjust(value));
  }

  private static int adjust(int value) {
    return (int) Math.floor(value / 10) * 10;
  }

  public Amount plus(Amount other) {
    return new Amount(value + other.value);
  }

  public Amount minus(Amount other) {
    return new Amount(value - other.value);
  }

  public Amount multiply(Numbers numbers) {
    return new Amount(adjust(value * numbers.getValue()));
  }

  public Amount half() {
    return new Amount(adjust(value / 2));
  }

  public Amount twice() {
    return new Amount(adjust(value * 2));
  }

  public Amount percentOf(Percent percent) {
    return new Amount(adjust(value * percent.getValue() / 100));
  }
}
