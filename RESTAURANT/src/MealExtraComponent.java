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
public abstract class MealExtraComponent implements Interface{
	protected String Package;
	protected Double price ;
	protected String typeOfComponent;
	

	public MealExtraComponent() {
		Package = "";
		price = 0.0;
		typeOfComponent ="";	
	}
	
	public abstract Double getPrice();

}
