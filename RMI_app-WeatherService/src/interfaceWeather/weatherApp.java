package interfaceWeather;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class weatherApp extends Application{

	public weatherApp() {
		// TODO Auto-generated constructor stub
	}
	public void consultWeather(String day) {
		
		String[] response = ClientConnection.doRequestToServer(day);
		System.out.println("INSIDE APP "+ response);	
		String place = response[0];
		String temperature = response[1];
		String Weather = response[2];
			
		Stage placeStage = new Stage();
		
		GridPane gridPane = new GridPane();	
	    gridPane.setHgap(20);
	    gridPane.setVgap(20);
	    Label p   = new Label("City:   ");
	    p.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	    Label t   = new Label("Temperature:  ");
	    t.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	    Label w   = new Label("Weather:  ");
	    w.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	    

	    gridPane.add(p, 0, 0);
	    gridPane.add(new Label(place), 1, 0);
	    gridPane.add(t, 0, 1);
	    gridPane.add(new Label(temperature), 1, 1);
	    gridPane.add(w, 0, 2);
	    gridPane.add(new Label(Weather), 1, 2);
		
		gridPane.setAlignment(Pos.CENTER);     
		placeStage .setTitle("Weather request results");
        Scene responseScene = new Scene(gridPane, 300, 300);
        placeStage.setScene(responseScene);
        placeStage.show();

	}

	  public static void main(String[] args) {
		    launch(args);
		  }

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btCalculate = new Button("Calculate");
	    btCalculate.setPadding(new Insets(30));
	    GridPane.setHalignment(btCalculate, HPos.CENTER);

		
		TilePane mainPane = new TilePane();
		mainPane.setAlignment(Pos.CENTER);
		 GridPane gridpane1 = new GridPane();
		  gridpane1.setAlignment(Pos.CENTER);
		  gridpane1.setHgap(10);
		  gridpane1.setVgap(20);
		  ToggleGroup tg = new ToggleGroup();
		  Label l = new Label("SELECT THE DAY TO CONSULT THE WEATHER: ");
		  l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		  gridpane1.add(l, 0, 0);
		String options[] = {"Monday", "Tuesday", "Wednesday","Thursday", "Friday","Saturday","Sunday" };
		int i;
		  for (i=0; i < options.length; i++) {
			  RadioButton  x = new RadioButton (options[i]);
			  if (i == 0) {
				  x.setSelected(true);
			  }
	        	x.setToggleGroup(tg);
	        	gridpane1.add(x, 0, i+1);
	        }
		  gridpane1.add(btCalculate, 0, i+1);
		  btCalculate.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					//Extract input
					String optSearch = tg.getSelectedToggle().toString();
					System.out.println(optSearch);
							
		    		optSearch = optSearch.substring(46, (optSearch.length() -1));
		    		System.out.println(optSearch);
		    	    //send input to calculate and create 
		    	    consultWeather(optSearch);
				}
		    });

		mainPane.getChildren().add(gridpane1);
	    Scene scene = new Scene(mainPane, 450,450);
	    primaryStage.setTitle("Forecast Application");
	    primaryStage.setScene(scene);
	    primaryStage.show();  
		
	}

}
