import java.util.Scanner;

public class Vehicle2 {
	
	public static double priceType (String vehicleType ){
		double priceType=0;
		do {
			Scanner input=new Scanner(System.in);
			System.out.println("Please enter price per motobike in cents ("+vehicleType+")");
			priceType = input.nextDouble ();
			if (priceType <=0){
				System.out.println ("Error, number invalid \n"
									+ "The price of category"+vehicleType+"be greater than 0");
			}
		} while (priceType<=0);
		return priceType;
	
	}
	public static void main(String[] args) {
		// Define all the value in this inputvehicle part
		double priceV1 = 0;
		double priceV2 = 0;
		double priceV3 = 0;
		int booleanAnwser = 0;
		Scanner input = new Scanner(System.in);
		do {
			do {
				do { 
				// Get input of V1 from user
					System.out
							.println("Please enter price per motobike in cents (V1)");
					priceV1 = input.nextDouble();
					// If price of V1 less than or equal to 0, ask for input again
					if (priceV1 <= 0) {
						System.out
								.println("Error, number invalid \n"
										+ "The price of category V1 be greater than 0");
					}
				} while (priceV1 <= 0);
				do {
					do {
					// Get input of V2 from user
						System.out
								.println("Please enter price per car or 2 axle truck without trailer in cents (V2)");
						priceV2 = input.nextDouble();
						// If price of V2 less or equal to 0, ask for input again
						if (priceV2 <= 0) {
							System.out
									.println("Error, number invalid \n"
											+ "The price of category V2 must be greater than 0");
						}
					} while (priceV2 <= 0);
					// Define booleanAnwser = 0 so it dont start "do {}while( booleanAnwser == 2)" again when user input the right number
					booleanAnwser = 0;
					// if price of V1 > V2, print out error and ask wheither user want to input v2 or input V1 and V2 again 
					if (priceV1 > priceV2) {
						System.out
								.println("Error, number invalid \n"
										+ "The price of category V2 must be greater than the price of category V1 ");
						// Ask user to input booleanAnwser again if booleanAnwser is not equal to 1 or 2
						do {
							System.out.println("Enter 1 for input V1 and V2 again \n"
										+ "Enter 2 for input V2 again");
							booleanAnwser = input.nextInt();
						} while (!((booleanAnwser == 1)||(booleanAnwser ==2)));
					// if price of V2 greater than triple of price of V1,print put error and ask wheither user want to input V2 or input V1 and V2 again
					} else if (priceV1 * 3 < priceV2) {
						System.out
								.println("Error, number invalid \n"
										+ "The price of category V2 cannot be more than triple the price of category V1 ");
					// Ask user to input booleanAnwser again if booleanAnwser is not equal to 1 or 2
						do {
							System.out.println("Enter 1 for input V1 and V2 again \n"
										+ "Enter 2 for input V2 again");
							booleanAnwser = input.nextInt();
						} while (!((booleanAnwser == 1)||(booleanAnwser ==2)));
					} 
					// print out current price categories that user have input
					System.out.println("Your current price for each categories are \n"
						+ "V1:" + priceV1 + " cent(s)" + "\nV2:" + priceV2
						+ " cent(s)" + "\nV3:" + priceV3 + " cent(s)");
				} while (booleanAnwser == 2);// start ask for V2 again when booleanAnwser equal to 2
			} while ((priceV1 > priceV2)||(priceV1 * 3 < priceV2)); 
			// start to ask for V1 and V2 again when user input 1 for booleanAnwser while price of V1 greater than price of V2 
			// or price of V2 is greater than triple of price of V1
			do {
				do {
				// Get price of V3 from user
					System.out
							.println("Please enter price per 2 axle truck with trailer or truck with 3 or more axles in cents (V3)");
					priceV3 = input.nextDouble();
					if (priceV3 <= 0) {
						System.out
									.println("Error, number invalid \n"
											+ "The price of category V3 must be greater than 0");
					}
				} while (priceV3 <= 0); // If price of V3 less or equal to 0, ask for input again
				// Set booleanAnwser = 0 so it dont start "do {}while( booleanAnwser == 2)" again when user input the right number
				booleanAnwser = 0;
				if (priceV2 > priceV3) {
				// print out error priceV2 must not be greater than price of V3 and ask wheither user want to input V1,V2,V3 again or just want to input V3 again
					System.out
							.println("Error, number invalid \n"
									+ "The price of category V3 must be greater than the price of category V2 ");
					do {
								System.out.println("Enter 1 for input V1, V2 and V3 again \n"
											+ "Enter 2 for input V3 again");
								booleanAnwser = input.nextInt();
					} while (!((booleanAnwser == 1)||(booleanAnwser ==2)));
					// Ask user to input booleanAnwser again if booleanAnwser is not equal to 1 or 2
				} else if (priceV2 * 2 < priceV3) {
				// print out error, priceV3 must not be greater than double of priceV2, ask wheiter user want to input V1,V2,V3 again or just want to input V3 again
					System.out
							.println("Error, number invalid \n"
									+ "The price of category V3 cannot be more than double the price of category V2 ");
					do {
								System.out.println("Enter 1 for input V1 and V2 again \n"
											+ "Enter 2 for input V2 again");
								booleanAnwser = input.nextInt();
					} while (!((booleanAnwser == 1)||(booleanAnwser == 2)));
					// Ask user to input booleanAnwser again if booleanAnwser is not equal to 1 or 2
				}
				// print out current each categories price user have input
				System.out.println("Your current price for each categories are \n"
						+ "V1:" + priceV1 + " cent(s)" + "\nV2:" + priceV2
						+ " cent(s)" + "\nV3:" + priceV3 + " cent(s)");
				} while (booleanAnwser == 2);
		} while ((priceV2 > priceV3) || (priceV2 * 2 < priceV3));
		// ask for V1,V2,V3 again as user input booleanAnwser equal tp  1 while priceV2 greater than priceV3 or price3 greater than double of priceV2
	}

}
