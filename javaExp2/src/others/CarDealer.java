package others;

import inOut.*;
import vehicles.*;

/**
 * This class generated to take whole constants.We generate our constants in here.
 * @author Nehil
 *
 */

public class CarDealer {
	
	public static final int MAX_NUMBER_OF_VEHICLE_THAT_CAN_BE_SOLD=10;
	public static final int MIN_VEHICLE_AGE=0;
	public static final int MAX_VEHICLE_AGE=20;
	
	/**
	 * This method is used to round double values.
	 * @param deger This is the value that we wanted to round.
	 * @return This is a string value.We will round the price and total amount of money in here.And return the new value of price and total amount of money.
	 */
		
		public static String yuvarla(double deger){
		    double roundOff =(double) Math.round(deger*100)/100;
		    String deger1=Double.toString(roundOff);
		    return deger1;
		}


}
