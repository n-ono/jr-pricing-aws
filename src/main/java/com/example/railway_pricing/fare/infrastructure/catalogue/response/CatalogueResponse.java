package com.example.railway_pricing.fare.infrastructure.catalogue.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogueResponse {

  @Getter
  @Setter
  private int value;
}
