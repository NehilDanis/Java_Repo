package item;

public class Bus_Stop {
	
	private String id;
	private String name;
	private String location;
	private String capacity;
	public static int counterBusStop=0;//We will use this in the add_method class.To take the number of elements that is registered.
	
	public Bus_Stop [] busStops=new Bus_Stop[100];//We will use this array to take the element before add the it to the arraylist
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

}
