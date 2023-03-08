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
public abstract class Hamburger implements Interface{
	protected int numPattys = 1;
	protected String Package = "Wrap";
	protected boolean Mayo = false;
	protected boolean Salad = false;
	protected boolean Tomatoes = false;
	protected boolean Onions = false;
	protected boolean hotSauce = false;
	protected double price = 0.0;
	protected double totalToppings = 0.0;


	public Hamburger() {
		price = price + numPattys*2;   //PRICE PER PATTY IS $2
		boolean DONE = false;
		while(!DONE) {
			String[] options  = {"Add Mayo", "Add Salad", "Add Tomatoes", "Add Onions","Add Hot sauce", "Change number of patties ","  DONE", };
			int option  = menu(7, options, "Select your hamburger toppings $0.8 each");
			if (option == 1) {Mayo = true; price +=0.8; totalToppings+=0.8;}
			if (option == 2) {Salad = true;price +=0.8; totalToppings+=0.8;}
			if (option == 3) {Tomatoes = true; price +=0.8;totalToppings+=0.8;}
			if (option == 4) {Onions = true; price +=0.8;totalToppings+=0.8;}
			if (option == 5) {hotSauce = true; price +=0.8;totalToppings+=0.8;}
			if (option == 6) {
				Utilities.displayMsg("*** How many patties in your burger? $2 each ***");

				numPattys = Utilities.getInteger();
				
			}
			if (option == 7) DONE = true;	
		}

	}
	public abstract void DisplayDetails();
	
	public void commonDetails(){
		Utilities.displayMsg("* NUMBER OF PATTIES: "+ numPattys);
		Utilities.displayMsg("Patties price        : "+(numPattys*2));
		if (Mayo || Salad || Tomatoes || Onions || hotSauce) {
			Utilities.displayMsg("* YOUR TOPPINGS: ");
			if (Mayo)Utilities.displayMsg(" > Mayo");
			if (Salad)Utilities.displayMsg(" > Salad");
			if (Tomatoes)Utilities.displayMsg(" > Tomatoes");
			if (Onions)Utilities.displayMsg(" > Onions");
			if (hotSauce)Utilities.displayMsg(" > hotSauce");
			Utilities.displayMsg("Toppings price       : " + totalToppings);
			
		}else {
			Utilities.displayMsg("* NO TOPPINGS: ");
		}
	
	}
	public abstract Double getPrice();
	
	public Hamburger createHamburger() {
		Hamburger newHam = null;
		String[] options  = {"Vegie Hamburger", "Chicken Hamburger"};
		int option  = menu(2, options, "Add hamburger menu");
		if (option == 1 ) {
			newHam = new VegHamburger();
		}
		if (option ==2) {
			newHam = new ChickenHamburger();
		}
		return newHam;
		
	}

}
