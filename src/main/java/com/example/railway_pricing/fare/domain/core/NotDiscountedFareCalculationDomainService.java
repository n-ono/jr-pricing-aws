package com.example.railway_pricing.fare.domain.core;

import com.example.railway_pricing.shared.domain.Amount;

/**
 * 割引適用前の運賃を計算するドメインサービス
 */
public class NotDiscountedFareCalculationDomainService {

  public static NotDiscountedFare calculate(Amount amount) {
    return NotDiscountedFare.from(amount);
  }
}
