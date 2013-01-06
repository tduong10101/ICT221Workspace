package tut9;
import java.util.Scanner;
public class testCircle2{
	public static void main (String[]args){
		circle2 c1 = new circle2();
		System.out.println ("Before creating c2");
		System.out.println ("c1 is: radius ("+c1.radius+")and number of Circle objects is ("+c1.numberOfObjects+")");
		

		circle2 c2 = new circle2(5.0);
		c1.radius = 5.0;
		System.out.println ("c2 is: radius ("+c2.radius+")and number of Circle objects is ("+c2.numberOfObjects+")");
		System.out.println ("c1 is: radius ("+c1.radius+")and number of Circle objects is ("+c1.numberOfObjects+")");
		
	}
}
class circle2 {
double radius;
static int numberOfObjects = 0;
circle2(){
	radius = 2.0;
	numberOfObjects++;
}
circle2(double newRadius){
	radius = newRadius;
	numberOfObjects++;
	
}
static int getNumberOfObjects(){
	return numberOfObjects;
}
double getArea(){
	return radius*radius*Math.PI;
}
}
