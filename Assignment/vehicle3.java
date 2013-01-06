import java.util.Scanner;

public class vehicle3 {
	
	public static int priceValidate1 (String vehicleType ){
		int priceType;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please input price for cartegory "+vehicleType+" in cent(s)");
			priceType = input.nextInt();
			if (priceType <=0){
				System.out.println ("Error, number invalid \n"
									+ "The price of category "+vehicleType+" must be greater than 0");
			} 
		} while (priceType <= 0);
		return priceType;
	}
	public static void main (String[] a){
		Scanner input = new Scanner(System.in);
		int priceV1 = priceValidate1 ("V1");
		System.out.println ("Price of V1: " + priceV1 +" cents");
		int priceV2 = priceValidate1 ("V2");
		while (priceV1 >= priceV2) {
			System.out.println ("Error, number invalid\n" +"Price of category V1 must not be greater than or equal to price of category V2\n"
								+"Choose price category to fix: \n"+"1- V1 and V2\n"+"2- V2");
			int i = input.nextInt();
			if (i == 1){
				priceV1 = priceValidate1 ("V1");
				priceV2 = priceValidate1 ("V2");
			}
			else if (i == 2){
				priceV2 = priceValidate1 ("V2");
			}
		}
		System.out.println ("Price of V1: " + priceV1 +" cents");
		System.out.println ("price of V2: " + priceV2 +" cents");
		int priceV3 = priceValidate1 ("V3");
		while (priceV2 >= priceV3){
			System.out.println ("Error, number invalid\n" +"Price of category V2 must not be greater than or equal to price of category V3\n"
								+"Choose price category to fix: \n"+"1- V1,V2 and V3\n"+"2- V3");
			int i = input.nextInt();
			if (i == 1){
				do {
					priceV1 = priceValidate1 ("V1");
					priceV2 = priceValidate1 ("V2");
					priceV3 = priceValidate1 ("V3");
				} while (priceV2<priceV1);
			}
			else if (i == 2){
				priceV3 = priceValidate1 ("V3");
			}
		}
		System.out.println ("Price of V1: " + priceV1 +" cents");
		System.out.println ("price of V2: " + priceV2 +" cents");
		System.out.println ("price of V3: " + priceV3 +" cents");
	}
}