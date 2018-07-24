

import others.Methods;
import inOut.*;
import vehicles.*;
import java.io.*;

/**
 * This is the main class.This includes the main method.
 * @author Nehil
 *
 */

public class Main {
	
	/**
	 * Everything starts here.We will call our dosyaOku method in here.
	 * @param args Gets arguments.
	 */

	public static void main(String[] args) {
		Input a=new Input();
		Methods dizi=new Methods();
		a.dosyaOku(args[0],args[1]);
	}

}
