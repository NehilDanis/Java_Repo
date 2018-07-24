package item;



public class Bus {
	private String id;
	private String plate;
	private String brand;
	private String model;
	private String year_of_manufacture;
	public static int counter=0;//We will use this in the add_method class.To take the number of elements that is registered.

	
	public Bus [] buses=new Bus[100];//We will use this array to take the element before add the it to the arraylist
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getYear_of_manufacture() {
		return year_of_manufacture;
	}


	public void setYear_of_manufacture(String year_of_manufacture) {
		this.year_of_manufacture = year_of_manufacture;
	}

}
