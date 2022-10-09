package com.example.railway_pricing.price.infrastructure.discount;

import com.example.railway_pricing.price.domain.core.ComplimentaryPassenger;
import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.price.infrastructure.discount.response.ComplimentaryPassengerCalculationResponse;
import com.example.railway_pricing.price.infrastructure.util.InfrastructureUtility;
import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Numbers;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalComplimentaryPassengerCalculationService implements
    DiscountCalculationService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/calculate-complimentary-numbers?children={children}&adults={adults}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public ComplimentaryPassenger calculate(Passenger passenger) {
    ComplimentaryPassengerCalculationResponse response =
        restTemplate.getForObject(
            URL,
            ComplimentaryPassengerCalculationResponse.class,
            InfrastructureUtility.getChildren(passenger),
            InfrastructureUtility.getAdults(passenger));
    Objects.requireNonNull(response);
    Children children = Children.from(Numbers.from(response.getChildren()));
    Adults adults = Adults.from(Numbers.from(response.getAdults()));
    return new ComplimentaryPassenger(children, adults);
  }
}
