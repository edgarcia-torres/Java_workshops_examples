/**********************************************
Workshop #5
Course:JAC444 - Semester4
Last Name:Garcia Torres
First Name:Edgar David
ID:104433206
Section:ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:10/07/2022
**********************************************/

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class Streaming implements Serializable{
	String id = "series1";
	
	public Streaming() {
		
	}
	public void addObject(Shape obj1, Shape obj2) throws IOException { // SERIALIZE 

		FileOutputStream fileOutC = new FileOutputStream("circle.ser");
		ObjectOutputStream outc = new ObjectOutputStream(fileOutC);

			outc.writeObject(obj1);
			Util.displayMsg("Circle Object saved");	
		outc.close();
		fileOutC.close();
		
		FileOutputStream fileOutT = new FileOutputStream("trapezoid.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOutT);

			out.writeObject(obj2);
			Util.displayMsg("Trapezoid Object saved");	
		out.close();
		fileOutT.close();
	}
	
	public void retrieveObject() throws IOException, ClassNotFoundException{   // DESERIALIZE 
		Shape shap= null;
		FileInputStream fileIn = new FileInputStream("C:\\Users\\Edgar Garcia\\eclipse-workspace\\Workshop4\\circle.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		shap = (Shape) in.readObject();
		in.close();
		fileIn.close();
		Util.displayMsg(shap.toString());
		
		
		Shape shapT= null;
		FileInputStream fileInT = new FileInputStream("C:\\Users\\Edgar Garcia\\eclipse-workspace\\Workshop4\\trapezoid.ser");
		ObjectInputStream inT = new ObjectInputStream(fileInT);
		shapT = (Shape) inT.readObject();
		inT.close();
		fileInT.close();
		Util.displayMsg(shapT.toString());
		
		
	}
	

}
