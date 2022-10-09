package com.example.railway_pricing.fare.infrastructure.discount;

import com.example.railway_pricing.fare.domain.core.Fare;
import com.example.railway_pricing.fare.domain.core.NotDiscountedFare;
import com.example.railway_pricing.fare.domain.core.Passenger;
import com.example.railway_pricing.fare.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.fare.infrastructure.discount.response.DiscountResponse;
import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalDiscountedFareCalculationCalculationServiceImpl implements
    DiscountCalculationService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/discount-fare?fare={fare}&trip-type={tripType}&destination={destination}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public Fare calculate(
      NotDiscountedFare notDiscountedFare,
      TripType tripType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    return Fare.from(
        Amount.from(
            restTemplate
                .getForObject(
                    URL,
                    DiscountResponse.class,
                    notDiscountedFare.getAmount().getValue(),
                    getTripTypeString(tripType),
                    getDestinationString(destination),
                    passenger.getChildren(),
                    passenger.getAdults(),
                    getDepartureMonthDay(departureMonthDay))
                .getValue()));
  }

  private String getTripTypeString(TripType tripType) {
    return tripType.isOneWay() ? "one-way" : "round";
  }

  private String getDestinationString(Destination destination) {
    return destination.isShinOsaka() ? "shinosaka" : "himeji";
  }

  private String getDepartureMonthDay(DepartureMonthDay departureMonthDay) {
    return String.format(
        "%02d%02d", departureMonthDay.getMonthValue(), departureMonthDay.getDayOfMonth());
  }
}
