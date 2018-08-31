/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * Given an String, a java method that returns the decimal value
  * for the given binary string.
*/

import java.util.Scanner;

/**
 * Class for solution.
 */

public class Solution {

  /**
   * Constructs the object.
   */

  private Solution() {
    //unused
  }

  /*
  Do not modify this main function.
  */

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i <= n; i++) {
      String s = sc.nextLine();
      if (i > 0) {
        String res = binaryToDecimal(s);
        System.out.println(res);
      }
    }
  }

  public static String binaryToDecimal(String biStr) {
    int sum = 0;
    final int strLen = biStr.length() - 1;
    for (int i = 0; i <= strLen; i++) {
      if (biStr.charAt(i) == '1') {
        sum += Math.pow(2, strLen - i);
      }
    }
    String sumStr = String.valueOf(sum);
    return sumStr;
  }
}
