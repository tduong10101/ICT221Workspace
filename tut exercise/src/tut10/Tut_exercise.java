package tut10;
import java.util.Scanner;
public class Tut_exercise {
	public static void main (String[] args){
		Scanner input = new Scanner (System.in);
		Sale Sale1 = new Sale();
		String toString1 = Sale1.toString();
		int [] codes = new int[3];
		System.out.println ("Code Batch: ");
		codes[0] = input.nextInt();
		System.out.println ("Code Date: ");
		codes[1] = input.nextInt();
		System.out.println ("Code: ");
		codes[2] = input.nextInt();
		System.out.println ("Volume: ");
		int volume = input.nextInt();
		Sale Sale2 = new Sale(volume, codes);
		String toString2 = Sale2.toString();
		
		System.out.println (toString1+toString2);
	}
}
class Sale {
	private static int totalVolumeRemain = 10000;
	private int volume;
	private int [] codes =  new int [3];
	Sale(){
		volume = 50;
		int [] defaultcode = {0,0,0};
		codes = defaultcode;
		getTotalVolumeRemaining();
	}
	Sale(int constructionVolume, int [] constructionCodes){
		volume = constructionVolume;
		codes = constructionCodes;
		getTotalVolumeRemaining();
	}
	int getTotalVolumeRemaining (){
		totalVolumeRemain = totalVolumeRemain - volume;
		return totalVolumeRemain;
	}
	public String toString (){
		String toString = ("volume: "+volume+"\ncodes: "+codes[0]+codes[1]+codes[2]+"\nTotal Volume Remain: "+totalVolumeRemain+"\n"); 
		return toString;  
		
	}
}
