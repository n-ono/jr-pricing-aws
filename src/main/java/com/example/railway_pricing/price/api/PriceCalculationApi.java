package com.example.railway_pricing.price.api;

import com.example.railway_pricing.price.api.response.PriceCalculationApiResponse;
import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.core.TotalPrice;
import com.example.railway_pricing.price.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.price.domain.fare.FareCalculationService;
import com.example.railway_pricing.price.domain.super_express_surcharge.SuperExpressSurchargeCalculationService;
import com.example.railway_pricing.price.service.TotalPriceCalculationService;
import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
import com.example.railway_pricing.shared.api.annotation.AllowedDepartureDate;
import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
import com.example.railway_pricing.shared.api.annotation.AllowedSeatType;
import com.example.railway_pricing.shared.api.annotation.AllowedTrainType;
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
public class PriceCalculationApi {
  @Autowired
  private final TotalPriceCalculationService service;
  @Autowired
  private final FareCalculationService fareRepository;
  @Autowired
  private final SuperExpressSurchargeCalculationService superExpressSurchargeRepository;
  @Autowired
  private final DiscountCalculationService discountRepository;

  @RequestMapping(value = "/calculate-price", method = RequestMethod.GET)
  public PriceCalculationApiResponse calculate(
      @RequestParam(name = "train-type") @AllowedTrainType String trainType,
      @RequestParam(name = "seat-type") @AllowedSeatType String seatType,
      @RequestParam(name = "destination") @AllowedDestination String destination,
      @RequestParam(name = "trip-type") @AllowedTripType String tripType,
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults,
      @RequestParam(name = "departure-date") @AllowedDepartureDate String departureDate) {
    TotalPrice totalPrice =
        service.calculate(
            ValueConverter.trainTypeFrom(trainType),
            ValueConverter.seatTypeFrom(seatType),
            ValueConverter.destinationFrom(destination),
            ValueConverter.tripTypeFrom(tripType),
            new Passenger(ValueConverter.childrenFrom(children), ValueConverter.adultsFrom(adults)),
            ValueConverter.departureDateFrom(departureDate));
    return new PriceCalculationApiResponse(totalPrice.getAmount().getValue());
  }
}
