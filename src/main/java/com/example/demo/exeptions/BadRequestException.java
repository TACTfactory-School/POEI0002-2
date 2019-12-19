package com.example.demo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle bad requests exceptions.
 * @author Cedrick Pennec.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpException {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  public BadRequestException() {
  }

  /**
 * @param message String
 */
public BadRequestException(final String message) {
    super(message);
  }

  /**
 * @param cause Throwable
 */
public BadRequestException(final Throwable cause) {
    super(cause);
  }

  /**
 * @param message String
 * @param cause Throwable
 */
public BadRequestException(final String message, final Throwable cause) {
    super(message, cause);
  }
  /**
 * @param message String
 * @param cause Throwable
 * @param enableSuppression boolean
 * @param writableStackTrace boolean
 */
public BadRequestException(final String message, final Throwable cause, final boolean enableSuppression,
          final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
