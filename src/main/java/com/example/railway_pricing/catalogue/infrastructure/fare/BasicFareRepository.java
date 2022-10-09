package com.example.railway_pricing.catalogue.infrastructure.fare;

import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BasicFareRepository {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public int findBy(String destination) {
    return Objects.requireNonNull(
        jdbcTemplate.queryForObject(
            "select amount from basic_fare where destination = ?",
            Integer.class,
            destination));
  }
}
