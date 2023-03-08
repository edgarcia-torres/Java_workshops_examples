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

public class Trapezoid extends Shape {
	
	private Double baseA = 1.0;
	private Double baseB = 1.0;
	private Double height = 1.0;
	private Double legA = 1.0;
	private Double legB = 1.0;
	

	public Trapezoid() {
		
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
		Util.displayMsg("Write base A");
		baseA = Util.getDouble();
		Util.displayMsg("Write base B");
		baseB= Util.getDouble();
		Util.displayMsg("Write height");
		height= Util.getDouble();
		Util.displayMsg("Write leg A");
		legA= Util.getDouble();
		Util.displayMsg("Write leg B");
		legB= Util.getDouble();
		Util.displayMsg("**************************************");
		
	}

	public Trapezoid(Double ba, Double bb, Double h, Double le, Double la, String color, boolean filled) {
		super(color, filled);

		baseA = ba;
		baseB = bb;
		height = h;
		legA = le;
		legB = la;
	
	}
	
	public Double getBaseA () {
		return baseA;
	}
	public Double getBaseB () {
		return baseB;
	}
	public Double getHeight() {
		return height;
	}
	public Double getLegA () {
		return legA;
	}
	public Double getLegB () {
		return legB;
	}
	
	//----------SET-----
	
	public void setBaseA (Double x) {
		 baseA = x;
	}
	public void setBaseB (Double x) {
		baseB= x;
	}
	public void setHeight(Double x) {
		height= x;
	}
	public void setLegA (Double x) {
		legA= x;
	}
	public void setLegB (Double x) {
		legB= x;
	}
	
	// ----METHODS-----

	@Override
	Double getArea() {
		Double Area= (baseA + baseB) * height /2;
		return Area;
	}

	@Override
	Double getPerimeter() {
		Double perimeter= baseA+baseB+legA+legB;
		return perimeter;
	}
	
	@Override
	 Boolean equal(Shape objA) {
		Boolean result  = false;
		Boolean shape  = false;
		Boolean trap = false; 
		if(super.equal(objA))shape  = true;
		
		if(objA instanceof Trapezoid) {
			Trapezoid obj = (Trapezoid)objA; // casting to obtain trapezoid attributes		
			if(obj.baseA.equals(this.baseA)  && obj.baseB.equals(this.baseB) &&  obj.height.equals(this.height) &&  obj.legA.equals(this.legA)&&  obj.legB.equals(this.legB) ) {
				trap = true;
			}
		}
		if (trap && shape) 	result = true;

		return result;
	}
	
	 public String toString() {
		String wrap = "\n=====================================\n";
		String parent  = super.toString();
		
		String trap = "This is a Trapezoid" 
				+ "\ninferior base lenght is: "+ baseA + 
				"\nSuperior base lentgh is: "+ baseB+
				"\nHeight is :" + height  + 
				"\nLeg a is :" + legA+ 
				"\nLeg b is :" + legB  ; 

		String result  =  wrap + parent + trap + wrap;
		return result; 
	}
	
	
	 void incSize(int percentage) throws InvalidShapeSizeException {
		 if(percentage  > 100 || percentage < 0) {
			 throw new InvalidShapeSizeException("Size increment not valid, enter a value between 0 and " + maxsize);
		 }else {
			 baseA = baseA + (baseA * percentage) / 100; 
			 baseB = baseB + (baseB * percentage) / 100; 
			 height = height + (height * percentage) / 100; 
		 }
	 }
	 void decSize(int percentage) throws InvalidShapeSizeException {
		 if(percentage  > maxsize || percentage < 0) {
			 throw new InvalidShapeSizeException("Size decrement not valid, enter a value between 0 and " + maxsize);
		 }else {
			 baseA = baseA - (baseA * percentage) / 100; 
			 baseB = baseB - (baseB * percentage) / 100; 
			 height = height - (height * percentage) / 100; 
			 
		 }
		 
	 }
	

}
