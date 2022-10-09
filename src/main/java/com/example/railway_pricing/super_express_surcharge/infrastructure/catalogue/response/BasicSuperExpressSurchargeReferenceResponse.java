package com.example.railway_pricing.super_express_surcharge.infrastructure.catalogue.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicSuperExpressSurchargeReferenceResponse {

  @Getter
  @Setter
  private int value;
}
