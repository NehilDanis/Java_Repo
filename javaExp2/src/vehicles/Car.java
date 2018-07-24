package vehicles;

import others.*;
import inOut.*;

/**
 * This class is subclass of vehicle.This was generated from vehicle.
 * @author Nehil
 *
 */

public class Car extends Vehicle {
	
	private int numberOfDoors;

	/**
	 * This is a getter to get the value of number of doors.
	 * @return This is the value of number of doors.
	 */
	
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	
	/**
	 * This is a setter to set the value of number of doors.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of number of doors in our array.
	 */

	public void setNumberOfDoors(String [] parcala ,int x) {
		this.numberOfDoors = Integer.parseInt(parcala[x]);
	}
	
}
