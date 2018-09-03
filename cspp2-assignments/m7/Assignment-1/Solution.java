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

  public boolean validateData() {
    return inpData.length() >= 6;
  }

}
public class Solution {
  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    String input = s.next();
    InputValidator i = new InputValidator(input);
    System.out.println(i.validateData());

  }

}
