/**
  * Date: 29-08-2018.
  * Name: Madhulika
  * To print a given pattern
*/

/**
 * { main class }.
 */
public final class Pattern {

  /**
   * Constructs the object.
   */

  private Pattern() {
    //unused
  }

  /**
   * { the main function }.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    final int numLines = 5;
    for (int i = 1; i <= numLines; i++) {
      String output = "";
      for (int j = 1; j <= i; j++) {
        output = output + j + " ";
      }
      System.out.println(output);
    }
  }
}
