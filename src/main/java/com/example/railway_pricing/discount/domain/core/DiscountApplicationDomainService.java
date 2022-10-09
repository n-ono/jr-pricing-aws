package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.TripType;

/**
 * 割引を適用するドメインサービス
 */
public class DiscountApplicationDomainService {

  public static DiscountAppliedFare apply(
      DiscountNotAppliedFare discountNotAppliedFare,
      TripType tripType,
      BusinessKilometer businessKilometer,
      Group group,
      DepartureMonthDay departureMonthDay) {
    GroupDiscountNotAppliedFare groupDiscountNotAppliedFare =
        applyRoundTripDiscount(discountNotAppliedFare, tripType, businessKilometer);
    return applyGroupDiscount(groupDiscountNotAppliedFare, group, departureMonthDay);
  }

  public static DiscountAppliedSuperExpressSurcharge apply(
      DiscountNotAppliedSuperExpressSurcharge discountNotAppliedSuperExpressSurcharge,
      Group group,
      DepartureMonthDay departureMonthDay) {
    return applyGroupDiscount(discountNotAppliedSuperExpressSurcharge, group, departureMonthDay);
  }

  private static GroupDiscountNotAppliedFare applyRoundTripDiscount(
      DiscountNotAppliedFare discountNotAppliedFare,
      TripType tripType,
      BusinessKilometer businessKilometer) {
    if (tripType.isOneWay()) {
      return GroupDiscountNotAppliedFare.from(discountNotAppliedFare.getAmount());
    } else if (businessKilometer.isGreaterThanOrEqual(BusinessKilometer.from(601))) {
      return discountNotAppliedFare.applied(Percent.ten());
    } else {
      return GroupDiscountNotAppliedFare.from(discountNotAppliedFare.getAmount());
    }
  }

  private static DiscountAppliedFare applyGroupDiscount(
      GroupDiscountNotAppliedFare groupDiscountNotAppliedFare,
      Group group,
      DepartureMonthDay departureMonthDay) {
    return groupDiscountNotAppliedFare.applied(
        calculateGroupDiscountPercentage(group, departureMonthDay));
  }

  private static DiscountAppliedSuperExpressSurcharge applyGroupDiscount(
      DiscountNotAppliedSuperExpressSurcharge discountNotAppliedSuperExpressSurcharge,
      Group group,
      DepartureMonthDay departureMonthDay) {
    return discountNotAppliedSuperExpressSurcharge.applied(
        calculateGroupDiscountPercentage(group, departureMonthDay));
  }

  private static Percent calculateGroupDiscountPercentage(
      Group group, DepartureMonthDay departureMonthDay) {
    if (group.meetGroupDiscountAppliedCondition()) {
      if (GroupDiscountTenPercentApplicationTerm.include(departureMonthDay)) {
        return Percent.ten();
      } else {
        return Percent.fifteen();
      }
    } else {
      return Percent.zero();
    }
  }
}
