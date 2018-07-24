package vehicles;

import others.*;
import inOut.*;

/**
 * This class is subclass of commercial vehicle.
 * This was generated from commercial vehicle.
 * @author Nehil
 *
 */

public class Bus extends CommercialVehicle {
	
	private int capacity;
	
	Methods kontrol=new Methods();
	Methods vergiOraniYolla=new Methods();

	@Override
	
	/**
	 * This method is used to change our values into string.
	 */
	
	public String toString() {
		return "Type = "+getType()+""+System.lineSeparator()+"Model = "+getModel()+""+System.lineSeparator()+
				"Age = "+getAge()+""+System.lineSeparator()+"Capacity = "+capacity+""+System.lineSeparator()+
				"Price = "+getPrice()+""+System.lineSeparator()+System.lineSeparator();
		
		
	}
	
	/**
	 * This is the constructor of Bus class.
	 * @param parcala This is a array that contains all element of line that was read.
	 * @param x this is the lenght of an array(parcala).
	 */

	public Bus(String [] parcala,int x){
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
				vergiOraniYolla.vergiOrani=Double.parseDouble(parcala[4]);
				super.setPrice(parcala,i);
			}
			else if(i==4){
				super.setTaxRate(parcala, i);
			}
			else if(i==5){
				setCapacity(parcala,i);
			}
		}
		
	}

	
	/**
	 * This is a getter to get the value of capacity.
	 * @return This is the value of capacity for bus.
	 */

	public int getCapacity() {
		return capacity;
	}

	/**
	 *  This is a setter to set the value of capacity.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of capacity in our array.
	 */
	
	public void setCapacity(String [] parcala,int x) {
		this.capacity=Integer.parseInt(parcala[x]);
	}

}
