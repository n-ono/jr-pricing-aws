package com.example.railway_pricing.discount.service;

import com.example.railway_pricing.discount.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.discount.domain.core.BusinessKilometer;
import com.example.railway_pricing.discount.domain.core.ComplimentaryNumbers;
import com.example.railway_pricing.discount.domain.core.ComplimentaryNumbersCalculationDomainService;
import com.example.railway_pricing.discount.domain.core.DiscountApplicationDomainService;
import com.example.railway_pricing.discount.domain.core.DiscountAppliedFare;
import com.example.railway_pricing.discount.domain.core.DiscountAppliedSuperExpressSurcharge;
import com.example.railway_pricing.discount.domain.core.DiscountNotAppliedFare;
import com.example.railway_pricing.discount.domain.core.DiscountNotAppliedSuperExpressSurcharge;
import com.example.railway_pricing.discount.domain.core.Group;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountCalculationService {

  @Autowired
  private final CatalogueReferenceService catalogueReferenceService;

  public DiscountAppliedFare calculate(
      DiscountNotAppliedFare discountNotAppliedFare,
      TripType tripType,
      Destination destination,
      Group group,
      DepartureMonthDay departureMonthDay) {
    BusinessKilometer businessKilometer = catalogueReferenceService.findBy(destination);
    return DiscountApplicationDomainService.apply(
        discountNotAppliedFare, tripType, businessKilometer, group, departureMonthDay);
  }

  public DiscountAppliedSuperExpressSurcharge calculate(
      DiscountNotAppliedSuperExpressSurcharge discountNotAppliedSuperExpressSurcharge,
      Group group,
      DepartureMonthDay departureMonthDay) {
    return DiscountApplicationDomainService.apply(
        discountNotAppliedSuperExpressSurcharge, group, departureMonthDay);
  }

  public ComplimentaryNumbers calculate(Group group) {
    return ComplimentaryNumbersCalculationDomainService.calculate(group);
  }
}
