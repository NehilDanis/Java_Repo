package inOut;

import java.io.File;
import java.util.Scanner;

import method.*;
import data.*;


public class Input {//The input files read here.
	public static int commandCounter=0;//This is for counting the commands.
	public String database;//This take the database word.
	Output out=new Output();
	Oracle val1=new Oracle();
	MySQL val2=new MySQL();
	PostgreSQL val3=new PostgreSQL();
	Control_Method value=new Control_Method();
	Delete_Method valueDelete=new Delete_Method();
	List_Method valueList=new List_Method();

	public static String [] splittedArrayCommand=new String [10];//When we split the line this array will take the values of line.
	public void readInput(String busFile,String driverFile,String busStopFile,String routeFile,String serviceFile ,String commandFile,String outputFile){
		for(int i=0;i<6;i++){
			if(i==0){
				File fBus=new File(busFile);
				String read=null;
				String [] oracleBus=new String[10];
				String [] mySQLBus=new String[10];
				String [] postgreSQLBus=new String[10];
				String [] allBus=new String[10];
				try{
					Scanner sBus=new Scanner(fBus);
			
					while(sBus.hasNextLine()){
						read=sBus.nextLine();
						
						if(read.equals("Oracle")){
							while(sBus.hasNextLine()){
								read=sBus.nextLine();
								if(read.equalsIgnoreCase("")){
									break;
								}
								else{
									 oracleBus=read.split("\t");
									 value.checkBus(oracleBus, "Oracle",outputFile);//invoke the check method.
								}
							}
						}
						
						else if(read.equals("MySQL")){
							while(sBus.hasNextLine()){
								read=sBus.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									mySQLBus=read.split("\t");
									value.checkBus(mySQLBus, "MySQL",outputFile);//invoke the check method.
								}
								
							}
						}
						
						else if(read.equals("PostgreSQL")){
							while(sBus.hasNextLine()){
								read=sBus.nextLine();								
								if(read.equals("")){
									break;
								}
								else{
									postgreSQLBus=read.split("\t");
									value.checkBus(postgreSQLBus, "PostgreSQL",outputFile);//invoke the check method.
								}
							}
						}
						
						else if(read.equals("All_Databases")){//The elements in the all database have to add all databases.
							
							while(sBus.hasNextLine()){
								read=sBus.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									allBus=read.split("\t");
									value.checkBus(allBus, "Oracle",outputFile);//invoke the check method.
									value.checkBus(allBus, "MySQL",outputFile);//invoke the check method.
									value.checkBus(allBus, "PostgreSQL",outputFile);//invoke the check method.
									
								}
							}
						}
					}
				}
				catch(Exception error){
					System.out.println("busFile error: "+error.getMessage());
				}
			}//end of if(i==0)
			
	else if(i==1){
				File fDriver=new File(driverFile);
				String read=null;
				String [] oracleDriver=new String[10];
				String [] mySQLDriver=new String[10];
				String [] postgreSQLDriver=new String[10];
				String [] allDriver=new String[10];
				try{
					
					Scanner sDriver=new Scanner(fDriver);
					while(sDriver.hasNextLine()){
						read=sDriver.nextLine();
						
						if(read.equals("Oracle")){
							while(sDriver.hasNextLine()){
								read=sDriver.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									 oracleDriver=read.split("\t");
									 value.checkDriver(oracleDriver, "Oracle",outputFile);//invoke the check method.
									
								}
								
							}
						
						}

						else if(read.equals("MySQL")){
							while(sDriver.hasNextLine()){
								read=sDriver.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									 mySQLDriver=read.split("\t");
									 value.checkDriver(mySQLDriver, "MySQL",outputFile);//invoke the check method.
								
								}
							}
							
						}
						
						else if(read.equals("PostgreSQL")){
							while(sDriver.hasNextLine()){
								read=sDriver.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									postgreSQLDriver=read.split("\t");
									value.checkDriver(postgreSQLDriver, "PostgreSQL",outputFile);//invoke the check method.
								}
							}
						}
						
