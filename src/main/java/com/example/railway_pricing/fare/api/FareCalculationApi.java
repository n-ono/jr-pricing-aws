package com.example.railway_pricing.fare.api;

import com.example.railway_pricing.fare.api.response.FareCalculationApiResponse;
import com.example.railway_pricing.fare.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.fare.domain.core.Fare;
import com.example.railway_pricing.fare.domain.core.Passenger;
import com.example.railway_pricing.fare.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.fare.service.FareCalculationService;
import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
import com.example.railway_pricing.shared.api.annotation.AllowedDepartureMonthDay;
import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
import com.example.railway_pricing.shared.api.annotation.AllowedTripType;
import com.example.railway_pricing.shared.api.converter.ValueConverter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
public class FareCalculationApi {

  @Autowired
  private final FareCalculationService service;
  @Autowired
  private final CatalogueReferenceService catalogueService;
  @Autowired
  private final DiscountCalculationService discountService;

  @RequestMapping(value = "/calculate-fare", method = RequestMethod.GET)
  public FareCalculationApiResponse calculate(
      @RequestParam(name = "destination") @AllowedDestination String destination,
      @RequestParam(name = "trip-type") @AllowedTripType String tripType,
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults,
      @RequestParam(name = "departure-month-day") @AllowedDepartureMonthDay String departureMonthDay) {
    Fare fare =
        service.calculate(
            ValueConverter.destinationFrom(destination),
            ValueConverter.tripTypeFrom(tripType),
            getPassenger(children, adults),
            ValueConverter.departureMonthDayFrom(departureMonthDay));
    return new FareCalculationApiResponse(fare.getAmount().getValue());
  }

  private Passenger getPassenger(int children, int adults) {
    return new Passenger(children, adults);
  }
}
