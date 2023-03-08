/**********************************************
Workshop #1
Course:JAC444 - 4 Semester
Last Name:Garcia Torres
First Name: Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Edgar Garcia
Date:28/05/2022
**********************************************/
package creditApp;

import java.util.Scanner;

public class customer {
	
	private int accountNumber;
	private boolean isAccountTypeNew;
	private double beginningBalance;
	private double ItemsCharged;
	private double CreditsApplied;
	private double bonusCredit;
	private double creditLimit;
	private double newBalance = 0;
	private boolean newBalanceCalculated = false;
	
	public customer() {
		//Require customer information: 
		System.out.println("\nEnter account number");
		Scanner input = new Scanner(System.in);
		String response  = input.next();
		setAccountNumber(Integer.valueOf(response));
		System.out.println("Enter account type(N (New),E (Existing))");
		boolean typeResolved= false;
		while(!typeResolved) {
		
		response  = input.next();
			if(response.equals("N")) {
				setAccountType(true);		
				typeResolved = true;
			}else {
				if(response.equals("E")) {
					setAccountType(false);
					typeResolved = true;
				}else {
					System.out.println(" ERROR - You only can enter either N or E  \n -    TRY AGAIN PLEASE  (N (New),E (Existing))");
				}
			}
		}
		System.out.println("Enter balance at the beggining of the month");
		response  = input.next();
		setBegginingBalance(Double.valueOf(response));
		System.out.println("Enter total of all items charged by the customer this month");
		response  = input.next();
		setiItemsCharged(Double.valueOf(response));
		System.out.println("Enter total of all credits applied to the customer’s account this month");
		response  = input.next();
		setCreditsApplied(Double.valueOf(response));
		System.out.println("allowed credit limit.");
		response  = input.next();
		setcreditLimit(Double.valueOf(response));

	}
	
	public void calculateNewBalance() { // 
	
		if (isAccountTypeNew) {
			bonusCredit = 100;
		}else {
			bonusCredit = 0; 
		}
		newBalance = beginningBalance + ItemsCharged + bonusCredit - CreditsApplied ;
		newBalanceCalculated = true;
		System.out.println("\n-------------------------------------------------------------");
		System.out.println("             The new balance is:    "+getnewBalance());
		System.out.println("-------------------------------------------------------------\n");
	}
	
	public void displayNeewBalance() {
		System.out.println("-----------THE CLIENT'S INFORMATION YOU ENTERED IS-----------");
		System.out.println("Account number:               " + getAccountNumber() );
		if (isAccountTypeNew) {		System.out.println("This acount is:                  NEW" );}
		else {
		System.out.println("This acount :                  EXISTING" );}
		System.out.println("The initial balance:          " + getBegginingBalance() );
		System.out.println("Total Items Charged:          " + getItemsCharged() );
		System.out.println("Credits applied value:        " + getCreditsApplied() );
		System.out.println("Credit limit of this account: " + getcreditLimit() );
		System.out.println("-------------------------------------------------------------");
		if (newBalanceCalculated) {
			System.out.println("             The new balance is:    "+getnewBalance());
			isCreditExceeded();
		}else {
			System.out.println("             The new balance has not been Calculated");
		}
		System.out.println("-------------------------------------------------------------\n");
		
	}
	
	public void isCreditExceeded() {
		if(getnewBalance()>getcreditLimit()) {
			System.out.println(" ALERT!!  Credit limit exceeded" );
		}else {
			System.out.println(" The credit limit is not exceded." );
		}
	}
	//Get and Set methods 
		//ACCOUNT NUMBER
	public void setAccountNumber(int AcNumber) {
		this.accountNumber = AcNumber;
	}
	public int getAccountNumber() {
		return this.accountNumber;
	}
		//ACCOUNT TYPE
	public void setAccountType(boolean Actype) {
		this.isAccountTypeNew= Actype;
	}
	public boolean getAccountType() {
		return this.isAccountTypeNew;
	}
		//BEGGINNIG BALANCE
	public void setBegginingBalance(double begBalance) {
		this.beginningBalance= begBalance;
	}
	public double getBegginingBalance() {
		return this.beginningBalance;
	}
		//ITEMS CHARGED
	public void setiItemsCharged(double IteCharged) {
		this.ItemsCharged= IteCharged;
	}
	public double getItemsCharged() {
		return this.ItemsCharged;
	}
		//CREDITS APPLIED
	public void setCreditsApplied(double CreditsApplied) {
		this.CreditsApplied= CreditsApplied;
	}
	public double getCreditsApplied() {
		return this.CreditsApplied;
	}
		//CREDIT LIMIT
	public void setcreditLimit(double creditLimit) {
		this.creditLimit= creditLimit;
	}
	public double getcreditLimit() {
		return this.creditLimit;
	}
		//NEW BALANCE
	public void setnewBalance(double newBalance) {
		this.newBalance= newBalance;
	}
	public double getnewBalance() {
		return this.newBalance;
	}
}
