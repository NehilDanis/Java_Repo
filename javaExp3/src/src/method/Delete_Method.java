package method;
import java.util.Iterator;

import data.*;
import inOut.*;
import item.*;

public class Delete_Method {
	Output out=new Output();//This use for writing output.
	Oracle val1=new Oracle();//These use for using the different database.
	MySQL val2=new MySQL();
	PostgreSQL val3=new PostgreSQL();
	
	public void DELETE_BUS(String [] splittedArray,String databaseWord,String outputFile){

		if(databaseWord.equals("Oracle")){
			int count=0;
			 Iterator <Bus> itrbus = val1.busData.iterator();
			 Iterator <Service> itrService=val1.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getBus_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 while(itrbus.hasNext()){
				 if(itrbus.next().getId().equals(splittedArray[0])){
					 itrbus.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}

		else if(databaseWord.equals("MySQL")){
			int count=0;
			 Iterator <Bus> itrbus = val2.busData.iterator();
			 Iterator <Service> itrService=val2.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getBus_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 while(itrbus.hasNext()){
				 if(itrbus.next().getId().equals(splittedArray[0])){
					 itrbus.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			int count=0;
			 Iterator <Bus> itrbus = val3.busData.iterator();
			 Iterator <Service> itrService=val3.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getBus_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 while(itrbus.hasNext()){
				 if(itrbus.next().getId().equals(splittedArray[0])){
					 itrbus.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}
	}
	
	public void DELETE_DRIVER(String [] splittedArray,String databaseWord,String outputFile){

		if(databaseWord.equals("Oracle")){
			int count=0;
			 Iterator <Driver> itrDriver = val1.driverData.iterator();
			 Iterator <Service> itrService=val1.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getDriver_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 
			 while(itrDriver.hasNext()){
				 if(itrDriver.next().getId().equals(splittedArray[0])){
					 itrDriver.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}
		else if(databaseWord.equals("MySQL")){
			int count=0;
			 Iterator <Driver> itrDriver = val2.driverData.iterator();
			 Iterator <Service> itrService=val2.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getDriver_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 
			 while(itrDriver.hasNext()){
				 if(itrDriver.next().getId().equals(splittedArray[0])){
					 itrDriver.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			int count=0;
			 Iterator <Driver> itrDriver = val3.driverData.iterator();
			 Iterator <Service> itrService=val3.serviceData.iterator();
			 while(itrService.hasNext()){
				 if(itrService.next().getDriver_id().equals(splittedArray[0])){
					 itrService.remove();
				 }
			 }
			 
			 while(itrDriver.hasNext()){
				 if(itrDriver.next().getId().equals(splittedArray[0])){
					 itrDriver.remove();
					 count++;
					 break;
				 }
			 }
			 if(count==0){
				 out.writeOutput("ERROR\n", outputFile);
				}
				else if (count>0) {
					out.writeOutput("SUCCESSFULL\n", outputFile);
				}
			
		}
		
		
		
	}
	
	public void DELETE_BUS_STOP(String [] splittedArray,String databaseWord,String outputFile){
		if(databaseWord.equals("Oracle")){
			int count=0;
			String itr;
			for(int a=0;a<val1.routeData.size();a++){
				for(int b=0;b<val1.routeData.get(a).getBus_stop_id().size();b++){
					if(val1.routeData.get(a).getBus_stop_id().get(b).equals(splittedArray[0])){
						itr=val1.routeData.get(a).getId();
						val1.routeData.remove(a);
						for(int c=0;c<val1.serviceData.size();c++){
							if(val1.serviceData.get(c).getRoute_id().equals(itr)){
								val1.serviceData.remove(c);
								
							}
						}
					}
				}
			}
			
			for(int i=0;i<val1.busStopData.size();i++){
				if(val1.busStopData.get(i).getId().equals(splittedArray[0])){
					val1.busStopData.remove(i);
					count++;
					break;
				}
			}
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if (count>0) {
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}

		}
		else if(databaseWord.equals("MySQL")){
			
			int count=0;
			String itr;
			for(int a=0;a<val2.routeData.size();a++){
				for(int b=0;b<val2.routeData.get(a).getBus_stop_id().size();b++){
					if(val2.routeData.get(a).getBus_stop_id().get(b).equals(splittedArray[0])){
						itr=val2.routeData.get(a).getId();
						val2.routeData.remove(a);
						for(int c=0;c<val2.serviceData.size();c++){
							if(val2.serviceData.get(c).getRoute_id().equals(itr)){
								val2.serviceData.remove(c);
								
							}
						}
					}
				}
			}
			
			for(int i=0;i<val2.busStopData.size();i++){
				if(val2.busStopData.get(i).getId().equals(splittedArray[0])){
					val2.busStopData.remove(i);
					count++;
					break;
				}
			}
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if (count>0) {
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			
		}
		else if (databaseWord.equals("PostgreSQL")) {
			int count=0;
			String itr;
			for(int a=0;a<val3.routeData.size();a++){
				for(int b=0;b<val3.routeData.get(a).getBus_stop_id().size();b++){
					if(val3.routeData.get(a).getBus_stop_id().get(b).equals(splittedArray[0])){
						itr=val3.routeData.get(a).getId();
						val3.routeData.remove(a);
						for(int c=0;c<val3.serviceData.size();c++){
							if(val3.serviceData.get(c).getRoute_id().equals(itr)){
								val3.serviceData.remove(c);
								
							}
						}
					}
				}
			}
			
			for(int i=0;i<val3.busStopData.size();i++){
				if(val3.busStopData.get(i).getId().equals(splittedArray[0])){
					val3.busStopData.remove(i);
					count++;
					break;
				}
			}
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if (count>0) {
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
		}
	}
	
	public void DELETE_ROUTE(String [] splittedArray,String databaseWord,String outputFile){
		if(databaseWord.equals("Oracle")){
			int count=0;
			Iterator<Service> itrService=val1.serviceData.iterator();
			Iterator<Route> itrRoute=val1.routeData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getRoute_id().equals(splittedArray[0])){
					itrService.remove();
				}
			}
			while(itrRoute.hasNext()){
				if(itrRoute.next().getId().equals(splittedArray[0])){
					itrRoute.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
		}
		else if(databaseWord.equals("MySQL")){
			int count=0;
			Iterator<Service> itrService=val2.serviceData.iterator();
			Iterator<Route> itrRoute=val2.routeData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getRoute_id().equals(splittedArray[0])){
					itrService.remove();
				}
			}
			while(itrRoute.hasNext()){
				if(itrRoute.next().getId().equals(splittedArray[0])){
					itrRoute.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			
		}
		else if(databaseWord.equals("PostgreSQL")){
			int count=0;
			Iterator<Service> itrService=val3.serviceData.iterator();
			Iterator<Route> itrRoute=val3.routeData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getRoute_id().equals(splittedArray[0])){
					itrService.remove();
				}
			}
			while(itrRoute.hasNext()){
				if(itrRoute.next().getId().equals(splittedArray[0])){
					itrRoute.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
			
		}
		
	}
	
	public void DELETE_SERVICE(String [] splittedArray,String databaseWord,String outputFile){
		if(databaseWord.equals("Oracle")){
			int count=0;
			Iterator<Service> itrService=val1.serviceData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getId().equals(splittedArray[0])){
					itrService.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
		}
		else if(databaseWord.equals("MySQL")){
			int count=0;			
			Iterator<Service> itrService=val2.serviceData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getId().equals(splittedArray[0])){
					itrService.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
		}
		else if (databaseWord.equals("PostgreSQL")) {
			int count=0;
			Iterator<Service> itrService=val3.serviceData.iterator();
			
			while(itrService.hasNext()){
				if(itrService.next().getId().equals(splittedArray[0])){
					itrService.remove();
					count++;
					break;
				}
			}
			
			if(count==0){
				out.writeOutput("ERROR\n", outputFile);
			}
			else if(count>0){
				out.writeOutput("SUCCESSFULL\n", outputFile);
			}
		}
		
	}

}
