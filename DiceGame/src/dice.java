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
public class dice {

	int diceResult = 0; 
	boolean rolled = false;
	static int minvalue = 1; 
	static int maxvalue = 6; 
	
	
	public void rollDice() {
	      diceResult  = (int)Math.floor(Math.random()*(maxvalue-minvalue+1)+minvalue);
	}
	
	public int getdiceResult() {
		return this.diceResult;
	}
	
	
	
}
