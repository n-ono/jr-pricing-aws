package com.example.railway_pricing.shared.domain;

public class FixtureTripTypeValue {
  public static TripType get(String s) {
    return s.equals("one-way") ? TripType.ONE_WAY : TripType.ROUND;
  }
}
