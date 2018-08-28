/**
  * Date: 28-08-2018.
  * Name: Madhulika
  * Roots to the quadratic equation
*/

import java.util.Scanner;

/**
  * The only class.
*/


public class Solution {
  /**
    * default constructor.
  */

  private Solution() {
    //unused
  }
  
  /**
   * { calculates exponent }.
   *
   * @param      x     { base }
   * @param      y     { exponent }
   *
   * @return     { calculates exponent }
   */

  public static int power(final int x, final int y) {
    if (y == 1) {
      return x;
    } else {
        return x * power(x, y-1);
    }
  }

  /*
  Do not modify this main function.
  */

  /**
   * { main function }
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {
    Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        int result=power(base,exponent);
        System.out.println(result);
  }
  /*
  Need to write the power function and print the output.
  */
}
