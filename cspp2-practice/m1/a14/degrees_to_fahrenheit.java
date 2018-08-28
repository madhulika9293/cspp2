/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * Swapping two numbers
*/

import java.util.Scanner;

/**
  * The only classs.
*/

public final class degrees_to_fahrenheit {
  /**
    * default constructor.
  */

  private degrees_to_fahrenheit() {
    //unused
  }

  /**
    * main function.
    * @param args is for command line arguments.
  */

  public static void main(final String[] args) {

    double degrees;
    double fahrenheit;

    Scanner n = new Scanner(System.in);
    System.out.println("Enter temperature in degrees");
    degrees = n.nextInt();

    final double mulfact = 1.8;
    final int addfact = 32;

    fahrenheit = (mul_fact * degrees) + add_fact;

    System.out.println("Temperature in fahrenheit is: " + fahrenheit + " F");
  }
}
