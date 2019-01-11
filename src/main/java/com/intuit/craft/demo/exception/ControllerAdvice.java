package com.intuit.craft.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller Advice for handling global exceptions.
 * 
 * @author SANDGUP
 *
 */
@RestControllerAdvice
public class ControllerAdvice {

  /**
   * Exception handler for invalid session of request.
   * 
   * @param e
   * @return
   */
  @ExceptionHandler(value = {ResourceNotAvailable.class})
  public ResponseEntity<ErrorResponse> excuteCallAndCheckException(final ResourceNotAvailable e) {
    return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage()), HttpStatus.GONE);
  }



}
