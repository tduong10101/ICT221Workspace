package reWrite_1;

import java.util.Scanner;

public class Input {
	// MAIN METHOD
	public static void main(String[] args) {
		// DEFINE VARIABLE
		int[] totalLanes = new int[3];
		int[] vehicleTimeProcessingRequirement = new int[3];
		int[] vehiclePrice = new int[3];
		int manualCost;
		int autoCost;
		int eTollCost;
		int anwser = 0;
		int anwser1 = 0;
		final int MC = 0;
		final int AC = 1;
		final int ET = 2;
		final int V1 = 0;
		final int V2 = 1;
		final int V3 = 2;
		final int CATEGORIES_0=0;
		final int CATEGORIES_1=1;
		final int CATEGORIES_2=2;
		final int CATEGORIES_3=3;
		Scanner input = new Scanner(System.in);
		System.out
				.println("Welcome to J-toll JavaSolution and thank you for using our sofware\n"
						+ "Version: 1.0.0\n"
						+ "Buid by: Terry Duong\n"
						+ "ID: 1039474\n");

		do {
			System.out.println("INPUT\n");
			// Number of Lane for each type
			final int MIN_LANE = 1;
			final int MAX_LANE = 4;
			do {
				totalLanes[MC] = input("Number of Manual Lane", "", MIN_LANE,
						MAX_LANE, 0);
				totalLanes[AC] = input("Number of Auto Lane", "", MIN_LANE, MAX_LANE,
						0);
				totalLanes[ET] = input("Number of E-toll Lane", "", MIN_LANE,
						MAX_LANE, 0);
				if ((totalLanes[MC] +totalLanes[AC] + totalLanes[ET]) > 8) {
					System.out.println("Total Lane must not be greater than 8");
				}
			} while ((totalLanes[MC] +totalLanes[AC] + totalLanes[ET]) > 8);
			// Cost per Lane
			final int MIN_MANUAL_COST = 1374;
			final int MAX_MANUAL_COST = 3000;
			final int MIN_COST = 1;
			final int MAX_COST = 10000;
			manualCost = input("Manual Cost (cents/hour)", "", MIN_MANUAL_COST,
					MAX_MANUAL_COST, CATEGORIES_0);
			autoCost = input("Auto Cost (cents/hour)", "", MIN_COST, MAX_COST,
					CATEGORIES_0);
			eTollCost = input("E-toll Cost (cents/hour)", "", MIN_COST,
					MAX_COST, CATEGORIES_0);

			// Time taken per lane
			final int MIN_MANUAL_TIME = 20;
			final int MAX_MANUAL_TIME = 60;
			final int MIN_AUTO_TIME = 3;
			final int MAX_AUTO_TIME = 30;
			final int MIN_ETOLL_TIME = 1;
			final int MAX_ETOLL_TIME = 5;
			vehicleTimeProcessingRequirement[MC] = input("Manual Lane taken time (seconds)", "",
					MIN_MANUAL_TIME, MAX_MANUAL_TIME, CATEGORIES_0);

			if (vehicleTimeProcessingRequirement[MC] > MAX_AUTO_TIME) {
				vehicleTimeProcessingRequirement[AC] = input("Auto Lane taken time (seconds)", "",
						MIN_AUTO_TIME, MAX_AUTO_TIME, CATEGORIES_0);
			} else if (vehicleTimeProcessingRequirement[MC] <= MAX_AUTO_TIME) {
				vehicleTimeProcessingRequirement[AC] = input("Auto Lane taken time (seconds)",
						"Manual Lane taken time (seconds)", MIN_AUTO_TIME,
						vehicleTimeProcessingRequirement[MC], CATEGORIES_1);
			}
			if (vehicleTimeProcessingRequirement[AC] > MAX_ETOLL_TIME) {
				vehicleTimeProcessingRequirement[ET] = input("E-toll Lane taken time (seconds)", "",
						MIN_ETOLL_TIME, MAX_ETOLL_TIME, CATEGORIES_0);
			} else if (vehicleTimeProcessingRequirement[AC] <= MAX_ETOLL_TIME) {
				vehicleTimeProcessingRequirement[ET] = input("E-toll Lane taken time (seconds)",
						"Auto Lane taken time (seconds)", MIN_ETOLL_TIME,
						vehicleTimeProcessingRequirement[AC], CATEGORIES_1);
			}

			// Vehicle price
			final int MIN_PRICE = 100;
			final int MAX_PRICE = 9 ^ 9999999;
			vehiclePrice[V1] = input("Vehicle type 1 price (cents)", "", MIN_PRICE,
					MAX_PRICE, CATEGORIES_2);
			vehiclePrice[V2] = input("Vehicle type 2 price (cents)",
					"Vehicle type 1 price (cents)", vehiclePrice[V1], MAX_PRICE, CATEGORIES_3);
			vehiclePrice[V3] = input("Vehicle type 3 price (cents)",
					"Vehicle type 2 price (cents)", vehiclePrice[V2], MAX_PRICE, CATEGORIES_3);
			do {
				// New traffic object name myTraffic
				System.out.println("Please input traffic.txt path:");
				String path = input.next();
				Traffic myTraffic = new Traffic(path);
				
				// Transfer data into myTraffic object
				myTraffic.setTotalLanes(totalLanes);
				myTraffic.setVehiclePrice(vehiclePrice);
				myTraffic
						.setVehicleTimeProcessingRequirement(vehicleTimeProcessingRequirement);
				myTraffic.setAcMachineCostPerHour(autoCost);
				myTraffic.setStaffCostPerHour(manualCost);
				myTraffic.setEtMachineCostPerHour(eTollCost);

				// OUTPUT
				System.out.println("\nOUTPUT\n");
				System.out.println("\nCost for each type of lane");
				System.out.println("Total Manual cash lanes cost per hour: "
						+ convertTo$(myTraffic.costPerHourMCLanes()) + " $/hour");
				System.out.println("Total Auto cash lanes cost per hour: "
						+ convertTo$(myTraffic.costPerHourACLanes()) + " $/hour");
				System.out.println("Total e-toll lanes cost per hour: "
						+ convertTo$(myTraffic.costPerHourETLanes()) + " $/hour");
				System.out.println("\nTime processing for each type of lane");
				System.out
						.println("Total processing time for all Manual Cash lanes: "
								+ myTraffic.processingTimePerVehicle(MC) + " seconds");
				System.out
						.println("Total processing time for all Auto Cash lanes: "
								+ myTraffic.processingTimePerVehicle(AC) + " seconds");
				System.out
						.println("Total processing time for all E-toll Lanes: "
								+ myTraffic.processingTimePerVehicle(ET) + " seconds");

				System.out.println("\nNumber of vehicle in traffic.txt");
				System.out.println("Vehicle V1 type: " + myTraffic.vehicleInList(V1));
				System.out.println("Vehicle V2 type: " + myTraffic.vehicleInList(V2));
				System.out.println("Vehicle V3 type: " + myTraffic.vehicleInList(V3));
				System.out.println("Total vehicles: " + myTraffic.vehicleInList());

				System.out
						.println("\nTable: Number of vehicles in each type of lane\n"
								+ "\nLane Type\t\t"
								+ "Manual Cash\t"
								+ "Auto Cash\t"
								+ "E-toll"
								+ "\n------------------------------------------------------------------"
								+ "\nVehicle Type\t\t"
								+ "\n   V1\t\t\t"
								+ myTraffic.vehicleInLaneType(V1, MC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V1, AC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V1, ET)
								+ "\n   V2\t\t\t"
								+ myTraffic.vehicleInLaneType(V2, MC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V2, AC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V2, ET)
								+ "\n   V3\t\t\t"
								+ myTraffic.vehicleInLaneType(V3, MC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V3, AC)
								+ "\t\t"
								+ myTraffic.vehicleInLaneType(V3, ET));
				System.out.println("\nTotal vehicles can access the lanes: "
						+ myTraffic.vehicleInLaneType(false));
				System.out
						.println("Total vehicles denied to access the lanes: "
								+ myTraffic.vehicleInLaneType(true));

				System.out.println("\nTime processing");
				System.out
						.println("The total time for all vehicle to process through Manual Cash lanes: "
								+ myTraffic.processingTimePerLaneType(MC) + " seconds");
				System.out
						.println("The total time for all vehicle to process through Auto Cash lanes: "
								+ myTraffic.processingTimePerLaneType(AC) + " seconds");
				System.out
						.println("The total time for all vehicle to process through E-toll lanes: "
								+ myTraffic.processingTimePerLaneType(ET) + " seconds");
				System.out
						.println("The total time for all vehicle to process through all lanes: "
								+ myTraffic.processingTimePerLaneType() + " seconds");

				System.out.println("\nRevenue");
				System.out
						.println("Total revenue gained for Manual Cash lanes: "
								+ "$" + convertTo$(myTraffic.revenuePerLaneType(MC)));
				System.out.println("Total revenue gained for Auto Cash lanes: "
						+ "$" + convertTo$(myTraffic.revenuePerLaneType(AC)));
				System.out.println("Total revenue gained for E-toll lanes: "
						+ "$" + convertTo$(myTraffic.revenuePerLaneType(ET)));
				System.out.println("Total revenue gained for all lanes: " + "$"
						+ convertTo$(myTraffic.revenuePerLaneType()));

				System.out
						.println("\nTotal Cost for the lanes to process all the vehicles in traffic.txt");
				System.out
						.println("Total cost of running all Manual Cash lanes: "
								+ "$" + convertTo$(myTraffic.costPerLaneType(MC)));
				System.out
						.println("Total cost of running all Auto Cash lanes: "
								+ "$" + convertTo$(myTraffic.costPerLaneType(AC)));
				System.out.println("Total cost of running all E-toll lanes: "
								+ "$" + convertTo$(myTraffic.costPerLaneType(ET)));
				System.out.println("Total cost of running all lanes: " + "$"
								+ convertTo$(myTraffic.costPerLaneType()));

				System.out.println("\nNet Income");
				System.out.println("Net Income for Manual Cash lanes: " + "$"
						+ convertTo$(myTraffic.netIncomePerLaneType(MC)));
				System.out.println("Net Income for Auto Cash lanes: " + "$"
						+ convertTo$(myTraffic.netIncomePerLaneType(AC)));
				System.out.println("Net Income for E-toll lanes: " + "$"
						+ convertTo$(myTraffic.netIncomePerLaneType(ET)));
				System.out.println("Net Income for all lanes: " + "$"
						+ convertTo$(myTraffic.netIncomePerLaneType()));
				System.out
						.println("Do you want to calculate the data with other traffic.txt file or exit the prograrm?"
								+ "\n1- Calculate the data with other traffic.txt"
								+ "\n2- Exit the prograrm");
				final int MAX_ANWSER = 2;
				final int MIN_ANWSER = 1;
				anwser = input("Anwser", "", MIN_ANWSER, MAX_ANWSER, 0);
				if (anwser == 1) {
					System.out
							.println("Do you want to use the previouse data you have enter?"
									+ "\n1- Yes" + "\n2- No");
					anwser1 = input("Anwser", "", MIN_ANWSER, MAX_ANWSER, 0);
					if (anwser1 == 1){
						System.out.println ("Number of Manual Lane: "+totalLanes[MC]);
						System.out.println ("Number of Auto Lane: "+totalLanes[AC]);
						System.out.println ("Number of E-toll Lane: "+totalLanes[ET]);
						System.out.println ("Manual Cost: "+manualCost+"(cents/hour)");
						System.out.println ("Auto Cost: "+autoCost+"(cents/hour)");
						System.out.println ("E-toll Cost: "+eTollCost+"(cents/hour)");
						System.out.println ("Manual Lane taken time: "+vehicleTimeProcessingRequirement[MC]+"(seconds)");
						System.out.println ("Auto Lane taken time: "+vehicleTimeProcessingRequirement[AC]+"(seconds)");
						System.out.println ("E-toll taken time: "+vehicleTimeProcessingRequirement[ET]+"(seconds)");
						System.out.println ("Vehicle type 1 price: "+vehiclePrice[V1]+"(cents)");
						System.out.println ("Vehicle type 2 price: "+vehiclePrice[V2]+"(cents)");
						System.out.println ("Vehicle type 3 price: "+vehiclePrice[V3]+"(cents)");
					}
				} else if (anwser == 2) {
					anwser1 = 2;
				}
				
				
			} while (anwser1 == 1);
		} while (anwser == 1);
		System.exit(0);
	}

