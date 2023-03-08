import java.util.Random;
import java.util.random.*;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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

public class MatrixApp extends Application{
	
	static int matrixSize = 2000;
	int numbThreads = 4;
	//create two 2000 * 2000 matrix" 
	static int[][] matrix1 = new int[matrixSize][matrixSize];
	static int[][] matrix2 = new int[matrixSize][matrixSize];
	int[][] resultMatrix = new int[matrixSize][matrixSize];
	
	
	public static int randomNumber () {
	      Random rand = new Random(); //instance of random class
	      int upperbound = 10;
	      return  rand.nextInt(upperbound); 
	}
	public MatrixApp(){
		//fill the matrix 
		for(int i = 0; i< matrixSize; i++) {
			for(int e = 0; e<matrixSize;e++) {
				matrix1[i][e] = randomNumber();
				matrix2[i][e] = randomNumber();
			}
		}
		
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane gridPane = new GridPane();
	    gridPane.setHgap(5);
	    gridPane.setVgap(10);  
	    Scene scene = new Scene(gridPane, 700, 350);
	    gridPane.setPadding(new Insets(20, 10, 20, 10));
	    primaryStage.setTitle("Multithread time calculator");
	    
	    int c = 0;
	    Label oneThread = new Label("ONE Thread");
	    oneThread.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gridPane.add(oneThread, 0, 0);c++;
	    Label twoThread = new Label("TWO Threads");
	    twoThread.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gridPane.add(twoThread, 0, 2);c++;
	    Label fourThread = new Label("FOUR Threads");
	    fourThread.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gridPane.add(fourThread, 0, 4);c++;
	    Label eightThread = new Label("EIGHT Threads");
	    eightThread.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gridPane.add(eightThread, 0, 6);c++;
        
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    

	    gridPane.add((new Label("Total time")), 0, 1);c++;
	    int one = performThreadOne();
	    gridPane.add((new Label(String.valueOf(one))), 1, 1);c++;

	    gridPane.add((new Label("Total time")), 0, 3);c++;
	    int two = performThreadTwo();
	    gridPane.add((new Label(String.valueOf(two))), 1, 3);c++;
	    
	    gridPane.add((new Label("Total time")), 0, 5);c++;
	    int four = performThreadFour();
	    gridPane.add((new Label(String.valueOf(four))), 1, 5);c++;
	    
	    gridPane.add((new Label("Total time")), 0, 7);c++;
	    int eight = performThreadEight();
	    gridPane.add((new Label(String.valueOf(eight))), 1, 7);c++;
		
	}
	
