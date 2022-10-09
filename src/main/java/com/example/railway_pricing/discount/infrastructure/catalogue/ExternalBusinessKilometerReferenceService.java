package com.example.railway_pricing.discount.infrastructure.catalogue;

import static io.vavr.API.$;

import com.example.railway_pricing.discount.domain.catalogue.CatalogueReferenceService;
import com.example.railway_pricing.discount.domain.core.BusinessKilometer;
import com.example.railway_pricing.discount.infrastructure.catalogue.response.CatalogueResponse;
import com.example.railway_pricing.shared.domain.Destination;
import io.vavr.API;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class ExternalBusinessKilometerReferenceService implements CatalogueReferenceService {

  public static final String URL =
      "http://localhost:8080/railway_pricing/business-kilometer?destination={destination}";

  @Autowired
  private final RestTemplate restTemplate;

  @Override
  public BusinessKilometer findBy(Destination destination) {
    return BusinessKilometer.from(
        Objects.requireNonNull(
                restTemplate.getForObject(
                    URL, CatalogueResponse.class, getDestination(destination)))
            .getValue());
  }

  private String getDestination(Destination destination) {
    return API.Match(destination)
        .of(
            API.Case($(Destination.SHINOSAKA), "shinosaka"),
            API.Case($(Destination.HIMEJI), "himeji"));
  }
}
