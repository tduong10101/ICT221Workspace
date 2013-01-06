package tut_2;
import java.util.Scanner;
public class Calculating_tips {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Input
		//	double subTotal
		System.out.println("Input subtotal($): ");
		double subTotal = input.nextDouble();
		//	double gratuityRate
		System.out.println("Input gratuity rate($): ");
		double gratuityRate = input.nextDouble();
		// Process
		// 	double gratuity = subTotal*gratuityRate/100.0
		double gratuity = subTotal*gratuityRate/100.0;
		//	double total = subTotal + gratuity;
		double total = subTotal+gratuity;
		// Output
		//	gratuity
		System.out.println("Gratuity: $"+gratuity);
		// 	total
		System.out.println("Total: $"+total);

	}

}
