package com.example.railway_pricing.discount.api;

import com.example.railway_pricing.discount.api.converter.DiscountConverter;
import com.example.railway_pricing.discount.api.response.FareDiscountCalculationApiResponse;
import com.example.railway_pricing.discount.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.discount.domain.core.DiscountAppliedFare;
import com.example.railway_pricing.discount.service.DiscountCalculationService;
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
public class FareDiscountCalculationApi {

  @Autowired
  private final DiscountCalculationService service;
  @Autowired
  private final CatalogueReferenceService catalogueReferenceService;

  @RequestMapping(value = "/discount-fare", method = RequestMethod.GET)
  public FareDiscountCalculationApiResponse calculate(
      @RequestParam(name = "fare") int fare,
      @RequestParam(name = "trip-type") @AllowedTripType String tripType,
      @RequestParam(name = "destination") @AllowedDestination String destination,
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults,
      @RequestParam(name = "departure-month-day") @AllowedDepartureMonthDay String departureMonthDay) {
    DiscountAppliedFare discountAppliedFare =
        service.calculate(
            DiscountConverter.discountNotAppliedFareFrom(fare),
            ValueConverter.tripTypeFrom(tripType),
            ValueConverter.destinationFrom(destination),
            DiscountConverter.groupFrom(children, adults),
            ValueConverter.departureMonthDayFrom(departureMonthDay));
    return new FareDiscountCalculationApiResponse(discountAppliedFare.getAmount().getValue());
  }
}
