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
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;

public class Customer {
	
	private int customerID;  //no set method
	private String Name;
	private String Address;
	private LocalDate DOB;
	private int rewardPoints;  // no set method 
	private LocalDate joiningDate;//
	//*******************************
	static Customer[] arrayCustomers;
	
	static public void  startArrayCustomers(int Size) {
		arrayCustomers= new Customer[global.numTickets];// ARRAY OF CUSTOMERS 
	}
	
	public static void displayMsg(String msg) {
		System.out.println(msg);
	}
	
	
	
	private int generateId() {
		global.customersAdded++;
	      int newId = global.customersAdded;
	      return newId;
	}

	public Customer() {
		global.displayMsg("*************************** ADD CUSTOMER MENU ************************");
		global.displayMsg("Enter the customer's name");
		Name = global.getString();
		global.displayMsg("Enter the customer's address");
		Address = global.getString();
		global.displayMsg("Enter the customer's Date of birth in the format YYYY-MM-DD");
		DOB = global.getDate();
		global.displayMsg("your DOB is: " + DOB);	
		customerID = generateId();
		joiningDate = LocalDate.now();
		rewardPoints = 100;
		global.displayMsg("creating customer id is "+ customerID);
	}
	
	public static Customer findCustomer(int index) {
		global.displayMsg("Total customers is: "+ global.customersAdded);
		Customer result= null;
		boolean resolved = false;
		for(int i =0; i<= global.customersAdded && !resolved; i++) {
			if (Customer.arrayCustomers[i] != null ) {
				if(Customer.arrayCustomers[i].getCustomerID() == index) {
					result  = Customer.arrayCustomers[i];
					resolved = true;
				}
			}
		}
		resolved = false;
		return result;
	} 
	
	public static void allCustomers() {
		global.displayMsg("Total customers is: "+ global.customersAdded);
		if(global.customersAdded ==0) {
			global.displayMsg("no customers added yet ");
		}else {
			for(int i =0; i< global.customersAdded ; i++) {
				if (Customer.arrayCustomers[i] != null) {
					global.displayMsg(Customer.arrayCustomers[i].toString());
				}else {
					global.displayMsg("not customer in index  "+i);
				}

				}
		}
	}
	

	
	
	public String toString(){
		   return "****** CUSTOMER # "+ String.valueOf(customerID)+"INFO ***********\n"
				+ "* Name : "+Name + "\n"
				+ "* Address: " +Address+"\n"
				+ "* DOB: " + String.valueOf(DOB) + "\n"
				+ "* Reward Points: "+  String.valueOf(rewardPoints) +"\n"
				+ "* Joining date: " +  String.valueOf(joiningDate) +"\n"
				+ "**************************************\n";
	}
	
	public void displayDetails(){
		
	}
	
	public void calculateReward(boolean newticket){//calculate rewards based on criteria
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date now = new Date();  
	    System.out.println(formatter.format(now)); 

		if(LocalDate.now() == DOB){
			rewardPoints += 100;
			displayMsg("Happy Birthday, You get 100 points gift from us");
		}
		if(LocalDate.now() == joiningDate){//You can use java.util.Date,   You can use java.util.Date,
			rewardPoints += 1000;
			displayMsg("Happy anniversary and thank for remaining loyal customer, You get 1000 points gift from us");
		}
		if(newticket){
			rewardPoints+=10;
			displayMsg("you get 10 points for buying a new ticket");
		}
		
		
	}
		public void receiveGift(int gift) {
			this.rewardPoints += gift;
		}
	
	//set get methods 
	public int getCustomerID() {
		return this.customerID;
	}
	public String getCustomerName() {
		return this.Name;
	}
	public String getMonthOfBirth() {
		String month;
		month = String.valueOf(DOB.getMonth());
		return month;
	}
	public String getDayOfBirth() {
		String day;
		day = String.valueOf(DOB.getDayOfMonth());
		return day;
	}
	public String getMonthOfAniversary() {
		String month;
		month = String.valueOf(joiningDate.getMonth());
		return month;
	}
	public String getDayOfAniversary() {
		String day;
		day = String.valueOf(joiningDate.getDayOfMonth());
		return day;
	}

	public boolean isYearanniversary() {
		boolean response = true;
		LocalDate today = LocalDate.now();
		String yearToday = String.valueOf(today.getYear());
		int yearTodayInt = Integer.valueOf(yearToday);
		
		String yearAnniversary = String.valueOf(joiningDate.getYear());
		int yearAnnyversary = Integer.valueOf(yearAnniversary);
		
		if (yearTodayInt == yearAnnyversary) {
			response = false;
		}
		return response;
	}

	

}