						else if(read.equals("All_Databases")){//The elements in the all database have to add all databases.
							
							while(sDriver.hasNextLine()){
								read=sDriver.nextLine();
								if(read.equals("")){
									break;
								}
								else{
									allDriver=read.split("\t");
									value.checkDriver(allDriver, "Oracle",outputFile);//invoke the check method.
									value.checkDriver(allDriver, "MySQL",outputFile);//invoke the check method.
									value.checkDriver(allDriver, "PostgreSQL",outputFile);//invoke the check method.
								}
							}
						}

					}
					
				}
				catch(Exception a){
					System.out.println("driverFile readingError : "+a.getMessage());
				}
				
			}//else if(i==1)
			
	else if(i==2){
		File fBusStop=new File(busStopFile);
		String read=null;
		String [] oracleBusStop=new String[10];
		String [] mySQLBusStop=new String[10];
		String [] postgreSQLBusStop=new String[10];
		String [] allBusStop=new String[10];
		
		
		try{
			
			Scanner sBusStop=new Scanner(fBusStop);
			while(sBusStop.hasNextLine()){
				read=sBusStop.nextLine();
				
				if(read.equals("Oracle")){
					while(sBusStop.hasNextLine()){
						read=sBusStop.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							 oracleBusStop=read.split("\t");
							 value.checkBus_Stop(oracleBusStop, "Oracle",outputFile);//invoke the check method.
							
						}
						
					}
					
				}

				else if(read.equals("MySQL")){
					while(sBusStop.hasNextLine()){
						read=sBusStop.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							 mySQLBusStop=read.split("\t");
							 value.checkBus_Stop(mySQLBusStop, "MySQL",outputFile);//invoke the check method.
							
						}
					}
					
				}
				
				else if(read.equals("PostgreSQL")){
					while(sBusStop.hasNextLine()){
						read=sBusStop.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							postgreSQLBusStop=read.split("\t");
							value.checkBus_Stop(postgreSQLBusStop, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}
				
				else if(read.equals("All_Databases")){//The elements in the all database have to add all databases.
					
					while(sBusStop.hasNextLine()){
						read=sBusStop.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							allBusStop=read.split("\t");
							value.checkBus_Stop(allBusStop, "Oracle",outputFile);//invoke the check method.
							value.checkBus_Stop(allBusStop, "MySQL",outputFile);//invoke the check method.
							value.checkBus_Stop(allBusStop, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}

			}
			
			
		}
		catch(Exception a){
			System.out.println("busStopFile readingError : "+a.getMessage());
		}
		
		
	}//else if(i==2)
			
	else if(i==4){
		File fService=new File(serviceFile);
		String read=null;
		String [] oracleService=new String[10];
		String [] mySQLService=new String[10];
		String [] postgreSQLService=new String[10];
		String [] allService=new String[10];
		
		
		try{
			
			Scanner sService=new Scanner(fService);
			while(sService.hasNextLine()){
				read=sService.nextLine();
				
				if(read.equals("Oracle")){
					while(sService.hasNextLine()){
						read=sService.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							oracleService=read.split("\t");
							 value.checkService(oracleService, "Oracle",outputFile);//invoke the check method.
							
						}
						
					}
					
				}

				else if(read.equals("MySQL")){
					while(sService.hasNextLine()){
						read=sService.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							mySQLService=read.split("\t");
							 value.checkService(mySQLService, "MySQL",outputFile);//invoke the check method.
							
						}
					}
					
				}
				
				else if(read.equals("PostgreSQL")){
					while(sService.hasNextLine()){
						read=sService.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							postgreSQLService=read.split("\t");
							value.checkService(postgreSQLService, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}
				
				else if(read.equals("All_Databases")){//The elements in the all database have to add all databases.
					
					while(sService.hasNextLine()){
						read=sService.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							allService=read.split("\t");
							value.checkService(allService, "Oracle",outputFile);//invoke the check method.
							value.checkService(allService, "MySQL",outputFile);//invoke the check method.
							value.checkService(allService, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}

			}
			
		}
		catch(Exception a){
			System.out.println("serviceFile readingError : "+a.getMessage());
		}
		
	}//else if(i==4)
			
	else if(i==3){
		File fRoute=new File(routeFile);
		String read=null;
		String [] oracleRoute=new String[10];
		String [] mySQLRoute=new String[10];
		String [] postgreSQLRoute=new String[10];
		String [] allRoute=new String[10];
		
		
		try{
			Scanner sRoute=new Scanner(fRoute);
			while(sRoute.hasNextLine()){
				read=sRoute.nextLine();

				if(read.equals("Oracle")){
					while(sRoute.hasNextLine()){
						read=sRoute.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							oracleRoute=read.split("\t");
							 value.checkRoute(oracleRoute, "Oracle",outputFile);//invoke the check method.
							
						}
						
					}
					
				}

				else if(read.equals("MySQL")){
					while(sRoute.hasNextLine()){
						read=sRoute.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							mySQLRoute=read.split("\t");
							value.checkRoute(mySQLRoute, "MySQL",outputFile);//invoke the check method.
							
						}
					}
					
				}
				
				else if(read.equals("PostgreSQL")){
					while(sRoute.hasNextLine()){
						read=sRoute.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							postgreSQLRoute=read.split("\t");
							value.checkRoute(postgreSQLRoute, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}
				
				else if(read.equals("All_Databases")){//The elements in the all database have to add all databases.
					
					while(sRoute.hasNextLine()){
						read=sRoute.nextLine();
						if(read.equals("")){
							break;
						}
						else{
							allRoute=read.split("\t");
							value.checkRoute(allRoute, "Oracle",outputFile);//invoke the check method.
							value.checkRoute(allRoute, "MySQL",outputFile);//invoke the check method.
							value.checkRoute(allRoute, "PostgreSQL",outputFile);//invoke the check method.
						}
					}
				}

			}
			
		}
		catch(Exception a){
			System.out.println("routeFile error : "+a.getMessage());
		}
	
	}//else if(i==3)

			
	else if(i==5){
		File fCommand=new File(commandFile);
		String read=null;
		int x;
		
		try{
			Scanner sCommand=new Scanner(fCommand);
			while(sCommand.hasNextLine()){
				read=sCommand.nextLine();
				commandCounter++;
				out.writeOutput("COMMAND "+commandCounter+":"+read+"\n", outputFile);//This write the commands to the output file.
				splittedArrayCommand=read.split("\t");
				
				if(splittedArrayCommand[0].equals("ADD_BUS")){
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					if(database.equals("Oracle")){
						val1.controller(1);
					}
					else if (database.equals("MySQL")) {
						val2.controller(1);
					}
					else if (database.equals("PostgreSQL")) {
						val3.controller(1);
					}
					
					value.checkBus(element, database,outputFile);
				}
				
				else if(splittedArrayCommand[0].equals("ADD_DRIVER")){
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					if(database.equals("Oracle")){
						val1.controller(1);
					}
					else if (database.equals("MySQL")) {
						val2.controller(1);
					}
					else if (database.equals("PostgreSQL")) {
						val3.controller(1);
					}
					value.checkDriver(element, database,outputFile);

				}
				else if(splittedArrayCommand[0].equals("ADD_BUS_STOP")){
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					if(database.equals("Oracle")){
						val1.controller(1);
					}
					else if (database.equals("MySQL")) {
						val2.controller(1);
					}
					else if (database.equals("PostgreSQL")) {
						val3.controller(1);
					}
					value.checkBus_Stop(element, database,outputFile);

				}
				else if(splittedArrayCommand[0].equals("ADD_ROUTE")){
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					if(database.equals("Oracle")){
						val1.controller(1);
					}
					else if (database.equals("MySQL")) {
						val2.controller(1);
					}
					else if (database.equals("PostgreSQL")) {
						val3.controller(1);
					}
					value.checkRoute(element, database,outputFile);
					

				}
				else if(splittedArrayCommand[0].equals("ADD_SERVICE")){
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					if(database.equals("Oracle")){
						val1.controller(1);
					}
					else if (database.equals("MySQL")) {
						val2.controller(1);
					}
					else if (database.equals("PostgreSQL")) {
						val3.controller(1);
					}
					value.checkService(element, database,outputFile);
				}
				else if(splittedArrayCommand[0].equals("DELETE_BUS")){
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueDelete.DELETE_BUS(element,database,outputFile);
					

				}
				else if (splittedArrayCommand[0].equals("DELETE_DRIVER")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueDelete.DELETE_DRIVER(element,database,outputFile);

				}
				else if (splittedArrayCommand[0].equals("DELETE_BUS_STOP")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueDelete.DELETE_BUS_STOP(element,database,outputFile);

				}
				else if (splittedArrayCommand[0].equals("DELETE_ROUTE")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueDelete.DELETE_ROUTE(element,database,outputFile);


				}
				else if (splittedArrayCommand[0].equals("DELETE_SERVICE")) {
					
					x=splittedArrayCommand.length-2;
					String [] element=new String [x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueDelete.DELETE_SERVICE(element,database,outputFile);
					
				}
				else if (splittedArrayCommand[0].equals("LIST_ROUTES_CONTAINING_BUS_STOP")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueList.LIST_ROUTES_CONTAINING_BUS_STOP(element, database,outputFile);

				}
				else if (splittedArrayCommand[0].equals("LIST_DRIVERS_OF_BUS")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueList.LIST_DRIVERS_OF_BUS(element, database,outputFile);

				}
				else if (splittedArrayCommand[0].equals("LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueList.LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY(element, database,outputFile);
					
				}
				else if (splittedArrayCommand[0].equals("LIST_SERVICES_BY_BUS_STOPS")) {
					x=splittedArrayCommand.length-2;
					String [] element=new String[x];
					database=splittedArrayCommand[1];
					for(int count=0,count1=2;count<x;count++,count1++){
						element[count]=splittedArrayCommand[count1];
					}
					valueList.LIST_SERVICES_BY_BUS_STOPS(element, database,outputFile);
					

				}
				else if (splittedArrayCommand[0].equals("LIST_ALL")) {
					if(splittedArrayCommand.length==1){
						valueList.LIST_ALL(outputFile);
					}
					else{
						database=splittedArrayCommand[1];
						valueList.LIST_ALL( database,outputFile);
					}
				}
				out.writeOutput("\n", outputFile);
			}
		}
		catch(Exception error){
			System.out.println("commandFile reading error : ");
			error.printStackTrace();
		}
	
	}//else if(i==5)

		}//for loop
			
	}//public void readInput

}
