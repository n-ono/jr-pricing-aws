package com.example.railway_pricing.discount.domain.core;

import com.example.railway_pricing.discount.domain.utility.DiscountDomainUtility;
import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.Numbers;

/**
 * 無料の人数を計算するドメインサービス
 */
public class ComplimentaryNumbersCalculationDomainService {

  public static ComplimentaryNumbers calculate(Group group) {
    final Numbers adultsNumbers = group.getAdults();
    final Numbers totalNumbers = group.total();
    if (isNormalGroup(group)) {
      Numbers complimentaryAdults = DiscountDomainUtility.min(adultsNumbers, Numbers.one());
      Numbers complimentaryChildren = Numbers.one().minus(complimentaryAdults);
      return new ComplimentaryNumbers(
          Children.from(complimentaryChildren), Adults.from(complimentaryAdults));
    } else if (group.isGreaterThanOrEqual(Numbers.from(51))) {
      Numbers maxComplimentaryNumbers = totalNumbers.divide(Numbers.from(50));
      Numbers complimentaryAdults =
          DiscountDomainUtility.min(adultsNumbers, maxComplimentaryNumbers);
      Numbers complimentaryChildren = maxComplimentaryNumbers.minus(complimentaryAdults);
      return new ComplimentaryNumbers(
          Children.from(complimentaryChildren), Adults.from(complimentaryAdults));
    } else {
      return new ComplimentaryNumbers(Children.zero(), Adults.zero());
    }
  }

  private static boolean isNormalGroup(Group group) {
    return group.isGreaterThanOrEqual(Numbers.from(31))
        && group.isLessThanOrEqual(Numbers.from(50));
  }
}
