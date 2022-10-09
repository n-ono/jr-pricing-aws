package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Numbers;

public class FixtureComplimentaryPassengerValue {
  public static ComplimentaryPassenger get(int children, int adults) {
    return new ComplimentaryPassenger(
        Children.from(Numbers.from(children)), Adults.from(Numbers.from(adults)));
  }
}
