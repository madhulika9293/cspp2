/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * Convert Fahrenheit temperature to Celsius
*/

import java.util.Scanner;

/**
  * The only class.
*/

public final class Solution {
  /**
    * default constructor.
  */

  private Solution() {
    //unused
  }

  /*
  Do not modify this main function.
  */
  /**
   * Calculates the temperature from degrees to farenheit.
   *
   * @param      temp  Temperature
   *
   * @return     The temperature from farenheit to degrees.
   */

  public static void calculateFromFarenheitToDegrees(double temp) {
    final double subNum = 32;
    final double divNum = 1.8;

    double cel;
    cel = (temp - subNum) / divNum;
    System.out.println(cel);
  }

  /**
   * { main function }.
   *
   * @param      args  The arguments
   */
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double degreesCelsius = scan.nextDouble();
    calculateFromFarenheitToDegrees(degreesCelsius);
  }
  /*
  Need to fill the calculateFromFarenheitToDegrees function and print the output
  of fahrenheit.
  */
}