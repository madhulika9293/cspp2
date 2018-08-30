/**
  * Date: 30-08-2018.
  * Name: Madhulika
  * To find the largest number in a given array
*/

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
	
	/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}

		int max = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		System.out.println(max);
	}
}

