package tut9;
import java.util.Scanner;
public class testCircle1 {
	public static void main (String[] args){
		Circle1 myCircle = new Circle1(5.0);
		System.out.println ("The area of the circle of radius "+ myCircle.radius +" is "+ myCircle.getArea());
		Scanner input = new Scanner(System.in);
		System.out.println ("Please input radius");
		double radius = input.nextDouble ();
		Circle1 yourCircle = new Circle1(radius);
		System.out.println ("The area of the circle of radius "+ yourCircle.radius +" is "+ yourCircle.getArea());
		myCircle = new Circle1();
		System.out.println ("The area of the circle of radius "+ myCircle.radius +" is "+ myCircle.getArea());
		
	}
}
class Circle1 {
	double radius;
	Circle1(){
		radius = 1;
	}
	Circle1(double newRadius){
		radius = newRadius;
	}
	double getArea(){
		return radius*radius*Math.PI;
	}
}
