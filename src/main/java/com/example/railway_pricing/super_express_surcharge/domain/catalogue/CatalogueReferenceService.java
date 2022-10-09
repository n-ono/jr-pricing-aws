package com.example.railway_pricing.super_express_surcharge.domain.catalogue;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.Destination;
import com.example.railway_pricing.shared.domain.SeatType;
import com.example.railway_pricing.shared.domain.TrainType;

public interface CatalogueReferenceService {

  Amount findBy(TrainType trainType, SeatType seatType, Destination destination);
}
