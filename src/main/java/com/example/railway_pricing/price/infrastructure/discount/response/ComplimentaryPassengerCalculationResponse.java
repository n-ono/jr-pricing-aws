package com.example.railway_pricing.price.infrastructure.discount.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplimentaryPassengerCalculationResponse {

  @Getter
  @Setter
  private int children;
  @Getter
  @Setter
  private int adults;
}
