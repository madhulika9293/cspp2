import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for invalid arguments.
 */
class InvalidArguments extends Exception {
  /**
   * Constructs the object.
   */
  InvalidArguments() {
    super();
  }
}

/**
 * Class for set empty.
 */
class SetEmpty extends Exception {
  /**
   * Constructs the object.
   */
  SetEmpty() {
    super();
  }
}

/**
 * Class for sorted set.
 */
class SortedSet extends Set {
  /**
   * Constructs the object.
   */
  SortedSet() {
    super();
  }

  /**
   * sorts the given set.
   *
   * @param      arrInp  The arr inp
   * @param      sz      The size
   */
  public void sortSet(final int[] arrInp, final int sz) {
    Arrays.sort(arrInp, 0, sz);
  }

  /**
   * adds elements to the set.
   *
   * @param      item  The item
   */
  public void add(final int item) {
    super.add(item);
    sortSet(setArr, size);
  }

  /**
   * returns a subset of the given set.
   *
   * @param      fromElement  The from element
   * @param      toElement    To element
   */
  public void subSet(final int fromElement, final int toElement) {
    try {
      if (fromElement <= toElement) {
        SortedSet res = new SortedSet();
        for (int i = 0; i < size; i++) {
          if (setArr[i] >= fromElement && setArr[i] < toElement) {
            res.add(setArr[i]);
          }
        }
        System.out.println(res);
      } else {
        throw new InvalidArguments();
      }
    } catch (InvalidArguments e) {
      System.out.println("Invalid Arguments to Subset Exception");
    }
  }

  /**
   * returs the values of set upto a given element.
   *
   * @param      toElement  To element
   *
   * @return     A sorted Set.
   */
  public SortedSet headSet(final int toElement) {
    try {
      if (toElement > setArr[0]) {
        SortedSet res = new SortedSet();
        for (int i = 0; i < size; i++) {
          if (setArr[i] < toElement) {
            res.add(setArr[i]);
          }
        }
        return res;
      } else {
        throw new SetEmpty();
      }
    } catch (SetEmpty e) {
      System.out.println("Set Empty Exception");
    }
    return null;
  }

  /**
   * returns the last element of the given set.
   */
  public void last() {
    try {
      if (size == 0) {
        throw new SetEmpty();
      } else {
        System.out.println(setArr[size - 1]);
      }
    } catch (SetEmpty e) {
      System.out.println("Set Empty Exception");
    }
  }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * helper function to convert string input to int array.
   *
   * @param      s     { string input from test case file }
   *
   * @return     { int array from the given string }
   */
  public static int[] intArray(final String s) {
    String input = s;
    if (input.equals("[]")) {
      return new int[0];
    }
    if (s.contains("[")) {
      input = s.substring(1, s.length() - 1);
    }
    return Arrays.stream(input.split(","))
           .mapToInt(Integer::parseInt)
           .toArray();
  }
  /**
   * main function to execute test cases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // instantiate this set
    SortedSet s = new SortedSet();
    // code to read the test cases input file
    Scanner stdin = new Scanner(new BufferedInputStream(System.in));
    // check if there is one more line to process
    while (stdin.hasNext()) {
      // read the line
      String line = stdin.nextLine();
      // split the line using space
      String[] tokens = line.split(" ");
      // based on the list operation invoke the corresponding method
      switch (tokens[0]) {
      case "size":
        System.out.println(s.size());
        break;
      case "contains":
        System.out.println(s.contains(Integer.parseInt(tokens[1])));
        break;
      case "print":
        System.out.println(s);
        break;
      case "add":
        int[] intArray = intArray(tokens[1]);
        if (intArray.length == 1) {
          s.add(intArray[0]);
        }
        break;
      case "addAll":
        intArray = intArray(tokens[1]);
        s.addAll(intArray);
        break;
      case "intersection":
        SortedSet s1 = new SortedSet();
        SortedSet t = new SortedSet();
        intArray = intArray(tokens[1]);
        s1.addAll(intArray);
        intArray = intArray(tokens[2]);
        t.addAll(intArray);
        System.out.println(s1.intersection(t));
        break;
      case "retainAll":
        SortedSet s2 = new SortedSet();
        intArray = intArray(tokens[1]);
        s2.addAll(intArray);
        intArray = intArray(tokens[2]);
        System.out.println(s2.retainAll(intArray));
        break;
      case "cartesianProduct":
        // s = new SortedSet();
        t = new SortedSet();
        intArray = intArray(tokens[1]);
        s.addAll(intArray);
        intArray = intArray(tokens[2]);
        t.addAll(intArray);
        System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
        break;
      case "subSet":
        // s = new SortedSet();
        intArray = intArray(tokens[1]);
        // System.out.println(s.subSet(intArray[0], intArray[1]));
        s.subSet(intArray[0], intArray[1]);
        break;
      case "headSet":
        // s = new SortedSet();
        intArray = intArray(tokens[1]);
        if (s.headSet(intArray[0]) != null) {
          System.out.println(s.headSet(intArray[0]));
        }
        break;
      case "last":
        // s = new SortedSet();
        s.last();
        break;
      default:
        break;
      }
    }
  }
}
