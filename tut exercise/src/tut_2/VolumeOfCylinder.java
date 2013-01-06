package tut_2;
import java.util.Scanner;
public class VolumeOfCylinder {
	/**
	 * 	Test
	 * 	Input
	 * 	radius = 3
	 * 	length = 3
	 * 	Output
	 * 	area = 28.274333882308138
	 * 	volume = 84.82300164692441
	 * @param args
	 * @author NoX
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Input
		
		//	double radius
		System.out.println ("Input radius: ");
		double radius = input.nextDouble();
		//	double length
		System.out.println ("Input length: ");
		double length = input.nextDouble();
		// Process
		//	double area = radius*radius*Pi
		double area = radius*radius*Math.PI;
		//	double volume = area*length
		double volume = area*length;
		// Output
		
		//	area
		System.out.println("Area: "+area);
		//	volume
		System.out.println("Volume: "+volume);
	}

}
