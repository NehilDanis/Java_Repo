package method;

import java.util.*;

import inOut.*;
import item.*;
import data.*;

public class Control_Method {
	Output out=new Output();//This use for writing output.
	Oracle value1 = new Oracle();//These use for using the different database.
	MySQL value2 = new MySQL();
	PostgreSQL value3 = new PostgreSQL();
	Add_Method value = new Add_Method();

	public void checkBus(String[] splittedArray, String databaseWord,String outputFile) {
		if (databaseWord.equalsIgnoreCase("Oracle")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[3].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value1.control==1){
					out.writeOutput("ERROR\n", outputFile);
				}
			} else {
				value.bus(splittedArray, databaseWord,outputFile);
			}
		}

		else if (databaseWord.equalsIgnoreCase("MySQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")) {
				if(value2.control1==1){

					out.writeOutput("ERROR\n", outputFile);
				}
			} 
			else {
				value.bus(splittedArray, databaseWord,outputFile);
			}
		} 
		else if (databaseWord.equalsIgnoreCase("PostgreSQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value3.control2==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			} else {
				value.bus(splittedArray, databaseWord,outputFile);
			}
		}

	}

	public void checkDriver(String[] splittedArray, String databaseWord,String outputFile) {
		if (databaseWord.equalsIgnoreCase("Oracle")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value1.control==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
				
			} else {
				value.driver(splittedArray, databaseWord,outputFile);
			}

		} else if (databaseWord.equalsIgnoreCase("MySQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")) {
				if(value2.control1==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			} 
			else {
				value.driver(splittedArray, databaseWord,outputFile);
			}

		} 
		else if (databaseWord.equalsIgnoreCase("PostgreSQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value3.control2==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			} 
			else {
				value.driver(splittedArray, databaseWord,outputFile);
			}

		}

	}

	public void checkBus_Stop(String[] splittedArray, String databaseWord,String outputFile) {
		if (databaseWord.equalsIgnoreCase("Oracle")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[3].equals("-")) {
				if(value1.control==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			} else {
				value.busStop(splittedArray, databaseWord,outputFile);
			}

		} else if (databaseWord.equalsIgnoreCase("MySQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")) {
				if(value2.control1==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			}
			else {
				value.busStop(splittedArray, databaseWord,outputFile);
			}

		} 
		else if (databaseWord.equalsIgnoreCase("PostgreSQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[3].equals("-")) {
				if(value3.control2==1){

					out.writeOutput("ERROR\n", outputFile);
					
				}
				
			}
			else {
				value.busStop(splittedArray, databaseWord,outputFile);
			}

		}

	}

	public void checkRoute(String[] splittedArray, String databaseWord,String outputFile) {
		if (databaseWord.equalsIgnoreCase("Oracle")) {
			int a = 0;
			for (int i = 0; i < splittedArray.length; i++) {
				if (splittedArray[i].equals("-")) {
					a++;
				}
			}
			if (a == 0) {
				boolean x;
				x = controlRoute(splittedArray, databaseWord,outputFile);
				if (x == true) {
					value.route(splittedArray, databaseWord,outputFile);
				}
			} 
			else {
				if(value1.control==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			}

		} else if (databaseWord.equalsIgnoreCase("MySQL")) {
			int a = 0;
			if (splittedArray[0].equals("-")) {
				if(value2.control1==1){

					out.writeOutput("ERROR\n", outputFile);
				}
			
			} 
			else {
				for (int i = 2; i < splittedArray.length; i++) {
					if (splittedArray[i].equals("-")) {
						a++;
					}
				}
				if (a == 0) {
					boolean x;
					x = controlRoute(splittedArray, databaseWord,outputFile);
					if (x == true) {
						value.route(splittedArray, databaseWord,outputFile);
					}
				} 
				else {
					if(value2.control1==1){

						out.writeOutput("ERROR\n", outputFile);
					}
				
				}

			}

		} else if (databaseWord.equalsIgnoreCase("PostgreSQL")) {
			int a = 0;
			for (int i = 0; i < splittedArray.length; i++) {
				if (splittedArray[i].equals("-")) {
					a++;
				}
			}
			if (a == 0) {
				boolean x;
				x = controlRoute(splittedArray, databaseWord,outputFile);
				if (x == true) {
					value.route(splittedArray, databaseWord,outputFile);
				}
			} 
			else {
				if(value3.control2==1){

					out.writeOutput("ERROR\n", outputFile);
				}
			
			}
		}

	}

	public void checkService(String[] splittedArray, String databaseWord,String outputFile){
		if (databaseWord.equalsIgnoreCase("Oracle")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value1.control==1){

					out.writeOutput("ERROR\n", outputFile);
				}

				
			} else {
				Boolean x;
				x = controlService(splittedArray, databaseWord,outputFile);
				if (x == true) {
					value.service(splittedArray, databaseWord,outputFile);
				}
			}

		}
		else if (databaseWord.equalsIgnoreCase("MySQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value2.control1==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			}
			else {
				Boolean x;
				x = controlService(splittedArray, databaseWord,outputFile);
				if (x == true) {
					value.service(splittedArray, databaseWord,outputFile);
				}
			}

		} 
		else if (databaseWord.equalsIgnoreCase("PostgreSQL")) {
			if (splittedArray[0].equals("-") || splittedArray[1].equals("-")
					|| splittedArray[2].equals("-")
					|| splittedArray[3].equals("-")
					|| splittedArray[4].equals("-")) {
				if(value3.control2==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				
			} else {
				Boolean x;
				x = controlService(splittedArray, databaseWord,outputFile);
				if (x == true) {
					value.service(splittedArray, databaseWord,outputFile);
				}
			}

		}

	}

	public boolean controlService(String[] splittedArray, String databaseWord,String outputFile) {
		if (databaseWord.equals("Oracle")) {
			int a = 0, b = 0, c = 0;
			for (int k = 0; k < value1.routeData.size(); k++) {
				if(value1.routeData.get(k).getId().equals(splittedArray[2])){
					a++;
				}
			}
			for (int i = 0; i < value1.busData.size(); i++) {
				if(value1.busData.get(i).getId().equals(splittedArray[3])){
					b++;
				}
				
			}
			for (int m = 0; m < value1.driverData.size(); m++) {
				if(value1.driverData.get(m).getId().equals(splittedArray[4])){
					c++;
				}
			}
			if (a == 0 || b == 0 || c == 0) {
				if(value1.control==1){

					out.writeOutput("ERROR\n", outputFile);
				}
				return false;
			}
		} else if (databaseWord.equals("MySQL")) {
			int a = 0, b = 0, c = 0;
			for (int k = 0; k < value2.routeData.size(); k++) {
				if(value2.routeData.get(k).getId().equals(splittedArray[2])){
					a++;
				}
			}
			for (int i = 0; i < value2.busData.size(); i++) {
				if(value2.busData.get(i).getId().equals(splittedArray[3])){
					b++;
				}
			}
			for (int m = 0; m < value2.driverData.size(); m++) {
				if(value2.driverData.get(m).getId().equals(splittedArray[4])){
					c++;
				}
			}
			if (a == 0 || b == 0 || c == 0) {
				if (value2.control1==1) {

					out.writeOutput("ERROR\n", outputFile);
				}
				return false;
			}
		} else if (databaseWord.equals("PostgreSQL")) {
			int a = 0, b = 0, c = 0;
			for (int k = 0; k < value3.routeData.size(); k++) {
				if(value3.routeData.get(k).getId().equals(splittedArray[2])){
					a++;
				}
				
			}
			for (int i = 0; i < value3.busData.size(); i++) {
				if(value3.busData.get(i).getId().equals(splittedArray[3])){
					b++;
				}
			}
			for (int m = 0; m < value3.driverData.size(); m++) {
				if(value3.driverData.get(m).getId().equals(splittedArray[4])){
					c++;
				}
			}
			if (a == 0 || b == 0 || c == 0) {
				if (value3.control2==1) {

					out.writeOutput("ERROR\n", outputFile);
				}
				return false;
			}
		}
		return true;
	}

	public boolean controlRoute(String[] splittedArray, String databaseWord,String outputFile) {
		int a = 0, b = 0, c = 0;// her veri icin
		if (databaseWord.equals("Oracle")) {
			for (int i = 0; i < value1.busStopData.size(); i++) {
				for (int j = 2; j < splittedArray.length; j++) {
					if (value1.busStopData.get(i).getId()
							.equals(splittedArray[j])) {
						a++;
						break;
					}
				}
			}
			if (a == splittedArray.length - 2) {
				return true;
			}

		} else if (databaseWord.equals("MySQL")) {
			for (int i = 0; i < value2.busStopData.size(); i++) {
				for (int j = 2; j < splittedArray.length; j++) {
					if (value2.busStopData.get(i).getId()
							.equals(splittedArray[j])) {
						b++;
						break;
					}
				}
			}
			if (b == splittedArray.length - 2) {
				return true;
			}

			

		} else if (databaseWord.equals("PostgreSQL")) {
			for (int i = 0; i < value3.busStopData.size(); i++) {
				for (int j = 2; j < splittedArray.length; j++) {
					if (value3.busStopData.get(i).getId()
							.equals(splittedArray[j])) {
						c++;
						break;
					}
				}
			}
			if (c == splittedArray.length - 2) {
				return true;
			}
			
		}
		if(value1.control==1){

			out.writeOutput("ERROR\n", outputFile);
		}
		else if (value2.control1==1) {

			out.writeOutput("ERROR\n", outputFile);
		}
		else if (value3.control2==1) {

			out.writeOutput("ERROR\n", outputFile);
		}
		return false;
	}

}
