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
import java.time.LocalDate;

public class TicketSale {
	
	int saleId;
	Customer ticketOwner;
	Ticket ticketSold;
	int numberTicketSold;
	int maxNumberTicket;
	LocalDate dateSold;
	
	static TicketSale[] arrayTicketSales;
	
	static boolean seats[][]= new boolean[20][5];
	
	private void displaySeats() {
		global.displayMsg("     O = empty,  X = occupied");
		global.displayMsg("- - - - - - - S C R E E N - - - - - - -\n");
		global.displayMsg("- - - - - - - - - - - - - - - - - - - -");
		for(int i = 0; i< 5 ;i++) {
			String line = "";
			for(int e = 0; e< 20 ;e++) {
				if (seats[e][i]==true) {
					line  = line + "X ";
				}else {
					line  = line + "O ";
				}
			}
			global.displayMsg(line);
		}
		global.displayMsg("- - - - - - - - - - - - - - - - - - - -");
		
	}	
	
	
	static public void  startArrayTickets(int Size) {
		arrayTicketSales= new TicketSale[global.numTickets];// ARRAY OF TICKET SALE
	}
	
	
	private Customer searchCustomer() {
		Customer response = null;
		boolean resolved  = false;
		while(!resolved) {
			global.displayMsg("Enter the customer ID");
			int custID = global.getInteger();
			for(int i = 0; i< global.customersAdded && !resolved; i++ ) {
				if (Customer.arrayCustomers[i].getCustomerID() == custID) {
					response = Customer.arrayCustomers[i];
					resolved = true;
				}
			}
			if (!resolved) {
				global.displayMsg(".....The ID you entered was not found TRY AGAIN.");
			}
		}
		return response;
	}
	
	private Ticket searchTicket() {
		Ticket response = null;
		boolean resolved  = false;
		while(!resolved) {
			global.displayMsg("Enter the Ticket number");
			int tickNum = global.getInteger();
			for(int i = 0; i< global.ticketsAdded && !resolved; i++ ) {
				if (Ticket.arrayTickets[i].getTicketNumber() == tickNum) {
					response = Ticket.arrayTickets[i];
					resolved = true;
				}
			}
			if (!resolved) {
				global.displayMsg(".....The ticket number you entered was not found TRY AGAIN.");
			}
		}
		return response;
	}
	
	private int generateId() {
		global.salesCount++;
	      int newId = global.salesCount;
	      return newId;
	}

	public TicketSale() {
		int custID; 
		int tickID;
		boolean resolved = false;
		global.displayMsg("*************************** SELL TICKETS MENU ************************");
		ticketOwner = searchCustomer();
		while(!resolved) {
			ticketSold = searchTicket();
			if (ticketSold.getSold()==true) {
				global.displayMsg(" SORRY.. The ticket Number you enetered exist but is sold try with another ticket");
			}else {

			}
			if (ticketOwner!= null && ticketSold!=null) {

				boolean seatresolved = false;
				while(!seatresolved) {
					int seatRow = -1;
					int seatNumber = -1;
					global.displayMsg("SELECT YOUR SEAT");
					displaySeats();
					
					while (seatNumber < 0 || seatNumber > 5) {
						global.displayMsg("Enter ticket seatRow");
						seatNumber = global.getInteger()-1;
					}
					while (seatRow < 0 || seatRow > 20) {
						global.displayMsg("Enter ticket seatNumber");
						seatRow = global.getInteger()-1;
					}
					if(seats[seatRow][seatNumber] == false) {
						global.displayMsg("             available ");
						seats[seatRow][seatNumber] = true;
						seatresolved = true;
						displaySeats();
					}else {
						global.displayMsg("             taken ");
					}
				}
				
				ticketSold.sellTicket();
				numberTicketSold = ticketSold.getTicketNumber();
				dateSold = LocalDate.now();
				
				String soldMonth = String.valueOf(dateSold.getMonth());
				String soldDay = String.valueOf(dateSold.getDayOfMonth());
				
				if(soldMonth.equals(ticketOwner.getMonthOfBirth()) && soldDay.equals(ticketOwner.getDayOfBirth())) {	
					global.displayMsg("\n   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					  global.displayMsg("   &&&&&&&&&&         HAPPY BIRTHDAY       &&&&&&&&");
				      global.displayMsg("   &&&&&&&  YOU GET 100 POINTS GIFT FROM US  &&&&&&");
					  global.displayMsg("   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					ticketOwner.receiveGift(100);
					
				}
				if(soldMonth.equals(ticketOwner.getMonthOfAniversary()) && soldDay.equals(ticketOwner.getDayOfAniversary())  && ticketOwner.isYearanniversary() ) {	
					global.displayMsg("\n   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					  global.displayMsg("   &&&&           HAPPY ANNIVERSARY            &&&&");
					  global.displayMsg("   &&&&   thank for remaining loyal customer   &&&&");
					  global.displayMsg("   &&&&   YOU GET 1000 POINTS GIFT FROM US     &&&&");
					  global.displayMsg("   &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
					ticketOwner.receiveGift(1000);
				}
				global.displayMsg("*Ticket number"+ ticketSold.getTicketNumber()+" sold succesfuly to the customer number "+ticketOwner.getCustomerID() + "\n");
				saleId = generateId();
				resolved = true;
			}
			global.displayMsg("**********************************************************************");

		}

	}
	
	public String toString(){
		   return "****** SALE # "+ String.valueOf(saleId)+"INFO ***********\n"
				+ "* Ticket Owner : "+ticketOwner.getCustomerName() + "\n"
				+ "* Ticket number: " +String.valueOf(ticketSold.getTicketNumber())+"\n"
				+ "* Date Sold: " + String.valueOf(dateSold) + "\n"
				+ "**************************************\n";
	}
	
	public static void allSales() {
		global.displayMsg("Total sales  is: "+ global.salesCount);
		if(global.salesCount ==0) {
			global.displayMsg("no sales have been done yet ");
		}else {
			for(int i =0; i< global.salesCount ; i++) {

				if (TicketSale.arrayTicketSales[i] != null) {
					global.displayMsg(TicketSale.arrayTicketSales[i].toString());
				}else {
					global.displayMsg("not ticket in index  "+i);
				}
				}
		}
	}
	
	

}
