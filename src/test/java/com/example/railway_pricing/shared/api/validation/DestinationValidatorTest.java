package com.example.railway_pricing.shared.api.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.api.annotation.AllowedDestination;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DestinationValidatorTest {

  private Validator validator;

  @BeforeEach
  public void beforeEach() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @ParameterizedTest
  @CsvSource({"shinosaka", "himeji"})
  public void valid(String destination) {
    TestBean bean = new TestBean(destination);
    assertTrue(validator.validate(bean).isEmpty());
  }

  @Test
  public void invalid() {
    TestBean bean = new TestBean("tokyo");
    assertFalse(validator.validate(bean).isEmpty());
  }

  private static class TestBean {

    @AllowedDestination
    private String s;

    TestBean(String s) {
      this.s = s;
    }
  }
}