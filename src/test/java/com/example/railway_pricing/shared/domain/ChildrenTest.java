package com.example.railway_pricing.shared.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChildrenTest {
  @Test
  public void minus() {
    Children fiveChildren = FixtureChildrenValue.get(5);
    Children threeChildren = FixtureChildrenValue.get(3);

    Children twoChildren = fiveChildren.minus(threeChildren);

    assertEquals(twoChildren, FixtureChildrenValue.get(2));
  }

  @Test
  public void zero() {
    assertEquals(FixtureChildrenValue.get(0), Children.zero());
  }
}