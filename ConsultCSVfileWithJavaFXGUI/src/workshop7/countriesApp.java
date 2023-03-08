package workshop7;


import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class countriesApp extends Application {
	
	private static fileInfo document1 = null;
	private TextField Country = new TextField();

	public countriesApp() {
		// TODO Auto-generated constructor stub
	}
		
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
		
        String st1[] = { "Adequacy of social insurance programs (% of total welfare of beneficiary households)",
        		"Adequacy of social protection and labor programs (% of total welfare of beneficiary households)",
        		"Adjusted savings: education expenditure (% of GNI)",
        		"Adequacy of unemployment benefits and ALMP (% of total welfare of beneficiary households)",
        		"Adjusted net national income (annual % growth)",
        		"Adjusted net national income per capita (annual % growth)",
        		"CO2 emissions (metric tons per capita)"
        		};
        String st2[] = { "2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
        
        TilePane r = new TilePane();
        Label l = new Label("Please select the value that you want to display");
        l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        // add label
        gridPane.add(l, 0, 0);
        

        ToggleGroup tg = new ToggleGroup();
        ToggleGroup tgr = new ToggleGroup();
	    gridPane.setHgap(5);
	    gridPane.setVgap(5);
         int i;
        for (i=0; i < st1.length; i++) {
        	RadioButton  x = new RadioButton (st1[i]);
        	x.setToggleGroup(tg);
            r.getChildren().add(x);
            gridPane.add(x, 0, i+1);
        }
        
        i++;i++;
        Label yearLabel = new Label("Select the year to retrieve data ");
        yearLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gridPane.add(yearLabel, 0, i);
        i++;   
        int lr = 0;
        HBox hyearPane = new HBox();
        hyearPane.setSpacing(10);
        for (lr=1; lr < st2.length; lr++) {
        	RadioButton  yearRadio = new RadioButton (st2[lr]);
        	yearRadio.setToggleGroup(tgr);
            r.getChildren().add(yearRadio);
            hyearPane.getChildren().add(yearRadio);
        }       
             

        gridPane.add(hyearPane, 0, i);
        HBox hCountryPane = new HBox();

        i++;i++;
        Label v = new Label("Enter the country:  ");
        v.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        i++;

        hCountryPane.getChildren().add(v);
        hCountryPane.getChildren().add(Country);
        gridPane.add(hCountryPane, 0, i);i++;i++;	    
	    Button submitBtn = new Button("SUBMIT");
	    gridPane.add(submitBtn, 0, i);
	    GridPane.setHalignment(submitBtn, HPos.CENTER);
	    gridPane.setAlignment(Pos.CENTER);
	    

	    submitBtn.setOnAction(new EventHandler<ActionEvent>() {
	    	Boolean success= false;
	    	String countrySearch;
	    	String optSearch;
	    	String yearSearch;
	    	String retrieved = "";

	    	public void handle(ActionEvent event){
		    	try {
		    		boolean countdone = false;
		    		Util.displayMsg("pressed the SUBMIT button");
		    		countrySearch  = Country.getText();
		    		if(countrySearch.equals("")) {
			    		Alert a = new Alert(AlertType.ERROR);
			    		a.setContentText("Please enter the country");
		                // show the dialog
		                a.show();
		    		}else {
		    			countdone = true;
		    		}
		    		Util.displayMsg("the country to perform search is: "+countrySearch);
		    		optSearch = tg.getSelectedToggle().toString();
		    		optSearch = optSearch.substring(46, (optSearch.length() -1));
		    		Util.displayMsg(optSearch);
		    		yearSearch = tgr.getSelectedToggle().toString();
		    		yearSearch = yearSearch.substring(46, (yearSearch.length() -1));
		    		Util.displayMsg(yearSearch);
		    		retrieved = document1.search(countrySearch,optSearch,yearSearch);
		    		if (retrieved.equals("") || retrieved.equals("..")) {
		    			retrieved = "Data not available in the file";
		    		}
		    		if(countdone == true) {
		    			success = true;
		    		}

		    	}catch(Exception e) {
		    		Util.displayMsg("FATAL ERROR OPTION WAS NOT ENTERED");
		    		Alert a = new Alert(AlertType.ERROR);
		    		a.setContentText("Please enter the country, the year and the indicator you want to retrieve.");
	                // show the dialog
	                a.show();
		    	}
		    	
		    	if (success) {
	                GridPane gridPaneResponse = new GridPane();
	                Label coun = new Label("COUNTRY:  ");
	                Label ye = new Label("YEAR:  ");
	                Label ind = new Label("INDICATOR:  ");
	                Label ress = new Label("RESPONSE:  ");
	                Label result = new Label(retrieved);
	                result.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                result.setStyle("-fx-text-fill:red;");
	                coun.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                ye.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                ind.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                ress.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                gridPaneResponse.add(coun, 0, 0);
	                gridPaneResponse.add(ind, 0, 1);
	                gridPaneResponse.add(ye, 0, 2);
	                gridPaneResponse.add(ress, 0, 3);
	                gridPaneResponse.add(new Label(countrySearch), 1, 0);
	                gridPaneResponse.add(new Label(optSearch), 1, 1);
	                gridPaneResponse.add(new Label(yearSearch), 1, 2);
	                gridPaneResponse.add(result, 1, 3);
	                ress.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
	                gridPaneResponse.setAlignment(Pos.CENTER);
	                Stage secondaryStage = new Stage();
	                secondaryStage.setTitle("Data retrieved");
	                Scene responseScene = new Scene(gridPaneResponse, 600, 200);
	                secondaryStage.setScene(responseScene);
	                secondaryStage.show();
		    		
		    	}

	    	}
	    });

	    Scene scene = new Scene(gridPane, 700, 350);
	    primaryStage.setTitle("\r\n"
	    		+ "World Development Indicators\r\n"
	    		+ "");
	    primaryStage.setScene(scene);
	    primaryStage.show();

	}


	public static void main(String[] args) throws IOException {
		

		try {
			document1 = new fileInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}

		launch(args);

	}
}
