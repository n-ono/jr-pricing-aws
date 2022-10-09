package com.example.railway_pricing.super_express_surcharge.domain.core;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.SeatType;

/**
 * 割引適用前の特急料金を計算するドメインサービス
 */
public class NotDiscountedSuperExpressSurchargeCalculationDomainService {

  public static NotDiscountedSuperExpressSurcharge calculate(
      Amount amount, SeatType seatType, DepartureMonthDay departureMonthDay) {
    return seatType.isFree()
        ? calculateForFreeSeat(amount)
        : calculateForReservedSeat(amount, departureMonthDay);
  }

  private static NotDiscountedSuperExpressSurcharge calculateForFreeSeat(Amount amount) {
    NotDiscountedFreeSeatSuperExpressSurcharge notDiscountedFreeSeatSuperExpressSurcharge =
        NotDiscountedFreeSeatSuperExpressSurcharge.from(amount);
    return NotDiscountedSuperExpressSurcharge.from(notDiscountedFreeSeatSuperExpressSurcharge);
  }

  private static NotDiscountedSuperExpressSurcharge calculateForReservedSeat(
      Amount amount, DepartureMonthDay departureMonthDay) {
    SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge
        seasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge =
        SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge.from(amount);
    NotDiscountedReservedSeatSuperExpressSurcharge notDiscountedReservedSeatSuperExpressSurcharge =
        seasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge.adjust(
            SeasonalVariationAmount.from(departureMonthDay));
    return NotDiscountedSuperExpressSurcharge.from(notDiscountedReservedSeatSuperExpressSurcharge);
  }
}
