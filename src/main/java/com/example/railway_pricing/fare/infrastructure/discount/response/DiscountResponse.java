package com.example.railway_pricing.fare.infrastructure.discount.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountResponse {

  @Getter
  @Setter
  private int value;
}
