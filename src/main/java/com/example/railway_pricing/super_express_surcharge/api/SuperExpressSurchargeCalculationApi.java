package com.example.railway_pricing.super_express_surcharge.api;

import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
import com.example.railway_pricing.shared.api.annotation.AllowedDepartureMonthDay;
import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
import com.example.railway_pricing.shared.api.annotation.AllowedSeatType;
import com.example.railway_pricing.shared.api.annotation.AllowedTrainType;
import com.example.railway_pricing.shared.api.converter.ValueConverter;
import com.example.railway_pricing.super_express_surcharge.api.response.SuperExpressSurchargeCalculationApiResponse;
import com.example.railway_pricing.super_express_surcharge.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.super_express_surcharge.domain.core.Passenger;
import com.example.railway_pricing.super_express_surcharge.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.super_express_surcharge.service.SuperExpressSurchargeCalculationService;
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
public class SuperExpressSurchargeCalculationApi {

  @Autowired
  private final SuperExpressSurchargeCalculationService service;
  @Autowired
  private final CatalogueReferenceService catalogueReferenceService;
  @Autowired
  private final DiscountCalculationService discountCalculationService;

  @RequestMapping(value = "/calculate-super-express-surcharge", method = RequestMethod.GET)
  public SuperExpressSurchargeCalculationApiResponse calculate(
      @RequestParam(name = "train-type") @AllowedTrainType String trainType,
      @RequestParam(name = "seat-type") @AllowedSeatType String seatType,
      @RequestParam(name = "destination") @AllowedDestination String destination,
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults,
      @RequestParam(name = "departure-month-day") @AllowedDepartureMonthDay String departureMonthDay) {
    SuperExpressSurcharge superExpressSurcharge =
        service.calculate(
            ValueConverter.trainTypeFrom(trainType),
            ValueConverter.seatTypeFrom(seatType),
            ValueConverter.destinationFrom(destination),
            getPassenger(children, adults),
            ValueConverter.departureMonthDayFrom(departureMonthDay));
    return new SuperExpressSurchargeCalculationApiResponse(
        superExpressSurcharge.getAmount().getValue());
  }

  private Passenger getPassenger(int children, int adults) {
    return new Passenger(children, adults);
  }
}
