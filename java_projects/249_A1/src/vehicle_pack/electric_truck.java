// 
// Assignment 1 
// Question: 1 
// Written by: Jack Fraser 40266009
// 




package vehicle_pack;

public class electric_truck extends electric_vehicle{

	protected int maxcapacity;
	private static int numberofelectrictrucks=0;
	
	/**
	 * sets the plate number of the object
	 */
	protected void setplate() {
		this.platenumber="ET"+(1001+numberofelectrictrucks);
	}
	
	//constructors
	
	/**
	 * default constructor, initializes numerical variables to 0, and string variables to "NA", sets a plate number normally  
	 */
	public electric_truck() 
	{
		super("NA","NA",0,0);
		this.maxcapacity=0;
		setplate();
		numberofelectrictrucks++;
	}
	/**parameter constructor, intializes parameterized instance of electric_car object. And automatically assigns plate number
	 * @param make is the make of the gas_car
	 * @param model is the model of the gas_car
	 * @param year is the production year of the gas_car
	 * @param maxrange is the max range of the electric_car
	 * @param maxcapacity is the maximum load capacity in kg of the electric_truck
	 */
	public electric_truck(String make, String model, int year,int maxrange,int maxcapacity) {
		
		super( make, model, year, maxrange);
		this.maxcapacity=maxcapacity;
		setplate();
		numberofelectrictrucks++;
	}
	
	/**
	 * copy constructor, copies given objects attributes to create a deep copy
	 * @param copy is the electric_truck to copy
	 */
	public electric_truck(electric_truck copy) {
		super( copy.getMake(), copy.getModel(), copy.getYear(), copy.getMaxrange());
		this.maxcapacity=copy.maxcapacity;
		this.platenumber=copy.platenumber;
		numberofelectrictrucks++;
	}

	
	//getters and setters
	/**
	 * gives the max load capacity of the electric_truck
	 * @return maxcapacity
	 */
	public int getMaxcapacity() {
		return maxcapacity;
	}
	/**
	 * changes the maximum load capacity of the 
	 * @param maxcapacity
	 */
	public void setMaxcapacity(int maxcapacity) {
		this.maxcapacity = maxcapacity;
	}
	/**
	 * gives the number of existing electric_trucks
	 * @return numberofelectrictrucks
	 */
	public static int getNumberofelectrictrucks() {
		return numberofelectrictrucks;
	}

	
	
	
	/**
	 * updates vehicle info with the given parameters
	 * @param make to change to
	 * @param model to change to
	 * @param year to change to
	 * @param maxrange to change to
	 * @param maxcapacity to change to
	 */
	public void updatecehicleinfo(String make,String model,int year,int maxrange,int maxcapacity) {
		super.updatecehicleinfo(make, model, year,maxrange);
		this.maxcapacity=maxcapacity;
		
		
	}
	
	
	
	
	
	/**
	 * gives the string representation of the object and its attributes
	 * @return formated string of object attributes
	 */
	public String toString() {
		return "electric_truck [maxcapacity=" + maxcapacity + ", maxrange=" + maxrange + ", platenumber=" + platenumber
				+ ", make=" + make + ", model=" + model + ", year=" + year + "]";
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
			electric_truck compare=(electric_truck) comp;
			//this if checks that the remaning attributes are the same and return true/false accordingly  
			if(this.maxrange==compare.maxrange&&this.maxcapacity==compare.maxcapacity) {return true;}
			else {return false;}
			
			
			
		}
		else {return false;}
	
	}
	
}
