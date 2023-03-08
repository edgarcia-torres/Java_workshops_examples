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

public class Drink extends MealExtraComponent{
	
	String temperature = ""; 
	
	public Drink() {//constructor
		Package = "bottle";
		price = 2.5;
		String [] options  = {"Soda Pop", "Ice Tea","Natural juice", "Watter" };
		int action = menu(4, options, "SELECT YOUR TYPE OF DRINK");
		switch(action) {
		case 1:
			typeOfComponent ="Soda Pop";
			break;
		case 2:
			typeOfComponent ="Ice Tea";
			break;
		case 3:
			typeOfComponent ="Natural juice";
			break;
		case 4:
			typeOfComponent ="Watter";
			break;
		}
		
		String [] options2  = {"Cold", "room temperature" };
		int action1 = menu(2, options2, "SELECT YOUR TYPE OF DRINK");
		switch(action1) {
		case 1:
			temperature = "Cold"; 
			break;
		case 2:
			temperature = "room temperature"; 
			break;
		}
		Utilities.displayMsg("***** Your drink: " +typeOfComponent +" "+temperature+ "********");
		
	}

	public Double getPrice() {
		
		return this.price;
	}
	
	public void  DisplayDetails() {
		Utilities.displayMsg("----------------- DRINK ------------------------");
		Utilities.displayMsg("* TEMPERATURE: " +temperature);
		Utilities.displayMsg("* PACKAGE: " +Package);
		Utilities.displayMsg("* TYPE OF DRINK: " +typeOfComponent);
		Utilities.displayMsg("Drink price          : " + price);

	}

}
