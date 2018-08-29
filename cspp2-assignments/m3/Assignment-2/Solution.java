/**
  * Date: 29-08-2018.
  * Name: Madhulika
  * To print the number of 7's from 1 to n
*/

import java.util.Scanner;
  /*
  Do not modify this main function.
  */

  /**
   * { main class }.
   */
public final class Solution {
  /* Fill the main function to print the number of 7's between 1 to n*/
  /**
   * Constructs the object.
   */

  private Solution() {
    //unused
  }

  /**
  * { main function }.
  *
  * @param      args  The arguments
  */

  public static void main(final String[] args) {

    Scanner s = new Scanner(System.in);      
    int n = s.nextInt();
    int count = 0;

    for (int i = 1;i <= n ; i++) {
      String num = String.valueOf(i);
      char[] num_arr = num.toCharArray();
      for (char c: num_arr) {
        if (c == '7') {
          count = count + 1;
        }
      }
    }
    System.out.println(count);
  }
}
