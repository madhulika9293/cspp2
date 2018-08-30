/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * To print the average of the given array
*/

import java.util.Arrays;
import java.util.Scanner;

/**
 * The only class.
 */

public final class Average {
  /**
   * input array.
   */

  /**
   * Constructs the object.
   */

  private Average() {
    //unused
    }

  /**
   * main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number of elements");
    int[] arr = new int[scan.nextInt()];

    System.out.println("Enter elements");

    for (int i = 0; i < arr.length; i++) {
      arr[i] = scan.nextInt();
    }
    // System.out.println(Arrays.toString(arr));

    int sum = Arrays.stream(arr).sum();
    double average = sum / arr.length;
    System.out.println("Average" + ": " + average);
  }
}
