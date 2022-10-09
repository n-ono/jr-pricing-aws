package com.example.railway_pricing.catalogue.infrastructure.fare;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BusinessKilometerRepositoryTest {
  @Autowired
  private BusinessKilometerRepository repository;

  static Stream<Arguments> businessKilometerReferenceProvider() {
    return Stream.of(
        Arguments.of("shinosaka", 553),
        Arguments.of("himeji", 644));
  }

  @ParameterizedTest
  @MethodSource("businessKilometerReferenceProvider")
  public void findBy(String destination, int expected) {
    assertEquals(expected, repository.findBy(destination));
  }
}