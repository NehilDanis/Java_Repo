package vehicles;

import others.*;
import inOut.*;

/**
 * This is a superclass of other classes.
 * @author Nehil
 *
 */

public class Vehicle {
	private String type;
	private String model;
	private String price;
	private int age;
	
	
	
	CarDealer a=new CarDealer();
	Methods b=new Methods();
	Methods kontrol=new Methods();
	
	
	/**
	 * This is a getter to get the value of type.
	 * @return This is the value of type.
	 */
	
	public String getType() {
		return type;
	}
	
	/**
	 * This is a setter to set the value of type.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of type in our array.
	 */
	
	public void setType(String [] parcala,int x) {
		this.type = parcala[x];
	}
	
	/**
	 * This is a getter to get the value of model.
	 * @return This is the value of model.
	 */
	
	public String getModel() {
		return model;
	}
	
	/**
	 * This is a setter to set the value of model.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of model in our array.
	 */
	
	public void setModel(String [] parcala,int x) {
		if(parcala[x].length()>15){
			this.model=parcala[x].substring(0, 15);
		}
		else {
			this.model =parcala[x];
		}
	}
	
	/**
	 * This is a getter to get the value of age.
	 * @return This is the value of age.
	 */
	
	public	int getAge() {
		return age;
	}
	
	/**
	 * This is a setter to set the value of age.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of age in our array.
	 */
	
	public void setAge(String [] parcala,int x) {
		
		int deger =Integer.parseInt(parcala[x]);
		this.age=kontrol.ageControl(deger);
	}
	
	/**
	 * This is a getter to get the value of price.
	 * @return This is the value of price.
	 */
	
	public String getPrice() {
		return price;
	}
	
	/**
	 * This is a setter to set the value of price.
	 * @param parcala This is an array that we took whole vehicles in here.
	 * @param x This represents the place of price in our array.
	 */
	
	public void setPrice(String [] parcala,int x) {
	
		double deger1 = Double.parseDouble(parcala[x]);
		deger1=deger1+deger1*b.vergiOrani/100;
		b.vergiOrani=0;
		b.toplam=b.toplam+deger1;
		b.yeniToplam=a.yuvarla(b.toplam);
		this.price=a.yuvarla(deger1);
		
	}

}
