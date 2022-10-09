package com.example.railway_pricing.fare.domain.catalogue;

import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.Destination;

public interface CatalogueReferenceService {

  Amount findBy(Destination destination);
}
