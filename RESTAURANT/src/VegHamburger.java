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
public class VegHamburger extends Hamburger{
	
	final Double cost = 9.0;


	public VegHamburger() { // CONSTRUCTOR 
		price = price + cost;

	}

	public Double getPrice() {
		return this.price;
	}
	
	public void DisplayDetails() {
		Utilities.displayMsg("-------------  VEGETARIAN BURGER ---------------");
		Utilities.displayMsg("Burger price         : " + cost );
        commonDetails();
	}
	
	

}


