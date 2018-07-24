package item;

import java.util.*;

public class Route {
	private String id;
	private String year_of_establishment;
	private ArrayList<String> bus_stop_id=new ArrayList <String>();
	public static int counterRoute=0;//We will use this in the add_method class.To take the number of elements that is registered.
	
	public Route [] routes=new Route[100];//We will use this array to take the element before add the it to the arraylist
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYear_of_establishment() {
		return year_of_establishment;
	}

	public void setYear_of_establishment(String year_of_establishment) {
		this.year_of_establishment = year_of_establishment;
	}

	public ArrayList<String> getBus_stop_id() {
		 return new ArrayList<>(bus_stop_id);
	}

	public void setBus_stop_id(ArrayList<String> bus_stop_id) {
		this.bus_stop_id.addAll(bus_stop_id);
	}
	
	
}
