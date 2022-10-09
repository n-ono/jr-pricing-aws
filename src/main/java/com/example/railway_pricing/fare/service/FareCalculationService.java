package com.example.railway_pricing.fare.service;

import com.example.railway_pricing.fare.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.fare.domain.core.Fare;
import com.example.railway_pricing.fare.domain.core.NotDiscountedFare;
import com.example.railway_pricing.fare.domain.core.NotDiscountedFareCalculationDomainService;
import com.example.railway_pricing.fare.domain.core.Passenger;
import com.example.railway_pricing.fare.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FareCalculationService {

  @Autowired
  private final CatalogueReferenceService catalogueReferenceService;
  @Autowired
  private final DiscountCalculationService discountCalculationService;

  public Fare calculate(
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    Amount amount = catalogueReferenceService.findBy(destination);
    NotDiscountedFare notDiscountedFare =
        NotDiscountedFareCalculationDomainService.calculate(amount);
    return discountCalculationService.calculate(
        notDiscountedFare, tripType, destination, passenger, departureMonthDay);
  }
}
