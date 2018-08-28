/**
  * Date: 28-08-2018
  * Name: Madhulika
  * To compute the factoria of a given number
 */

import java.util.Scanner;

/**
  * The only class.
*/

public final class factorial {
  /**
    * default constructor.
  */

  private factorial() {
    //unused
  }
  /**
   * { function for calculating factorial }.
   *
   * @param      x     { int input }
   *
   * @return     { factorial of the given number }
   */

  public static int fact(final int x) {
    if (x == 0 || x == 1) {
      return 1;
    } else {
      return x * fact(x - 1);
    }
  }

  /**
   * {Main Function}.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    System.out.println("Enter the number ");

    Scanner scan = new Scanner(System.in);

    int num = scan.nextInt();

    System.out.println("The factorial of the given number is: " + fact(num));

  }

}
