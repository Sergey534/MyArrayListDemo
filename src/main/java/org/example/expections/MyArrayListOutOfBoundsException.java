package org.example.expections;

/**
 * Thrown to indicate that an {@code MyArrayList} has been accessed with an illegal index
 */
public class MyArrayListOutOfBoundsException extends MyException {

  /**
   * Constructs a new MyArrayListOutOfBoundsException exception with the specified detail message.
   *
   * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
   */
  public MyArrayListOutOfBoundsException(String message) {
    super(message);
  }
}
