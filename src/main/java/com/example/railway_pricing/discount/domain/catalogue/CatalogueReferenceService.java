package com.example.railway_pricing.discount.domain.catalogue;

import com.example.railway_pricing.discount.domain.core.BusinessKilometer;
import com.example.railway_pricing.shared.domain.Destination;

public interface CatalogueReferenceService {

  BusinessKilometer findBy(Destination destination);
}
