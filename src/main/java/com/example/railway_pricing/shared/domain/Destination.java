package com.example.railway_pricing.shared.domain;

/**
 * 目的地
 * <p>
 * 新大阪 or 姫路
 */
public enum Destination {
  SHINOSAKA,
  HIMEJI;

  public boolean isShinOsaka() {
    return this == SHINOSAKA;
  }
}
