package com.viktoriyatp.handlers;

import com.viktoriyatp.exceptions.ClientNotFound;
import com.viktoriyatp.exceptions.ProductNotFound;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(value = {ClientNotFound.class, ProductNotFound.class})
  public ResponseEntity<String> handleDatabaseException(RuntimeException exception) {
    log.error("Caught exception: {} ", exception.getMessage());
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {SQLException.class})
  public ResponseEntity<String> handleRouteGeneralException(Exception exception) {
    log.error("Caught exception: {} ", exception.getMessage());
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(
    value = {ConstraintViolationException.class})
  public ResponseEntity<String> handleConstraintViolationException(RuntimeException exception) {
    log.error("Caught exception: {} ", exception.getMessage());
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleControllerValidationException(
    MethodArgumentNotValidException exception) {
    List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                                   .map(FieldError::getDefaultMessage)
                                   .collect(Collectors.toList());
    log.error("Caught exception: {} ", exception.getMessage());
    return new ResponseEntity<>(formatErrorsResponse(errors), HttpStatus.BAD_REQUEST);
  }

  private Map<String, List<String>> formatErrorsResponse(List<String> errors) {
    Map<String, List<String>> errorResponse = new HashMap<>(10);
    errorResponse.put("Errors", errors);
    return errorResponse;
  }
}
