package com.example.railway_pricing.shared.domain;

/**
 * 座席区分
 * <p>
 * 自由 or 指定
 */
public enum SeatType {
  FREE,
  RESERVED;

  public boolean isFree() {
    return this == FREE;
  }
}
