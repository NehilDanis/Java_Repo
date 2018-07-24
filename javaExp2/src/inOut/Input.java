package inOut;

import others.*;
import vehicles.*;
import java.util.*;
import java.io.*;
/**
 * This class will help us to read the values from input file.
 * @author Nehil
 * 
 *
 */
public class Input {
	
	/**
	 * When the main called this method,this method will implement the reading prompt.
	 * We can only read 10 cars from our file.
	 */
	
	public void dosyaOku(String okuma,String yazma){
		Output b=new Output();
		CarDealer say=new CarDealer();
		Methods metod=new Methods();
		File f=new File(okuma);
		String read=null;
		int satirSayisi=0;
		try{
			Scanner s=new Scanner(f);
			while(s.hasNextLine()){
				if(satirSayisi<=say.MAX_NUMBER_OF_VEHICLE_THAT_CAN_BE_SOLD){
				
					
					if((read=s.nextLine()).equalsIgnoreCase("print")){
						b.dosyayaYaz(metod.arac,yazma);
						satirSayisi=0;
						metod.delete();
						metod.delete1(metod.arac);
						continue;
					}
					else{
					
						satirSayisi++;
						 String [] parcala=read.split("\\s+");
						
							if(parcala[0].equalsIgnoreCase("petrol")){
								int deger=0;
								metod.type(parcala, deger);
								
							}
							else if(parcala[0].equalsIgnoreCase("electric")){
								int deger=1;
								metod.type(parcala, deger);
								
							}
							else if(parcala[0].equalsIgnoreCase("bus")){
								int deger=2;
								metod.type(parcala, deger);
								
							}
							else if(parcala[0].equalsIgnoreCase("truck")){
								int deger=3;
								metod.type(parcala, deger);
								
							}
						
					}
					
				}
				
				else{
					System.err.println("Hata : 10 taneden fazla araba satilamaz lutfen dosyanizi kontrol ediniz!");
					 break;
				}
			}
			
			
		}
		catch(Exception hata){
			System.err.println("Hata dosya okuma : "+hata.getMessage());
		}
		
	}
	
}
