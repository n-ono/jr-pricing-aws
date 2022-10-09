package com.example.railway_pricing.price.domain.fare;

import com.example.railway_pricing.price.domain.core.Fare;
import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.TripType;

public interface FareCalculationService {

  Fare calculate(
      Destination destination, TripType tripType, Passenger passenger, DepartureDate departureDate);
}
