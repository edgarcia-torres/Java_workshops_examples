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
public class gameMain {

	public static void main(String[] args) {
		
		player player1 = new player();
		
		while(player1.getnumRounds() <=  player1.getLimitRounds()) {
			player1.playRound();			
		}
		player1.isReachedHarbor();

	}

}
