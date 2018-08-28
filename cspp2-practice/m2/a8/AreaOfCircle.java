/**
  * Date: 28-08-2018
  * Name: Madhulika
  * Program to calculate area of circle   
 */

import java.util.Scanner;

/**
  * The only class.
*/

public class AreaOfCircle {
  /**
    * default constructor.
  */

  private AreaOfCircle() {
    //unused
  }

  /**
   * { returns the value of pi }.
   *
   * @return     { double, value of pi }
   */

  public static double pi() {
    return 3.14;
  }

  /**
   * {Function to calculate circle area}.
   *
   * @param      rad   The radians
   *
   * @return     { area }
   */

  public static double area(int rad) {
    return 2 * pi() * rad;
  }

  /**
   * {Main Function}.
   *
   * @param      args  The arguments
   */

  public static void main(String[] args) {
  
    int radius;
    double cir_area;

    Scanner n = new Scanner(System.in);
    System.out.println("Enter the radius of a circle");
    radius = n.nextInt();

    cir_area = area(radius); 
    System.out.println("The area of the circle is: " + cir_area);
  }
  
}
