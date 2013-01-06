import java.util.Scanner;

public class Vehicle {
	public static void main(String[] args) {
		double priceV1 = 0;
		double priceV2 = 0;
		double priceV3 = 0;
		Scanner input = new Scanner(System.in);
		do {
			do {
				do { 
					System.out
							.println("Please enter price per motobike in cents (V1)");
					priceV1 = input.nextDouble();
					if (priceV1 <= 0) {
						System.out
								.println("Error, number invalid \n"
										+ "The price of category V1 be greater than 0");
					}
				} while (priceV1 <= 0);
				do {
					System.out
							.println("Please enter price per car or 2 axle truck without trailer in cents (V2)");
					priceV2 = input.nextDouble();
					if (priceV1 <= 0) {
						System.out
								.println("Error, number invalid \n"
										+ "The price of category V2 must be greater than 0");
					}
				} while (priceV2 <=0);
				if (priceV1 > priceV2) {
					System.out
							.println("Error, number invalid \n"
									+ "The price of category V2 must be greater than the price of category V1 \n"
									+ "Please enter the value again");
				} else if (priceV1 * 3 < priceV2) {
					System.out
							.println("Error, number invalid \n"
									+ "The price of category V2 cannot be more than triple the price of category V1 \n"
									+ "Please enter the value again");
				}				
			} while ((priceV1 > priceV2) || (priceV1 < priceV2 / 3));
			do {
				System.out
						.println("Please enter price per 2 axle truck with trailer or truck with 3 or more axles in cents (V3)");
				priceV3 = input.nextDouble();
				if (priceV3 <= 0) {
					System.out
								.println("Error, number invalid \n"
										+ "The price of category V3 must be greater than 0");
				}
			} while (priceV3 <= 0);
			if (priceV2 > priceV3) {
				System.out
						.println("Error, number invalid \n"
								+ "The price of category V3 must be greater than the price of category V2 \n"
								+ "Please enter the value again");
			} else if (priceV2 * 2 < priceV3) {
				System.out
						.println("Error, number invalid \n"
								+ "The price of category V3 cannot be more than double the price of category V2 \n"
								+ "Please enter the value again");
			}
			System.out.println("Your current price for each categories are \n"
					+ "V1:" + priceV1 + "cent(s)" + "\nV2:" + priceV2
					+ "cent(s)" + "\nV3:" + priceV3 + "cent(s)");
		} while ((priceV2 > priceV3) || (priceV2 * 2 < priceV3));
	}

}
