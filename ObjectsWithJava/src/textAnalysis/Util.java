/**********************************************
Workshop #5
Course:JAC444 - Semester4
Last Name:Garcia Torres
First Name:Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:10/07/2022
**********************************************/

package textAnalysis;

import java.util.Scanner;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
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
	 
	public int menu(int numberOptions, String[] Options, String tittle ) {
		int response = 0;
				 
		Util.displayMsg("**************" + tittle + "******************");
		for (int i = 0; i < numberOptions; i++ ) {
			 Util.displayMsg((i+1)+"* "+ Options[i]); 
		}
		Util.displayMsg("**********************************************");
	    boolean resolved  = false;
			while(!resolved) {
			response = Util.getInteger();
						//displayMsg("ENTERED" + response);
			if(response >=1 && response <=numberOptions) {
				resolved = true;
			}else {
				Util.displayMsg("   ERROR: select option between 1 and "+numberOptions);
			}
		}
			 return response;
			 
	} 

}
