package tut8;

import java.util.Scanner;
public class tut8exercise {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // input
        // security code, account number array
        int[][] code = {
                {786411,54},
                {552909,932},
                {641608,1408}
        };
        System.out.println ("Input code:");
        // new security code
        int newCode = input.nextInt();
        String booleanStatement = "1";
        // check if new security code is match with security code
        // if new security code is 10 above or below security code than print out
        // boolean statement = account number
        for (int i=0; i<3; i++){
            if ((code[i][1]-newCode>=-10)&&(code[i][1]-newCode<=10)){
                // set boolean statement  = "Account number:"+code[i][0];
                booleanStatement ="Account number:"+code[i][0];
                System.out.println (booleanStatement);
            }
        }
        // if booleanStatement haven't  change then print out Wrong security number
        if (booleanStatement == "1"){
            System.out.println ("Wrong sercurity number!");
        }
        
    }

}
