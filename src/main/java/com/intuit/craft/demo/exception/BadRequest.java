package com.intuit.craft.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class to encapsulate root of invalid parameters present in request body.
 * 
 * @author sandgup
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

  private static final long serialVersionUID = 1L;

  /**
   * Instantiates BadRequest exception with the supplied message.
   * 
   * @param message
   */
  public BadRequest(String message) {
    super(message);
  }

  /**
   * Instantiates BadRequest exception with the supplied message and cuse.
   * 
   * @param message
   * @param cause
   */
  public BadRequest(String message, Throwable cause) {
    super(message, cause);
  }


}
