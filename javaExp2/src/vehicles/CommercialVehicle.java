package vehicles;

import inOut.*;
import others.*;

/**
 *  This class is subclass of vehicle.This was generated from vehicle.
 * @author Nehil
 *
 */

public class CommercialVehicle extends Vehicle {
		private double taxRate;
		
		/**
		 * This is a getter to get the value of tax rate.
		 * @return  This is the value of tax rate.
		 */
		
		public double getTaxRate() {
			return taxRate;
		}
		
		/**
		 * This is a setter to set the value of tax rate.
		 * @param parcala This is an array that we took whole vehicles in here.
		 * @param x This represents the place of tax rate in our array.
		 */

		public void setTaxRate(String [] parcala,int x) {
			this.taxRate = Double.parseDouble(parcala[x]);
		}
		
		
}
