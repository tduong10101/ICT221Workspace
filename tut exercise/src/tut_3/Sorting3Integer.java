package tut_3;
import java.util.Scanner;
public class Sorting3Integer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println ("Input integer 1: ");
		int integer1 = input.nextInt();
		System.out.println ("Input integer 2: ");
		int integer2 = input.nextInt();
		System.out.println ("Input integer 3: ");
		int integer3 = input.nextInt();
		int minNumber;
		int maxNumber;
		int midNumber = 0;
		minNumber = integer1;
		if (minNumber>integer2){
			minNumber = integer2;
		}
		else if (minNumber>integer3){
			minNumber = integer3;
		}
		maxNumber = integer3;
		if (maxNumber<integer1){
			maxNumber = integer1;
		}
		else if (maxNumber<integer2){
			maxNumber = integer2;
		}
		if ((minNumber<integer1)&&(integer1<maxNumber)){
			midNumber = integer1;
		}
		else if ((minNumber<integer2)&&(integer2<maxNumber)){
			midNumber = integer2;
		}
		else if ((minNumber<integer3)&&(integer3<maxNumber)){
			midNumber = integer3;
		}
		System.out.println ("Sort solution: "+minNumber+"<"+midNumber+"<"+maxNumber);
	}

}
