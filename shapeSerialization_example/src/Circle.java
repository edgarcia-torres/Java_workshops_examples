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

import java.util.Scanner;
public class Circle extends Shape {
	
	private Double radio = 1.0;
	

	public Circle() {
		
		boolean resolved = false;
		String response = "";
		Scanner input = new Scanner(System.in);
		
		Util.displayMsg("**************CREATE CIRCLE***********");
		Util.displayMsg("Write the color");
		fillcolor = Util.getString();
		while(!resolved) {
			Util.displayMsg("is the shape filled? yes or no ");
			 response = input.next();
			if (response.equals("yes") || response.equals("no")) {
				resolved = true;
			}
			if (response.equals("yes") ) {
				isfilled = true;
			}
			if (response.equals("no") ) {
				isfilled = false;
			}
		}
		Util.displayMsg("Write th radius");
		radio = Util.getDouble();
		Util.displayMsg("**************************************");
	}

	public Circle(String color, boolean filled, Double radio) {
		super(color, filled);
		this.radio = radio;

	}
	// ----GET AND SET METHODS --- 
	public Double getRadio() {
		return this.radio;
	} 
	public void setRadio(Double radio) {
		this.radio = radio;
	}
	
	//---METHODS---

	@Override
	Double getArea() {
		Double area  = radio * radio * Math.PI;
		return area;
	}

	@Override
	Double getPerimeter() {
		Double perimeter = 2 * Math.PI * radio;
		return perimeter;
	}

	@Override
	 Boolean equal(Shape objA) {
		Boolean result  = false;
		Boolean shape  = false;
		Boolean circ = false; 
		if(super.equal(objA)) shape  = true;

		if(objA instanceof Circle) {
			Circle obj = (Circle)objA; // casting to obtain circle properties	
			if((obj.getRadio() - this.getRadio())==0) circ = true;
		}
		
		if (circ && shape)	result = true;
		return result;
	}
	
	 public String toString() {
		String wrap = "=====================================\n";
		String parent  = super.toString();
		
		String result  = "\n"+ wrap + parent + "The radio of this Cirle is: "+ radio + "\n"+ wrap;
		return result; 
	}
	 @Override
	public void incSize(int percentage) throws InvalidShapeSizeException {
		 if(percentage  > 100 || percentage < 0) {
			 throw new InvalidShapeSizeException("Size increment not valid, enter a value between 0 and" + maxsize);
		 }else {
			 radio = radio + (radio * percentage) / 100; 
		 }
	 }
	 @Override
	public void decSize(int percentage) throws InvalidShapeSizeException {
		 if(percentage  > 100 || percentage < 0) {
			 throw new InvalidShapeSizeException("Size decrement not valid, enter a value between 0 and" + maxsize);
		 }else {
			 radio = radio - (radio * percentage) / 100; 
		 }
		 
	 }
	

}
