package com.intuit.craft.demo.exception;

/**
 * Error response for the client.
 * 
 * @author SANDGUP
 *
 */
public class ErrorResponse {
  private final String message;

  public String getMessage() {
    return message;
  }

  public ErrorResponse(String message) {
    super();
    this.message = message;
  }

}
