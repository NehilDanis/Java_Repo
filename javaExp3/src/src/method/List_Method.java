package method;


import data.*;
import inOut.*;
import item.*;

public class List_Method {
	Output out=new Output();//This use for writing output.
	Oracle val1=new Oracle();//These use for using the different database.
	MySQL val2=new MySQL();
	PostgreSQL val3=new PostgreSQL();
	
	
	public void LIST_ROUTES_CONTAINING_BUS_STOP(String [] splittedArray,String databaseWord,String outputFile){
		
		if(databaseWord.equals("Oracle")){
			int count=0;
			for(int i=0;i<val1.routeData.size();i++){
				for(int j=0;j<val1.routeData.get(i).getBus_stop_id().size();j++){
					if(val1.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						count++;
						out.writeOutput("ID:"+val1.routeData.get(i).getId()+" Year of Establishment:"+val1.routeData.get(i).getYear_of_establishment()+"\n", outputFile);
						
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		else if(databaseWord.equals("MySQL")){
			int count=0;
			for(int i=0;i<val2.routeData.size();i++){
				for(int j=0;j<val2.routeData.get(i).getBus_stop_id().size();j++){
					if(val2.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						count++;
						out.writeOutput("ID:"+val2.routeData.get(i).getId()+" Year of Establishment:"+val2.routeData.get(i).getYear_of_establishment()+"\n", outputFile);
						
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		else if (databaseWord.equals("PostgreSQL")) {
			int count=0;
			for(int i=0;i<val3.routeData.size();i++){
				for(int j=0;j<val3.routeData.get(i).getBus_stop_id().size();j++){
					if(val3.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						count++;
						out.writeOutput("ID:"+val3.routeData.get(i).getId()+" Year of Establishment:"+val3.routeData.get(i).getYear_of_establishment()+"\n", outputFile);
						
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		
	}
	
	public void LIST_DRIVERS_OF_BUS(String [] splittedArray,String databaseWord,String outputFile){

		if(databaseWord.equals("Oracle")){
			int count=0;
			for(int i=0;i<val1.serviceData.size();i++){
				if(val1.serviceData.get(i).getBus_id().equals(splittedArray[0])){
					for(int j=0;j<val1.driverData.size();j++){
						if(val1.serviceData.get(i).getDriver_id().equals(val1.driverData.get(j).getId())){
							count++;
							out.writeOutput("ID:"+val1.driverData.get(j).getId()+" Driver Name:"+val1.driverData.get(j).getName()+" Driver Surname:"+
									val1.driverData.get(j).getSurname()+"\n", outputFile);

						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		else if (databaseWord.equals("MySQL")) {
			int count=0;
			for(int i=0;i<val2.serviceData.size();i++){
				if(val2.serviceData.get(i).getBus_id().equals(splittedArray[0])){
					for(int j=0;j<val2.driverData.size();j++){
						if(val2.serviceData.get(i).getDriver_id().equals(val2.driverData.get(j).getId())){
							count++;
							out.writeOutput("ID:"+val2.driverData.get(j).getId()+" Driver Name:"+val2.driverData.get(j).getName()+" Driver Surname:"+
									val2.driverData.get(j).getSurname()+"\n", outputFile);
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
		}
		else if (databaseWord.equals("PostgreSQL")) {
			int count=0;
			for(int i=0;i<val3.serviceData.size();i++){
				if(val3.serviceData.get(i).getBus_id().equals(splittedArray[0])){
					for(int j=0;j<val3.driverData.size();j++){
						if(val3.serviceData.get(i).getDriver_id().equals(val3.driverData.get(j).getId())){
							count++;
							out.writeOutput("ID:"+val3.driverData.get(j).getId()+" Driver Name:"+val3.driverData.get(j).getName()+" Driver Surname:"+
									val3.driverData.get(j).getSurname()+"\n", outputFile);
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
		}
		
	}
	
	public void LIST_SERVICES_BY_MEAN_BUS_STOP_CAPACITY(String [] splittedArray,String databaseWord,String outputFile){
		if(databaseWord.equals("Oracle")){
			Float toplam=(float) 0.0;
			Float average;
			Float capacity;
			Float busStopCapacity;
			int count=0;
			capacity=Float.valueOf(splittedArray[0]);
			for(int i=0;i<val1.serviceData.size();i++){
				for(int j=0;j<val1.routeData.size();j++){
					if(val1.serviceData.get(i).getRoute_id().equals(val1.routeData.get(j).getId())){
						toplam=(float) 0.0;
						for(int k=0;k<val1.routeData.get(j).getBus_stop_id().size();k++){
							for(int m=0;m<val1.busStopData.size();m++){
								if(val1.busStopData.get(m).getId().equals(val1.routeData.get(j).getBus_stop_id().get(k))){
									busStopCapacity=Float.valueOf(val1.busStopData.get(m).getCapacity());
									toplam+=busStopCapacity;
								}
							}
						}
						average=toplam/val1.routeData.get(j).getBus_stop_id().size();
						if(average>=capacity){
							count++;
							String formattedString = String.format("%.01f", average);
							out.writeOutput("ID:"+val1.serviceData.get(i).getId()+" Time of Departure:"+val1.serviceData.get(i).getTime_of_departure()+
									" Route ID:"+val1.routeData.get(j).getId()+" Route Mean Capacity:"+formattedString+"\n", outputFile);
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
			
		}
		else if (databaseWord.equals("MySQL")) {
			Float toplam=(float) 0.0;
			Float average;
			Float capacity;
			Float busStopCapacity;
			int count=0;
			capacity=Float.valueOf(splittedArray[0]);
			for(int i=0;i<val2.serviceData.size();i++){
				for(int j=0;j<val2.routeData.size();j++){
					if(val2.serviceData.get(i).getRoute_id().equals(val2.routeData.get(j).getId())){
						toplam=(float) 0.0;
						for(int k=0;k<val2.routeData.get(j).getBus_stop_id().size();k++){
							for(int m=0;m<val2.busStopData.size();m++){
								if(val2.busStopData.get(m).getId().equals(val2.routeData.get(j).getBus_stop_id().get(k))){
									busStopCapacity=Float.valueOf(val2.busStopData.get(m).getCapacity());
									toplam+=busStopCapacity;
								}
							}
						}
						average=toplam/val2.routeData.get(j).getBus_stop_id().size();
						if(average>=capacity){
							count++;
							String formattedString = String.format("%.01f", average);
							out.writeOutput("ID:"+val2.serviceData.get(i).getId()+" Time of Departure:"+val2.serviceData.get(i).getTime_of_departure()+
									" Route ID:"+val2.routeData.get(j).getId()+" Route Mean Capacity:"+formattedString+"\n", outputFile);
							
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			Float toplam=(float) 0.0;
			Float average;
			Float capacity;
			Float busStopCapacity;
			int count=0;
			capacity=Float.valueOf(splittedArray[0]);
			for(int i=0;i<val3.serviceData.size();i++){
				for(int j=0;j<val3.routeData.size();j++){
					if(val3.serviceData.get(i).getRoute_id().equals(val3.routeData.get(j).getId())){
						toplam=(float) 0.0;
						for(int k=0;k<val3.routeData.get(j).getBus_stop_id().size();k++){
							for(int m=0;m<val3.busStopData.size();m++){
								if(val3.busStopData.get(m).getId().equals(val3.routeData.get(j).getBus_stop_id().get(k))){
									busStopCapacity=Float.valueOf(val3.busStopData.get(m).getCapacity());
									toplam+=busStopCapacity;
								}
							}
						}
						average=toplam/val3.routeData.get(j).getBus_stop_id().size();
						if(average>=capacity){
							count++;
							String formattedString = String.format("%.01f", average);
							out.writeOutput("ID:"+val3.serviceData.get(i).getId()+" Time of Departure:"+val3.serviceData.get(i).getTime_of_departure()+
									" Route ID:"+val3.routeData.get(j).getId()+" Route Mean Capacity:"+formattedString+"\n", outputFile);
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
		}
		
	}
	
	public void LIST_SERVICES_BY_BUS_STOPS(String [] splittedArray,String databaseWord,String outputFile){
		int count=0;
		if(databaseWord.equals("Oracle")){
			for(int i=0;i<val1.routeData.size();i++){
				for(int j=0;j<val1.routeData.get(i).getBus_stop_id().size();j++){
					if(val1.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						for(int k=j;k<val1.routeData.get(i).getBus_stop_id().size();k++){
							if(val1.routeData.get(i).getBus_stop_id().get(k).equals(splittedArray[1])){
								for(int m=0;m<val1.serviceData.size();m++){
									if(val1.serviceData.get(m).getRoute_id().equals(val1.routeData.get(i).getId())){
										out.writeOutput("ID:"+val1.serviceData.get(m).getId()+" Time of Departure:"
								     +val1.serviceData.get(m).getTime_of_departure()+
											" Route ID:"+val1.routeData.get(i).getId()+"\n", outputFile);
										count++;
									}
								}
							}
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
			
		}
		else if (databaseWord.equals("MySQL")) {
			for(int i=0;i<val2.routeData.size();i++){
				for(int j=0;j<val2.routeData.get(i).getBus_stop_id().size();j++){
					if(val2.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						for(int k=j;k<val2.routeData.get(i).getBus_stop_id().size();k++){
							if(val2.routeData.get(i).getBus_stop_id().get(k).equals(splittedArray[1])){
								for(int m=0;m<val2.serviceData.size();m++){
									if(val2.serviceData.get(m).getRoute_id().equals(val2.routeData.get(i).getId())){
										out.writeOutput("ID:"+val2.serviceData.get(m).getId()+" Time of Departure:"
											     +val2.serviceData.get(m).getTime_of_departure()+
														" Route ID:"+val2.routeData.get(i).getId()+"\n", outputFile);
										count++;
									}
								}
							}
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}

		}
		else if(databaseWord.equals("PostgreSQL")){
			for(int i=0;i<val3.routeData.size();i++){
				for(int j=0;j<val3.routeData.get(i).getBus_stop_id().size();j++){
					if(val3.routeData.get(i).getBus_stop_id().get(j).equals(splittedArray[0])){
						for(int k=j;k<val3.routeData.get(i).getBus_stop_id().size();k++){
							if(val3.routeData.get(i).getBus_stop_id().get(k).equals(splittedArray[1])){
								for(int m=0;m<val3.serviceData.size();m++){
									if(val3.serviceData.get(m).getRoute_id().equals(val3.routeData.get(i).getId())){
										out.writeOutput("ID:"+val3.serviceData.get(m).getId()+" Time of Departure:"
											     +val3.serviceData.get(m).getTime_of_departure()+
														" Route ID:"+val3.routeData.get(i).getId()+"\n", outputFile);
										count++;
									}
								}
							}
						}
					}
				}
			}
			if(count==0){
				out.writeOutput("NO RESULTS FOUND\n", outputFile);
			}
			
			
		}
		
	}
	
	public void LIST_ALL(String databaseWord,String outputFile){
		if(databaseWord.equals("Oracle")){
			out.writeOutput("Oracle Bus Information\n", outputFile);
			for(int i=0;i<val1.busData.size();i++){
				out.writeOutput("ID:"+val1.busData.get(i).getId()+" Plate:"+val1.busData.get(i).getPlate()+" Brand:"+val1.busData.get(i).getBrand()+
						" Model:"+val1.busData.get(i).getModel()+" Year of Manufacture:"
			+val1.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("Oracle Driver Information\n", outputFile);
			for(int i=0;i<val1.driverData.size();i++){
				out.writeOutput("ID:"+val1.driverData.get(i).getId()+" Name:"+val1.driverData.get(i).getName()
						+" Surname:"+val1.driverData.get(i).getSurname()+" Birthdate:"+val1.driverData.get(i).getBirthdate()+" Phone:"+
						val1.driverData.get(i).getPhoneNumber()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("Oracle Bus Stop Information\n", outputFile);
			for(int i=0;i<val1.busStopData.size();i++){
				out.writeOutput("ID:"+val1.busStopData.get(i).getId()+" Name:"+val1.busStopData.get(i).getName()
						+" Location:"+val1.busStopData.get(i).getLocation()+" Capacity:"+val1.busStopData.get(i).getCapacity()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("Oracle Route Information\n", outputFile);
			for(int i=0;i<val1.routeData.size();i++){
				out.writeOutput("ID:"+val1.routeData.get(i).getId()+" Year of Establishment:"+val1.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
				for(int j=0;j<val1.routeData.get(i).getBus_stop_id().size();j++){
					for(int k=0;k<val1.busStopData.size();k++){
						if(val1.busStopData.get(k).getId().equals(val1.routeData.get(i).getBus_stop_id().get(j))){
							out.writeOutput(val1.busStopData.get(k).getName()+" ", outputFile);
						}
					}
				}
				out.writeOutput("\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("Oracle Service Information\n", outputFile);
			for(int i=0;i<val1.serviceData.size();i++){
				out.writeOutput("ID:"+val1.serviceData.get(i).getId()+" Time of Departure:"+val1.serviceData.get(i).getTime_of_departure()+
						" Route ID:"+val1.serviceData.get(i).getRoute_id(), outputFile);
				for(int a=0;a<val1.busData.size();a++){
					if(val1.serviceData.get(i).getBus_id().equals(val1.busData.get(a).getId())){
						out.writeOutput(" Bus ID:"+val1.busData.get(a).getId()+" Bus Plate:"+val1.busData.get(a).getPlate(), outputFile);
					}
				}
				for(int b=0;b<val1.driverData.size();b++){
					if(val1.serviceData.get(i).getDriver_id().equals(val1.driverData.get(b).getId())){
						out.writeOutput(" Driver ID:"+val1.driverData.get(b).getId()+" Driver Name:"+val1.driverData.get(b).getName()
								+" Driver Surname:"+val1.driverData.get(b).getSurname(), outputFile);
					}
				}
				out.writeOutput("\n", outputFile);
			}
			
		}
		else if (databaseWord.equals("MySQL")) {
			
			out.writeOutput("MySQL Bus Information\n", outputFile);
			for(int i=0;i<val2.busData.size();i++){
				out.writeOutput("ID:"+val2.busData.get(i).getId()+" Plate:"+val2.busData.get(i).getPlate()+" Brand:"+val2.busData.get(i).getBrand()+
						" Model:"+val2.busData.get(i).getModel()+" Year of Manufacture:"
			+val2.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("MySQL Driver Information\n", outputFile);
			for(int i=0;i<val2.driverData.size();i++){
				out.writeOutput("ID:"+val2.driverData.get(i).getId()+" Name:"+val2.driverData.get(i).getName()
						+" Surname:"+val2.driverData.get(i).getSurname()+" Birthdate:"+val2.driverData.get(i).getBirthdate()+" Phone:"+
						val2.driverData.get(i).getPhoneNumber()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("MySQL Bus Stop Information\n", outputFile);
			for(int i=0;i<val2.busStopData.size();i++){
				out.writeOutput("ID:"+val2.busStopData.get(i).getId()+" Name:"+val2.busStopData.get(i).getName()
						+" Location:"+val2.busStopData.get(i).getLocation()+" Capacity:"+val2.busStopData.get(i).getCapacity()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("MySQL Route Information\n", outputFile);
			for(int i=0;i<val2.routeData.size();i++){
				out.writeOutput("ID:"+val2.routeData.get(i).getId()+" Year of Establishment:"+val2.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
				for(int j=0;j<val2.routeData.get(i).getBus_stop_id().size();j++){
					for(int k=0;k<val2.busStopData.size();k++){
						if(val2.busStopData.get(k).getId().equals(val2.routeData.get(i).getBus_stop_id().get(j))){
							out.writeOutput(val2.busStopData.get(k).getName()+" ", outputFile);
						}
					}
				}
				out.writeOutput("\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("MySQL Service Information\n", outputFile);
			for(int i=0;i<val2.serviceData.size();i++){
				out.writeOutput("ID:"+val2.serviceData.get(i).getId()+" Time of Departure:"+val2.serviceData.get(i).getTime_of_departure()+
						" Route ID:"+val2.serviceData.get(i).getRoute_id(), outputFile);
				for(int a=0;a<val2.busData.size();a++){
					if(val2.serviceData.get(i).getBus_id().equals(val2.busData.get(a).getId())){
						out.writeOutput(" Bus ID:"+val2.busData.get(a).getId()+" Bus Plate:"+val2.busData.get(a).getPlate(), outputFile);
					}
				}
				for(int b=0;b<val2.driverData.size();b++){
					if(val2.serviceData.get(i).getDriver_id().equals(val2.driverData.get(b).getId())){
						out.writeOutput(" Driver ID:"+val2.driverData.get(b).getId()+" Driver Name:"+val2.driverData.get(b).getName()
								+" Driver Surname:"+val2.driverData.get(b).getSurname(), outputFile);
					}
				}
				out.writeOutput("\n", outputFile);
				
			}
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			
			out.writeOutput("PostgreSQL Bus Information\n", outputFile);
			for(int i=0;i<val3.busData.size();i++){
				out.writeOutput("ID:"+val3.busData.get(i).getId()+" Plate:"+val3.busData.get(i).getPlate()+" Brand:"+val3.busData.get(i).getBrand()+
						" Model:"+val3.busData.get(i).getModel()+" Year of Manufacture:"
			+val3.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("PostgreSQL Driver Information\n", outputFile);
			for(int i=0;i<val3.driverData.size();i++){
				out.writeOutput("ID:"+val3.driverData.get(i).getId()+" Name:"+val3.driverData.get(i).getName()
						+" Surname:"+val3.driverData.get(i).getSurname()+" Birthdate:"+val3.driverData.get(i).getBirthdate()+" Phone:"+
						val3.driverData.get(i).getPhoneNumber()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("PostgreSQL Bus Stop Information\n", outputFile);
			for(int i=0;i<val3.busStopData.size();i++){
				out.writeOutput("ID:"+val3.busStopData.get(i).getId()+" Name:"+val3.busStopData.get(i).getName()
						+" Location:"+val3.busStopData.get(i).getLocation()+" Capacity:"+val3.busStopData.get(i).getCapacity()+"\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("PostgreSQL Route Information\n", outputFile);
			for(int i=0;i<val3.routeData.size();i++){
				out.writeOutput("ID:"+val3.routeData.get(i).getId()+" Year of Establishment:"+val3.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
				for(int j=0;j<val3.routeData.get(i).getBus_stop_id().size();j++){
					for(int k=0;k<val3.busStopData.size();k++){
						if(val3.busStopData.get(k).getId().equals(val3.routeData.get(i).getBus_stop_id().get(j))){
							out.writeOutput(val3.busStopData.get(k).getName()+" ", outputFile);
						}
					}
				}
				out.writeOutput("\n", outputFile);
			}
			
			out.writeOutput("\n", outputFile);
			out.writeOutput("PostgreSQL Service Information\n", outputFile);
			for(int i=0;i<val3.serviceData.size();i++){
				out.writeOutput("ID:"+val3.serviceData.get(i).getId()+" Time of Departure:"+val3.serviceData.get(i).getTime_of_departure()+
						" Route ID:"+val3.serviceData.get(i).getRoute_id(), outputFile);
				for(int a=0;a<val3.busData.size();a++){
					if(val3.serviceData.get(i).getBus_id().equals(val3.busData.get(a).getId())){
						out.writeOutput(" Bus ID:"+val3.busData.get(a).getId()+" Bus Plate:"+val3.busData.get(a).getPlate(), outputFile);
					}
				}
				for(int b=0;b<val3.driverData.size();b++){
					if(val3.serviceData.get(i).getDriver_id().equals(val3.driverData.get(b).getId())){
						out.writeOutput(" Driver ID:"+val3.driverData.get(b).getId()+" Driver Name:"+val3.driverData.get(b).getName()
								+" Driver Surname:"+val3.driverData.get(b).getSurname(), outputFile);
					}
				}
				out.writeOutput("\n", outputFile);
			}
		}
		
	}
	
	public void LIST_ALL(String outputFile){
		out.writeOutput("Oracle Bus Information\n", outputFile);
		for(int i=0;i<val1.busData.size();i++){
			out.writeOutput("ID:"+val1.busData.get(i).getId()+" Plate:"+val1.busData.get(i).getPlate()+" Brand:"+val1.busData.get(i).getBrand()+
					" Model:"+val1.busData.get(i).getModel()+" Year of Manufacture:"
		+val1.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("Oracle Driver Information\n", outputFile);
		for(int i=0;i<val1.driverData.size();i++){
			out.writeOutput("ID:"+val1.driverData.get(i).getId()+" Name:"+val1.driverData.get(i).getName()
					+" Surname:"+val1.driverData.get(i).getSurname()+" Birthdate:"+val1.driverData.get(i).getBirthdate()+" Phone:"+
					val1.driverData.get(i).getPhoneNumber()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("Oracle Bus Stop Information\n", outputFile);
		for(int i=0;i<val1.busStopData.size();i++){
			out.writeOutput("ID:"+val1.busStopData.get(i).getId()+" Name:"+val1.busStopData.get(i).getName()
					+" Location:"+val1.busStopData.get(i).getLocation()+" Capacity:"+val1.busStopData.get(i).getCapacity()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("Oracle Route Information\n", outputFile);
		for(int i=0;i<val1.routeData.size();i++){
			out.writeOutput("ID:"+val1.routeData.get(i).getId()+" Year of Establishment:"+val1.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
			for(int j=0;j<val1.routeData.get(i).getBus_stop_id().size();j++){
				for(int k=0;k<val1.busStopData.size();k++){
					if(val1.busStopData.get(k).getId().equals(val1.routeData.get(i).getBus_stop_id().get(j))){
						out.writeOutput(val1.busStopData.get(k).getName()+" ", outputFile);
					}
				}
			}
			out.writeOutput("\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("Oracle Service Information\n", outputFile);
		for(int i=0;i<val1.serviceData.size();i++){
			out.writeOutput("ID:"+val1.serviceData.get(i).getId()+" Time of Departure:"+val1.serviceData.get(i).getTime_of_departure()+
					" Route ID:"+val1.serviceData.get(i).getRoute_id(), outputFile);
			for(int a=0;a<val1.busData.size();a++){
				if(val1.serviceData.get(i).getBus_id().equals(val1.busData.get(a).getId())){
					out.writeOutput(" Bus ID:"+val1.busData.get(a).getId()+" Bus Plate:"+val1.busData.get(a).getPlate(), outputFile);
				}
			}
			for(int b=0;b<val1.driverData.size();b++){
				if(val1.serviceData.get(i).getDriver_id().equals(val1.driverData.get(b).getId())){
					out.writeOutput(" Driver ID:"+val1.driverData.get(b).getId()+" Driver Name:"+val1.driverData.get(b).getName()
							+" Driver Surname:"+val1.driverData.get(b).getSurname(), outputFile);
				}
			}
			out.writeOutput("\n", outputFile);
		}
		out.writeOutput("\n", outputFile);
		
		out.writeOutput("MySQL Bus Information\n", outputFile);
		for(int i=0;i<val2.busData.size();i++){
			out.writeOutput("ID:"+val2.busData.get(i).getId()+" Plate:"+val2.busData.get(i).getPlate()+" Brand:"+val2.busData.get(i).getBrand()+
					" Model:"+val2.busData.get(i).getModel()+" Year of Manufacture:"
		+val2.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("MySQL Driver Information\n", outputFile);
		for(int i=0;i<val2.driverData.size();i++){
			out.writeOutput("ID:"+val2.driverData.get(i).getId()+" Name:"+val2.driverData.get(i).getName()
					+" Surname:"+val2.driverData.get(i).getSurname()+" Birthdate:"+val2.driverData.get(i).getBirthdate()+" Phone:"+
					val2.driverData.get(i).getPhoneNumber()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("MySQL Bus Stop Information\n", outputFile);
		for(int i=0;i<val2.busStopData.size();i++){
			out.writeOutput("ID:"+val2.busStopData.get(i).getId()+" Name:"+val2.busStopData.get(i).getName()
					+" Location:"+val2.busStopData.get(i).getLocation()+" Capacity:"+val2.busStopData.get(i).getCapacity()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("MySQL Route Information\n", outputFile);
		for(int i=0;i<val2.routeData.size();i++){
			out.writeOutput("ID:"+val2.routeData.get(i).getId()+" Year of Establishment:"+val2.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
			for(int j=0;j<val2.routeData.get(i).getBus_stop_id().size();j++){
				for(int k=0;k<val2.busStopData.size();k++){
					if(val2.busStopData.get(k).getId().equals(val2.routeData.get(i).getBus_stop_id().get(j))){
						out.writeOutput(val2.busStopData.get(k).getName()+" ", outputFile);
					}
				}
			}
			out.writeOutput("\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("MySQL Service Information\n", outputFile);
		for(int i=0;i<val2.serviceData.size();i++){
			out.writeOutput("ID:"+val2.serviceData.get(i).getId()+" Time of Departure:"+val2.serviceData.get(i).getTime_of_departure()+
					" Route ID:"+val2.serviceData.get(i).getRoute_id(), outputFile);
			for(int a=0;a<val2.busData.size();a++){
				if(val2.serviceData.get(i).getBus_id().equals(val2.busData.get(a).getId())){
					out.writeOutput(" Bus ID:"+val2.busData.get(a).getId()+" Bus Plate:"+val2.busData.get(a).getPlate(), outputFile);
				}
			}
			for(int b=0;b<val2.driverData.size();b++){
				if(val2.serviceData.get(i).getDriver_id().equals(val2.driverData.get(b).getId())){
					out.writeOutput(" Driver ID:"+val2.driverData.get(b).getId()+" Driver Name:"+val2.driverData.get(b).getName()
							+" Driver Surname:"+val2.driverData.get(b).getSurname(), outputFile);
				}
			}
			out.writeOutput("\n", outputFile);
			
		}
		out.writeOutput("\n", outputFile);
		
		out.writeOutput("PostgreSQL Bus Information\n", outputFile);
		for(int i=0;i<val3.busData.size();i++){
			out.writeOutput("ID:"+val3.busData.get(i).getId()+" Plate:"+val3.busData.get(i).getPlate()+" Brand:"+val3.busData.get(i).getBrand()+
					" Model:"+val3.busData.get(i).getModel()+" Year of Manufacture:"
		+val3.busData.get(i).getYear_of_manufacture()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("PostgreSQL Driver Information\n", outputFile);
		for(int i=0;i<val3.driverData.size();i++){
			out.writeOutput("ID:"+val3.driverData.get(i).getId()+" Name:"+val3.driverData.get(i).getName()
					+" Surname:"+val3.driverData.get(i).getSurname()+" Birthdate:"+val3.driverData.get(i).getBirthdate()+" Phone:"+
					val3.driverData.get(i).getPhoneNumber()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("PostgreSQL Bus Stop Information\n", outputFile);
		for(int i=0;i<val3.busStopData.size();i++){
			out.writeOutput("ID:"+val3.busStopData.get(i).getId()+" Name:"+val3.busStopData.get(i).getName()
					+" Location:"+val3.busStopData.get(i).getLocation()+" Capacity:"+val3.busStopData.get(i).getCapacity()+"\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("PostgreSQL Route Information\n", outputFile);
		for(int i=0;i<val3.routeData.size();i++){
			out.writeOutput("ID:"+val3.routeData.get(i).getId()+" Year of Establishment:"+val3.routeData.get(i).getYear_of_establishment()+" Bus Stops:", outputFile);
			for(int j=0;j<val3.routeData.get(i).getBus_stop_id().size();j++){
				for(int k=0;k<val3.busStopData.size();k++){
					if(val3.busStopData.get(k).getId().equals(val3.routeData.get(i).getBus_stop_id().get(j))){
						out.writeOutput(val3.busStopData.get(k).getName()+" ", outputFile);
					}
				}
			}
			out.writeOutput("\n", outputFile);
		}
		
		out.writeOutput("\n", outputFile);
		out.writeOutput("PostgreSQL Service Information\n", outputFile);
		for(int i=0;i<val3.serviceData.size();i++){
			out.writeOutput("ID:"+val3.serviceData.get(i).getId()+" Time of Departure:"+val3.serviceData.get(i).getTime_of_departure()+
					" Route ID:"+val3.serviceData.get(i).getRoute_id(), outputFile);
			for(int a=0;a<val3.busData.size();a++){
				if(val3.serviceData.get(i).getBus_id().equals(val3.busData.get(a).getId())){
					out.writeOutput(" Bus ID:"+val3.busData.get(a).getId()+" Bus Plate:"+val3.busData.get(a).getPlate(), outputFile);
				}
			}
			for(int b=0;b<val3.driverData.size();b++){
				if(val3.serviceData.get(i).getDriver_id().equals(val3.driverData.get(b).getId())){
					out.writeOutput(" Driver ID:"+val3.driverData.get(b).getId()+" Driver Name:"+val3.driverData.get(b).getName()
							+" Driver Surname:"+val3.driverData.get(b).getSurname(), outputFile);
				}
			}
			out.writeOutput("\n", outputFile);
		}
	
	}
	

}
