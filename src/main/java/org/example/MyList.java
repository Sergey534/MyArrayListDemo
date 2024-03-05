package org.example;

import java.util.Comparator;
import org.example.expections.MyArrayListOutOfBoundsException;

/**
 * interface that provides the ability to maintain an ordered collection. It contains index-based methods for inserting, updating,
 * deleting, and searching for elements.
 *
 * @param <T>the type of elements in this list
 */
public interface MyList<T> {

  /**
   * Appends the specified element to the list.
   *
   * @param element element to be appended to this list
   * @return {@code true}
   */
  boolean add(T element);

  /**
   * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any)
   * and any subsequent elements to the right (adds one to their indices).
   *
   * @param index   index at which the specified element is to be inserted
   * @param element element to be inserted
   */
  void add(int index, T element);

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list
   */
  int size();

  /**
   * Removes the element at the specified position in this list (optional operation). Shifts any subsequent elements to the left
   * (subtracts one from their indices). Returns the element that was removed from the list.
   *
   * @param index the index of the element to be removed
   * @return the element that was removed from the list
   * @throws MyArrayListOutOfBoundsException if index is greater than or equal to size
   */
  T remove(int index);

  /**
   * Removes all of the elements from this list.  The list will be empty after this call returns.
   */
  void clear();

  /**
   * Sorts this list according to the order induced by the specified comparator
   *
   * @param comparator specified comparator
   */
  void sort(Comparator<? super T> comparator);

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   */
  T get(int index);
}
