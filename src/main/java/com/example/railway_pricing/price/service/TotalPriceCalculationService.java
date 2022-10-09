package com.example.railway_pricing.price.service;

import com.example.railway_pricing.price.domain.core.ComplimentaryPassenger;
import com.example.railway_pricing.price.domain.core.Fare;
import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.price.domain.core.TotalPrice;
import com.example.railway_pricing.price.domain.core.TotalPriceCalculationDomainService;
import com.example.railway_pricing.price.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.price.domain.fare.FareCalculationService;
import com.example.railway_pricing.price.domain.super_express_surcharge.SuperExpressSurchargeCalculationService;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import com.example.railway_pricing.shared.domain.TripType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TotalPriceCalculationService {

  @Autowired
  private final FareCalculationService fareCalculationService;
  @Autowired
  private final SuperExpressSurchargeCalculationService superExpressSurchargeCalculationService;
  @Autowired
  private final DiscountCalculationService discountCalculationService;

  public TotalPrice calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureDate departureDate) {
    Fare fare = fareCalculationService.calculate(destination, tripType, passenger, departureDate);
    SuperExpressSurcharge superExpressSurcharge =
        superExpressSurchargeCalculationService.calculate(
            trainType, seatType, destination, passenger, departureDate);
    ComplimentaryPassenger complimentaryPassenger = discountCalculationService.calculate(passenger);
    return TotalPriceCalculationDomainService.calculate(
        fare, superExpressSurcharge, passenger, complimentaryPassenger, tripType);
  }
}
