package vehicle_pack;
//
//Assignment 1 
//Question: 1 
//Written by: Jack Fraser 40266009
//
public class gas_car extends vehicle{
	
	protected int maxpassengers;
	private static int numberofgascars=0;
	/**
	 * sets the plate number of the object
	 */
	protected void setplate() {
		this.platenumber="GC"+(1001+numberofgascars);
		
	}
	/**
	 * default constructor, initializes numerical variables to 0, and string variables to "NA", sets a plate number normally  
	 */
	public gas_car() {
		super("NA","NA",0);
		this.maxpassengers=0;
		setplate();
		numberofgascars++;
	}
	/**parameter constructor, intializes parameterized instance of gas_car object. and automatically assigns plate number
	 * @param make is the make of the gas_car
	 * @param model is the model of the gas_car
	 * @param year is the production year of the gas_car
	 * @param maxpassengers is the max amount of passengers of the gas_car
	 */
public gas_car(String make,String model,int year,int maxpassengers) {
		
		super(make, model, year);
		this.maxpassengers=maxpassengers;
		
		setplate();
		numberofgascars++;
	}
/**
 * copy constructor, copies given objects attributes to create a deep copy
 * @param copy is the gas_car to copy
 */
public gas_car(gas_car copy) {
	super(copy.getMake(),copy.getModel(),copy.getYear());
	this.maxpassengers=copy.maxpassengers;
	this.platenumber=copy.platenumber;
	numberofgascars++;
}
/**
 * updates vehicle info with the given parameters
 * @param make to change to
 * @param model to change to
 * @param year to change to
 * @param maxpassengers to change
 */
public void updatecehicleinfo(String make,String model,int year,int maxpassengers) {
	super.updatecehicleinfo(make, model, year);
	this.maxpassengers=maxpassengers;
	
}




//tostring
/**
 * gives the string representation of the object and its attributes
 * @return formated string of object attributes
 */
public String toString() {
	return "gas_car [maxpassengers=" + maxpassengers + ", platenumber=" + platenumber + ", make=" + make + ", model="
			+ model + ", year=" + year + "]";
}
//getters and setters

/**
 * gives the max amount of passengers for the car
 * @return maxpassengers 
 */
public int getMaxpassengers() {
	return maxpassengers;
}

/**
 * changes the maximum amount of passengers for the car
 * @param maxpassengers
 */
public void setMaxpassengers(int maxpassengers) {
	this.maxpassengers = maxpassengers;
}
/**
 * gives the Number of gas cars 
 * @return Numberofgascars 
 */
public static int getNumberofgascars() {
	return numberofgascars;
}
/**
 * compare 2 vehicles
 * @param vehicle to compare
 * @return true if vehicles are the same false otherwise
 * 
 */
public boolean equals(vehicle comp) {
	//this if checks if the objects are the same vehicle type 
	if(super.equals(comp)) {
		//this type casts the object to compare to the gas_car type to access the gas_car methods+attributes
		//we are able to type cast without data loss because the previous if confirms that the compared vehicle (comp) is a gas_car
		gas_car compare=(gas_car) comp;
		//this if checks that the remaning attributes are the same and return true/false accordingly  
		if(this.maxpassengers==compare.maxpassengers) {return true;}
		else {return false;}
		
		
		
	}
	else {return false;}
	
}
}








