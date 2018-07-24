package vehicles;

import others.*;
import inOut.*;

/**
 * This class is subclass of Car class.This was generated from Car class.
 * @author Nehil
 *
 */


public class ElectricCar extends Car{
	
	private int batteryCapacity;
	
Methods kontrol=new Methods();
	
	@Override
	
	/**
	 * This method is used to change our values into string.
	 */
	
	public String toString() {
		return "Type = "+getType()+""+System.lineSeparator()+"Model = "+getModel()+""+System.lineSeparator()+
				"Age = "+getAge()+""+System.lineSeparator()+"Battery Capacity = "+batteryCapacity+""+System.lineSeparator()+
				"Number Of Doors = "+getNumberOfDoors()+""+System.lineSeparator()+"Price = "+getPrice()+""+System.lineSeparator()+System.lineSeparator();
	}

	/**
	 * This is the constructor of Electric Car class.
	 * @param parcala This is a array that contains all element of line that was read.
	 * @param x this is the lenght of an array(parcala).
	 */
	
	public ElectricCar(String []parcala,int x){
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
				setBatteryCapacity(parcala,i);
			}
		}
	}
	
	/**
	 * This is a getter to get the value of battery capacity.
	 * @return This is the value of battery capacity.
	 */

	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	
	/**
	 * This is a setter to set the value of battery capacity.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of battery capacity in our array.
	 */

	public void setBatteryCapacity(String [] parcala,int x) {
		this.batteryCapacity=Integer.parseInt(parcala[x]);
	}
}
