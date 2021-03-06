/**
  * Date: 29-08-2018.
  * Name: Madhulika
  * Sum of first n natural numbers
*/

import java.util.Scanner;

/**
 * { The main class }.
 */

public final class SumofNNumbers {

  /**
   * Constructs the object.
   */

  private SumofNNumbers() {
    //unused
  }

  /**
   * { main function }.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int num = 1;
    int sum = 0;
    while (num <= n) {
      sum = sum + num;
      num++;
    }
    System.out.println(sum);
  }
}
