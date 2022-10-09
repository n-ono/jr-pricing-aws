package com.example.railway_pricing.shared.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 子供の人数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Children {

  @Getter
  private final Numbers numbers;

  public static Children from(Numbers numbers) {
    return new Children(numbers);
  }

  public static Children zero() {
    return new Children(Numbers.zero());
  }

  public Children minus(Children other) {
    return new Children(numbers.minus(other.numbers));
  }
}
