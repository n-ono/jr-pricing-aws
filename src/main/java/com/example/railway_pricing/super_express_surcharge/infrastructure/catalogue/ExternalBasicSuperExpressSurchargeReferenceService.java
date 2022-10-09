package com.example.railway_pricing.super_express_surcharge.infrastructure.catalogue;

import static io.vavr.API.$;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import com.example.railway_pricing.super_express_surcharge.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.super_express_surcharge.infrastructure.catalogue.response.BasicSuperExpressSurchargeReferenceResponse;
import io.vavr.API;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalBasicSuperExpressSurchargeReferenceService implements
    CatalogueReferenceService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/basic-super-express-surcharge?train-type={trainType}&seat-type={seatType}&destination={destination}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public Amount findBy(TrainType trainType, SeatType seatType, Destination destination) {
    return Amount.from(
        Objects.requireNonNull(
                restTemplate.getForObject(
                    URL,
                    BasicSuperExpressSurchargeReferenceResponse.class,
                    getTrainType(trainType),
                    getSeatType(seatType),
                    getDestination(destination)))
            .getValue());
  }

  private String getTrainType(TrainType trainType) {
    return API.Match(trainType)
        .of(API.Case($(TrainType.NOZOMI), "nozomi"), API.Case($(TrainType.HIKARI), "hikari"));
  }

  private String getSeatType(SeatType seatType) {
    return API.Match(seatType)
        .of(API.Case($(SeatType.FREE), "free"), API.Case($(SeatType.RESERVED), "reserved"));
  }

  private String getDestination(Destination destination) {
    return API.Match(destination)
        .of(
            API.Case($(Destination.SHINOSAKA), "shinosaka"),
            API.Case($(Destination.HIMEJI), "himeji"));
  }
}
