import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Madhulika, 20186015
 */
class Set {
  //your code goes here...
  //Good luck :-)

  /**
   * array to implement Set - class variable.
   */
  int[] setArr;

  /**
   * class variable for Set size.
   */
  int size;

  /**
   * Constructs the object.
   */
  Set() {
    final int capacity = 500;
    setArr = new int[capacity];
    size = 0;
  }

  /**
   * returns the size of the set.
   *
   * @return     int, size value.
   */
  public int size() {
    return size;
  }

  /**
   * checks if the given integer is in the set.
   *
   * @param      item  The item
   *
   * @return     boolean - true or false.
   */
  public boolean contains(final int item) {
    boolean checkFlag = false;
    for (int i = 0; i < size; i++) {
      if (setArr[i] == item) {
        checkFlag = true;
      }
    }
    return checkFlag;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    if (size == 0) {
      return "{}";
    }
    String res = "{";
    for (int i = 0; i < size - 1; i++) {
      res += setArr[i];
      res += ", ";
    }
    res += setArr[size - 1];
    res += "}";
    return res;
  }

  /**
   * adds an element to the set.
   *
   * @param      item  The item
   */
  public void add(final int item) {
    if (!contains(item)) {
      setArr[size] = item;
      size += 1;
    }
  }

  /**
   * adds multiple elements to the set.
   *
   * @param      addArr  The add arr
   */
  public void addAll(final int[] addArr) {
    for (int i = 0; i < addArr.length; i++) {
      add(addArr[i]);
    }
  }

  /**
   * getter method to access elements.
   *
   * @param      index  The index
   *
   * @return    integer value.
   */
  public int get(final int index) {
    return setArr[index];
  }

  public int indexOf(final int item) {
    int temp = 0;
    if (contains(item)) {
      for (int i = 0; i < size(); i++) {
        if (setArr[i] == item) {
          temp = i;
        }
      }
    }
    return temp;
  }

  /**
   * intersection of 2 sets.
   *
   * @param      set2  The set 2
   *
   * @return     returns the resultant Set.
   */
  public Set intersection(final Set set2) {
    Set rSet = new Set();
    if (size == 0 || set2.size == 0) {
      return rSet;
    } else {
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < set2.size; k++) {
          if (setArr[j] == set2.get(k)) {
            rSet.add(setArr[j]);
          }
        }
      }
      return rSet;
    }
  }

  /**
   * retains the elements in the Set from a given Array.
   *
   * @param      ret   The ret
   *
   * @return     a Set with all the elements.
   */
  public Set retainAll(final int[] ret) {
    Set rSet = new Set();
    for (int j = 0; j < size; j++) {
      for (int k = 0; k < ret.length; k++) {
        if (setArr[j] == ret[k]) {
          rSet.add(setArr[j]);
        }
      }
    }
    return rSet;
  }

  /**
   * Calculates the Cartesan product of the given 2 sets.
   *
   * @param      set2  The set 2
   *
   * @return     2D Array for the product.
   */
  public int[][] cartesianProduct(final Set set2) {
    int[][] res = new int[size * set2.size][2];
    if (size > 0 && set2.size > 0) {
      for (int i = 0; i < size * set2.size; i++) {
        res[i][0] = setArr[i / set2.size];
        res[i][1] = set2.get(i % set2.size);
      }

    } else {
      res = null;
    }
    return res;
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
    Set s = new Set();
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
        } else {
          s.addAll(intArray);
        }
        break;
      case "intersection":
        s = new Set();
        Set t = new Set();
        intArray = intArray(tokens[1]);
        s.addAll(intArray);
        intArray = intArray(tokens[2]);
        t.addAll(intArray);
        System.out.println(s.intersection(t));
        break;
      case "retainAll":
        s = new Set();
        intArray = intArray(tokens[1]);
        s.addAll(intArray);
        intArray = intArray(tokens[2]);
        System.out.println(s.retainAll(intArray));
        break;
      case "cartesianProduct":
        s = new Set();
        t = new Set();
        intArray = intArray(tokens[1]);
        s.addAll(intArray);
        intArray = intArray(tokens[2]);
        t.addAll(intArray);
        System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
        break;
      default:
        break;
      }
    }
  }


}





