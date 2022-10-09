package com.example.railway_pricing.discount.domain.utility;

import com.example.railway_pricing.shared.domain.Numbers;

public class DiscountDomainUtility {

  public static Numbers min(Numbers numbers1, Numbers numbers2) {
    return numbers1.isLessThan(numbers2) ? numbers1 : numbers2;
  }
}
