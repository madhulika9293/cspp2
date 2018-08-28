/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * To print the area of a triangle
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
   * { function for area of a triangle }.
   *
   * @param      base    The base
   * @param      height  The height
   *
   * @return     { area, area of the given triangle }
   */

  public static double areaOfTriangle(final double base, final double height) {
    double area = 0.5 * base * height;
    return area;
  }

  /**
    Do not modify this main function.
    * @param args is for command line arguments.
  */

  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int base = scan.nextInt();
    int height = scan.nextInt();
    areaOfTriangle(base, height);
    System.out.println(areaOfTriangle(base, height));
  }

}

