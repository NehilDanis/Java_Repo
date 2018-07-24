package data;

import java.util.*;

import item.*;

public abstract class Database {//That is an abstract class.
	
	public abstract void insert(Bus element,String outputFile);
	public abstract void insert(Bus_Stop element,String outputFile);
	public abstract void insert(Driver element,String outputFile);
	public abstract void insert(Route element,String outputFile);
	public abstract void insert(Service element,String outputFile);
	
	public abstract void controller(int controller);

}
