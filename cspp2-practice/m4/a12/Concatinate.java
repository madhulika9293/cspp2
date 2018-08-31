/**
  * Date: 31-08-2018.
  * Name: Madhulika
  * To concatinate 2 strings and print out the output
*/

import java.util.Scanner;

/**
 * The only class.
 */

public final class Concatinate {
  /**
   * input array.
   */

  /**
   * Constructs the object.
   */

  private Concatinate() {
    //unused
  }

  /**
   * main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    System.out.println(helloName(name));
  }

  public static String helloName(String name) {
    String output = "Hello ";
    output = output.concat(name).concat("!");
    return output;
  }

}
