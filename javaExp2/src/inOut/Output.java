package inOut;

import java.io.*;
import java.util.*;

import vehicles.*;
import others.*;
/**
 *  This class will help us to write the values to output file.
 * @author Nehil
 *
 */
public class Output {
	
	/**
	 * 	 When the main called this method,this method will implement the reading prompt.
	 * This method will write all elements of this array to the output file.
	 * @param arac This array described as a type of Vehicle.
	 * @param dosyaAdi file name
	 */
	
	public void dosyayaYaz(Vehicle [] arac,String dosyaAdi){
		Methods say=new Methods();
		   try{
		        File dosya = new File(dosyaAdi);
		        FileWriter yazici = new FileWriter(dosya,true);
		        BufferedWriter yaz = new BufferedWriter(yazici);
		        yaz.write("Number of vehicles that are sold : "+Methods.toplamSatilanAraba+System.lineSeparator());
	        	yaz.newLine();
		        for(int i=0;i<arac.length;i++){
		        	if(arac[i]!=null){
		        		yaz.write(arac[i].toString()+System.lineSeparator());
		        	}
		        }
		        if(Methods.toplamSatilanAraba==0){
		        	yaz.write("No vehicle that is sold."+System.lineSeparator());
		        	yaz.newLine();
		        }
		        
		        if(Methods.yeniToplam==null){
		        	yaz.write("Total amount of money : "+String.format("%s", 0.00));
		        }
		        
		        else{
		        	yaz.write("Total amount of money : "+String.format("%s", Methods.yeniToplam));
		        }
		        
		        yaz.newLine();
		        yaz.write("---------------------------------------------------");
		        yaz.newLine();
		        yaz.close();
		    }
		    catch (Exception hata){
		        hata.printStackTrace();
		    }
		
		
		
		
	}

}
