package tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Field;
import org.example.MyArrayList;
import org.example.utils.CollectionsUtil;
import org.testng.annotations.Test;
import testConstants.TestConstants;

/**
 * Test class for testing the functionality of MyArrayList.
 */
public class MyArrayListTest {

  /**
   * Test method to verify the behavior of the add method in MyArrayList. This method tests adding two elements.
   */
  @Test
  public void testAdd() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    assertEquals(list.size(), TestConstants.EXPECTED_ADD_RESULT, "size is not equals!");
  }

  /**
   * Test method to verify the behavior of the adding an element by index in MyArrayList. This method tests adding of one element
   * at index 1.
   */
  @Test
  public void testAddByIndex() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add(1, "D");
    assertEquals(list.get(1), TestConstants.EXPECTED_AddByIndex_RESULT, "elements is not equals");
  }

  /**
   * Test method to verify the behavior of the clear method in MyArrayList. This method tests removes of three elements from this
   * list.
   */
  @Test
  public void testClear() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.clear();
    assertEquals(list.size(), TestConstants.EXPECTED_CLEAR_RESULT, "size is not equals!");
  }

  /**
   * Test method to verify the behavior of the get method in MyArrayList. This method tests getting the element at index 2.
   */
  @Test
  public void testGet() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    String letter = list.get(2);
    assertEquals(letter, TestConstants.EXPECTED_GET_RESULT, "elements is not equals");
  }

  /**
   * Test method to verify the behavior of the get method in MyArrayList. This method tests getting the element at index 2.
   */
  @Test
  public void testRemove() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("A");
    list.add("B");
    list.remove(0);
    assertEquals(list.get(0), TestConstants.EXPECTED_REMOVE_RESULT, "elements is not equals");
  }

  /**
   * Test method to verify the behavior of the size method in MyArrayList. This method tests the returned list size.
   */
  @Test
  public void testSize() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    assertEquals(list.size(), TestConstants.EXPECTED_SIZE_RESULT, "size is not equals!");
  }

  /**
   * Test method to verify the behavior of the sort method in MyArrayList. This method tests String sorting lexicographically.
   */
  @Test
  public void testSort() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("D");
    list.add("B");
    list.add("C");
    list.add("A");
    list.sort(String::compareTo);
    assertEquals(list.toString(), TestConstants.EXPECTED_SORT_RESULT, "elements is not equals");
  }

  /**
   * Test method to verify the behavior of the trimToSize method in MyArrayList. This method tests that capacity will trim to list
   * size.
   */
  @Test
  public void testTrimToSize() {
    MyArrayList<Integer> list = new MyArrayList<>(10);
    list.add(1);
    list.add(2);
    list.add(3);
    list.trimToSize();

    Field privateField = null;
    try {
      privateField = MyArrayList.class.getDeclaredField("elementData");
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    privateField.setAccessible(true);
    try {
      Object[] value = (Object[]) privateField.get(list);
      assertEquals(value.length, TestConstants.EXPECTED_TrimToSize_RESULT, "length is not equals!");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test method to verify the behavior of the set method in MyArrayList. This method tests setting the element at index 2.
   */
  @Test
  public void testSet() {
    MyArrayList<String> list = new MyArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    list.add("D");
    list.set(2, "F");
    assertEquals(list.get(2), TestConstants.EXPECTED_SET_RESULT, "elements is not equals");
  }

  /**
   * Test method to verify the behavior of the sort method in MyArrayList. This method tests Integer sorting .
   */
  @Test
  public void testComparableSort() {
    MyArrayList<Integer> list = new MyArrayList<>();
    for (int i = 4; i >= 1; i--) {
      list.add(i);
    }
    CollectionsUtil.sort(list);
    assertEquals(list.toString(), TestConstants.EXPECTED_COMPARABLE_SORT_RESULT, "elements is not equals");
  }

}
