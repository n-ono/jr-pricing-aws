package com.example.railway_pricing.super_express_surcharge.domain.discount;

import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.super_express_surcharge.domain.core.NotDiscountedSuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.core.Passenger;
import com.example.railway_pricing.super_express_surcharge.domain.core.SuperExpressSurcharge;

public interface DiscountCalculationService {

  SuperExpressSurcharge calculate(
      NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge,
      Passenger passenger,
      DepartureMonthDay departureMonthDay);
}
