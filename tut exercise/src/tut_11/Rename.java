package tut_11;

public class Rename {
	 public static StringBuffer formatToNamingConvention(String name, String type) {
	   StringBuffer result = new StringBuffer();
	   String[] nameArray = name.split(" ");
	   boolean firstToken = true;

	   for (String token: nameArray) {
	     if (type.equalsIgnoreCase("constant")) {
	       if(!firstToken)
	         result.append("_");
	       result.append(token.toUpperCase());
	     }

	     else if (type.equalsIgnoreCase("class"))
	       result.append(capitaliseFirstLetter(token));

	     else {
	       if (firstToken)
	         result.append(token.toLowerCase());
	       else
	         result.append(capitaliseFirstLetter(token));
	     }
	     firstToken = false;
	   }

	   return result;
	 }

	 public static String capitaliseFirstLetter(String word) {
	   String wordEnd = word.substring(1);
	   String wordStart = word.substring(0,1);

	   return wordStart.toUpperCase() + wordEnd.toLowerCase();
	 }

	 public static void main(String[] args) {
	   System.out.println(formatToNamingConvention("booking Number CODES",
	                      "variable"));
	   System.out.println(formatToNamingConvention("Discount Code",
	                      "constant"));
	   System.out.println(formatToNamingConvention("THEME park",
	                      "class"));
	 }
	}
