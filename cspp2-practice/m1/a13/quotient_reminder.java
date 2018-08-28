/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * Swapping two numbers
*/

import java.util.Scanner;

/**
  * The only classs.
*/

public final class quotient_reminder {
  /**
    * default constructor.
  */

  private quotient_reminder() {
    //unused
  }

  /**
    * main function.
    * @param args is for command line arguments.
  */

  public static void main(final String[] args) {

    int num, denom;

    Scanner n = new Scanner(System.in);
    System.out.println("Enter dividend");
    num = n.nextInt();

    Scanner d = new Scanner(System.in);
    System.out.println("Enter divisor");
    denom = d.nextInt();

    double quo, rem;
    // quo = 0.0;
    // rem = 0.0;

    // while (num >= denom) {
    //   num -= denom;
    //   quo++;
    // }

    // rem = num - quo;
    quo = num / denom;
    rem = num % denom;

    System.out.println("Quotient is: " + quo + "; Reminder is: " + rem);
  }
}
