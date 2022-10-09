package com.example.railway_pricing.super_express_surcharge.service;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import com.example.railway_pricing.super_express_surcharge.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.super_express_surcharge.domain.core.NotDiscountedSuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.core.NotDiscountedSuperExpressSurchargeCalculationDomainService;
import com.example.railway_pricing.super_express_surcharge.domain.core.Passenger;
import com.example.railway_pricing.super_express_surcharge.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.discount.DiscountCalculationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuperExpressSurchargeCalculationService {

  @Autowired
  private final CatalogueReferenceService catalogueReferenceService;
  @Autowired
  private final DiscountCalculationService discountCalculationService;

  public SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    Amount amount = catalogueReferenceService.findBy(trainType, seatType, destination);
    NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge =
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            amount, seatType, departureMonthDay);
    return discountCalculationService.calculate(
        notDiscountedSuperExpressSurcharge, passenger, departureMonthDay);
  }
}
