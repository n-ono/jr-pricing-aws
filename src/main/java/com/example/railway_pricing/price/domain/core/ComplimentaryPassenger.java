package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 料金が無料になる乗客数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ComplimentaryPassenger {

  @Getter
  private final Children children;
  @Getter
  private final Adults adults;
}
