import inOut.*;
public class Main {

	public static void main(String[] args) {
		Input readObject=new Input();
		try{//The code send the input files to the read method in the input file.
			readObject.readInput(args[0], args[1],args[2], args[3], args[4],args[5],args[6]);
		}
		catch(Exception e){
			System.out.println("Hata : "+e.getMessage());
		}
		

	}

}
