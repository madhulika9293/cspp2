/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * To find the largest number in a given array
*/

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for solution.
 */

public class Solution {

	/**
	* Constructs the object.
	*/

	private Solution() {
		//unused
	}

	/* Fill the main function to print
	 * resultant of addition of matrices*/

	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		int[][] mat1 = new int[n1][n2];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int n3 = sc.nextInt();
		int n4 = sc.nextInt();

		int[][] mat2 = new int[n3][n4];

		for (int i = 0; i < n3; i++) {
			for (int j = 0; j < n4; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		if (n1 == n3 && n2 == n4) {
		int[][] matAdd = new int[n1][n2];

		for (int i = 0; i < n1; i++) {
			String output = "";
			for (int j = 0; j < n2; j++) {
				matAdd[i][j] = mat1[i][j] + mat2[i][j];
				output += matAdd[i][j];
				output += " ";
			}
			System.out.println(output.substring(0,output.length()-1));
		}			
		}
	}
}


