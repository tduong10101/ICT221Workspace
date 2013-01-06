package tut_2;
import java.util.Scanner;
public class Summing_the_digits_in_an_interger {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Input
		//	Integer
		int integer = 0;
		do {
			System.out.println("Input an integer: ");
			integer = input.nextInt();
			if ((integer<=0)||(integer>=1000)){
				System.out.println ("Integer must be in between 0 and 1000");
			}
		} while ((integer<=0)||(integer>=1000));
		// Process
		int digit1 = integer%10;
		int digit2 = (integer/10)%10;
		int digit3 = (integer/100)%10;
		
		//	Calculate total of digits
		int total = digit1+digit2+digit3;
		// Output
		//	total of digits
		System.out.println("Summing the digits in the integer: "+total);

	}

}