	// INPUT METHOD
	/**
	 * @param String nameOfInput
	 * @param String nameOfInputBefore
	 * @param int min Minimum input number
	 * @param int max Maximum input number
	 * @param int categories - 
	 * <p>CATEGORIES_0 the validity number of each laneType,cost of each laneType and max, min time
	 * <p>CATEGORIES_1 the validity time process of laneType1 can not be faster than time process of laneType2
	 * <p>CATEGORIES_2 the validity for vehicle price must be greater than 100
	 * <p>CATEGORIES_3 the validity for vehicle price1 must not be greater than vehicle price 2
	 */
	public static int input(String nameOfInput, String nameOfInputBefore,
			int min, int max, int categories) {
		int inputNumber = 0;
		final int CATEGORIES_0=0;
		final int CATEGORIES_1=1;
		final int CATEGORIES_2=2;
		final int CATEGORIES_3=3;
		do {
			inputNumber = input(nameOfInput);
			if ((inputNumber < min) || (inputNumber > max)) {
				if (categories == CATEGORIES_0) {
					System.out
							.println("Invalid input! Input can not be less than "
									+ min
									+ " or greater than "
									+ max
									+ "\nPlease try again!");
				} else if (categories == CATEGORIES_1) {
					System.out.println("Invalid input! " + nameOfInput
							+ " can not be slower than " + nameOfInputBefore
							+ " (" + max + "s)"+"\nor faster than " +min+" (seconds)"+ "\nPlease try again!");
				} else if (categories == CATEGORIES_2) {
					System.out
							.println("Invalid input! Input can not be less than "
									+ min + "\nPlease try again!");
				}
			}
			while (((inputNumber <= min) || (inputNumber >= max))
					&& (categories == CATEGORIES_3)) {
				System.out.println("Invalid input! " + nameOfInput
						+ " must be greater than " + nameOfInputBefore + " ("
						+ min + ") " + "\nPlease try again!");
				inputNumber = input(nameOfInput);
			}
		} while ((inputNumber < min) || (inputNumber > max));
		return inputNumber;
	}

