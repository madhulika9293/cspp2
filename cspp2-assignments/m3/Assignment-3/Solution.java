/**
  * Date: 29-08-2018.
  * Name: Madhulika
  * To find the GCD of given 2 numbers
*/

import java.util.Scanner;
  /*
  Do not modify this main function.
  */

  /**
   * Class for solution.
   */

public final class Solution {

  /**
   * Constructs the object.
   */

  private Solution() {
    //unused
  }

  /**
   * The Greatest Common Divisor of the given 2 numbers.
   *
   * @param      x     First Number
   * @param      y     Second Number
   *
   * @return     GCD, int
   */

  public static int gcd(final int x, final int y) {
    int gcdOut = Math.min(x, y);
    for (int i = gcdOut; i >= 1; i--) {
      if (x % i == 0 && y % i == 0) {
        return i;
      }
    }
    return 1;
  }

  /**
   * Main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    Scanner s = new Scanner(System.in);
    int n1 = s.nextInt();
    int n2 = s.nextInt();
    int gcd = gcd(n1, n2);
    System.out.println(gcd);
    }
  /*
    Need to write the gcd function and print the output.
  */
}

