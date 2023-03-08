/**********************************************
Workshop #1
Course:JAC444 - 4 Semester
Last Name:Garcia Torres
First Name: Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Edgar Garcia
Date:28/05/2022
**********************************************/

package creditApp;
import java.util.Scanner;

public class CreditCalcAppMain {
	
	public static void main(String[] args) {
		System.out.println("       WELCOME! Lets calculate credit spent by customers.\n \n Please enter the client's information as required.\n ");
		boolean keep = true; 
		int expression  = 0;
		boolean entercustomer = true;
				
		Scanner input = new Scanner(System.in);
		
		while(entercustomer) {
			expression  = 0;
			customer C1 = new customer();
		
		while(keep) {
			System.out.println("\n*************    MENU    *************");
			System.out.println("*  1. Calculate Balance              *");
			System.out.println("*  2. Display Details                *");
			System.out.println("*  3. Exit                           *");
			System.out.println("**************************************");

			String response  = input.next();
			expression  = Integer.valueOf(response);
			
			switch(expression) {
			  case 1:
					//Calculate new balance
					C1.calculateNewBalance();
			    break;
			  case 2:
					//Display new balance information
					C1.displayNeewBalance();
					//Display if the credit limit is exceeded

			    break;
			  case 3:
				  keep = false;
				    break;
			  default:
				  System.out.println("     Enter only 1,2 or 3. \n");
			}
		}
		System.out.println("Do you want to enter another customer?\n Enter yes or no");
		String response  = input.next();
			if(response.equals("yes")|| response.equals("Yes") ||response.equals("YES") || response.equals(" yes")||response.equals("yes ") ) {
				entercustomer = true;
				keep = true;
			}else {
				entercustomer = false;
			}
		} 
		System.out.println("\n     THIS IS THE END OF THE PROGRAM!! Have  nice day. ");
	}
}



