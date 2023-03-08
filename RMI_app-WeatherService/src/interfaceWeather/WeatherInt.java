package interfaceWeather;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface WeatherInt extends Remote {
	
	//include the method declaration
	public String[] retrieveWeather(String day)throws RemoteException;
}

