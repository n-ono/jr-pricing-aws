package com.example.railway_pricing.shared.api.converter;

import static io.vavr.API.$;

import com.example.railway_pricing.shared.domain.Adults;
import com.example.railway_pricing.shared.domain.Children;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.DepartureMonthDay;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.Numbers;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import com.example.railway_pricing.shared.domain.TripType;
import io.vavr.API;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class ValueConverter {

  public static TrainType trainTypeFrom(String s) {
    return API.Match(s)
        .of(API.Case($("nozomi"), TrainType.NOZOMI), API.Case($("hikari"), TrainType.HIKARI));
  }

  public static SeatType seatTypeFrom(String s) {
    return API.Match(s)
        .of(API.Case($("free"), SeatType.FREE), API.Case($("reserved"), SeatType.RESERVED));
  }

  public static Destination destinationFrom(String s) {
    return API.Match(s)
        .of(
            API.Case($("shinosaka"), Destination.SHINOSAKA),
            API.Case($("himeji"), Destination.HIMEJI));
  }

  public static TripType tripTypeFrom(String s) {
    return API.Match(s)
        .of(API.Case($("one-way"), TripType.ONE_WAY), API.Case($("round"), TripType.ROUND));
  }

  public static Children childrenFrom(int n) {
    return Children.from(Numbers.from(n));
  }

  public static Adults adultsFrom(int n) {
    return Adults.from(Numbers.from(n));
  }

  public static DepartureDate departureDateFrom(String s) {
    return DepartureDate.from(
        LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyyMMdd"))
    );
  }

  public static DepartureMonthDay departureMonthDayFrom(String s) {
    return DepartureMonthDay.from(
        MonthDay.parse(s, DateTimeFormatter.ofPattern("MMdd"))
    );
  }

}
