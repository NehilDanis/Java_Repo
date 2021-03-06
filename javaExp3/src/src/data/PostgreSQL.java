package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import item.Bus;
import item.Bus_Stop;
import item.Driver;
import item.Route;
import item.Service;
import inOut.*;

public class PostgreSQL extends Database { //This class inherited from database class.
	
public static int countPostgreSQL=0;//These counters will use to find the adding expression is implemented or not.
public static int countPostgreSQLDriver=0;
public static int countPostgreSQLBusStop=0;
public static int countPostgreSQLService=0;
public static int countPostgreSQLRoute=0;
public static int control2;//This is for the control method.

Output out=new Output();//We use this object to invoke ouput method.

	
	public static ArrayList<Bus> busData=new ArrayList<Bus>();//These are the arraylists to register the elements.
	public static ArrayList<Driver> driverData=new ArrayList<Driver>();
	public static ArrayList<Bus_Stop> busStopData=new ArrayList<Bus_Stop>();
	public static ArrayList<Route> routeData=new ArrayList<Route>();
	public static ArrayList<Service> serviceData=new ArrayList<Service>();
	
	public void insert(Bus element,String outputFile){//Insert method for bus elements
		for(int i=0;i<busData.size();i++){
			if(busData.get(i).getId().equals(element.getId())){
				countPostgreSQL++;
			}
		}
		if(busData.size()==0){
			busData.add(element);
			Collections.sort(busData,new Comparator<Bus>(){//This is for sorting.
				public int compare(Bus bus1,Bus bus2){
					return new Integer(Integer.parseInt(bus1.getId())).compareTo(Integer.parseInt(bus2.getId()));
				}
			});
		}
		else if(countPostgreSQL==0){
			if(control2==1){

				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			busData.add(element);
			Collections.sort(busData,new Comparator<Bus>(){//This is for sorting.
				public int compare(Bus bus1,Bus bus2){
					return new Integer(Integer.parseInt(bus1.getId())).compareTo(Integer.parseInt(bus2.getId()));
				}
			});
		}
		else{
			if(control2==1){

				out.writeOutput("ERROR\n", outputFile);
			}
			countPostgreSQL=0;
		}

	}
	
	public void insert(Driver element,String outputFile){//Insert method for driver elements
		for(int i=0;i<driverData.size();i++){
			if(driverData.get(i).getId().equals(element.getId())){
				countPostgreSQLDriver++;
			}
		}
		if(driverData.size()==0){
			driverData.add(element);
			Collections.sort(driverData,new Comparator<Driver>(){//This is for sorting.
				public int compare(Driver driver1,Driver driver2){
					return new Integer(Integer.parseInt(driver1.getId())).compareTo(Integer.parseInt(driver2.getId()));
				}
			});
		
			
		}
		else if(countPostgreSQLDriver==0){
			if(control2==1){

				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			driverData.add(element);
			Collections.sort(driverData,new Comparator<Driver>(){//This is for sorting.
				public int compare(Driver driver1,Driver driver2){
					return new Integer(Integer.parseInt(driver1.getId())).compareTo(Integer.parseInt(driver2.getId()));
				}
			});
		}
		else{
			if(control2==1){

				out.writeOutput("ERROR\n", outputFile);
			}
			countPostgreSQLDriver=0;
		}

	}
	
	public  void insert(Bus_Stop element,String outputFile){//Insert method for bus stop elements
		
		for(int i=0;i<busStopData.size();i++){
			if(busStopData.get(i).getId().equals(element.getId())){
				countPostgreSQLBusStop++;
			}
		}
		if(busStopData.size()==0){
			busStopData.add(element);
			Collections.sort(busStopData,new Comparator<Bus_Stop>(){//This is for sorting.
				public int compare(Bus_Stop busStop1,Bus_Stop busStop2){
					return new Integer(Integer.parseInt(busStop1.getId())).compareTo(Integer.parseInt(busStop2.getId()));
				}
			});
		}
		else if(countPostgreSQLBusStop==0){
			if(control2==1){

				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			busStopData.add(element);
			Collections.sort(busStopData,new Comparator<Bus_Stop>(){//This is for sorting.
				public int compare(Bus_Stop busStop1,Bus_Stop busStop2){
					return new Integer(Integer.parseInt(busStop1.getId())).compareTo(Integer.parseInt(busStop2.getId()));
				}
			});
		}
		else{
			if(control2==1){

				out.writeOutput("ERROR\n", outputFile);
			}
			countPostgreSQLBusStop=0;
		}

	}
	
	
	public void insert(Service element,String outputFile){//Insert method for service elements
		for(int i=0;i<serviceData.size();i++){
			if(serviceData.get(i).getId().equals(element.getId())){
				countPostgreSQLService++;
			}
		}
		if(serviceData.size()==0){
			serviceData.add(element);
			Collections.sort(serviceData,new Comparator<Service>(){//This is for sorting.
				public int compare(Service service1,Service service2){
					return new Integer(Integer.parseInt(service1.getId())).compareTo(Integer.parseInt(service2.getId()));
				}
			});
		}
		else if(countPostgreSQLService==0){
			if(control2==1){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			serviceData.add(element);
			Collections.sort(serviceData,new Comparator<Service>(){//This is for sorting.
				public int compare(Service service1,Service service2){
					return new Integer(Integer.parseInt(service1.getId())).compareTo(Integer.parseInt(service2.getId()));
				}
			});
		}
		else{
			if(control2==1){
				out.writeOutput("ERROR\n", outputFile);
			}
			countPostgreSQLService=0;
		}
		
	}
	
	public void insert(Route element,String outputFile){//Insert method for route elements
		for(int i=0;i<routeData.size();i++){
			if(routeData.get(i).getId().equals(element.getId())){
				countPostgreSQLRoute++;
			}
		}
		if(routeData.size()==0){
			routeData.add(element);
			Collections.sort(routeData,new Comparator<Route>(){//This is for sorting.
				public int compare(Route route1,Route route2){
					return new Integer(Integer.parseInt(route1.getId())).compareTo(Integer.parseInt(route2.getId()));
				}
			});
		}
		else if(countPostgreSQLRoute==0){
			if(control2==1){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			routeData.add(element);
			Collections.sort(routeData,new Comparator<Route>(){//This is for sorting.
				public int compare(Route route1,Route route2){
					return new Integer(Integer.parseInt(route1.getId())).compareTo(Integer.parseInt(route2.getId()));
				}
			});
		}
		else{
			if(control2==1){
				out.writeOutput("ERROR\n", outputFile);
			}
			countPostgreSQLRoute=0;
		}

	}
	
	public void controller(int controller){
		control2=controller;
	}
	
}