	/**
	 * Input can not be less than or equal to 0
	 * @param nameOfInput
	 * @return Input greater than 0
	 */
	public static int input(String nameOfInput) {
		int inputNumber = 0;
		do {
			System.out.println(nameOfInput);
			Scanner input = new Scanner(System.in);
			inputNumber = input.nextInt();
			if (inputNumber <= 0) {
				System.out
						.println("Invalid input! Input can not be less than or equal to 0\n"
								+ "Please try again!");
			}
		} while (inputNumber <= 0); // while input is less than or equal to 0 keep asking user to enter the right input
		return inputNumber;
	}
	// Method convert int cash in cents to double cash in dollar
	public static double convertTo$(int amountOfCashInCents) {
		return amountOfCashInCents / 100.0;
	}
	// Method convert long cash in cents to double cash in dollar
	public static double convertTo$(long amountOfCashInCents) {
		return amountOfCashInCents / 100.0;
	}
}

class Traffic {
	// Declare the variables
	final int MOTOBIKE = 0;
	final int CAR = 1;
	final int TRUCK = 2;
	final int DA = -1;
	final int MC = 0;
	final int AC = 1;
	final int ET = 2;
	final int V1 = 0;
	final int V2 = 1;
	final int V3 = 2;
	final int VEHICLE_TYPE = 0;
	final int NUMBER_AXLES = 1;
	final int NUMBER_TRAILER = 2;
	final int CASH = 3;
	private int[][] vehicleList;
	private int[] totalLanes;
	private int staffCostPerHour;
	private int acMachineCostPerHour;
	private int etMachineCostPerHour;
	private int[] vehicleTimeProcessingRequirement;
	private int[] vehiclePrice;

