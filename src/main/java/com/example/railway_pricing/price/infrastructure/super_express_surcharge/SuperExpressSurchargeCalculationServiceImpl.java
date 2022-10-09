package com.example.railway_pricing.price.infrastructure.super_express_surcharge;

import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.price.domain.super_express_surcharge.SuperExpressSurchargeCalculationService;
import com.example.railway_pricing.price.infrastructure.super_express_surcharge.response.SuperExpressSurchargeCalculationResponse;
import com.example.railway_pricing.price.infrastructure.util.InfrastructureUtility;
import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class SuperExpressSurchargeCalculationServiceImpl implements
    SuperExpressSurchargeCalculationService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/calculate-super-express-surcharge?train-type={trainType}&seat-type={seatType}&destination={destination}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureDate departureDate) {
    return SuperExpressSurcharge.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        SuperExpressSurchargeCalculationResponse.class,
                        InfrastructureUtility.getTrainType(trainType),
                        InfrastructureUtility.getSeatType(seatType),
                        InfrastructureUtility.getDestination(destination),
                        InfrastructureUtility.getChildren(passenger),
                        InfrastructureUtility.getAdults(passenger),
                        InfrastructureUtility.getDepartureMonthDay(departureDate)))
                .getValue()));
  }
}
