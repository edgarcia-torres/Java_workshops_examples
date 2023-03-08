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

import java.io.IOException;
public class testShapes {
	

	public static void main(String[] args) {
		
		/**Construct a trapezoid with the specified sides */
		//instantiate two circles
		Streaming file1 = new Streaming();
		Shape a = null; 
		Shape b = null ; 
		
		
		boolean keep = true;
		while(keep) {
			
			String menu[] = {"Create circle", "Create Trapezoide", "LOAD", "SAVE", "   END PROGRAM"};
			int option = Util.menu(5, menu, "MAIN MENU");
			switch (option) {
			case 1://create circle 

					a = new Circle();
					Util.displayMsg("circle created");

				break;
			case 2://create trapezoid 

					b =new Trapezoid();
					Util.displayMsg("Trapezoid created");
	
				break;
			case 3:// LOAD 
				try {
					file1.retrieveObject();
				} catch (ClassNotFoundException e1) {
					Util.displayMsg("Error in retrieve");
					e1.printStackTrace();
				} catch (IOException e1) {
					Util.displayMsg("Error in retrieve");
					e1.printStackTrace();
				}
				break;
			case 4:// SAVE
				try {
					file1.addObject(a,b);				
				} catch (IOException e) {
					Util.displayMsg("Error in save");
					e.printStackTrace();
				}catch(NullPointerException e) {
					Util.displayMsg("Please create both objects Circle and Trapezoid before saving");
				}
				break;
			case 5: // END
				keep = false;
				break;
			default: 
				Util.displayMsg("Error in main menu");
				break;
			
			
			} 
			
		}



	}

}
