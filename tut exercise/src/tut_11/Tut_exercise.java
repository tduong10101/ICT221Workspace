package tut_11;
import java.util.Scanner;
public class Tut_exercise {
	public static void main (String[] args){
		final int VARIABLE = 1;
		final int CONSTANT = 2;
		final int CLASS = 3;
		Scanner stringInput = new Scanner (System.in);
		Scanner Input = new Scanner (System.in);
		System.out.println ("New string");
		String input = stringInput.nextLine();
		int type = 0;
		do {
			System.out.println ("Type string\n1-Variable (inputVariable)\n2-Constant (INPUT_VARIABLE)\n3-Class (InputVariable)");
			type = Input.nextInt();
			
		} while ((type < VARIABLE)||(type>CLASS));
		if (type == VARIABLE){
			input = variableStringConverter(input);
		}
		if (type == CONSTANT){
			input = constantStringConverter(input);
		}
		if (type == CLASS){
			input = classStringConverter(input);
		}
		System.out.println (input);
		
	}
	public static String variableStringConverter(String input) {
		input = input.toLowerCase();
		for (int i=0;i<input.length();i++){
			if (input.charAt(i)==' '){
				input = input.substring(0,i)+input.substring(i+1,i+2).toUpperCase()+input.substring(i+2);
			}
		}
		return input;
	}
	public static String constantStringConverter (String input) {
		input = input.toUpperCase();
		input = input.replace(' ', '_');
		return input;
	}
	public static String classStringConverter(String input) {
		input = input.toLowerCase();
		input = input.substring(0, 1).toUpperCase() +input.substring(1);
		for (int i=0;i<input.length();i++){
			if (input.charAt(i)==' '){
				input = input.substring(0,i)+input.substring(i+1,i+2).toUpperCase()+input.substring(i+2);
			}
		}
		return input;
	}
}
