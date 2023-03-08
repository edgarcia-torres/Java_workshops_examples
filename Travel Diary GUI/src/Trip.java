import java.time.LocalDate;
import java.util.LinkedList;

public class Trip {
	String Country;
	LocalDate date;
	LinkedList<City> citiesList  = new LinkedList<City>(); //collection cities
	

	public Trip() {
		// TODO Auto-generated constructor stub
	}
	public void  addCity(City newCity) {
		citiesList.add(newCity);
	}
	public void setTrip(String country, LocalDate date ) {
		this.Country = country;
		this.date = date;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
