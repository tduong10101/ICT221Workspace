import java.util.Scanner;
public class machineLane {
	public static void main (String[] a){
		/*Machine Cost pseudocode
		Input
		lane number for manual cash
						auto cash
						E-toll
		Process
		sort number manual cash <4 and greater than 0
					auto cash
					E-toll
		Total number of lane have to be less than 8
		
		*/
		int manualLane = 0;
		int autoLane = 0;
		int eTollLane = 0;
		int totalLane = 0;
		do {
			manualLane = numberLane ("Manual");
			autoLane = numberLane ("Auto");
			eTollLane = numberLane ("E-toll");
			totalLane = manualLane + autoLane + eTollLane;
			System.out.println ("Current input\n"
								+"Manual lane: "+manualLane+"\n"
								+"Auto lane: "+autoLane+"\n"
								+"E-toll lane: "+eTollLane+"\n"
								+"Total lane: "+totalLane);
			if (totalLane > 8){
				System.out.println ("Total number lane must not be greater than 8/n" +
						"Please input the value again");
			}
		} while (totalLane > 8);
	}
	public static int numberLane (String laneType){
		int numberLane = 0; 
		do {
			System.out.println ("Number of "+laneType+" lane:");
			Scanner input = new Scanner(System.in);
			numberLane = input.nextInt();
			if (numberLane > 4){
				System.out.println ("Number of "+laneType+" lanes must be less than 4");
			}
			else if (numberLane < 1){
				System.out.println ("Number of "+laneType+" lanes must be greater than 0");
			}
		} while ((numberLane >4)||(numberLane<1));
		return numberLane;
	}
}