package com.example.railway_pricing.shared.api.response;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<Object> handleConstraintViolationException(
      ConstraintViolationException ex, WebRequest request) {
    ApiValidationErrorResponse response = new ApiValidationErrorResponse("validation error");
    ex.getConstraintViolations().forEach(constraintViolation -> response.addValidationMessage(
        constraintViolation.getMessage()));
    return super.handleExceptionInternal(ex, response, null, HttpStatus.BAD_REQUEST, request);
  }
}
