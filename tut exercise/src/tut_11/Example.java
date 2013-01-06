package tut_11;

public class Example{

	public static void main(String[] args){
	Example example = new Example();
	example.test();
	}

	public void test(){
	String someString = "la la la la la la la";
	/* 1) i need to know how to change a String first character to uppercase. */ 
	String string1 = someString.substring(0,1).toUpperCase() + someString.substring(1);
	/* 2) i also how to change all characters to lower case. */
	String string2 = someString.toUpperCase();
	/* 3) i also need to know how to replace a space with underscore
	eg " " to "_". */
	String string3 = someString.replace(' ','_');
	System.out.println(someString);
	System.out.println(string1);
	System.out.println(string2);
	System.out.println(string3); 
	}
	}