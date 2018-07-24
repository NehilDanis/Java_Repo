package item;

public class Driver {
	private String id;
	private String name;
	private String surname;
	private String birthdate;
	private String phoneNumber;
	public static int counterDriver=0;//We will use this in the add_method class.To take the number of elements that is registered.
	
	public Driver [] drivers=new Driver[100];//We will use this array to take the element before add the it to the arraylist

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
