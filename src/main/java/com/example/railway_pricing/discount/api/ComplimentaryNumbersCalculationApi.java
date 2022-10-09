package com.example.railway_pricing.discount.api;

import com.example.railway_pricing.discount.api.response.ComplimentaryNumbersCalculationApiResponse;
import com.example.railway_pricing.discount.api.converter.DiscountConverter;
import com.example.railway_pricing.discount.domain.core.ComplimentaryNumbers;
import com.example.railway_pricing.discount.service.DiscountCalculationService;
import com.example.railway_pricing.shared.api.annotation.AllowedAdults;
import com.example.railway_pricing.shared.api.annotation.AllowedChildren;
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
public class ComplimentaryNumbersCalculationApi {

  @Autowired
  private final DiscountCalculationService service;

  @RequestMapping(value = "/calculate-complimentary-numbers", method = RequestMethod.GET)
  public ComplimentaryNumbersCalculationApiResponse calculate(
      @RequestParam(name = "children") @AllowedChildren int children,
      @RequestParam(name = "adults") @AllowedAdults int adults) {
    ComplimentaryNumbers complimentaryNumbers =
        service.calculate(DiscountConverter.groupFrom(children, adults));
    return new ComplimentaryNumbersCalculationApiResponse(
        complimentaryNumbers.getChildren().getNumbers().getValue(),
        complimentaryNumbers.getAdults().getNumbers().getValue());
  }
}
