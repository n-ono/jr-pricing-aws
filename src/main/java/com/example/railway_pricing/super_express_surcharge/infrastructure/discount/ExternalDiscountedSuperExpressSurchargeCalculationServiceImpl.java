package com.example.railway_pricing.super_express_surcharge.infrastructure.discount;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.super_express_surcharge.domain.core.NotDiscountedSuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.core.Passenger;
import com.example.railway_pricing.super_express_surcharge.domain.core.SuperExpressSurcharge;
import com.example.railway_pricing.super_express_surcharge.domain.discount.DiscountCalculationService;
import com.example.railway_pricing.super_express_surcharge.infrastructure.discount.response.DiscountedSuperExpressSurchargeCalculationResponse;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalDiscountedSuperExpressSurchargeCalculationServiceImpl implements
    DiscountCalculationService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/discount-super-express-surcharge?super-express-surcharge={superExpressSurcharge}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public SuperExpressSurcharge calculate(
      NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    return SuperExpressSurcharge.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        DiscountedSuperExpressSurchargeCalculationResponse.class,
                        getAmount(notDiscountedSuperExpressSurcharge),
                        passenger.getChildren(),
                        passenger.getAdults(),
                        getDepartureMonthDay(departureMonthDay)))
                .getValue()));
  }

  private int getAmount(NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge) {
    return notDiscountedSuperExpressSurcharge.getAmount().getValue();
  }

  private String getDepartureMonthDay(DepartureMonthDay departureMonthDay) {
    return String.format(
        "%02d%02d", departureMonthDay.getMonthValue(), departureMonthDay.getDayOfMonth());
  }
}
