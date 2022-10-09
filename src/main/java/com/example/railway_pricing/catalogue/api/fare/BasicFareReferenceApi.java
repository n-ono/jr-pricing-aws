package com.example.railway_pricing.catalogue.api.fare;

import com.example.railway_pricing.catalogue.api.fare.response.BasicFareReferenceResponse;
import com.example.railway_pricing.catalogue.infrastructure.fare.BasicFareRepository;
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
public class BasicFareReferenceApi {

  @Autowired
  private final BasicFareRepository basicFareRepository;

  @RequestMapping(value = "/basic-fare", method = RequestMethod.GET)
  public BasicFareReferenceResponse refer(
      @RequestParam(name = "destination") @AllowedDestination String destination) {
    return new BasicFareReferenceResponse(
        basicFareRepository.findBy(destination)
    );
  }
}
