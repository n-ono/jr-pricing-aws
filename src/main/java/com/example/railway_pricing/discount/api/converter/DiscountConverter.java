package com.example.railway_pricing.discount.api.converter;

import com.example.railway_pricing.discount.domain.core.DiscountNotAppliedFare;
import com.example.railway_pricing.discount.domain.core.DiscountNotAppliedSuperExpressSurcharge;
import com.example.railway_pricing.discount.domain.core.Group;
import com.example.railway_pricing.shared.api.converter.ValueConverter;
import com.example.railway_pricing.shared.domain.Amount;

public class DiscountConverter {

  public static DiscountNotAppliedFare discountNotAppliedFareFrom(int n) {
    return DiscountNotAppliedFare.from(Amount.from(n));
  }

  public static DiscountNotAppliedSuperExpressSurcharge discountNotAppliedSuperExpressSurchargeFrom(
      int n) {
    return DiscountNotAppliedSuperExpressSurcharge.from(Amount.from(n));
  }

  public static Group groupFrom(int children, int adults) {
    return new Group(
        ValueConverter.childrenFrom(children),
        ValueConverter.adultsFrom(adults));
  }
}
