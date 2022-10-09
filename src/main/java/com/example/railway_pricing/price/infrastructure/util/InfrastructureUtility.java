package com.example.railway_pricing.price.infrastructure.util;

import static io.vavr.API.$;

import com.example.railway_pricing.price.domain.core.Passenger;
import com.example.railway_pricing.shared.domain.DepartureDate;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;
import com.example.railway_pricing.shared.domain.TripType;
import io.vavr.API;

public class InfrastructureUtility {

  public static String getDestination(Destination destination) {
    return API.Match(destination)
        .of(
            API.Case($(Destination.SHINOSAKA), "shinosaka"),
            API.Case($(Destination.HIMEJI), "himeji"));
  }

  public static String getTripType(TripType tripType) {
    return API.Match(tripType)
        .of(API.Case($(TripType.ONE_WAY), "one-way"), API.Case($(TripType.ROUND), "round"));
  }

  public static String getTrainType(TrainType trainType) {
    return API.Match(trainType)
        .of(API.Case($(TrainType.NOZOMI), "nozomi"), API.Case($(TrainType.HIKARI), "hikari"));
  }

  public static String getSeatType(SeatType seatType) {
    return API.Match(seatType)
        .of(API.Case($(SeatType.FREE), "free"), API.Case($(SeatType.RESERVED), "reserved"));
  }

  public static int getChildren(Passenger passenger) {
    return passenger.getChildren().getNumbers().getValue();
  }

  public static int getAdults(Passenger passenger) {
    return passenger.getAdults().getNumbers().getValue();
  }

  public static String getDepartureMonthDay(DepartureDate departureDate) {
    return String.format("%02d%02d", departureDate.getMonthValue(), departureDate.getDayOfMonth());
  }
}
