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
<<<<<<< HEAD
   * @param message String
   * @param cause Throwable
   * @param enableSuppression boolean
=======
   * @param message            of the exception
   * @param cause              of the exception
   * @param enableSuppression  boolean
>>>>>>> d65c9592909306e71230b36759dbaf58c9b2b828
   * @param writableStackTrace boolean
   */
  public HttpException(final String message, final Throwable cause, final boolean enableSuppression,
                       final boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  /**
<<<<<<< HEAD
   * @param message String.
   * @param cause Throwable
=======
   * @param message of the exception
   * @param cause   of the exception
>>>>>>> d65c9592909306e71230b36759dbaf58c9b2b828
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
