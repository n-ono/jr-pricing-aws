package com.example.railway_pricing.catalogue.infrastructure.super_express_surcharge;

import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BasicSuperExpressSurchargeRepository {

  @Autowired
  private final JdbcTemplate jdbcTemplate;

  public int findBy(String trainType, String seatType, String destination) {
    return
        Objects.requireNonNull(
            jdbcTemplate.queryForObject(
                "select amount from basic_super_express_surcharge where train_type = ? and seat_type = ? and destination = ?",
                Integer.class,
                trainType,
                seatType,
                destination));
  }
}
