package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 無料の人数
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ComplimentaryNumbers {

  @Getter
  private final Children children;
  @Getter
  private final Adults adults;
}
