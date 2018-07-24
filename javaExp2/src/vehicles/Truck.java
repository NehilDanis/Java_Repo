package vehicles;

import others.*;
import inOut.*;

/**
 * This class is subclass of commercial vehicle.
 * This was generated from commercial vehicle.
 * @author Nehil
 *
 */

public class Truck extends CommercialVehicle {
	
	private int tonnage;
	
	
	Methods kontrol=new Methods();
	Methods vergiOraniYolla=new Methods();
	
	

	@Override
	
	/**
	 * This method is used to change our values into string.
	 */
	
	public String toString() {
		return "Type = "+getType()+""+System.lineSeparator()+"Model = "+getModel()+""+System.lineSeparator()+
				"Age = "+getAge()+""+System.lineSeparator()+"Tonnage = "+tonnage+""+System.lineSeparator()+
				"Price = "+getPrice()+""+System.lineSeparator()+System.lineSeparator();
	}

	
	/**
	 * This is the constructor of Truck class.
	 * @param parcala This is a array that contains all element of line that was read.
	 * @param x this is the lenght of an array(parcala).
	 */

	public Truck(String [] parcala,int x){
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
				setTonnage(parcala,i);
			}
		}
	}

	
	/**
	 * This is a getter to get the value of tonnage.
	 * @return This is the value of tonnage for truck.
	 */
	
	public int getTonnage() {
		return tonnage;
	}

	/**
	 * This is a setter to set the value of tonnage.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of tonnage in our array.
	 */
	
	
	public void setTonnage(String [] parcala,int x) {
		this.tonnage =Integer.parseInt(parcala[x]);
	}


}
