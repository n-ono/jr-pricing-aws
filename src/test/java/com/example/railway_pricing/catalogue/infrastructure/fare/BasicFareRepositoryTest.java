package com.example.railway_pricing.catalogue.infrastructure.fare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicFareRepositoryTest {
  @Autowired
  private BasicFareRepository repository;

  static Stream<Arguments> fareReferenceProvider() {
    return Stream.of(
        Arguments.of("shinosaka", 8910),
        Arguments.of("himeji", 10010));
  }

  @ParameterizedTest
  @MethodSource("fareReferenceProvider")
  public void findBy(String destination, int expected) {
    assertEquals(expected, repository.findBy(destination));
  }
}