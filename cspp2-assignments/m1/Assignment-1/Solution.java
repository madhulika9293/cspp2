/**
  * Date: 27-08-2018.
  * Name: Madhulika
  * To print out name and roll number
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

  /**
    * main function.
    * @param args is for command line arguments.
  */

  public static void main(final String[] args) {
    String nameinp;
    String rollinp;

    Scanner nmobj = new Scanner(System.in);
    Scanner rollobj = new Scanner(System.in);

    System.out.println("Enter your Name");
    nameinp = nmobj.nextLine();

    System.out.println("Enter your Roll Number");
    rollinp = rollobj.nextLine();

    System.out.println("Name :" + nameinp + "; Roll Number :" + rollinp);
  }
}
