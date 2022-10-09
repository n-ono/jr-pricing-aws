package com.example.railway_pricing.shared.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 大人の人数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Adults {

  @Getter
  private final Numbers numbers;

  public static Adults from(Numbers numbers) {
    return new Adults(numbers);
  }

  public static Adults zero() {
    return new Adults(Numbers.zero());
  }

  public Adults minus(Adults other) {
    return new Adults(numbers.minus(other.numbers));
  }
}