	public int performThreadOne() throws InterruptedException {
		long timeStart  = System.nanoTime();
		MultithreadUnit unit = new MultithreadUnit(matrix1, matrix2,matrixSize,matrixSize, 0);
		unit.start();
		unit.join();
		long duration = (System.nanoTime() - timeStart)/1000000;
		System.out.println(">>>>>>>>>> TOTAL TIME THREAD ONE: " +duration );
		return (int) duration;
	}
	public int performThreadTwo() throws InterruptedException{
		long timeStart  = System.nanoTime();
		int[][] matrix1a = new int[matrixSize/2][matrixSize];
		int[][] matrix1b = new int[matrixSize/2][matrixSize];
		int[][] matrix2a = new int[matrixSize/2][matrixSize];
		int[][] matrix2b = new int[matrixSize/2][matrixSize];
		for(int i = 0; i < matrixSize/2;i++) {
			for(int e = 0; e< matrixSize;e++) {
				matrix1a[i][e] = matrix1[i][e];
				matrix1b[i][e] = matrix1[i+(matrixSize/2)][e];
			}
		}
		for(int i = 0; i < matrixSize/2;i++) {
			for(int e = 0; e< matrixSize;e++) {
				matrix2a[i][e] = matrix2[i][e];
				matrix2b[i][e] = matrix2[i+(matrixSize/2)][e];
			}
		}
		MultithreadUnit unit0 = new MultithreadUnit(matrix1a, matrix2a,matrixSize,(matrixSize/2), 1);			
		MultithreadUnit unit1 = new MultithreadUnit(matrix1b, matrix2b,matrixSize,(matrixSize/2), 2);
		unit0.start();
		unit1.start();
		unit0.join();
		unit1.join();
		long duration = (System.nanoTime() - timeStart)/1000000;
		System.out.println(">>>> TOTAL TIME THREAD TWO: " +duration );
		return (int) duration;
	}
	public int performThreadFour() throws InterruptedException{
		long timeStart  = System.nanoTime();
		int halfsize = matrixSize/2;
		int[][] matrix1a = new int[halfsize][halfsize];
		int[][] matrix1b = new int[halfsize][halfsize];
		int[][] matrix1c = new int[halfsize][halfsize];
		int[][] matrix1d = new int[halfsize][halfsize];
		
		int[][] matrix2a = new int[halfsize][halfsize];
		int[][] matrix2b = new int[halfsize][halfsize];
		int[][] matrix2c = new int[halfsize][halfsize];
		int[][] matrix2d = new int[halfsize][halfsize];
		
		for(int i = 0; i < halfsize;i++) {
			for(int e = 0; e< halfsize;e++) {
				matrix1a[i][e] = matrix1[i][e];
				matrix1b[i][e] = matrix1[i+(halfsize)][e];
				matrix1c[i][e] = matrix1[i][e+(halfsize)];
				matrix1d[i][e] = matrix1[i+(halfsize)][e+(halfsize)];
			}
		}
		for(int i = 0; i < halfsize;i++) {
			for(int e = 0; e< halfsize;e++) {
				matrix2a[i][e] = matrix2[i][e];
				matrix2b[i][e] = matrix2[i+halfsize][e];
				matrix2c[i][e] = matrix2[i][e+(halfsize)];
				matrix2d[i][e] = matrix2[i+(halfsize)][e+(halfsize)];
			}
		}
		MultithreadUnit unit0 = new MultithreadUnit(matrix1a, matrix2a,(halfsize),(halfsize), 1);
		MultithreadUnit unit1 = new MultithreadUnit(matrix1b, matrix2b,(halfsize),(halfsize), 2);
		MultithreadUnit unit2 = new MultithreadUnit(matrix1c, matrix2c,(halfsize),(halfsize), 3);
		MultithreadUnit unit3 = new MultithreadUnit(matrix1d, matrix2d,(halfsize),(halfsize), 4);
		
		unit0.start();
		unit1.start();
		unit2.start();
		unit3.start();
		
		unit0.join();
		unit1.join();
		unit2.join();
		unit3.join();
		long duration = (System.nanoTime() - timeStart)/1000000;
		System.out.println(">>>> TOTAL TIME THREAD FOUR: " +duration );
		return (int) duration;
	}
	public int performThreadEight() throws InterruptedException{
		long timeStart  = System.nanoTime();
		int halfsize = matrixSize/2;
		int cuadSize = matrixSize/4;
		int[][] matrix1a = new int[cuadSize][halfsize];
		int[][] matrix1b = new int[cuadSize][halfsize];
		int[][] matrix1c = new int[cuadSize][halfsize];
		int[][] matrix1d = new int[cuadSize][halfsize];
		int[][] matrix1e = new int[cuadSize][halfsize];
		int[][] matrix1f = new int[cuadSize][halfsize];
		int[][] matrix1g = new int[cuadSize][halfsize];
		int[][] matrix1h = new int[cuadSize][halfsize];
		
		int[][] matrix2a = new int[cuadSize][halfsize];
		int[][] matrix2b = new int[cuadSize][halfsize];
		int[][] matrix2c = new int[cuadSize][halfsize];
		int[][] matrix2d = new int[cuadSize][halfsize];
		int[][] matrix2e = new int[cuadSize][halfsize];
		int[][] matrix2f = new int[cuadSize][halfsize];
		int[][] matrix2g = new int[cuadSize][halfsize];
		int[][] matrix2h = new int[cuadSize][halfsize];
		
		for(int i = 0; i < cuadSize;i++) {
			for(int e = 0; e< halfsize;e++) {
				matrix1a[i][e] = matrix1[i][e];
				matrix1b[i][e] = matrix1[i+cuadSize][e];
				matrix1c[i][e] = matrix1[i+(halfsize)][e];
				matrix1d[i][e] = matrix1[i+(halfsize+cuadSize)][e];
				matrix1e[i][e] = matrix1[i][e+(halfsize)];
				matrix1f[i][e] = matrix1[i+cuadSize][e+(halfsize)];
				matrix1g[i][e] = matrix1[i+(halfsize)][e+(halfsize)];
				matrix1h[i][e] = matrix1[i+(halfsize+cuadSize)][e+(halfsize)];
			}
		}

		for(int i = 0; i < cuadSize;i++) {
			for(int e = 0; e< halfsize;e++) {
				matrix2a[i][e] = matrix2[i][e];
				matrix2b[i][e] = matrix2[i+cuadSize][e];
				matrix2c[i][e] = matrix2[i+(halfsize)][e];
				matrix2d[i][e] = matrix2[i+(halfsize+cuadSize)][e];
				matrix2e[i][e] = matrix2[i][e+(halfsize)];
				matrix2f[i][e] = matrix2[i+cuadSize][e+(halfsize)];
				matrix2g[i][e] = matrix2[i+(halfsize)][e+(halfsize)];
				matrix2h[i][e] = matrix2[i+(halfsize+cuadSize)][e+(halfsize)];
			}
		}
		MultithreadUnit unit0 = new MultithreadUnit(matrix1a, matrix2a,(halfsize),(cuadSize), 1);
		MultithreadUnit unit1 = new MultithreadUnit(matrix1b, matrix2b,(halfsize),(cuadSize), 2);
		MultithreadUnit unit2 = new MultithreadUnit(matrix1c, matrix2c,(halfsize),(cuadSize), 3);
		MultithreadUnit unit3 = new MultithreadUnit(matrix1d, matrix2d,(halfsize),(cuadSize), 4);
		MultithreadUnit unit4 = new MultithreadUnit(matrix1e, matrix2e,(halfsize),(cuadSize), 5);
		MultithreadUnit unit5 = new MultithreadUnit(matrix1f, matrix2f,(halfsize),(cuadSize), 6);
		MultithreadUnit unit6 = new MultithreadUnit(matrix1g, matrix2g,(halfsize),(cuadSize), 7);
		MultithreadUnit unit7 = new MultithreadUnit(matrix1h, matrix2h,(halfsize),(cuadSize), 8);
		
		unit0.start();
		unit1.start();
		unit2.start();
		unit3.start();
		unit4.start();
		unit5.start();
		unit6.start();
		unit7.start();
		
		unit0.join();
		unit1.join();
		unit2.join();
		unit3.join();
		unit4.join();
		unit5.join();
		unit6.join();
		unit7.join();
		long duration = (System.nanoTime() - timeStart)/1000000;
		System.out.println(">>>> TOTAL TIME THREAD EIGHT: " +duration );
		return (int) duration;
	}
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}
}
