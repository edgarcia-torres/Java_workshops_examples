import javafx.scene.control.ScrollPane;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ListIterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class travelApp extends Application{
	
	private Button btnDisplay = new Button("DISPLAY LOG");
	private Button btnAddTravel= new Button("ADD TRAVEL");
	LinkedList<Travel> travelLog  = new LinkedList<Travel>(); //  ==> collection of travels
	
	public void addTravel(Travel newTravel) {
		travelLog.add(newTravel);
	}
	
	public void addPlace(City newCity) {//receive city to add the place
		Stage placeStage = new Stage();
		Button btnDone = new Button("DONE");
		GridPane gridPane = new GridPane();	
		TextField placeName = new TextField();
		TextField placeComments = new TextField();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Name of the Place:"), 0, 0);
	    gridPane.add(placeName, 1, 0);
	    gridPane.add(new Label("Comments on the place:"), 0, 1);
	    gridPane.add(placeComments, 1, 1);
	    gridPane.add(btnDone, 1, 2);
	    btnDone.setOnAction(new EventHandler<ActionEvent>() {//SAVE CITY AND CLOSE 
		
	    	String name  =  "";
	    	String comments = "";
	    	@Override
			public void handle(ActionEvent arg0) {
				//extract values from input
	    		name = placeName.getText();
	    		comments  = placeComments.getText();
	    		//create a place object
	    		PlaceVisited newPlace = new PlaceVisited(name, comments);
	    		//push place to the list of places
	    		newCity.addPlace(newPlace);//call the method   	
				placeStage.close();
			}
	    });
		gridPane.setAlignment(Pos.CENTER);     
		placeStage .setTitle("ADD NEW PLACE IN THE CITY");
        Scene responseScene = new Scene(gridPane, 600, 300);
        placeStage.setScene(responseScene);
        placeStage.show();
	}
	
	public void addCity(Trip newTrip) {//receive the trip to add the City 
		
		Stage addtravelStage = new Stage();
		Button btnPlace = new Button("Add place");
		Button btnDone = new Button("DONE");
		btnDone.setStyle("-fx-background-color: MEDIUMSPRINGGREEN");
		GridPane gridPane = new GridPane();	
		TextField cityName = new TextField();
		TextField dateInCity = new TextField();
		TextArea  cityDescription = new TextArea();
		TextField cityRating = new TextField();		
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Name of the city:"), 0, 0);
	    gridPane.add(cityName, 1, 0);
	    gridPane.add(new Label("Start Date:"), 0, 1);
	    gridPane.add(dateInCity, 1, 1);
	    gridPane.add(new Label("Description:"), 0, 2);
	    gridPane.add(cityDescription, 1, 2);
	    gridPane.add(new Label("Rating (number from 1 to 5):"), 0, 3);
	    gridPane.add(cityRating, 1, 3);
	    gridPane.add(btnPlace, 1, 4);
	    gridPane.add(btnDone, 1, 5);

	    
	    //create this city empty
	    City newCity = new City();  
	    btnDone.setOnAction(new EventHandler<ActionEvent>() {//SAVE CITY AND CLOSE 
		    String name = "";
		    String date = "";
		    String description = "";
		    String rate  = "";
		    int rating = 0;
		    LocalDate newDate;
	    	@Override
			public void handle(ActionEvent arg0) {
				//extract values from input
			     name = cityName.getText();
			     date = dateInCity.getText();
			     description = cityDescription.getText();
			     rate = cityRating.getText();	     
			    //validate inputs
			     rating = City.validateRate(rate);
			     newDate = City.validateDate(date);
			     if (rating >= 0 && rating<=5) {
			    	 if(newDate!=null) {
						 //set city values 
					     newCity.SetCity(name, newDate, description, rating); 
					     //push newTrip
					     newTrip.addCity(newCity);
						 addtravelStage.close();
			    	 }else {
			    		 City.displayDateError();
			    	 }
			     }else {
			    	 City.displayError();
			     }
			}
	    });
		
	    btnPlace.setOnAction(new EventHandler<ActionEvent>() {//SAVE CITY AND CLOSE 
			@Override
			public void handle(ActionEvent arg0) {
				//send this city to add places 
				addPlace(newCity);
			}
	    });

		gridPane.setAlignment(Pos.CENTER);     
        addtravelStage .setTitle("ADD NEW TRAVEL");
        Scene responseScene = new Scene(gridPane, 800, 350);
        addtravelStage.setScene(responseScene);
        addtravelStage.show();
	}
	
	public void addTripTravel(Travel thisTravel) {
		
		//BUTTON
		Stage tripStage = new Stage();
		Button btnAddTrip = new Button("ADD CITY");
		Button btnDone = new Button("DONE");
		btnDone.setStyle("-fx-background-color: MEDIUMSPRINGGREEN");
		GridPane gridPane = new GridPane();
		TextField tCountry = new TextField();
		TextField tDateStart = new TextField();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Country:"), 0, 0);
	    gridPane.add(tCountry, 1, 0);
	    gridPane.add(new Label("Arrival Date:"), 0, 1);
	    gridPane.add(tDateStart, 1, 1);
	    gridPane.add(btnAddTrip, 1, 5);
	    gridPane.add(btnDone, 1, 6);
	    //create an empty trip
	    Trip newTrip = new Trip();

		btnAddTrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//send this trip to add cities
				addCity(newTrip);
			}
	    });
		btnDone.setOnAction(new EventHandler<ActionEvent>() {
			String country; 
			String date;
			LocalDate newDate; 
			@Override
			public void handle(ActionEvent arg0) { //SAVE AND CLOSE
				//extract values from input
				country =  tCountry.getText();
				date = tDateStart.getText();
				//validate date 
				newDate = City.validateDate(date);
				if(newDate!=null) {
				//set trip values
				newTrip.setTrip(country, newDate);
				//push this Trip to travel
				thisTravel.addTrip(newTrip);
				tripStage.close();
				}else {
					City.displayDateError();
				}
			}
	    });

		gridPane.setAlignment(Pos.CENTER);       
		tripStage .setTitle("ADD NEW TRIP");
        Scene responseScene = new Scene(gridPane, 600, 200);
        tripStage.setScene(responseScene);
        tripStage.show();
	}
	
	public void addTravel() {
		Stage addtravelStage = new Stage();
		Button btnAddTrip = new Button("ADD TRIP");
		Button btnDone = new Button("DONE");
		btnDone.setStyle("-fx-background-color: MEDIUMSPRINGGREEN");
		GridPane gridPane = new GridPane();
		TextField tStartCountry = new TextField();
		TextField tDateStart = new TextField();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
	    gridPane.add(new Label("Start country:"), 0, 0);
	    gridPane.add(tStartCountry, 1, 0);
	    gridPane.add(new Label("Start Date:"), 0, 1);
	    gridPane.add(tDateStart, 1, 1);
	    gridPane.add(btnAddTrip, 1, 5);
	    gridPane.add(btnDone, 1, 6);    
	    Travel newtravel = new Travel();

		btnAddTrip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//send this travel to add trips
				addTripTravel(newtravel);
			}
	    });
		btnDone.setOnAction(new EventHandler<ActionEvent>() {//SAVE AND CLOSE
			String start;
			String date;
			LocalDate newDate;
			String end;//determine this country with the last trip.
			@Override
			public void handle(ActionEvent arg0) {
				//extract info from input 
				start = tStartCountry.getText();
				date = tDateStart.getText();
				//validate date 
				newDate = City.validateDate(date);
				if(newDate!=null) {
					//set travel values
					newtravel.setTravel(start,newDate,end);
					//push this Travel to travel Log
					addTravel(newtravel);
					addtravelStage.close();
				}else {
					City.displayDateError();
				}
			}
	    });
		gridPane.setAlignment(Pos.CENTER);
        addtravelStage .setTitle("ADD NEW TRAVEL");
        Scene responseScene = new Scene(gridPane, 600, 200);
        addtravelStage.setScene(responseScene);
        addtravelStage.show();
	}
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&   DISPLAY LOG &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

	
	public void displayLog() {
		System.out.println(travelLog);
		ListIterator<Travel> iter = travelLog.listIterator();
//		int count = 0;	                               //THIS SECTION TEST ON CONSOLE
//		while(iter.hasNext()) {
//			count++;
//			System.out.println("TRAVEL: " + count);
//			Travel next = iter.next();
//			System.out.println("	Country start: " + next.getCountryStart());
//			System.out.println("	Date start: " + next.getDateStart());
//			System.out.println("	TRIPS: ");
//			ListIterator<Trip> iterTrip = next.tripList.listIterator();
//			int countTrip = 0;
//			while(iterTrip.hasNext()) {
//				countTrip++;
//				System.out.println("		TRIP: " + countTrip);
//				Trip nextTrip = iterTrip.next();
//				System.out.println("		 Country trip: " + nextTrip.getCountry());
//				System.out.println("		 Date start: " + nextTrip.getDate());
//				ListIterator<City> iterCity = nextTrip.citiesList.listIterator();
//				int counterCity = 0;
//				while(iterCity.hasNext()) {
//					counterCity++;
//					System.out.println("			CITY: " + counterCity);
//					City nextCity = iterCity.next();
//					System.out.println("		  	City name: " + nextCity.getName());
//					System.out.println("		  	vist date: " + nextCity.getDate());
//					System.out.println("		  	City rate: " + nextCity.getRating());
//					System.out.println("		  	City desctiption: " + nextCity.getDescription());
//					ListIterator<PlaceVisited> iterPlace = nextCity.placesList.listIterator();
//					int countPlaces = 0;
//					while(iterPlace.hasNext()) {
//						countPlaces++;
//						System.out.println("				PLACE: " + countPlaces);
//						PlaceVisited nextPlace= iterPlace.next();
//						System.out.println("		  		Place name: " + nextPlace.getName());
//					}
//				}			
//			}
//		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    GRAPHIC INTERFACE %%%%%%%%%%%%%%%%%%%%%%%%%
		ScrollPane scrollPane = new ScrollPane();
		BorderPane root = new BorderPane();
		root.setCenter(scrollPane);
		  TilePane mainPane = new TilePane();
		  scrollPane.setContent(mainPane);
		  GridPane travelGrid= new GridPane();
		  travelGrid.setStyle("-fx-border: 2px solid; -fx-border-color: red;");

		int count=0 ;  
		int line = 0; 
		while(iter.hasNext()) {
			Label travelLabel = new Label("Travel #" + (count+1));
			travelLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
			travelGrid.add(travelLabel, 0, line); line++;
			Travel next = iter.next();
			travelGrid.add(new Label("	Country start: "), 0, line);
			travelGrid.add(new Label(next.getCountryStart()), 1, line);line++;
			travelGrid.add(new Label("	Date start: "), 0, line);
			travelGrid.add(new Label(next.getDateStart().toString()), 1, line);line++;			
			System.out.println("travel: " + (count+1) + " line: " + line);
			ListIterator<Trip> iterTrip = next.tripList.listIterator();
			count++;
			int countTrip = 0;
			int lineTrip = 0; 
			while(iterTrip.hasNext()) {
				GridPane tripGrid= new GridPane();
				tripGrid.setStyle("-fx-border: 2px solid; -fx-border-color: green; ");
				Label tripLabel = new Label("Trip #" + (countTrip+1));
				tripLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
				tripGrid.add(tripLabel, 0, lineTrip); lineTrip++;
				Trip nextTrip = iterTrip.next();			
				tripGrid.add(new Label("		 Country trip: "), 0, lineTrip);
				tripGrid.add(new Label(nextTrip.getCountry()), 1, lineTrip);lineTrip++;			
				tripGrid.add(new Label("		 Date start: : "), 0, lineTrip);
				tripGrid.add(new Label(nextTrip.getDate().toString()), 1, lineTrip);lineTrip++;	
				travelGrid.add(tripGrid, 1, line);line++;
				ListIterator<City> iterCity = nextTrip.citiesList.listIterator();
				countTrip++;
				int counterCity = 0;
				int lineCity = 0;
				while(iterCity.hasNext()) {
					GridPane cityGrid= new GridPane();
					cityGrid.setStyle("-fx-border: 2px solid; -fx-border-color: blue; ");
					Label cityLabel = new Label("City #" + (counterCity+1));
					cityLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
					cityGrid.add(cityLabel, 0, lineCity); lineCity++;
					City nextCity = iterCity.next();
					cityGrid.add(new Label("		 City Name: "), 0, lineCity);
					cityGrid.add(new Label(nextCity.getName()), 1, lineCity);lineCity++;	
					cityGrid.add(new Label("		 Visit date: "), 0, lineCity);
					cityGrid.add(new Label(nextCity.getDate().toString()), 1, lineCity);lineCity++;					
					cityGrid.add(new Label("		 Rating: "), 0, lineCity);
					cityGrid.add(new Label( String.valueOf(nextCity.getRating())), 1, lineCity);lineCity++;	
					cityGrid.add(new Label("		 Description: "), 0, lineCity);
					cityGrid.add(new Label(nextCity.getDescription()), 1, lineCity);lineCity++;
					tripGrid.add(cityGrid, 1, lineTrip);lineTrip++;
					ListIterator<PlaceVisited> iterPlace = nextCity.placesList.listIterator();
					counterCity++;
					int countPlaces = 0;
					int linePlace = 0;
					while(iterPlace.hasNext()) {
						GridPane placeGrid= new GridPane();
						placeGrid.setStyle("-fx-border: 2px solid; -fx-border-color: yellow; ");
						Label placeLabel = new Label("Place #" + (countPlaces+1));
						placeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
						placeGrid.add(placeLabel, 0, linePlace); linePlace++;
						PlaceVisited nextPlace= iterPlace.next();
						placeGrid.add(new Label("		 Place Name: "), 0, linePlace);
						placeGrid.add(new Label(nextPlace.getName()), 1, linePlace);linePlace++;
						placeGrid.add(new Label("		 Comments: "), 0, linePlace);
						placeGrid.add(new Label(nextPlace.getComments()), 1, linePlace);linePlace++;
						cityGrid.add(placeGrid, 1, lineCity);lineCity++;
						countPlaces++;
					}
				}			
			}	
		}
		mainPane.getChildren().add(travelGrid);
        Stage displayLogStage = new Stage();
        displayLogStage.setTitle("DISPLAY LOGS");
        Scene responseScene = new Scene(root, 550, 800);
        displayLogStage.setScene(responseScene);
        displayLogStage.show();
	}
	
	@Override
	public void start(Stage primaryStage) {
		TilePane mainPane = new TilePane();
		HBox hbox = new HBox();
		
		btnDisplay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				displayLog();
			}
	    });
		
		btnAddTravel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {	
				addTravel();
			}
	    });
		btnDisplay.setPadding(new Insets(30));
	    GridPane.setHalignment(btnDisplay, HPos.CENTER);
	    btnAddTravel.setPadding(new Insets(30));
	    GridPane.setHalignment(btnDisplay, HPos.CENTER);
    
	    mainPane.setAlignment(Pos.CENTER);
	    hbox.getChildren().add(btnDisplay);
	    hbox.getChildren().add(btnAddTravel);
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(50);
	    mainPane.getChildren().add(hbox);	    
	    Scene scene = new Scene(mainPane, 400,400);
	    primaryStage.setTitle("TRAVEL LOG APPLICATION");
	    primaryStage.setScene(scene);
	    primaryStage.show();    
	}

	public static void main(String[] args) {
		    launch(args);
	}

}
