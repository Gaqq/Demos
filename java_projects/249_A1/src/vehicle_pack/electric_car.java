// 
// Assignment 1 
// Question: 1 
// Written by: Jack Fraser 40266009
// 



package vehicle_pack;

public class electric_car extends electric_vehicle{
	
	private static int numberofelectriccars=0;
	
	/**
	 * sets the plate number of the object
	 */
	protected void setplate() {
		this.platenumber= "EC"+1001+numberofelectriccars;
		
	}
	
	
	//contructors
	/**
	 * default constructor, initializes numerical variables to 0, and string variables to "NA", sets a plate number normally  
	 */
	public electric_car() {
		super("Na","Na",0,0);
		setplate();
		numberofelectriccars++;
	}
	/**parameter constructor, intializes parameterized instance of electric_car object. And automatically assigns plate number
	 * @param make is the make of the gas_car
	 * @param model is the model of the gas_car
	 * @param year is the production year of the gas_car
	 * @param maxrange is the max range of the electric_car
	 */
	public electric_car(String make,String model,int year,int maxrange) {
		super( make, model, year, maxrange);
		setplate();
		numberofelectriccars++;		
	}
	/**
	 * copy constructor, copies given objects attributes to create a deep copy
	 * @param copy is the electric_car to copy
	 */
	public electric_car(electric_car copy) {
		super( copy.getMake(), copy.getModel(), copy.getYear(), copy.getMaxrange());
		this.platenumber=copy.platenumber;
		numberofelectriccars++;
	}

//getters and setters
	/**
	 * gives the number of existing electric_car objects
	 * @return numberofelectriccars
	 */
	public static int getNumberofelectriccars() {
		return numberofelectriccars;
	}


//tostring
	/**
	 * gives the string representation of the object and its attributes
	 * @return formated string of object attributes
	 */
	public String toString() {
		return "electric_car [maxrange=" + maxrange + ", platenumber=" + platenumber + ", make=" + make + ", model="
				+ model + ", year=" + year + "]";
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
			electric_car compare=(electric_car) comp;
			//this if checks that the remaning attributes are the same and return true/false accordingly  
			if(this.maxrange==compare.maxrange) {return true;}
			else {return false;}
			
			
			
		}
		else {return false;}
	
	
	
	}



}
