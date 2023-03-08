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
import java.text.SimpleDateFormat;  
import java.time.LocalDate;
import java.util.Date;  
import java.util.Scanner;

public class TicketApp {
		
	public static void main(String[] args) {
		boolean execution  = true;

			int mainOption;
			global.displayMsg(">>>>>>> WELCOME PLEASE SET THE NUMBER OF TICKETS AVAILABLE <<<<<<<");
			global.numTickets= global.getInteger();
			Ticket.startArrayTickets(global.numTickets);           // ARRAY OF TICKETS 
			TicketSale.startArrayTickets(global.numTickets);       // ARRAY TICKETSALES
			global.displayMsg(">>>>>>> PLEASE SET THE MAX NUMBER OF CUSTOMERS  <<<<<<<");
			global.maxNumCustomers  =  global.getInteger();
			Customer.startArrayCustomers(global.maxNumCustomers);  // ARRAY OF CUSTOMERS 
			global.displayMsg("Tickets available : " + global.numTickets + " Maximum number of customers: "+ global.maxNumCustomers);
		
			
			
			
		while(execution) {
			mainOption = global.mainMenu();
			switch(mainOption) {
			case 1:  // CREATE CUSTOMER 
				if(global.customersAdded<=global.maxNumCustomers) {
					Customer newCustomer = new Customer();                     //Create a customer
					Customer.arrayCustomers[global.customersAdded-1]= newCustomer;        //Assign new customer to a position in the array
				}else {
					global.displayMsg(" ERROR - limit of customers has been reached");
				}
				break;
			case 2: // CREATE TICKET
				if(global.ticketsAdded<=global.numTickets) {
					Ticket newTicket = new Ticket();
					Ticket.arrayTickets[global.ticketsAdded-1]=newTicket;
				}else {
					global.displayMsg(" ERROR - Limit of tickets has been reached");
				}
				break;
			case 3: // SELL TICKET
				if(global.ticketsAdded<=global.numTickets) {
					TicketSale  newTicketSale = new TicketSale();
					TicketSale.arrayTicketSales[global.ticketsAdded-1]=newTicketSale;
					global.displayMsg("Ticked added in position: "+(global.ticketsAdded-1)+"\n");
				}else {
					global.displayMsg(" ERROR - Limit of sales has been reached");
				}
				break;
			case 4: // DISPLAY CUSTOMER DETAILS
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
			case 5: // DISPLAY SALE STATISTICS 
				global.statMenu();
				break;
			case 6: // EXIT
				execution = false; 
				break;
			default:
				global.displayMsg("ERROR ON MAIN MENU");
			}
		}
	}

}
