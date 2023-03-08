package interfaceWeather;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientConnection {

	public ClientConnection() {
		// TODO Auto-generated constructor stub
	}
	public static String[] doRequestToServer(String day)	{
		System.out.println("inside doRequest ds : "+ day);
		String response[] = {"nothing ","sorry","empty"};
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			WeatherInt stub = (WeatherInt)registry.lookup("Weather-Server");
			response  = stub.retrieveWeather(day);
			System.out.println(response);

	    }catch (Exception e) {System.err.println("Client exception: " + e.toString()); e.printStackTrace();} 
		
		System.out.println("inside doRequest ds : "+response[0] + " " + response[1] + " " + response[2] );
		return response;
		
	}	

}
