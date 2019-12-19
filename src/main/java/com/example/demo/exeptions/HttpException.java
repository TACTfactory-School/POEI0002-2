package com.example.demo.exeptions;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

/**
 * Handle Http Exceptions.
 * @author Cedrick Pennec
 */
public class HttpException extends Exception {

  /**
   * The serial number.
   */
  private static final long serialVersionUID = 1L;

    public HttpException() {
        super();
    }

  /**
   * @param message String
   * @param cause Throwable
   * @param enableSuppression boolean
   * @param writableStackTrace boolean
   */
  public HttpException(final String message, final Throwable cause, final boolean enableSuppression,
                       final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message String.
   * @param cause Throwable
   */
  public HttpException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message String
   */
  public HttpException(final String message) {
    super(message);
  }

  /**
   * @param cause Throwable
   */
  public HttpException(final Throwable cause) {
    super(cause);
  }
}
