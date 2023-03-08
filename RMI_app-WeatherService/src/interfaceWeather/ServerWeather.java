package interfaceWeather;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

public class ServerWeather extends WeatherImpl{

	public ServerWeather() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException{
		try {
			WeatherImpl cal = new WeatherImpl();//create the object that we need o register

			WeatherInt stub = (WeatherInt) UnicastRemoteObject.exportObject(cal,0); //export the object and binds it to the calculator stub 
			Registry registry = LocateRegistry.getRegistry();
			
			registry.bind("Weather-Server", stub);
			System.err.println("Weather server ready"); 
		}catch (ExportException ex) { 
			 
	         System.err.println("Server exception: " + ex.toString()); 
	         ex.printStackTrace(); }
		catch (Exception e) { 
	         System.err.println("Server exception: " + e.toString()); 
	         e.printStackTrace(); }
	}

}