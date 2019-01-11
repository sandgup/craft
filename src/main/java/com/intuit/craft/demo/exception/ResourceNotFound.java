package com.intuit.craft.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Encapsulates message when requested resource is not available.
 * 
 * @author sandgup
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates exception with the supplied message.
   * 
   * @param message
   */
  public ResourceNotFound(String message) {
    super(message);
  }

}
