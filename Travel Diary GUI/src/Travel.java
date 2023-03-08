import java.time.LocalDate;
import java.util.LinkedList;

public class Travel { //travel entries 
	
	LinkedList<Trip> tripList  = new LinkedList<Trip>(); //collection of trips ////trip contains different countries  
	String id; 
	String countryStart;
	String countryEnd;
	LocalDate dateStart;
	
	public void setTravel(String country, LocalDate date,String end) {
		this.countryStart = country;
		this.dateStart = date;
		this.countryEnd = end;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryStart() {
		return countryStart;
	}
	public void setCountryStart(String countryStart) {
		this.countryStart = countryStart;
	}
	public String getCountryEnd() {
		return countryEnd;
	}
	public void setCountryEnd(String countryEnd) {
		this.countryEnd = countryEnd;
	}
	public LocalDate getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	public Travel() {
		// TODO Auto-generated constructor stub
	}
	public void addTrip(Trip newtrip) {
		tripList.add(newtrip);
	}

}
