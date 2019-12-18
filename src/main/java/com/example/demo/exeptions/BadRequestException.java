package com.example.demo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Cedrick Pennec.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends HttpException {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  public BadRequestException() {
  }

  public BadRequestException(final String message) {
    super(message);
  }

  public BadRequestException(final Throwable cause) {
    super(cause);
  }

  public BadRequestException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public BadRequestException(final String message, final Throwable cause, final boolean enableSuppression,
          final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
