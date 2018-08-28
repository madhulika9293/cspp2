/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * Swapping two numbers
*/

import java.util.Scanner;

/**
  * The only classs.
*/

public final class swap {
  /**
    * default constructor.
  */

  private swap() {
    //unused
  }

    /**
      * main function.
      * @param args is for command line arguments.
    */

  public static void main(final String[] args) {

    int num1, num2, temp;

    Scanner n1 = new Scanner(System.in);
    System.out.println("Enter your first number");
    num1 = n1.nextInt();

    Scanner n2 = new Scanner(System.in);
    System.out.println("Enter your second number");
    num2 = n2.nextInt();

    temp = num1;
    num1 = num2;
    num2 = temp;

    System.out.println("The swapped numbers are " + num1 + ", " + num2);
  }
}
