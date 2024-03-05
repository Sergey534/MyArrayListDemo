package org.example.expections;

/**
 * Superclass for custom exceptions.
 */
public class MyException extends RuntimeException {

  /**
   * Constructs a new MyException exception with the specified detail message.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
   */
  public MyException(String message) {
    super(message);
  }
}
