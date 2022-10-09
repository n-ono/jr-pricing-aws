package com.example.railway_pricing.discount.domain.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.railway_pricing.shared.domain.FixtureNumbersValue;
import com.example.railway_pricing.shared.domain.Numbers;
import org.junit.jupiter.api.Test;

class DiscountDomainUtilityTest {
  @Test
  public void min() {
    Numbers numbers1 = FixtureNumbersValue.get(30);
    Numbers numbers2 = FixtureNumbersValue.get(20);

    assertEquals(Numbers.from(20), DiscountDomainUtility.min(numbers1, numbers2));
  }
}