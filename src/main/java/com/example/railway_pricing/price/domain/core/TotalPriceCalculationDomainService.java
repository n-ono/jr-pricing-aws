package com.example.railway_pricing.price.domain.core;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.TripType;

/**
 * トータルの料金を計算するドメインサービス
 */
public class TotalPriceCalculationDomainService {

  public static TotalPrice calculate(
      Fare fare,
      SuperExpressSurcharge superExpressSurcharge,
      Passenger passenger,
      ComplimentaryPassenger complimentaryPassenger,
      TripType tripType) {
    Price price = fare.plus(superExpressSurcharge);
    ChildPrice childPrice = price.forChild();
    AdultPrice adultPrice = price.forAdult();
    ChargedPassenger chargedPassenger = passenger.exclude(complimentaryPassenger);
    return calculateTotalChildPrice(childPrice, chargedPassenger.getChildren(), tripType)
        .plus(calculateTotalAdultPrice(adultPrice, chargedPassenger.getAdults(), tripType));
  }

  private static TotalChildPrice calculateTotalChildPrice(
      ChildPrice childPrice, Children children, TripType tripType) {
    return tripType.isOneWay()
        ? childPrice.multiply(children)
        : childPrice.forRoundTrip().multiply(children);
  }

  private static TotalAdultPrice calculateTotalAdultPrice(
      AdultPrice adultPrice, Adults adults, TripType tripType) {
    return tripType.isOneWay()
        ? adultPrice.multiply(adults)
        : adultPrice.forRoundTrip().multiply(adults);
  }
}
