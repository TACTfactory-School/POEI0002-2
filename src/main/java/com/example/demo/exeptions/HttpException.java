package com.example.demo.exeptions;

//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
/**
 * @author Cedrick Pennec
 *
 */
public class HttpException extends Exception {

  /** The serial number. */
  private static final long serialVersionUID = 1L;

  /**
 *
 */
public HttpException() {
    super();
  }

  /**
   * @param message of the exception
   * @param cause of the exception
   * @param enableSuppression boolean
   * @param writableStackTrace boolean
   */
  public HttpException(final String message, final Throwable cause, final boolean enableSuppression,
          final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
   * @param message of the exception
   * @param cause of the exception
   */
  public HttpException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * @param message of the exception
   */
  public HttpException(final String message) {
    super(message);
  }

  /**
   * @param cause of the exception
   */
  public HttpException(final Throwable cause) {
    super(cause);
  }
}
