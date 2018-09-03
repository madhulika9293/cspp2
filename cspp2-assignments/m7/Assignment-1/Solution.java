/**
  * Date: 03-09-2018.
  * Name: Madhulika
  * To validate the given input
*/

import java.util.Scanner;

/**
 * Class for input validator.
 */

class InputValidator {
  /*Write the atrributes and methods for InputValidator*/
  /**
   * input string.
   */
  private String inpData;

  /**
   * Constructs the object.
   *
   * @param      iD    input string
   */

  InputValidator(final String iD) {
    inpData = iD;
  }

  /**
   * Validates data.
   *
   * @return     boolean for validating the input data.
   */
  boolean validateData() {
    final int lenCheck = 6;
    return inpData.length() >= lenCheck;
  }

}

/**
 * Class for solution.
 */

public final class Solution {

  /**
  * The main function.
  *
  * @param      args  The arguments
  */

  public static void main(final String[] args) {
    Scanner s = new Scanner(System.in);
    String input = s.next();
    InputValidator i = new InputValidator(input);
    System.out.println(i.validateData());

  }

}
