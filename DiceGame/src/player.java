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

public class player {
	
	private int score = 0;
	private int numRounds = 1; 
	static int limitRounds = 5;
	dice dice1 = new dice();
	dice dice2 = new dice();
	
	public void playRound() {
		System.out.println("\n*****************   ROUND #" + numRounds + "   *****************");
		dice1.rollDice();
		dice2.rollDice();
		
		
		System.out.println("You rolled: [" + dice1.getdiceResult()+ "] & ["+ dice2.getdiceResult()+"]");
		
		if((dice1.getdiceResult() + dice2.getdiceResult()) == 10 ) {//round got sum of 10.
			System.out.println("Ship is going down!     You lose 50 points.");
			score = score - 50;
		
		}else {
			if(dice1.getdiceResult()==dice2.getdiceResult() ) {
				System.out.println("Captain saved the ship!     You earn 50 points.");
				score = score + 50;
			}else {
				if(dice1.getdiceResult()==(dice2.getdiceResult()-1) ) {//round got a sequence of numbers 
					System.out.println("Captain sails the ship!     You earn 10 points.");
					score = score + 10;
				}else {
					System.out.println("Ship is in trouble!     You lose 5 points.");
					score = score - 5;
				}
				
			}

		}
		System.out.println("SCORE: "+ getScore());
		System.out.println("************************************************\n");
		numRounds ++;
	}
	
	public boolean isReachedHarbor() {
		boolean result  = false;
		System.out.println(" TOTAL SCORE IS: " + score);
		if(getScore() >= 100) {
			System.out.println("               The ship reached the harbor");
		}else {
			System.out.println("               Ship hit rock bottom");
		}
		return result;
	}
	
	public int getScore() {
		return this.score;
	}
	public int getLimitRounds() {
		return this.limitRounds;
	}
	public int getnumRounds() {
		return this.numRounds;
	}
	
}
