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
import java.time.LocalDate;

public class Ticket {
	
	enum typeEvent {
		Concert,
		Conference,
		Exposition
		}
	enum seatType {
		VIP,
		GENERAL,
		LAWN
		}

	
	private int ticketNumber; //no set method
	private String eventTitle;
	private typeEvent eventType;
	private int theaterNumber;
	private double price;
	private int seatRow;
	private int seatNumber;
	private seatType seatType;
	private LocalDate EventDate;
	private int EventDuration;
	private String MiscInformation;
	private boolean sold = false;
	
	static Ticket[] arrayTickets;
	
	public String toString(){
		   return "****** TICKET # "+ String.valueOf(ticketNumber)+" INFO ***********\n"
				+ "* Event : "+eventTitle + "\n"
				+ "* EventType: " +eventType+"\n"
				+ "* Date: " + String.valueOf(EventDate) + "\n"
				+ "* Seat Type: "+  String.valueOf(seatType) +"\n"
				+ "* Sold: " +  String.valueOf(sold) +"\n"
				+ "***********************************\n";
	}
	
	static public void  startArrayTickets(int Size) {
		arrayTickets= new Ticket[global.numTickets];// ARRAY OF TICKET SALE same size array cause only created tickets can be sold
	}
	
	private int generateId() {
		global.ticketsAdded++;
	      int newId = global.ticketsAdded;
	      return newId;
	}

	public Ticket() { // GENERATE TICKET 
		global.displayMsg("******************* GENERATE TICKETS FOR EVENTS ************************");
		global.displayMsg("Enter name of the ticket event");
		eventTitle = global.getString();
		global.displayMsg("Enter type of event  1:Concert     2:Conference     3:Exposition  ");
		boolean resolved= false;
		int eventOption= 0;
		while(!resolved) {
			eventOption = global.getInteger();
			if(eventOption <=3 && eventOption >0)resolved = true;else {global.displayMsg(" Try again 1,2 or 3");}
		}
		if(eventOption == 1)eventType = typeEvent.Concert;
		if(eventOption == 2)eventType = typeEvent.Conference;
		if(eventOption == 3)eventType = typeEvent.Exposition;
		global.displayMsg("Enter theater number");
		theaterNumber = global.getInteger();
		global.displayMsg("Enter ticket price");
		price = global.getInteger();
		global.displayMsg("Enter seatType   1:VIP     2:GENERAL     3:LAWN  ");
		resolved = false;
		int seatOption=0;
		while(!resolved) {
			seatOption = global.getInteger();
			if(seatOption <=3 && seatOption >0)resolved = true;else {global.displayMsg(" Try again 1,2 or 3");}
		}
		if(seatOption == 1)seatType = seatType.VIP;
		if(seatOption == 2)seatType = seatType.GENERAL;
		if(seatOption == 3)seatType = seatType.LAWN;
		global.displayMsg("Enter the event Date YYYY-MM-DD");
		EventDate = global.getDate();
		global.displayMsg("Enter Event duration in minutes");
		EventDuration = global.getInteger();
		global.displayMsg("Enter observation or additional information");
		MiscInformation = global.getString();
		ticketNumber = generateId();
	}
	

	
	public static void allTickets() {
		global.displayMsg("Total tickets  is: "+ global.ticketsAdded);
		if(global.ticketsAdded ==0) {
			global.displayMsg("no tickets added yet ");
		}else {
			for(int i =0; i< global.ticketsAdded ; i++) {
				if (Ticket.arrayTickets[i] != null) {
					global.displayMsg(Ticket.arrayTickets[i].toString());
				}else {
					global.displayMsg("not ticket in index  "+i);
				}
				}
		}
	}

	public void sellTicket() {
		sold = true;
	}
		
	//get set methods 
	
	public int getTicketNumber() {
		return this.ticketNumber;
	}
	
	public boolean getSold() {
		return this.sold;
	}


}
