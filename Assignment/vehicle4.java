import java.util.Scanner;

public class vehicle4 {
	public static int priceVehivleValidate1(String vehicleType) {
		int priceType;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please input price for cartegory "
					+ vehicleType + " in cent(s)");
			priceType = input.nextInt();
			if (priceType <=0) {
				System.out.println("Error, number invalid \n"
						+ "The price of category " + vehicleType
						+ " must be greater than 0");
			}
		} while (priceType <= 0);
		return priceType;
	}
	public static void main(String[] a) {
		
		Scanner input = new Scanner(System.in);
		int priceV1 = priceVehivleValidate1("V1");
		System.out.println("Price of V1: " + priceV1 + " cents");
		int priceV2 = priceVehivleValidate1("V2");
		while ((priceV1 >= priceV2)||(priceV1 * 3 < priceV2)){
			if (priceV1 >= priceV2){
			System.out.println ("price of V1 can not be greater than or equal to price of V2");
			}
			else if (priceV1 * 3 < priceV2){
				System.out.println("V2 must not be greater than triple of V1");
			}
			System.out.println ("Choose category to fix again\n"+"1- V1,V2\n"+"2- V2");
			int i = input.nextInt ();
			if (i == 1){
				priceV1 = priceVehivleValidate1("V1");
				priceV2 = priceVehivleValidate1("V2");
			}
			if (i == 2){
				priceV2 = priceVehivleValidate1("V2");
			}
		}
		System.out.println ("Price of V1: " + priceV1 + " cents\n"
							+"Price of V2: " + priceV2 + " cents");
		int priceV3 = priceVehivleValidate1("V3");
		while ((priceV2 >= priceV3)||(priceV1 >= priceV2)||(priceV2 * 2 < priceV3)){
			if (priceV2 >= priceV3){
				System.out.println ("price of V2 can not be greater than or equal to price of V3");
			}
			else if (priceV1 >=priceV2){
				System.out.println ("price of V1 can not be greater than or equal to price of V2");
			}
			else if (priceV2 * 2 < priceV3){
				System.out.println("V3 must not be greater than double of V2");
			}
			System.out.println ("Choose category to fix again\n"+"1- V1,V2,V3\n"+"2- V3");
			int i = input.nextInt ();
			if (i == 1){
				priceV1 = priceVehivleValidate1("V1");
				priceV2 = priceVehivleValidate1("V2");
				priceV3 = priceVehivleValidate1("V3");
			}
			if (i == 2){
				priceV3 = priceVehivleValidate1("V3");
			}
		}
		System.out.println ("Price of V1: " + priceV1 + " cents\n"
				+"Price of V2: " + priceV2 + " cents\n"
				+"Price of V3: "+ priceV3 + " cents");
	}
}