/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * To check the beginning and ending of an array for 6
*/

// import java.util.Arrays;
import java.util.Scanner;

/**
 * The only class.
 */

public final class FirstLast6 {
  /**
   * input array.
   */

  private int[] array;

  /**
   * Constructs the object.
   * @param      parray  The array
   */

  public FirstLast6(final int[] parray) {
    final int cNm = 6;
    System.out.println((parray[0] == cNm || parray[parray.length - 1] == cNm));
    }

  // boolean prnt() {
  //   return result;
  // }

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

    FirstLast6 obj = new FirstLast6(arr);
  }
}
