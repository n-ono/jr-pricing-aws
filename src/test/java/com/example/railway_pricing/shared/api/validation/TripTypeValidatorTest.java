package com.example.railway_pricing.shared.api.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.api.annotation.AllowedTripType;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TripTypeValidatorTest {

  private Validator validator;

  @BeforeEach
  public void beforeEach() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @ParameterizedTest
  @CsvSource({"one-way", "round"})
  public void valid(String tripType) {
    TestBean bean = new TestBean(tripType);
    assertTrue(validator.validate(bean).isEmpty());
  }

  @Test
  public void invalid() {
    TestBean bean = new TestBean("oneway");
    assertFalse(validator.validate(bean).isEmpty());
  }

  private static class TestBean {

    @AllowedTripType
    private String s;

    TestBean(String s) {
      this.s = s;
    }
  }
}