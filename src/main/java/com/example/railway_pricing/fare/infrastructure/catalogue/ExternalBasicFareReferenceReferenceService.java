package com.example.railway_pricing.fare.infrastructure.catalogue;

import com.example.railway_pricing.fare.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.fare.infrastructure.catalogue.response.CatalogueResponse;
import com.example.railway_pricing.shared.domain.Amount;
import com.example.railway_pricing.shared.domain.Destination;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalBasicFareReferenceReferenceService implements CatalogueReferenceService {

  public static final String URL = "http://localhost:8080/railway_pricing/basic-fare?destination={destination}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public Amount findBy(Destination destination) {
    return Amount.from(
        Objects.requireNonNull(
                restTemplate.getForObject(
                    URL, CatalogueResponse.class, getDestinationString(destination)))
            .getValue());
  }

  private String getDestinationString(Destination destination) {
    return destination.isShinOsaka() ? "shinosaka" : "himeji";
  }
}
