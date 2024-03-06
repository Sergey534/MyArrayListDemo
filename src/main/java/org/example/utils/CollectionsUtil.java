package org.example.utils;

import org.example.MyList;

/**
 * This class consists exclusively of static methods that operate on or return collections.
 */
public class CollectionsUtil {

  /**
   * Sorts the specified list according to the {@linkplain Comparable natural ordering} of its elements. All elements in the list
   * must implement the {@link Comparable} interface.
   *
   * @param list the list to be sorted.
   */
  public static <T extends Comparable<T>> void sort(MyList<T> list) {
    if (list == null || list.size() <= 1) {
      return;
    }
    quickSort(list, 0, list.size() - 1);
  }

  /**
   * Sorts the specified range of the specified list of objects according to the {@linkplain Comparable natural ordering} of its
   * elements.  The range to be sorted extends from index {@code low}, inclusive, to index {@code high}, inclusive.
   *
   * @param list  the list to be sorted
   * @param left  the index of the first element (inclusive) to be sorted
   * @param right the index of the last element (inclusive) to be sorted
   */
  private static <T extends Comparable<T>> void quickSort(MyList<T> list, int left, int right) {
    int i, j;
    T x, y;
    i = left;
    j = right;
    x = list.get((left + right) / 2);

    do {

      while ((list.get(i).compareTo(x) < 0) && (i < right)) {
        i++;
      }
      while ((list.get(j).compareTo(x) > 0) && (j > left)) {
        j--;
      }
      if (i <= j) {
        y = list.get(i);
        list.set(i, list.get(j));
        list.set(j, y);
        i++;
        j--;
      }
    } while (i <= j);
    if (left < j) {
      quickSort(list, left, j);
    }
    if (i < right) {
      quickSort(list, i, right);
    }

  }

}

