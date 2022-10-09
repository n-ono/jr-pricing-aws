package com.example.railway_pricing.discount.api;

import com.example.railway_pricing.discount.api.converter.DiscountConverter;
import com.example.railway_pricing.discount.api.response.SuperExpressSurchargeDiscountCalculationApiResponse;
import com.example.railway_pricing.discount.domain.core.DiscountAppliedSuperExpressSurcharge;
import com.example.railway_pricing.discount.service.DiscountCalculationService;
import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
import com.example.railway_pricing.shared.api.annotation.AllowedDepartureMonthDay;
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
public class SuperExpressSurchargeDiscountCalculationApi {

  @Autowired
  private final DiscountCalculationService service;

  @RequestMapping(value = "/discount-super-express-surcharge", method = RequestMethod.GET)
  public SuperExpressSurchargeDiscountCalculationApiResponse calculate(
      @RequestParam(name = "super-express-surcharge") int superExpressSurcharge,
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults,
      @RequestParam(name = "departure-month-day") @AllowedDepartureMonthDay String departureMonthDay) {
    DiscountAppliedSuperExpressSurcharge discountAppliedSuperExpressSurcharge =
        service.calculate(
            DiscountConverter.discountNotAppliedSuperExpressSurchargeFrom(superExpressSurcharge),
            DiscountConverter.groupFrom(children, adults),
            ValueConverter.departureMonthDayFrom(departureMonthDay));
    return new SuperExpressSurchargeDiscountCalculationApiResponse(
        discountAppliedSuperExpressSurcharge.getAmount().getValue());
  }
}
