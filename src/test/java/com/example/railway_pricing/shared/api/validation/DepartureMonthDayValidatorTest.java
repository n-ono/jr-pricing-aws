package com.example.railway_pricing.shared.api.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.railway_pricing.shared.api.annotation.AllowedDepartureMonthDay;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepartureMonthDayValidatorTest {

  private Validator validator;

  @BeforeEach
  public void beforeEach() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }

  @Test
  public void valid() {
    TestBean bean = new TestBean("0904");
    assertTrue(validator.validate(bean).isEmpty());
  }

  @Test
  public void invalid() {
    TestBean bean = new TestBean("904");
    assertFalse(validator.validate(bean).isEmpty());
  }

  private static class TestBean {

    @AllowedDepartureMonthDay
    private String s;

    TestBean(String s) {
      this.s = s;
    }
  }
}