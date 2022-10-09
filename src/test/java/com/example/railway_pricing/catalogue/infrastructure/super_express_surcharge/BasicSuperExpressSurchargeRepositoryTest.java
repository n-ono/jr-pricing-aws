package com.example.railway_pricing.catalogue.infrastructure.super_express_surcharge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicSuperExpressSurchargeRepositoryTest {
  @Autowired
  private BasicSuperExpressSurchargeRepository repository;

  static Stream<Arguments> superExpressSurchargeReferenceProvider() {
    return Stream.of(
        // のぞみ - 自由席 - 新大阪
        Arguments.of(
            "nozomi", "free", "shinosaka", 5810),
        // のぞみ - 自由席 - 姫路
        Arguments.of(
            "nozomi", "free", "himeji", 6450),
        // のぞみ - 指定席 - 新大阪
        Arguments.of(
            "nozomi", "reserved", "shinosaka", 5810),
        // のぞみ - 指定席 - 姫路
        Arguments.of(
            "nozomi", "reserved", "himeji", 6450),
        // ひかり - 自由席 - 新大阪
        Arguments.of(
            "hikari", "free", "shinosaka", 5490),
        // ひかり - 自由席 - 姫路
        Arguments.of(
            "hikari", "free", "himeji", 5920),
        // ひかり - 指定席 - 新大阪
        Arguments.of(
            "hikari", "reserved", "shinosaka", 5490),
        // ひかり - 指定席 - 姫路
        Arguments.of(
            "hikari", "reserved", "himeji", 5920));
  }

  @ParameterizedTest
  @MethodSource("superExpressSurchargeReferenceProvider")
  public void findAmountBy(
      String trainType, String seatType, String destination, int expected) {
    assertEquals(expected, repository.findBy(trainType, seatType, destination));
  }
}