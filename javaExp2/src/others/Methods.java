package others;

import inOut.*;
import vehicles.*;

/**
 * All methods that the code have used are described in this class.
 * @author Nehil
 *
 */

public class Methods {

	public static int sayac1=0;
	public static double toplam=0;
	public static String yeniToplam=null;
	public static int toplamSatilanAraba=0;
	public static double vergiOrani=0;

	public Vehicle [] arac=new Vehicle[10];

	public Output b=new Output();
	
		CarDealer kontrol=new CarDealer();
		
		/**
		 * This method will control the value of age.
		 * @param deger The value that will be controlled.
		 * @return This is the value that controlled,maybe that changed if it is needed.
		 */
		
		public int ageControl(int deger){
			if(deger<kontrol.MIN_VEHICLE_AGE){
				deger=kontrol.MIN_VEHICLE_AGE;
			}
			else if(deger>kontrol.MAX_VEHICLE_AGE){
				deger=kontrol.MAX_VEHICLE_AGE;
			}
			return deger;
		}
		
		/**
		 * We will use pollymorphism in here.We will generate an element of array that is type of vehicle.
		 * According to the first element of the line that we read,we will generate an element.
		 * It's type can be PetrolCar,ElectricCar,Bus or Truck.
		 * @param parcala This contains the all elements of line that we read.
		 * @param deger It helps us to determine which type that we want to generate.
		 */
		

		public void type(String [] parcala,int deger){
			if(deger==0){
				arac[sayac1]=new PetrolCar(parcala,parcala.length);
				satilanAraba();
				sayac1++;
			}
			else if(deger==1){
				arac[sayac1]=new ElectricCar(parcala,parcala.length);
				satilanAraba();
				sayac1++;
			}
			else if(deger==2){
				arac[sayac1]=new Bus(parcala,parcala.length);
				satilanAraba();
				sayac1++;
			}
			else if(deger==3){
				arac[sayac1]=new Truck(parcala,parcala.length);
				satilanAraba();
				sayac1++;
			}
		}

		/**
		 * When the code is executed,if the line contains only print,this method will invoked.
		 * And delete whole values about last term.
		 */
		public void delete(){
			this.sayac1=0;
			yeniToplam=null;
			toplam=0;
			toplamSatilanAraba=0;
		}
		
		/**
		 *This method change the values of array elements.All values change to zero.
		 * @param arac This array contains the vehicles.
		 */
		
		public void delete1 (Vehicle [] arac){
			for(int i=0;i<arac.length;i++){
				arac[i]=null;
				
			}
		}
		
		/**
		 * It helps us to increase the value of cars that were sold.
		 */
		
		public void satilanAraba(){
			toplamSatilanAraba++;
			
		}
		
	
	
	
	
}
