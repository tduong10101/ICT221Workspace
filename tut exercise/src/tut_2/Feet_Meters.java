package tut_2;
import java.util.Scanner;
public class Feet_Meters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Input
		//	double feet
		System.out.println ("Input feet: ");
		double feet = input.nextDouble();
		
		// Process
		
		//	meters = feet/0.305
		double meters = feet*0.305;
		// Output
		//	double meters
		System.out.println ("Meters: "+meters);

	}

}
