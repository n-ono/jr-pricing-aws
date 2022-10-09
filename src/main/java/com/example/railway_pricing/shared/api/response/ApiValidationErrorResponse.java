package com.example.railway_pricing.shared.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiValidationErrorResponse implements Serializable {

  private final String message;

  @Getter
  @RequiredArgsConstructor
  private static class ValidationMessage implements Serializable {

    private final String message;
  }

  @JsonInclude(Include.NON_EMPTY)
  private List<ValidationMessage> validationMessages = new ArrayList<>();

  public void addValidationMessage(String message) {
    validationMessages.add(new ValidationMessage(message));
  }
}
