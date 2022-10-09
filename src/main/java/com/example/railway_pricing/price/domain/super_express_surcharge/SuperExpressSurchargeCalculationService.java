package com.example.railway_pricing.price.domain.super_express_surcharge;

import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.price.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;

public interface SuperExpressSurchargeCalculationService {

  SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureDate departureDate);
}
