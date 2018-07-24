package inOut;

import java.io.*;

public class Output {
	
	public void writeOutput(String text,String outputFile){
		try{
				File fOut = new File(outputFile);
		        FileWriter writer = new FileWriter(fOut,true);
		        BufferedWriter write = new BufferedWriter(writer);
		        write.write(text);//This line will write the text that was sent to this method to the output.
		        write.close();
			
		}
		catch(Exception error){
			System.out.println("Error writeFile:"+error.getMessage());
		}
	}

}
