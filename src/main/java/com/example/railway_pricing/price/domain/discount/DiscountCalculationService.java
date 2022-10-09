package com.example.railway_pricing.price.domain.discount;

import com.example.railway_pricing.price.domain.core.ComplimentaryPassenger;
import com.example.railway_pricing.price.domain.core.Passenger;

public interface DiscountCalculationService {

  ComplimentaryPassenger calculate(Passenger passenger);
}
