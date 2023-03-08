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

public abstract class Shape implements Serializable{

	String fillcolor = "white";
	Boolean isfilled;
	final Double defaultSize = 1.0;
	final Double maxsize = 100.0;
	
	public Shape() { // no argument constructor 
		isfilled = false;
	}

	protected Shape(String color, boolean filled) {
		fillcolor = color;
		isfilled = filled;
	}
	
	//getters and setters
	public void setFillcolor(String color) {
		fillcolor = color;
	}
	public void setIsfilled(Boolean filled) {
		isfilled = filled;
	}
	public String getFillcolor() {
		return this.fillcolor;
	}
	public Boolean getIsfilled() {
		return this.isfilled;
	}
	
	abstract Double getArea();
	
	abstract Double getPerimeter(); 
	
	Boolean equal(Shape objA) {
		Boolean result = false;
		if(objA.fillcolor.equals(this.fillcolor) && objA.isfilled == this.isfilled  ) { 
			result  = true;
		}
		return result;
	}
	public String toString() {
		String result = "";
		String cl  = "The color of this shape is: " + this.fillcolor  + "\n";
		String fill  = "";
		if(this.isfilled) {
			fill = "This shape is filled\n";
		}else{
			fill = "This shape is not filled\n";
		}
		result  = cl + fill;
		return result;
	}
	
	abstract void incSize(int percentage)  throws InvalidShapeSizeException;
	abstract void decSize(int percentage)  throws InvalidShapeSizeException;
}
