/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * Given an String, a java method that returns the reverse
  * of the given string.
*/

import java.util.Scanner;

/**
 * Class for solution.
 */

public final class Solution {
  /*
  Do not modify the main function
  */

  /**
   * Constructs the object.
   */

  private Solution() {
    //unused constructor
  }

  /**
   * main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    String reverse = reverseString(s);
    System.out.println(reverse);
  }
  //Write reverseString function

  /**
   * reverse the given string.
   *
   * @param      str   The string
   *
   * @return     reverse of str, String
   */

  public static String reverseString(final String str) {
    String strRev = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      strRev += str.charAt(i);
    }
    return strRev;
  }
}
