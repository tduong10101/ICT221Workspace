package reWrite_1;
import java.util.Scanner;
public class VehicleListArrayTest {
	public static void main (String arg[]){
//		 Create list of vehicle
		final int V1 = 0;
		final int V2 = 1;
		final int V3 = 2;
		Scanner input = new Scanner(System.in);
		System.out.println("Input number of Vehicle");
		int numberOfVehicle =  input.nextInt();
		int [][]vehicleList = new int [numberOfVehicle][4];
		
		for (int i=0 ;i < numberOfVehicle;i++){
			do{
				System.out.println ("Vehicle number "+(i+1)+"\nInput vehicle type\n" +
						"1-Motobike\n" +
						"2-Car\n" +
						"3-Truck");
				vehicleList [i][0]= input.nextInt();
				if ((vehicleList [i][0]<1)||(vehicleList [i][0]>3)){
					System.out.println ("Invalid input!");
				}
			}while ((vehicleList [i][0]<1)||(vehicleList [i][0]>3));
			System.out.println ("Input number of axle(s)");
			vehicleList [i][1]= input.nextInt();
			System.out.println ("Input number of trail(s)");
			vehicleList [i][2]= input.nextInt();
			System.out.println ("Input Cashes in cents");
			vehicleList [i][3]= input.nextInt();
		}
		int getnumberofvehicle = getnumberofvehicle(V2,vehicleList);
		System.out.println (getnumberofvehicle);
		for (int i=0 ;i < numberOfVehicle;i++){
			//V1 type
			if ((vehicleList[i][0] == 1)||(vehicleList[i][0] == 2)){
				int numberOfV1 =+1;
			}
			if (vehicleList[i][0] == 2){
				int numberOfV2 =+1;
			}
			if (vehicleList[i][0] == 3){
				int numberOfV3 =+1;
			}
		}
	}
	public static int getnumberofvehicle(int vehicleType, int[][] vehicleList){
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
		int count = 0;
		if (vehicleType==MOTOBIKE){
			
			
			for (int i=0; i<vehicleList.length;i++){
				
				if (vehicleList[i][0]==MOTOBIKE+1){
					
				count++;
				}
			}
		}
		else if (vehicleType==CAR){
			for (int i=0; i<vehicleList.length;i++){
				if ((vehicleList[i][0]==CAR+1)||((vehicleList[1][i]==2)&&(vehicleList[2][i]==0))){
				count++;
				}
			}
		}
		else if (vehicleType==TRUCK){
			count++;
		}
		return count;
	}
}
