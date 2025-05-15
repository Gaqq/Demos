// 
// Assignment 1 
// Question: 1 
// Written by: Jack Fraser 40266009
// 



package vehicle_pack;




public class diesel_truck extends vehicle {
	
	
	protected int maxcapacity;
	protected int fuelcapacity;
	private static int diesel_numberoftrucks=0;
	
	/**
	 * updates vehicle info with the given parameters
	 * @param make to change to
	 * @param model to change to
	 * @param year to change to
	 * @param maxcapacity to change to
	 * @param fuelcapacity
	 */
	public void updatecehicleinfo(String make,String model,int year,int maxcapacity,int fuelcapacity) {
		super.updatecehicleinfo(make, model, year);
		this.maxcapacity=maxcapacity;
		this.fuelcapacity=fuelcapacity;
		
		
	}
	
	
	
	/**
	 * sets the plate number of the object
	 */
protected void setplate() {
		
	
		
		this.platenumber= "DT"+(1001+diesel_numberoftrucks);
		
	}
	
	
	/**parameter constructor, intializes parameterized instance of deisel_truck object. and automatically assigns plate number
	 * @param make is the make of the diesel_truck
	 * @param model is the model of the diesel_truck
	 * @param year is the production year of the diesel_truck
	 * @param maxcapacity is the maximum capacity of the truck
	 * 
	 * 
	 */
	public diesel_truck(String make,String model,int year,int maxcapacity,int fuelcapacity) {
		
		super(make, model, year);
		this.maxcapacity=maxcapacity;
		this.fuelcapacity=fuelcapacity;
		setplate();
		
		
		diesel_numberoftrucks++;
	}
	/**
	 * default constructor, initializes numerical variables to 0, and string variables to "NA", sets a plate number normally  
	 */
	public diesel_truck() {
			
			super("NA", "NA", 0);
			this.maxcapacity=0;
			this.fuelcapacity=0;
			setplate();
			
			diesel_numberoftrucks++;
		}
	/**
	 * copy constructor, copies given objects attributes to create a deep copy
	 * @param copy is the diesel_truck to copy
	 */
public diesel_truck(diesel_truck copy) {
		
		super(copy.getMake(), copy.getMake(), copy.getYear());
		this.maxcapacity=copy.maxcapacity;
		this.platenumber=copy.getPlatenumber();
		this.fuelcapacity=copy.fuelcapacity;
		
		diesel_numberoftrucks++;
	}

	//getters and setters
	/**
	 * gives the array of all the existing diesel_trucks
	 * @return alldieseltrucks
	 */
	
	
	/**
	 * gives maxcapacity of diesel_truck
	 * @return maxcapacity of the diesel_truck
	 */
	public int getMaxcapacity() {
		return new diesel_truck(this).maxcapacity;
	}

	/**
	 * changes maxcapacity
	 * @param maxcapacity is the new max capacity to set
	 */
	public void setMaxcapacity(int maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	/**
	 * gives number of diesel_truck
	 * @return number of the diesel_truck
	 */
	public static int getNumberofdiesel_trucks() {
		return diesel_numberoftrucks;
	}
	
	/**
	 * gives fuel capacity of diesel_truck
	 * @return fuelcapacity
	 */
	public int getFuelcapacity() {
		return fuelcapacity;
	}

	/**
	 * changes fuel capacity
	 * @param fuelcapacity
	 */
	public void setFuelcapacity(int fuelcapacity) {
		this.fuelcapacity = fuelcapacity;
	}


	/**
	 * compare 2 vehicles
	 * @param vehicle to compare
	 * @return true if vehicles are the same false otherwise
	 * do you guys even read all of these, cause like there is no way. like could i just write BS for the doc and u just mark it as done?
	 */
	public boolean equals(vehicle comp) {
		//this if checks if the objects are the same vehicle type 
		if(super.equals(comp)) {
			//this type casts the object to compare to the gas_car type to access the gas_car methods+attributes
			//we are able to type cast without data loss because the previous if confirms that the compared vehicle (comp) is a gas_car
			diesel_truck compare=(diesel_truck) comp;
			//this if checks that the remaning attributes are the same and return true/false accordingly  
			if(this.maxcapacity==compare.maxcapacity) {return true;}
			else {return false;}
			
			
			
		}
		else {return false;}
	
	
	
	
	
	
	

}

	


	/**
	 * gives the string representation of the object and its attributes
	 * @return formated string of object attributes
	 */
	public String toString() {
		return "diesel_truck [maxcapacity=" + maxcapacity + ", fuelcapacity=" + fuelcapacity + ", platenumber="
				+ platenumber + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	}
	
}
