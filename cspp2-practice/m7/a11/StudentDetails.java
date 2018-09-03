/**
  * Date: 03-09-2018.
  * Name: Madhulika
  * To write a student details class and print out the GPA
*/

import java.util.Scanner;

/**
* the only class.
*/
public final class StudentDetails {
  /**
   * Student Name.
   */
  private String name;
  /**
   * Roll Number.
   */
  private String rollNumber;
  /**
   * Marks in Subject 1.
   */
  private float sub1;
  /**
   * Marks in Subject 2.
   */
  private float sub2;
  /**
   * Marks in Subject 3.
   */
  private float sub3;

  /**
   * Constructs the object.
   *
   * @param      n     name
   * @param      rnum  The rnum
   * @param      s1    The s 1
   * @param      s2    The s 2
   * @param      s3    The s 3
   */

  public StudentDetails(
    final String n, final String rnum, final float s1,
    final float s2, final float s3) {
    name = n;
    rollNumber = rnum;
    sub1 = s1;
    sub2 = s2;
    sub3 = s3;
  }

  /**
   * Calculates the gpa of a student.
   *
   * @return     gpa
   */

  public float gpa() {
    final int num1 = 3;
    final int num2 = 10;
    float temp = ((sub1 + sub2 + sub3) / num1) * num2;
    int gp = (int) temp;
    return (float) gp / num2;
  }

  /**
   * The main function.
   *
   * @param      args  The arguments
   */

  public static void main(final String[] args) {

    Scanner s = new Scanner(System.in);

    String nm = s.next();
    String rnum = s.next();
    float sb1 = s.nextFloat();
    float sb2 = s.nextFloat();
    float sb3 = s.nextFloat();

    StudentDetails stu = new StudentDetails(nm, rnum, sb1, sb2, sb3);

    System.out.println(stu.gpa());
  }
}
