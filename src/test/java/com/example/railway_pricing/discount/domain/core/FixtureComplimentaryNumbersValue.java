package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Numbers;

public class FixtureComplimentaryNumbersValue {
  public static ComplimentaryNumbers get(int children, int adults) {
    return new ComplimentaryNumbers(
        Children.from(Numbers.from(children)),
        Adults.from(Numbers.from(adults)));
  }
}
