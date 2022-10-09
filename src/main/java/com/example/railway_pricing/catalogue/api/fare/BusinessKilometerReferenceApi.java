package com.example.railway_pricing.catalogue.api.fare;

import com.example.railway_pricing.catalogue.api.fare.response.BusinessKilometerReferenceResponse;
import com.example.railway_pricing.catalogue.infrastructure.fare.BusinessKilometerRepository;
import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
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
public class BusinessKilometerReferenceApi {

  @Autowired
  private final BusinessKilometerRepository businessKilometerRepository;

  @RequestMapping(value = "/business-kilometer", method = RequestMethod.GET)
  public BusinessKilometerReferenceResponse refer(
      @RequestParam(name = "destination") @AllowedDestination String destination) {
    return new BusinessKilometerReferenceResponse(
        businessKilometerRepository.findBy(destination)
    );
  }
}
