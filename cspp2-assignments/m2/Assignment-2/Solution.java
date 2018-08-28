/**
  * Date: 28-08-2018.
  * Name: Madhulika
  * Roots to the quadratic equation
*/

import java.util.Scanner;

/**
  * The only class.
*/

public final class Solution {
  /**
    * default constructor.
  */

  private Solution() {
    //unused
  }
  /**
   * { calculates roots for quadratic equation }.
   *
   * @param      x     { parameter_description }
   * @param      y     { parameter_description }
   * @param      z     { parameter_description }
   */

  public static void rootsOfQuadraticEquation(
    final int x, final int y, final int z) {
      final int mult = 4;
      final double powr = 0.5;

      double delta = Math.pow((Math.pow(y, 2) - mult * x * z), powr);

        System.out.println(""
          + (-1 * y + delta) / (2 * x) + " " + (-1 * y - delta) / (2 * x));

  }
  /*
  Do not modify this main function.
  */

  /**
   * { main function }.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    int c = scan.nextInt();
    rootsOfQuadraticEquation(a, b, c);
  }
  /*
  Need to write the rootsOfQuadraticEquation function and print the output.
  */
}
