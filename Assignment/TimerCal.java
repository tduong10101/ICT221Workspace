import java.util.Scanner;
public class TimerCal {
	public static void main (String[] a){
		// Define input in this Timerinput part
		Scanner input = new Scanner(System.in);
		int timeManual = 0;
		int timeAuto = 0;
		int timeEToll = 0;
		int booleanAnwser = 0;
		do { 
			do {
				do {
				// Ask user to input Timer for manual Cash
					System.out.println ("Timer for Manual Cash lane (s)");
					timeManual = input.nextInt ();
					// Timer for manual cash must not be greater than 60 or less than 20
					if ((timeManual < 20) || (timeManual > 60)){
						System.out.println ("Error! Time taken for 1 vehicle to be processed in an Manual Cash lane must be \n"
						+"between 20 and 60 seconds \n"+"Please enter the value again");
					}
				} while ((timeManual < 20) || (timeManual > 60)); // keep asking timer for manual cash lane when it greater than 60 or 20 second
				do {
					do {
					// Get Timer for auto cash lane from user
						System.out.println ("Timer for Auto Cash lane");
						timeAuto = input.nextInt ();
						// timer for auto lane must not be greater than 30 or less than 3
						if ((timeAuto < 3)||(timeAuto > 30)) {
							System.out.println ("Error! Time taken for 1 vehicle to be processed in an Auto Cash lane must be \n"
							+"between 3 and 30 seconds \n"+"Please enter the value again");
						}
					} while ((timeAuto < 3)||(timeAuto > 30)); // keep asking for timer of auto lane while it greater than 30 or less than 3 
					// set booleanAnwser equal to 0 so "do {...} while (boolean == 2)" not repeat when user has enter the right value
					booleanAnwser = 0;
					// if timeAuto taking longer than timeManual than print out error and ask for input again
					if (timeManual < timeAuto) { 
						System.out.println ("Error! Time taken for 1 vehicle to be processed in an Manual Cash lane must not be"
						+"less than or equal to time taken in an Auto Cash lane \n");
						// Ask wheither user want to fix the whole input value or just want to fix time of Auto cash		
						do {
							System.out.println ("Enter 1 to input Time for Manual Cash and Time for Auto Cash again\n"
												+"Enter 2 to input Time for Auto Cash again");
							booleanAnwser = input.nextInt();
						} while (!((booleanAnwser==1)||(booleanAnwser==2))); // keep ask for input if user enter the wrong number		
					}
					// print out current value that user have enter
						System.out.println ("Your current timer for Manual Cash lane is " + timeManual + " (s) \n" + 
											"Your current timer for Auto Cash lane is " + timeAuto + " (s) \n" 
											+ "Your current timer for E-toll lane is " + timeEToll + " (s)");
				} while (booleanAnwser == 2); // Start asking for timer of auto cash again while user choose to input timer 
											   //for Auto cash again as booleanAnwser equal to 2
			} while (timeManual < timeAuto); // Keep asking for time of Manual and Auto cash lane while user have choose to enter them again
				do {
					// Get input of timer taken for E-toll lane
					do {
						System.out.println ("Timer for E-toll lane:");
						timeEToll = input.nextInt ();
						// print out erorr and keep asking for input when timer of E-toll is less than 1 or greater than 5
						if ((timeEToll < 1)||(timeEToll > 5)) {
							System.out.println ("Error! Time taken for 1 vehicle to be processed in an E-toll lane must be \n"
							+"between 1 and 5 seconds \n");
						}
					} while ((timeEToll < 1)||(timeEToll > 5));
					// set booleanAnwser equal to 0 so "do {...} while (boolean == 2)" not repeat when user has enter the right value
					booleanAnwser = 0;
					// print out error when timeEtoll taken longer than timeAuto
					if (timeAuto < timeEToll) {
						System.out.println ("Error! Time taken for 1 vehicle to be processed in an Auto Cash lane must not be \n"
						+"less than or equal to time taken in an E-toll lane \n"+"Please enter the value again \n");
						// Ask wheither user want to fix the whole input value or just want to fix time of Auto cash		
						do {
							System.out.println ("Enter 1 to input Timer for Manual Cash, Auto Cash and E-toll again\n"
												+"Enter 2 to input Timer for E-toll again");
							booleanAnwser = input.nextInt();
						} while (!((booleanAnwser==1)||(booleanAnwser==2)));
					}
				} while (booleanAnwser == 2);// Start asking for timer of e-toll again while user have choosen to input timer 
											   //for e-toll again as booleanAnwser equal to 2
			// print out current value that user have enter
			System.out.println ("Your current timer for Manual Cash lane is " + timeManual + " (s) \n" + 
								"Your current timer for Auto Cash lane is " + timeAuto + " (s) \n" 
								+ "Your current timer for E-toll lane is " + timeEToll + " (s)");
		} while (timeAuto < timeEToll); // Keep asking for time of Manual, Auto cash and E-toll lane while user have choose to enter them again
	}
}