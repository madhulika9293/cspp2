import java.util.Scanner;

public class swap {
	public static void main(String[] args) {
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