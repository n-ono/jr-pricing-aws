package com.example.railway_pricing.discount.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ComplimentaryNumbersCalculationApiResponse {

  @Getter
  private final int children;
  @Getter
  private final int adults;
}
