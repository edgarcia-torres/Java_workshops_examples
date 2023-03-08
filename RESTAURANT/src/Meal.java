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
public class Meal implements Interface{
	
	Hamburger Hamb = null;
	MealExtraComponent Drin = null;
	MealExtraComponent Fri  = null;
	
	Double price = 0.0;
	String customerName = "";
	int customerID = 0;
	
	void hamburgerMenu() {
		String [] options  = {"Chiken burguer", "Vegetarian burger"};
		int action = menu(2, options, "SELECT YOUR TYPE OF BURGER");
		switch(action) {
		case 1:
			Hamb = new ChickenHamburger();
			break;
		case 2:
			Hamb = new VegHamburger();
			break;
		}
	}
	
	public Meal() { // CREATE MEAL 
		boolean resolved = false;
		
		while(!resolved) {
			
			String [] options  = {"Add Burger", "Add Cold Drink","Add Fries","CONFIRM ORDER ","           Cancel"};
			
			int action = menu(5, options, "CREATE MEAL MENU");
			boolean keepGoing = true;
			switch(action) {
			case 1:
				hamburgerMenu();
				break;
			case 2:
				Drin = new Drink();
				break;
			case 3:
				Fri = new Fries();
				break;
			case 4:
				keepGoing = false;
				resolved  = true;
				break;
			case 5:
				keepGoing = false;
				resolved  = true;
				Utilities.displayMsg(">>>> You have canceled your order  have a nice day <<<");
				Hamb = null; Drin = null; Fri = null; 
				break;
			}
			
			if (keepGoing) {
				if (Hamb == null) Utilities.displayMsg("You have not added HAMBURGER");
				if (Drin == null) Utilities.displayMsg("You have not added DRINK");
				if (Fri == null)  Utilities.displayMsg("You have not added FRIES");
			}
		}
		if (Hamb != null || Drin != null || Fri != null  ) {
			setCustomer();
			Utilities.displayMsg("Order generated successfully");
			updatePrice(Hamb, Drin, Fri);
			this.DisplayDetails();
		}
		
		
		
	}
	
	public void DisplayDetails() {
		Utilities.displayMsg("\n************** DETAILS OF THIS ORDER ***********");
		                        
		if (Hamb != null) {
			Hamb.DisplayDetails();
		}
		if (Drin != null) {
			

			Drin.DisplayDetails();
		}
		if (Fri != null) {
			
			Fri.DisplayDetails();
		}
		
		Utilities.displayMsg("Customers name             : " + customerName);
		Utilities.displayMsg("Customer Id                : " + customerID);
		Utilities.displayMsg("TOTAL PRICE                : " + price);
		

		Utilities.displayMsg("************************************************\n");

	}
	void sum(double value) {
		
	}
	
	void updatePrice(Hamburger h, MealExtraComponent d, MealExtraComponent f) {
		if (Hamb != null) 	price = Hamb.getPrice();
		if (Drin != null) 	price = price + Drin.getPrice();
		if (Fri != null) 	price = price + Fri.getPrice();
	}
	void setCustomer() {
		Utilities.displayMsg("***********     ENTER CUSTOMER NAME     ********");
		customerName = Utilities.getString();
		Utilities.displayMsg("***********      ENTER CUSTOMER ID   ***********");
		customerID = Utilities.getInteger();
	}
	
}
