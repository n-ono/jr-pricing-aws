package com.example.railway_pricing.discount.domain.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 割合
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Percent {

  @Getter
  private final int value;

  public static Percent zero() {
    return new Percent(0);
  }

  public static Percent ten() {
    return new Percent(10);
  }

  public static Percent fifteen() {
    return new Percent(15);
  }

  public Percent rest() {
    return new Percent(100 - value);
  }
}
