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
public class Fries extends MealExtraComponent{
	
	public Fries() {
		Package = "Paper Container";
		String [] options2  = {"Curly $4", "Straight $3" };
		int action1 = menu(2, options2, "SELECT YOUR TYPE OF FRIES");
		switch(action1) {
		case 1:
			typeOfComponent ="Curly";
			price += 4;
			break;
		case 2:
			typeOfComponent ="Straight";
			price += 3;
			break;
		}
		Utilities.displayMsg("*** Your fries: " + typeOfComponent + "****************");
	}
	
	
	public Double getPrice() {
		
		return this.price;
	}
	
	public void DisplayDetails() {
		Utilities.displayMsg("----------------- FRIES ------------------------");
		Utilities.displayMsg("* PACKAGE: " + Package);
		Utilities.displayMsg("* TYPE OF FRIES: " + typeOfComponent);
		Utilities.displayMsg("Fries price          : " + price);
	}
	
}
