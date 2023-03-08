package interfaceWeather;

import java.io.IOException;
import java.rmi.RemoteException;

public  class WeatherImpl implements WeatherInt{
		
	//include the method definitions 
	public String[] retrieveWeather(String day){
		System.out.println("RECEVID RFOM APP :    " + day);
		String data [][] = null;
		String response[] = null;
		//retrieve information form file ==> location, date/time, temperature, Weather
		 try {
			fileInformation file = new fileInformation();
			data = file.getInfo();
		} catch (IOException e) {e.printStackTrace();
		}

		if(day.equals("Monday")) {
			System.out.println("YOU CHOSE MONDAY ");
			response = data[0];
		}
		if(day.equals("uesday")) {	
			System.out.println("YOU CHOSE TUESDAY ");
			response = data[1];
		}
		if(day.equals("Wednesday")) {	
			System.out.println("YOU CHOSE WEDNESDAY ");
			response = data[2];

		}
		if(day.equals("Thursday")) {	
			response = data[3];

			}
		if(day.equals("Friday")) {	
			response = data[4];

		}
		if(day.equals("turday")) {	
			response = data[5];
			System.out.println("YOU CHOSE SATURDAY ");

		}
		if(day.equals("Sunday")) {			
			response = data[6];
			System.out.println("YOU CHOSE SUNDAY ");

		}
		System.out.println("INSIDE IMPLEMENTATIONS");

		return response;
		
	}

	public WeatherImpl() {

	}

}
