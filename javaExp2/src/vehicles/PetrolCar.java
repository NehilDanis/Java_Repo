package vehicles;

import others.*;
import inOut.*;

/**
 * This class is subclass of Car class.This was generated from Car class.
 * @author Nehil
 *
 */

public class PetrolCar extends Car{
	
	private int fuelCapacity;
	
	@Override
	
	/**
	 * This method is used to change our values into string.
	 */
	
	
	public String toString() {
		return "Type = "+getType()+""+"\r\n"+"Model = "+getModel()+""+System.lineSeparator()+
				"Age = "+getAge()+""+System.lineSeparator()+"Fuel Capacity = "+fuelCapacity+""+System.lineSeparator()+
				"Number Of Doors = "+getNumberOfDoors()+""+System.lineSeparator()+"Price = "+getPrice()+""+System.lineSeparator()+System.lineSeparator();
		
		
	}
	
	/**
	 * This is the constructor of Petrol Car class.
	 * @param parcala This is a array that contains all element of line that was read.
	 * @param x this is the lenght of an array(parcala).
	 */

	public PetrolCar(String [] parcala,int x){
			
			for(int i=0;i<x;i++){
				if(i==0){
					super.setType(parcala, i);
				}
				else if(i==1){
					super.setAge(parcala,i);
				}
				else if(i==2){
					super.setModel(parcala,i);
				}
				else if(i==3){
					super.setPrice(parcala,i);
				}
				else if(i==4){
					super.setNumberOfDoors(parcala, i);
				}
				else if(i==5){
					setFuelCapacity(parcala,i);
				}
			}
			
		
	}
	
	/**
	 * This is a setter to set the value of fuel capacity.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of battery capacity in our array.
	 */


	public void setFuelCapacity(String [] parcala,int x) {
		this.fuelCapacity=Integer.parseInt(parcala[x]);
	}

	/**
	 * This is a getter to get the value of fuel capacity.
	 * @return This is the value of fuel capacity.
	 */
	
	public int getFuelCapacity() {
		return fuelCapacity;
	}

}
