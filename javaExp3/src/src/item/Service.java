package item;

public class Service {

	private String id;
	private String time_of_departure;
	private String route_id;
	private String bus_id;
	private String driver_id;
	public static int counterService=0;//We will use this in the add_method class.To take the number of elements that is registered.
	
	public Service [] services=new Service[100];//We will use this array to take the element before add the it to the arraylist

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime_of_departure() {
		return time_of_departure;
	}

	public void setTime_of_departure(String time_of_departure) {
		this.time_of_departure = time_of_departure;
	}

	public String getRoute_id() {
		return route_id;
	}

	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}

	public String getBus_id() {
		return bus_id;
	}

	public void setBus_id(String bus_id) {
		this.bus_id = bus_id;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

}
