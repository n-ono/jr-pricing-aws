package com.example.railway_pricing.fare.domain.discount;

import com.example.railway_pricing.fare.domain.core.Fare;
import com.example.railway_pricing.fare.domain.core.NotDiscountedFare;
import com.example.railway_pricing.fare.domain.core.Passenger;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;

public interface DiscountCalculationService {

  Fare calculate(
      NotDiscountedFare notDiscountedFare,
      TripType tripType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay);
}
