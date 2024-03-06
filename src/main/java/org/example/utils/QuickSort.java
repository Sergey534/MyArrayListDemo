package org.example.utils;

import java.util.Comparator;

/**
 * This class consists exclusively of static methods that sorts the specified array of objects.
 */
public class QuickSort<T> {

  /**
   * Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.  The
   * range to be sorted extends from index {@code low}, inclusive, to index {@code high}, inclusive.
   *
   * @param array      the array to be sorted
   * @param left       the index of the first element (inclusive) to be sorted
   * @param right      the index of the last element (inclusive) to be sorted
   * @param comparator the comparator to determine the order of the array.
   */
  public static <T> void quickSort(T[] array, int left, int right, Comparator<? super T> comparator) {
    int i, j;
    T x, y;
    i = left;
    j = right;
    x = array[((left + right) / 2)];

    do {

      while ((comparator.compare(array[i], x) < 0) && (i < right)) {
        i++;
      }
      while ((comparator.compare(array[j], x) > 0) && (j > left)) {
        j--;
      }
      if (i <= j) {
        y = array[i];
        array[i] = array[j];
        array[j] = y;
        i++;
        j--;
      }
    } while (i <= j);
    if (left < j) {
      quickSort(array, left, j, comparator);
    }
    if (i < right) {
      quickSort(array, i, right, comparator);
    }
  }

}
