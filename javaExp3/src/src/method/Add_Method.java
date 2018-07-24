package method;

import java.util.*;

import inOut.Output;
import item.*;
import data.*;

public class Add_Method {
	Output out=new Output();
	Bus value=new Bus();
	Driver valueD=new Driver();
	Route valueR=new Route();
	Service valueS=new Service();
	Bus_Stop valueB=new Bus_Stop();
	Database value1=new Oracle();
	Database value2=new MySQL();
	Database value3=new PostgreSQL();

	public void bus(String [] splittedArray,String databaseWord,String outputFile){
		//All elements in the splittedArray is registered to the array to send to the insert method. 
		value.buses[value.counter]=new Bus();
		value.buses[value.counter].setId(splittedArray[0]);
		value.buses[value.counter].setPlate(splittedArray[1]);
		value.buses[value.counter].setBrand(splittedArray[2]);
		value.buses[value.counter].setModel(splittedArray[3]);
		value.buses[value.counter].setYear_of_manufacture(splittedArray[4]);
		if(databaseWord.equals("Oracle")){
			value1.insert(value.buses[value.counter],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("MySQL")){
			value2.insert(value.buses[value.counter],outputFile);//The code send the array then insert method.
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			value3.insert(value.buses[value.counter],outputFile);//The code send the array then insert method.
		}

		value.counter++;
	}
	
	public void driver(String [] splittedArray,String databaseWord,String outputFile){
		//All elements in the splittedArray is registered to the array to send to the insert method. 
		valueD.drivers[valueD.counterDriver]=new Driver();
		valueD.drivers[valueD.counterDriver].setId(splittedArray[0]);
		valueD.drivers[valueD.counterDriver].setName(splittedArray[1]);
		valueD.drivers[valueD.counterDriver].setSurname(splittedArray[2]);
		valueD.drivers[valueD.counterDriver].setBirthdate(splittedArray[3]);
		valueD.drivers[valueD.counterDriver].setPhoneNumber(splittedArray[4]);
		
		if(databaseWord.equals("Oracle")){
			value1.insert(valueD.drivers[valueD.counterDriver],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("MySQL")){
			value2.insert(valueD.drivers[valueD.counterDriver],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("PostgreSQL")){
			value3.insert(valueD.drivers[valueD.counterDriver],outputFile);//The code send the array then insert method.
		}
		valueD.counterDriver++;
		
	}
	
	public void busStop(String [] splittedArray,String databaseWord,String outputFile){
		//All elements in the splittedArray is registered to the array to send to the insert method. 
		valueB.busStops[valueB.counterBusStop]=new Bus_Stop();
		valueB.busStops[valueB.counterBusStop].setId(splittedArray[0]);
		valueB.busStops[valueB.counterBusStop].setName(splittedArray[1]);
		valueB.busStops[valueB.counterBusStop].setLocation(splittedArray[2]);
		valueB.busStops[valueB.counterBusStop].setCapacity(splittedArray[3]);
		
		if(databaseWord.equals("Oracle")){
			value1.insert(valueB.busStops[valueB.counterBusStop],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("MySQL")){
			value2.insert(valueB.busStops[valueB.counterBusStop],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("PostgreSQL")){
			value3.insert(valueB.busStops[valueB.counterBusStop],outputFile);//The code send the array then insert method.
		}
		valueB.counterBusStop++;
		
	}
	
	public void service(String [] splittedArray,String databaseWord,String outputFile){
		//All elements in the splittedArray is registered to the array to send to the insert method. 
		valueS.services[valueS.counterService]=new Service();
		valueS.services[valueS.counterService].setId(splittedArray[0]);
		valueS.services[valueS.counterService].setTime_of_departure(splittedArray[1]);
		valueS.services[valueS.counterService].setRoute_id(splittedArray[2]);
		valueS.services[valueS.counterService].setBus_id(splittedArray[3]);
		valueS.services[valueS.counterService].setDriver_id(splittedArray[4]);

		
		if(databaseWord.equals("Oracle")){
			value1.insert(valueS.services[valueS.counterService],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("MySQL")){
			value2.insert(valueS.services[valueS.counterService],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("PostgreSQL")){
			value3.insert(valueS.services[valueS.counterService],outputFile);//The code send the array then insert method.
		}
		valueS.counterService++;
		
	}
	
	public void route(String [] splittedArray,String databaseWord,String outputFile){
		//All elements in the splittedArray is registered to the array to send to the insert method. 
		ArrayList<String> bus_stop_id=new ArrayList <String>();//We don't know the number of bus stops in any route so we use arraylist.
		valueR.routes[valueR.counterRoute]=new Route();
		valueR.routes[valueR.counterRoute].setId(splittedArray[0]);
		valueR.routes[valueR.counterRoute].setYear_of_establishment(splittedArray[1]);
		for(int i=2;i<splittedArray.length;i++){
			bus_stop_id.add(splittedArray[i]);
		}
		valueR.routes[valueR.counterRoute].setBus_stop_id(bus_stop_id);
		if(databaseWord.equals("Oracle")){
			value1.insert(valueR.routes[valueR.counterRoute],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("MySQL")){
			value2.insert(valueR.routes[valueR.counterRoute],outputFile);//The code send the array then insert method.
		}
		else if(databaseWord.equals("PostgreSQL")){
			value3.insert(valueR.routes[valueR.counterRoute],outputFile);//The code send the array then insert method.
		}
		valueR.counterRoute++;
		
	}

}

	