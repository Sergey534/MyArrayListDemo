package org.example;

import java.util.Comparator;
import org.example.MyList;
import org.example.expections.MyArrayListOutOfBoundsException;
import org.example.utils.QuickSort;

/**
 * Represents a Resizable-array implementation of the MyList that stores elements of type T. Implements all operations. This class
 * provides methods to add, get, remove, and clear elements. Example usage:
 * <pre>
 *     MyArrayList<String> myArrayList = new MyArrayList<>(10);
 *     myArrayList.add("D");
 *     myArrayList.add("C");
 *     myArrayList.add("B");
 *     myArrayList.add("A");
 *     myArrayList.sort((o1, o2) -> o1.compareTo(o2));
 *     System.out.println(myArrayList); // result is [A, B, C, D]
 * </pre>
 *
 * @param <T> the type of elements stored in this ArrayList
 */
public class MyArrayList<T> implements MyList<T> {

  /**
   * The array buffer into which the elements of the ArrayList are stored. The capacity of the ArrayList is the length of this
   * array buffer.
   */
  private Object[] elementData;
  /**
   * The size of the ArrayList (the number of elements it contains).
   */
  private int size = 0;

  /**
   * Constructs an empty list with an initial capacity of ten.
   */
  public MyArrayList() {
    elementData = new Object[10];
  }

  /**
   * Constructs an empty list with the specified initial capacity.
   *
   * @param capacity the initial capacity of the list
   * @throws IllegalArgumentException if the specified initial capacity is negative
   */
  public MyArrayList(int capacity) {
    if (capacity >= 0) {
      elementData = new Object[capacity];
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " +
          capacity);
    }

  }

  /**
   * Appends the specified element to the end of this list.
   *
   * @param element element to be appended to this list
   * @return {@code true}
   */
  @Override
  public boolean add(T element) {
    growCapacity();
    elementData[size++] = element;
    return true;
  }

  /**
   * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any)
   * and any subsequent elements to the right (adds one to their indices).
   *
   * @param index   index at which the specified element is to be inserted
   * @param element element to be inserted
   * @throws MyArrayListOutOfBoundsException if index is greater than or equal to size
   */
  @Override
  public void add(int index, T element) {
    rangeCheck(index);
    growCapacity();
    System.arraycopy(elementData, index, elementData, index + 1,
        size - index);
    elementData[index] = element;
    size++;
  }

  /**
   * increases capacity if size is greater than or equal to capacity
   */
  private void growCapacity() {
    if (size < elementData.length) {
      return;
    }
    Object[] temp = new Object[elementData.length];
    System.arraycopy(elementData, 0, temp, 0, temp.length);

    elementData = new Object[elementData.length * 3 / 2 + 1];
    System.arraycopy(temp, 0, elementData, 0, temp.length);
  }

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from
   * their indices). Returns the element that was removed from the list.
   *
   * @param index the index of the element to be removed
   * @return the element that was removed from the list
   * @throws MyArrayListOutOfBoundsException if index is greater than or equal to size
   */
  @Override
  public T remove(int index) {
    rangeCheck(index);

    T oldValue = elementData(index);
    int numMoved = size - index - 1;
    if (numMoved > 0) {

      System.arraycopy(elementData, index + 1, elementData, index,
          numMoved);
    }
    elementData[--size] = null;

    return oldValue;
  }

  /**
   * Removes all of the elements from this list.  The list will be empty after this call returns.
   */
  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      elementData[i] = null;
    }
    size = 0;
  }

  /**
   * Sorts this MyArrayList according to the order induced by the specified comparator
   *
   * @param comparator specified comparator
   */
  @Override
  public void sort(Comparator<? super T> comparator) {
    if (elementData == null || elementData.length == 0) {
      return;
    }
    QuickSort.quickSort((T[]) elementData, 0, size - 1, comparator);
  }

  /**
   * Returns the element at the specified position in elementData.
   *
   * @param index index of the element to return
   * @return the element at the specified position in elementData
   */
  private T elementData(int index) {
    return (T) elementData[index];
  }

  /**
   * Trims the capacity of this {@code MyArrayList} instance to be the list's current size.  An application can use this operation
   * to minimize the storage of an {@code MyArrayList} instance.
   */
  public void trimToSize() {
    if (size < elementData.length) {
      Object[] temp = new Object[size];
      System.arraycopy(elementData, 0, temp, 0, temp.length);
      elementData = new Object[temp.length];
      System.arraycopy(temp, 0, elementData, 0, temp.length);
    }
  }

  /**
   * Used for check index.
   *
   * @param index the index of the element
   * @throws MyArrayListOutOfBoundsException if index is greater than or equal to size
   */
  private void rangeCheck(int index) {
    if (index >= size) {
      throw new MyArrayListOutOfBoundsException("Index: " + index + ", Size: " + size + ";");
    }
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index index of the element to return
   * @return the element at the specified position in this list
   * @throws MyArrayListOutOfBoundsException if index is greater than or equal to size
   */
  @Override
  public T get(int index) {
    rangeCheck(index);
    return elementData(index);
  }

  /**
   * Returns the String representation of the {@code MyArrayList}
   *
   * @return the String representation of the {@code MyArrayList}
   */
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      stringBuilder.append(elementData[i] + ", ");
    }
    if (size > 0) {
      stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

}