	// Set and get method for the private variables
	void setTotalLanes(int[] setTotalLanes) {
		totalLanes = setTotalLanes;
	}

	void setVehicleTimeProcessingRequirement(
			int[] setVehicleTimeProcessingRequirement) {
		vehicleTimeProcessingRequirement = setVehicleTimeProcessingRequirement;
	}

	void setVehiclePrice(int[] setVehiclePrice) {
		vehiclePrice = setVehiclePrice;
	}

	void setStaffCostPerHour(int setStaffCostPerHour) {
		staffCostPerHour = setStaffCostPerHour;
	}

	void setAcMachineCostPerHour(int setAcMachineCostPerHour) {
		acMachineCostPerHour = setAcMachineCostPerHour;
	}

	void setEtMachineCostPerHour(int setEtMachineCostPerHour) {
		etMachineCostPerHour = setEtMachineCostPerHour;
	}

	int[] getTotalLanes() {
		return totalLanes;
	}

	int[] getVehicleTimeProcessingRequirement() {
		return vehicleTimeProcessingRequirement;
	}

	int[] getVehiclePrice() {
		return vehiclePrice;
	}

	int getStaffCostPerHour() {
		return staffCostPerHour;
	}

	int getAcMachineCostPerHour() {
		return acMachineCostPerHour;
	}

