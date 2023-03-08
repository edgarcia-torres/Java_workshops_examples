/**********************************************
Workshop # 2
Course:JAC444 - Semester 4
Last Name:Garcia Torres
First Name:Edgar David
ID:104433206
Section: jac 4444
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:12/06/2022
**********************************************/

package eventManager;
import java.util.Scanner;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;
import java.time.LocalDate;

public class global {
	public static int numTickets;
	public static int maxNumCustomers;
	public static int customersAdded = 0;
	public static int ticketsAdded = 0;
	public static int salesCount = 0;
	
	
	
	
	public void setNumTickets(int numTick) {
		numTickets  = numTick;
	}
	public void setMaxCustomer(int maxCustomer) {
		maxNumCustomers  = maxCustomer;
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
	public static double getDouble() {
		Scanner input = new Scanner(System.in);
		double response = 0;
		boolean resolved = false;
		while(!resolved) {
			try {		
				String res  = input.next();
				response = Double.parseDouble(res);
				resolved = true;
			}catch(NumberFormatException e){
				displayMsg("  Error you did not enter a quantity >>> TRY AGAIN ");
			};	
		}
		return response;
	}
	
	 public static String getString() {
		 Scanner scan = new Scanner(System.in).useDelimiter("\n");
		 String input = scan.next();
		 return input;
	 }
	 public static LocalDate getDate(){
		 Scanner input = new Scanner(System.in);
		 boolean resolved = false;
		 //Date date = new Date();
		 LocalDate date = LocalDate.of(2020, 1, 8);
		 while(!resolved) {
			 String date_string  = input.next();
			 try {
				date = LocalDate.parse(date_string);
				resolved = true;
			 }catch(NumberFormatException e) {
				 displayMsg("  Error entering date try again." );
			 }
		 }
		return date;
	 }
		
	public static void displayMsg(String msg) {
		System.out.println(msg);
	}
	
	public static int mainMenu() {
		boolean resolved  = false;
		int response = 0;		
		global.displayMsg("\n******************************* MAIN MENU **************************");
		global.displayMsg("*  1: Add Customer                                                 *");
		global.displayMsg("*  2: Generate tickets for events                                  *");
		global.displayMsg("*  3: Sell Ticket                                                  *");
		global.displayMsg("*  4: Display Customer details                                     *");
		global.displayMsg("*  5:    STATISTICS MENU                                           *");
		global.displayMsg("*  6:    FINISH THE PROGRAM                                        *");
		global.displayMsg("********************************************************************\n");
		while(!resolved) {
		response = global.getInteger();
		if(response >=1 && response <=6) {
			resolved = true;
			}else {
				global.displayMsg("   ERROR: select option between 1 and 7. ");
			}
		}
		return response;
	}
	
	public static void statMenu() {
		boolean menu  = true;
		
		while(menu) {
			boolean resolved  = false;
			int response = 0;		
			global.displayMsg("\n************************* STATISTICS MENU **************************");
			global.displayMsg("*  1: Display all tickets                                          *");
			global.displayMsg("*  2: Display all customers                                        *");
			global.displayMsg("*  3: Display all sales                                            *");
			global.displayMsg("*  4: Display Customer details                                     *");
			global.displayMsg("*  5:    EXIT                                                      *");
			global.displayMsg("********************************************************************\n");
			while(!resolved) {
			response = global.getInteger();
			if(response >=1 && response <=5) {
				resolved = true;
				}else {
					global.displayMsg("   ERROR: select option between 1 and 5");
				}
			}
			
			switch(response) {
			case 1:  // DISPLAY TICKETS
				Ticket.allTickets(); 
				break;
			case 2: // DISPLAY CUSTOMERS 
				Customer.allCustomers(); 
				break;
			case 3: // DISPLAY SALES 
				TicketSale.allSales();
				break;
			case 4: 
				global.displayMsg("Enter the Id number of the customer to display");
				int displayCustomerId = global.getInteger();
				Customer displayCust = Customer.findCustomer(displayCustomerId);
				if(displayCust!=null) {
					global.displayMsg("customer found... ");
					global.displayMsg(displayCust.toString());
				}else {
					global.displayMsg("The Id number you antered does not exist in the data base");
				}
				break;
			case 5: 
				menu = false;
				break;
			default:
				global.displayMsg("ERROR ON STATS MENU");
			
			}
		}
	}
}
