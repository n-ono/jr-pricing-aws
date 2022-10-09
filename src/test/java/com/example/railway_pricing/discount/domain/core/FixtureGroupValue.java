package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Numbers;

public class FixtureGroupValue {
  public static Group get(int children, int adults) {
    return new Group(
        Children.from(Numbers.from(children)),
        Adults.from(Numbers.from(adults)));
  }
}
