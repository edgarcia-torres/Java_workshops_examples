import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Slider;


public class mainCalculator  extends Application {
	
	  private TextField THeight = new TextField("10");
	  private TextField TWeight = new TextField("10");
	  Slider slider = new Slider(0, 70, 10);
	  private Button btCalculate = new Button("Calculate");
	  public Results content[] = new Results[100] ; // here I will store calculations	 
	  public int quantity = 0;
	  TableView table = new TableView<Results>();//Provide the type of data to display 
	  public double defWeight = 0;
	  private double ageSlide = 10 ; 
	  
	  
	  
	  public void createStore(double height, double weight, String type, double age) {//this function is triggered by the button submission event  
		  double valueResult  =  0;
		  String status  = "UNDEFINED";
		  if (type.equals("Centimeters / Kilograms")) {
			  valueResult = weight/(height*height) * 10000;
		  }else {
			  valueResult = weight*703/(height*height);

		  }
		  if (valueResult<= 18.5) {status = "Thin"; };
		  if (valueResult > 18.5 && valueResult <= 24.9) {status = "Healthy" ;};
		  if (valueResult > 24.9 && valueResult <= 29.9) {status = "Overweight" ;};
		  if (valueResult > 29.9) {status = "Obese"; };
		  
		  content[quantity] = new Results(valueResult,type,status, age  );
		  table.getItems().add(new Results(valueResult, type,status,age));
		  quantity++;
	  }

	  @Override
	  public void start(Stage primaryStage) {

		  //MAIN PANE
		  TilePane mainPane = new TilePane();
		  GridPane formPane = new GridPane();
		  formPane.setHgap(1);
		  formPane.setVgap(1);
		  formPane.setPadding(new Insets(30));
		  // Grid pane for selection 
		  GridPane gridpane1 = new GridPane();
		  //gridpane1.setPadding(new Insets(30));
		  gridpane1.setAlignment(Pos.CENTER);
		  gridpane1.setHgap(1);
		  gridpane1.setVgap(1);
		  ToggleGroup tg = new ToggleGroup();
		  Label l = new Label("Please select the unit types: ");
		  l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		  gridpane1.add(l, 0, 0);
		  String options[] = {"Centimeters / Kilograms", "Inches / Pound " };
		  for (int i=0; i < options.length; i++) {
			  RadioButton  x = new RadioButton (options[i]);
			  if (i == 0) {
				  x.setSelected(true);
			  }
	        	x.setToggleGroup(tg);
	        	gridpane1.add(x, 0, i+1);
	        }
		  //gridpane1.setStyle("-fx-background-color: red");
		  formPane.add(gridpane1, 0, 0);
		  // Creating User Interface
		  GridPane gridpane2 = new GridPane();
		  gridpane2.setHgap(2);
		  gridpane2.setVgap(2);
		  Label dimentions = new Label("Please enter the dimentions");
		  dimentions.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		  gridpane2.add(dimentions, 0, 0);
		  gridpane2.add(new Label("HEIGHT:  "), 0, 1);
		  gridpane2.add(new Label("WEIGHT:  "), 0, 2);

		    gridpane2.add(THeight, 1, 1);

		    gridpane2.add(TWeight, 1, 2);
		    
		    //Setting the properties for the UI
		    gridpane2.setAlignment(Pos.CENTER);
		    THeight.setAlignment(Pos.CENTER);
		    TWeight.setAlignment(Pos.CENTER);  
		    //gridpane2.setStyle("-fx-background-color: MAGENTA ");
		    //gridpane2.setPadding(new Insets(30));
		    formPane.add(gridpane2, 0, 1);
		    //BUTTON ADDING 
		    btCalculate.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					//Extract input
					String optSearch = tg.getSelectedToggle().toString();
		    		optSearch = optSearch.substring(45, (optSearch.length() -1));
		    		System.out.println(optSearch);
		    	    double heightForm =Double.parseDouble(THeight.getText());  
		    	    double weightForm =Double.parseDouble(TWeight.getText());  
		    	    //send input to calculate and create 
		    	    createStore(heightForm, weightForm, optSearch, ageSlide);
				}
		    });
		    
		    final ColorPicker colorPicker = new ColorPicker();
		    colorPicker.setOnAction(new EventHandler<ActionEvent>(){
		        public void handle(ActionEvent t) {
		            Color c = colorPicker.getValue();
		            String col = c.toString();
		            col = col.substring(2, col.length()-2);
		            mainPane.setStyle("-fx-background-color:#" + col);
		        }
		    });
		    //Slider slider = new Slider(0, 70, 10);
		    slider.setPrefWidth(300);
		    slider.setMajorTickUnit(10);
		    slider.setShowTickMarks(true);
		    slider.setShowTickLabels(true);
		    slider.setBlockIncrement(1);
		    slider.setMinorTickCount(1);
		    slider.setSnapToTicks(true);
		    
		    slider.valueProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
					// TODO Auto-generated method stub
					ageSlide = slider.getValue();
					System.out.println(" Age from slider is: " + ageSlide);
				}
		    	
		    });
			  Label slideLabel = new Label("Select you age in the slider");
			  slideLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
			  formPane.add(slideLabel, 0, 2);
		    formPane.add(slider,0, 3); 
		    
		    btCalculate.setPadding(new Insets(30));
		    GridPane.setHalignment(btCalculate, HPos.CENTER);
		    GridPane.setHalignment(colorPicker, HPos.CENTER);
			  Label colorLabel = new Label("Select background color");
			  colorLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
			  formPane.add(colorLabel, 0, 4);
		    formPane.add(colorPicker,0, 5); 
		    formPane.add(btCalculate,0, 6); 

		   
		    //CREATE COLUMNS
		    TableColumn resultColumn = new TableColumn<Results,Double >("RESULT");//specify the object wehre it extracts data from  and type of variable to display 
		    resultColumn.setCellValueFactory(new PropertyValueFactory<Results,Double>("result"));//result is goiu we are going to be able to extract the property from the object 
		    TableColumn typeColumn = new TableColumn<Results,String >("TYPE");
		    typeColumn.setCellValueFactory(new PropertyValueFactory<Results,String>("type"));
		    TableColumn statusColumn = new TableColumn<Results,String >("STATUS");
		    statusColumn.setCellValueFactory(new PropertyValueFactory<Results,String>("status"));
		    
		    TableColumn ageColumn = new TableColumn<Results,Double >("AGE");
		    ageColumn.setCellValueFactory(new PropertyValueFactory<Results,Double >("age"));
		    //Add these columns to the table view 
		    table.getColumns().add(resultColumn);
		    table.getColumns().add(typeColumn);
		    table.getColumns().add(statusColumn);
		    table.getColumns().add(ageColumn);
		    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//get rid of extra columns   
  
		    mainPane.getChildren().add(formPane);
		    //ADD THIS TABLE TO THE MAIN PANE 
		    TilePane tablePane = new TilePane();
		    mainPane.getChildren().add(table);
		    
		    Scene scene = new Scene(mainPane, 850,450);
		    primaryStage.setTitle("\r\n"
		    		+ "World Development Indicators\r\n"
		    		+ "");
		    primaryStage.setScene(scene);
		    primaryStage.show();    
	  }
	  private void bmiCalculatorCmKg(double cm, double kg ) {
 
		  double heit = Double.parseDouble(THeight.getText());
		  double weit = Double.parseDouble(TWeight.getText());
		  System.out.println("values entered: " + heit + " and " + weit);
		   		  }

	  public static void main(String[] args) {
		    launch(args);
		  }

}
