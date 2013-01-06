package tut_2;
import java.util.Scanner;
public class Fahrenheit_Celsius {
	/**
	 * 	Test:
	 *  Input Fahrenheit = 100;
	 *  Output Celsius = 37.77777777777778
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// Input
		// 	Fahrenheit 
		// Process
		// 	Convert Fahrenheit to Celsius
		// Output
		// 	Celsius
		
		// Input
		// 	double Fahrenheit
		System.out.println ("Input Fahrenheit :");
		double fahrenheit = input.nextDouble();
		// Process
		// 	double Celsius = (5/9)*(Fahrenheit-32)
		double celsius = (5/9.0)*(fahrenheit - 32);
		// Output
		// 	double Celsius
		System.out.println ("Celsisus :"+celsius);

	}

}
