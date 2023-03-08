/**********************************************
Workshop #3
Course:JAC444 - Semester4
Last Name:Garcia Torres
First Name:Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:19/06=2022
**********************************************/
import java.util.Scanner;


public final class Utilities {

	public Utilities() {//constructor
	}
	
	public static int getInteger() {
		Scanner input = new Scanner(System.in);
		int response = 0;
		boolean resolved = false;
		while(!resolved) {
			try {		
				String res  = input.next();
				response = Integer.valueOf(res);
				resolved = true;
			}catch(NumberFormatException e){
				displayMsg("  Error you did not enter an integer >>> TRY AGAIN ");
			};	
		}
		return response;
	}
	
	
	public static void displayMsg(String msg) {
			System.out.println(msg);
	}

	 public static String getString() {
		Scanner scan = new Scanner(System.in).useDelimiter("\n");
		String input = scan.next();
		return input;
	 }
	  
	 
}