	int getEtMachineCostPerHour() {
		return etMachineCostPerHour;
	}

	/**
	 * Traffic default constructor
	 * 
	 */
	Traffic() {
	}

	/**
	 * Constructs a Traffic object that contains a vehicle list loaded from the
	 * file specified by path.
	 * 
	 * @param path
	 *            Location of file containing vehicle values
	 */
	public Traffic(String path) {
		final int TOTAL_COLUMNS = 4;

		// Declare file reader stream
		java.io.FileReader frs = null;

		// Declare streamTokenizer
		java.io.StreamTokenizer in = null;

		try {

			// Create file input stream
			frs = new java.io.FileReader(path);

			// Create a stream tokenizer wrapping file input stream
			in = new java.io.StreamTokenizer(frs);

			// Read first token from file
			in.nextToken();

			// Count total numbers in file
			int totalNumbers = 0;

			// Repeat until end of file reached
			while (in.ttype != java.io.StreamTokenizer.TT_EOF) {

				// Add 1 to numberCount if a number is read
				if (in.ttype == java.io.StreamTokenizer.TT_NUMBER) {
					totalNumbers++;
				}

				// Read next token from file
				in.nextToken();
			}

			// Only read data if number of totalNumbers is divisible by
			// totalColumns
			if (totalNumbers % TOTAL_COLUMNS != 0) {
				System.out
						.println("File error: The total numbers in the file ("
								+ totalNumbers + ") is not divisible by "
								+ TOTAL_COLUMNS);
			}

			else {

				// Set up vehicleList to contain the required number of rows and
				// columns
				vehicleList = new int[totalNumbers / TOTAL_COLUMNS][TOTAL_COLUMNS];

				// Reset file input
				frs = new java.io.FileReader(path);
				in = new java.io.StreamTokenizer(frs);
				int row = 0;
				int col = 0;

				// Read totalNumbers into operationList
				while (in.ttype != java.io.StreamTokenizer.TT_EOF) {

					// Add value to operationList if number
					if (in.ttype == java.io.StreamTokenizer.TT_NUMBER) {

						// Store value in vehicleList
						vehicleList[row][col] = (int) (in.nval);

						// Advance column
						col++;

						// Advance row and reset column if end of column reached
						if (col > TOTAL_COLUMNS - 1) {
							col = 0;
							row++;
						}
					}

					// Get next token from file
					in.nextToken();
				}
			}

		} catch (java.io.FileNotFoundException ex) {
			System.out.println("File not found: " + path);
		} catch (java.io.IOException ex) {
			System.out.println(ex.getMessage());
		}
		// Regardless of whether an exception occurs, attempt to close the input
		// file
		finally {
			try {
				if (frs != null) {
					frs.close();
				}
			} catch (java.io.IOException ex) {
				System.out.println(ex);
			}
		}
	}

	/**
	 * Calculate cost of all MC lanes per hour
	 * 
	 * @return cost MC lanes per hour = staffCostPerHour * total MC lanes
	 */
	int costPerHourMCLanes() {
		return staffCostPerHour * totalLanes[MC];
	}

