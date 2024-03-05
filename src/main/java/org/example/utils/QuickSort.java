package org.example.utils;

import java.util.Comparator;

public class QuickSort<T> {

  /**
   * Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.  The
   * range to be sorted extends from index {@code low}, inclusive, to index {@code high}, inclusive.
   *
   * @param array      the array to be sorted
   * @param low        the index of the first element (inclusive) to be sorted
   * @param high       the index of the last element (inclusive) to be sorted
   * @param comparator the comparator to determine the order of the array.
   */
  public static <T> void quickSort(T[] array, int low, int high, Comparator<? super T> comparator) {
    if (low < high) {
      int pivot = partition(array, low, high, comparator);
      quickSort(array, low, pivot - 1, comparator);
      quickSort(array, pivot + 1, high, comparator);
    }
  }

  /**
   * Chooses a pivot element, partitions the array around the pivot, and returns the index of the pivot after partitioning.
   *
   * @param array      the array to be sorted
   * @param low        the index of the first element (inclusive) to be sorted
   * @param high       the index of the last element (inclusive) to be sorted
   * @param comparator the comparator to determine the order of the array.
   */
  private static <T> int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
    T pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (comparator.compare(array[j], pivot) < 0) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return i + 1;
  }

  /**
   * Swaps two elements in the array.
   *
   * @param array the array in which elements will be swapped
   * @param i     the index of the first element to swap
   * @param j     the index of the second element to swap
   */
  private static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
