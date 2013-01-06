package tut8;

public class testPassArray {


	public static void main(String[] args) {
		int [] a = {1,2};
		System.out.println ("a[0] is "+ a[0]+"\na[1]is "+a[1]);
		swap (a[0], a[1]);
		System.out.println ("After swap 1\n"+"a[0] is "+ a[0]+"\na[1]is "+a[1]);
		swapArray (a);
		System.out.println ("After swap 1\n"+"a[0] is "+ a[0]+"\na[1]is "+a[1]);

	}
	public static void swap (int n1, int n2){
		int temp = n1;
		n1 = n2;
		n2 = temp;
	}
	public static void swapArray (int []array){
		int temp = array [0];
		array [0] = array[1];
		array [1] = temp;
	}
}
/**
a[0] is 1
a[1]is 2
After swap 1
a[0] is 1
a[1]is 2
Take array as an integer
After swap 2
a[0] is 2
a[1]is 1
Take array as an array
*/