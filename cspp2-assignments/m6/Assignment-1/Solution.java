import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : Madhulika, 20186015
 */
public final class Solution {
  /**
  * Empty constructor.
  */
  private Solution() {
    //not used
  }

  /**
   * Determines if prime.
   *
   * @param      num   The number
   *
   * @return     True if prime, False otherwise.
   */

  public static boolean isPrime(final int num) {
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Prints the odd composite numbers between 2 and n.
   *
   * @param      n     n value
   */
  static void oddComposites(final int n) {
    // write your code here
    for (int i = 1; i <= n; i = i + 2) {
      if (!isPrime(i)) {
        System.out.println(i);
      }
    }
  }
  /**
  * main method as driver program.
  * @param args is the parameter for this method
  */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    oddComposites(n);
  }
}

