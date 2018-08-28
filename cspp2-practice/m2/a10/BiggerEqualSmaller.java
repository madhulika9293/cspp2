/**
  * Date: 28-08-2018
  * Name: Madhulika
  * Program to compare two numbers
 */

import java.util.Scanner;

/**
  * The only class.
*/

public final class BiggerEqualSmaller {
  /**
    * default constructor.
  */

  private BiggerEqualSmaller() {
    //unused
  }

  /**
   * {Main Function}.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    System.out.println("Enter two variables: ");

    Scanner scan = new Scanner(System.in);

    int varA = scan.nextInt();
    int varB = scan.nextInt();

    if (varA > varB) {
      System.out.println("Bigger");
    }    else if (varA == varB) {
      System.out.println("Equal");
    }    else if (varA < varB) {
      System.out.println("Smaller");
    }
  }

}
