package com.example.railway_pricing.super_express_surcharge.domain.core;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Passenger {

  @Getter
  private final int children;
  @Getter
  private final int adults;
}
