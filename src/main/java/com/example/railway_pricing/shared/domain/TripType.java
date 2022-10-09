package com.example.railway_pricing.shared.domain;

/**
 * 旅行区分
 * <p>
 * 片道 or 往復
 */
public enum TripType {
  ONE_WAY,
  ROUND;

  public boolean isOneWay() {
    return this == ONE_WAY;
  }
}
