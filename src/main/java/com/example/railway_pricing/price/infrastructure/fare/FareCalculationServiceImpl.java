package com.example.railway_pricing.price.infrastructure.fare;

import com.example.railway_pricing.price.domain.core.Fare;
import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.fare.FareCalculationService;
import com.example.railway_pricing.price.infrastructure.fare.response.FareCalculationResponse;
import com.example.railway_pricing.price.infrastructure.util.InfrastructureUtility;
import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class FareCalculationServiceImpl implements FareCalculationService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/calculate-fare?destination={destination}&trip-type={tripType}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public Fare calculate(
      Destination destination,
      TripType tripType,
      Passenger passenger,
      DepartureDate departureDate) {
    return Fare.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        FareCalculationResponse.class,
                        InfrastructureUtility.getDestination(destination),
                        InfrastructureUtility.getTripType(tripType),
                        InfrastructureUtility.getChildren(passenger),
                        InfrastructureUtility.getAdults(passenger),
                        InfrastructureUtility.getDepartureMonthDay(departureDate)))
                .getValue()));
  }
}
