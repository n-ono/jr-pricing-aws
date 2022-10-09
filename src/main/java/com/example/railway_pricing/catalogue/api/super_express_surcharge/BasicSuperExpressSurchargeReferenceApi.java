package com.example.railway_pricing.catalogue.api.super_express_surcharge;

import com.example.railway_pricing.catalogue.api.super_express_surcharge.response.BasicSuperExpressSurchargeReferenceResponse;
import com.example.railway_pricing.catalogue.infrastructure.super_express_surcharge.BasicSuperExpressSurchargeRepository;
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
public class BasicSuperExpressSurchargeReferenceApi {

  @Autowired
  private final BasicSuperExpressSurchargeRepository basicSuperExpressSurchargeRepository;

  @RequestMapping(value = "/basic-super-express-surcharge", method = RequestMethod.GET)
  public BasicSuperExpressSurchargeReferenceResponse refer(
      @RequestParam(name = "train-type") String trainType,
      @RequestParam(name = "seat-type") String seatType,
      @RequestParam(name = "destination") String destination) {
    return new BasicSuperExpressSurchargeReferenceResponse(
        basicSuperExpressSurchargeRepository.findBy(trainType, seatType, destination)
    );
  }
}
