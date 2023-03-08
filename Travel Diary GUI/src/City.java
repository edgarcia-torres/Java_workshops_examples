import java.time.LocalDate;
import java.util.LinkedList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class City {
	String name; 
	String description; 
	LocalDate date;
	LinkedList<PlaceVisited> placesList  = new LinkedList<PlaceVisited>();
	
	int rating;
	
	public void  addPlace(PlaceVisited newplace) {
		placesList.add(newplace);
	}
	public City() {
		
	}

	public void SetCity(String name, LocalDate date, String description, int rate) {
		this.name = name;
		this.date = date;
		this.description = description;
		this.rating = rate;
	}
	
	public static void displayError() {
    	Alert a = new Alert(AlertType.ERROR);
		a.setContentText("Please enter an intger  number between 0 and 5");
        a.show();	
	}
	
	public static int validateRate(String rate) {
		int ratin = -1;
		 try {//validation on rating
			 ratin = Integer.parseInt(rate);;
		    	if(ratin>5 ||ratin<0)City.displayError();
		    }catch(Exception e) {
		    	//City.displayError();
		    }
		 return ratin;
	}
	
	public static void displayDateError(){
    	Alert a = new Alert(AlertType.ERROR);
		a.setContentText("Please entr a dat with the format: YYYY-MM-DD");
        a.show();	
	}	
	
	public static LocalDate validateDate(String input) {

		 boolean resolved = false;
		 boolean attempt = false;
		 LocalDate date = null;
		 while(!resolved && !attempt) {
			 attempt = true;
			 try {
				date = LocalDate.parse(input);
				resolved = true;
			 }catch(Exception e) {
				 resolved = false;
				 attempt = true;
				 //displayDateError();
			 }
		 }
		return date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