	/**
	 * Calculate cost of all AC lanes per hour
	 * 
	 * @return cost AC lanes per hour = acMachineCostPerHour * total AC lanes
	 */
	int costPerHourACLanes() {
		return acMachineCostPerHour * totalLanes[AC];
	}

	/**
	 * Calculate cost of all ET lanes per hour
	 * 
	 * @return cost ET lanes per hour = etMachineCostPerHour * total ET lanes
	 */
	int costPerHourETLanes() {
		return etMachineCostPerHour * totalLanes[ET];
	}

	/**
	 * Time processing of each lane type
	 * 
	 * @param laneType
	 * @return time processing per vehicle for each lane type = vehicle time
	 *         processing per lane / total of lanes of each type
	 */
	int processingTimePerVehicle(int laneType) {
		return vehicleTimeProcessingRequirement[laneType]
				/ totalLanes[laneType];
	}

	/**
	 * Sort out and count the number of vehicle for each type of vehicle in
	 * traffic.txt
	 * 
	 * @param vehicleType
	 * @return Number of vehicle counted
	 */
	long vehicleInList(int vehicleType) {
		long count = 0;
		// if vehicle type = V1 then count all motobike vehicle
		if (vehicleType == V1) {
			for (int i = 0; i < vehicleList.length; i++) {
				if (vehicleList[i][VEHICLE_TYPE] == MOTOBIKE)
					count++;
			}
		// if vehicle type = V2 then count car or truck with 2 axles, no trailer 
		} else if (vehicleType == V2) {
			for (int i = 0; i < vehicleList.length; i++) {
				if ((vehicleList[i][VEHICLE_TYPE] == CAR)
						|| ((vehicleList[i][VEHICLE_TYPE] == TRUCK)
								&& (vehicleList[i][NUMBER_AXLES] <= 2) && (vehicleList[i][NUMBER_TRAILER] == 0))) {
					count++;
				}
			}
		// if vehicle type = V3 then count truck with more than 2 axles or truck with at least 1 trailer
		} else if (vehicleType == V3) {
			for (int i = 0; i < vehicleList.length; i++) {
				if (((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] == 2) && (vehicleList[i][NUMBER_TRAILER] > 0))
						|| ((vehicleList[i][VEHICLE_TYPE] == TRUCK) && (vehicleList[i][NUMBER_AXLES] > 3))) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Count all the vehicles in traffic.txt
	 * 
	 * @return total vehicle counted
	 */
	long vehicleInList() {
		long count = 0;
		for (int i = 0; i < vehicleList.length; i++) {
			count++;
		}
		return count;
	}

	/**
	 * Count number of vehicles in specified type that can access specified lane
	 * type in the parameter
	 * 
	 * @param vehicleType
	 * @param laneType
	 * @return
	 */
	long vehicleInLaneType(int vehicleType, int laneType) {
		long count = 0;
		// vehicle V1 and Manual Cash Lane
		if ((vehicleType == V1) && (laneType == MC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				// Count if there is a motobike with cash GREATER than specified
				// V1 price
				if ((vehicleList[i][VEHICLE_TYPE] == MOTOBIKE)
						&& (vehicleList[i][CASH] > vehiclePrice[V1]))
					count++;
			}
		}
		// vehicle V2 and Auto Cash Lane
		else if ((vehicleType == V2) && (laneType == MC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				// Count if there is a car or a truck with 2 axles and no
				// trailer, with cash GREATER than V2 price specified
				if (((vehicleList[i][VEHICLE_TYPE] == CAR) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] <= 2) && (vehicleList[i][NUMBER_TRAILER] == 0)))
						&& (vehicleList[i][CASH] > vehiclePrice[V2]))
					count++;
			}
		}
		// vehicle V3 and E-toll Lane
		else if ((vehicleType == V3) && (laneType == MC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				// Count if there is a truck with 2 axles and more than 1
				// trailer or a truck with more than 2 axles, with cash GREATER
				// than V3 price specified
				if ((((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] == 2) && (vehicleList[i][NUMBER_TRAILER] > 0)) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK) && (vehicleList[i][NUMBER_AXLES] > 2)))
						&& (vehicleList[i][CASH] > vehiclePrice[V3])) {
					count++;
				}
			}
		}
		// Vehicle V1 and Auto Cash Lane
		if ((vehicleType == V1) && (laneType == AC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if ((vehicleList[i][VEHICLE_TYPE] == MOTOBIKE)
						&& (vehicleList[i][CASH] == vehiclePrice[V1]))
					count++;
			}
		}
		// vehicle V2 and Auto Cash Lane
		else if ((vehicleType == V2) && (laneType == AC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if (((vehicleList[i][VEHICLE_TYPE] == CAR) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] <= 2) && (vehicleList[i][NUMBER_TRAILER] == 0)))
						&& (vehicleList[i][CASH] == vehiclePrice[V2]))
					count++;
			}
		}
		// vehicle V3 and Auto Cash Lane
		else if ((vehicleType == V3) && (laneType == AC)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if ((((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] == 2) && (vehicleList[i][NUMBER_TRAILER] > 0)) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK) && (vehicleList[i][NUMBER_AXLES] > 2)))
						&& (vehicleList[i][CASH] == vehiclePrice[V3])) {
					count++;
				}
			}
		}
		// vehicle V1 and E-toll Lane
		if ((vehicleType == V1) && (laneType == ET)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if ((vehicleList[i][VEHICLE_TYPE] == MOTOBIKE)
						&& (vehicleList[i][CASH] == -1))
					count++;
			}
		}
		// vehicle V2 and E-toll Lane
		else if ((vehicleType == V2) && (laneType == ET)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if (((vehicleList[i][VEHICLE_TYPE] == CAR) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] <= 2) && (vehicleList[i][NUMBER_TRAILER] == 0)))
						&& (vehicleList[i][CASH] == -1))
					count++;
			}
		}
		// vehicle V3 and E-toll Lane
		else if ((vehicleType == V3) && (laneType == ET)) {
			for (int i = 0; i < vehicleList.length; i++) {
				if ((((vehicleList[i][VEHICLE_TYPE] == TRUCK)
						&& (vehicleList[i][NUMBER_AXLES] == 2) && (vehicleList[i][NUMBER_TRAILER] > 0)) || ((vehicleList[i][VEHICLE_TYPE] == TRUCK) && (vehicleList[i][NUMBER_AXLES] > 2)))
						&& (vehicleList[i][CASH] == -1)) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * If deniedAcess is false then returns the total number of vehicles using
	 * either MC, AC or ET lanes (ie the total number of vehicles that were not
	 * denied access), calculated above using vehiclesInLaneType. Otherwise
	 * works in the same way except that the total number of vehicles that were
	 * denied access, calculated above using vehiclesInLaneType, is returned
	 * 
	 * @param deniedAccess
	 * @return total number vehicle can access the lanes or total number denied
	 *         to access the lanes
	 */
	long vehicleInLaneType(boolean deniedAccess) {
		long count = 0;
		long totalVehicleAccess = vehicleInLaneType(V1, MC)
				+ vehicleInLaneType(V2, MC) + vehicleInLaneType(V3, MC)
				+ vehicleInLaneType(V1, AC) + vehicleInLaneType(V2, AC)
				+ vehicleInLaneType(V3, AC) + vehicleInLaneType(V1, ET)
				+ vehicleInLaneType(V2, ET) + vehicleInLaneType(V3, ET);
		if (deniedAccess == false) {
			count = totalVehicleAccess;
		} else if (deniedAccess == true) {
			count = vehicleInList() - totalVehicleAccess;
		}
		return count;

	}
	

	/**
	 * The time taken for each lane type is the time calculated per vehicle
	 * (from processingTimePerVehicle) multiplied by the number of vehicles
	 * using the lane (from vehiclesInLaneType).
	 * 
	 * @param laneType
	 * @return The total time taken to process all vehicles (in seconds) in the
	 *         lane type specified by laneType
	 */
	long processingTimePerLaneType(int laneType) {
		long totalVehicleInLaneType = 0;
		totalVehicleInLaneType = vehicleInLaneType(V1, laneType)
				+ vehicleInLaneType(V2, laneType)
				+ vehicleInLaneType(V3, laneType);
		long processingTimePerLaneType = totalVehicleInLaneType
				* processingTimePerVehicle(laneType);
		return processingTimePerLaneType;
	}

	/**
	 * The sum of the times from processingTimePerLaneType
	 * 
	 * @return Total time taken to process all vehicles (in seconds) across all
	 *         lane types
	 */
	long processingTimePerLaneType() {
		long totalTimeProcessing = processingTimePerLaneType(MC)
				+ processingTimePerLaneType(AC) + processingTimePerLaneType(ET);
		return totalTimeProcessing;
	}

	/**
	 * For each lane type, this is calculated by determining the number of
	 * vehicles of each type (V1/V2/V3), using vehiclesInLaneType, and
	 * multiplying this by the price per vehicle of each type, using
	 * vehiclePrices.
	 * 
	 * @param laneType
	 * @return The total revenue gained (in cents) for the lanes specified by
	 *         laneType
	 */
	long revenuePerLaneType(int laneType) {
		long revenuePerLane = 0;
		revenuePerLane = vehiclePrice[V1] * vehicleInLaneType(V1, laneType)
				+ vehiclePrice[V2] * vehicleInLaneType(V2, laneType)
				+ vehiclePrice[V3] * vehicleInLaneType(V3, laneType);
		return revenuePerLane;
	}

	/**
	 * The sum of the revenues from revenuePerLaneType
	 * 
	 * @return The total revenue gained (in cents) for all lane types (MC, AC
	 *         and ET).
	 */
	long revenuePerLaneType() {
		long totalRevenue;
		totalRevenue = revenuePerLaneType(MC) + revenuePerLaneType(AC)
				+ revenuePerLaneType(ET);
		return totalRevenue;
	}

	/**
	 * The running cost for each lane type is the cost per hour of running the
	 * lanes of that type (calculated using costPerHourMC/AC/ETLanes),
	 * multiplied by the total time in hours required to process all vehicles in
	 * that lane type (calculated using processingTimePerLaneType).
	 * 
	 * @param laneType
	 * @return The total cost (in cents) of running the lanes specified by
	 *         laneType
	 */
	final int SECONDS_PER_HOUR = 3600;
	long costPerLaneType(int laneType) {
		long costPerLaneType = 0;
		if (laneType == MC) {
			costPerLaneType = costPerHourMCLanes()
					* processingTimePerLaneType(laneType) / SECONDS_PER_HOUR;
		} else if (laneType == AC) {
			costPerLaneType = costPerHourACLanes()
					* processingTimePerLaneType(laneType) / SECONDS_PER_HOUR;
		} else if (laneType == ET) {
			costPerLaneType = costPerHourETLanes()
					* processingTimePerLaneType(laneType) / SECONDS_PER_HOUR;
		}
		return costPerLaneType;
	}

	/**
	 * The sum of the costs from costPerLaneType
	 * 
	 * @return The total cost (in cents) of running all lane types
	 */
	long costPerLaneType() {
		long totalCost = 0;
		totalCost = costPerLaneType(MC) + costPerLaneType(AC)
				+ costPerLaneType(ET);
		return totalCost;
	}

	/**
	 * The net income for each lane type is the total revenue for lanes of that
	 * type (calculated using revenuePerLaneType), minus the total cost of
	 * running lanes of that type (calculated using costPerLaneType).
	 * 
	 * @param laneType
	 * @return The net income (in cents) from running the lanes specified by
	 *         laneType (MC, AC or ET)
	 */
	long netIncomePerLaneType(int laneType) {
		long netIncomePerLaneType = revenuePerLaneType(laneType)
				- costPerLaneType(laneType);
		return netIncomePerLaneType;
	}

	/**
	 * The sum of the incomes from netIncomePerLaneType.
	 * 
	 * @return The total net income (in cents) from running all lanes (MC, AC
	 *         and ET)
	 */
	long netIncomePerLaneType() {
		long totalNetIncome = netIncomePerLaneType(MC)
				+ netIncomePerLaneType(AC) + netIncomePerLaneType(ET);
		return totalNetIncome;
	}
}
