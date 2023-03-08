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
public interface Interface {
		
	default int menu(int numberOptions, String[] Options, String tittle ) {
		 int response = 0;
			 
			 Utilities.displayMsg("**************" + tittle + "******************");
			 for (int i = 0; i < numberOptions; i++ ) {
				 Utilities.displayMsg((i+1)+"* "+ Options[i]); 
			 }
			 Utilities.displayMsg("**********************************************");
				boolean resolved  = false;
				while(!resolved) {
				response = Utilities.getInteger();
				//displayMsg("ENTERED" + response);
				if(response >=1 && response <=numberOptions) {
					resolved = true;
				}else {
					Utilities.displayMsg("   ERROR: select option between 1 and "+numberOptions);
				}
			}
		 return response;
		 
	 } 
	
	
	public void DisplayDetails();

}
