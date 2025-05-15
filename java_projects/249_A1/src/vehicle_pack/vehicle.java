// 
// Assignment 1 
// Question: 1 
// Written by: Jack Fraser 40266009
// 


package vehicle_pack;

import client_pack.managment;

public abstract class vehicle {
	
	
	protected String platenumber;
	protected String make;
	protected String model;
	protected int year;
	
	 
	/**
	 * parameterized constructor
	 * @param make is the vehicles make
	 * @param model is the vehicles model
	 * @param year is the vehicles production year
	 */
	public vehicle(String make,String model,int year) {
		this.make=make;
		this.model=model;
		this.year=year;
		
	}
	
	
		
	
	protected void updatecehicleinfo(String make,String model,int year) {
		this.make=make;
		this.model=model;
		this.year=year;
		
	}
	
	
	//setplate function to be defined by the child classes
	protected abstract void setplate();

	//getters and setters 
	//note that there is no setPlate because after it is generated it does not to be reset
	
	/**
	 * gives the vehicles plate number
	 * @return platenumber
	 */
	public String getPlatenumber() {
		return platenumber;
	}

	
	/**
	 * gives the vehicles make
	 * @return make
	 */
	protected String getMake() {
		return make;
	}
	/**
	 * changes the vehicles make
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * gives the vehicles model
	 * @return model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * changes the vehicles model
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * gives the vehicles production year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * changes the vehicles production year
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	
	
	
	//equals 
	/**
	 * compare 2 vehicles
	 * @param vehicle to compare
	 * @return true if vehicles are the same false otherwise
	 */
	public boolean equals(vehicle comp) {
		//checks to make sure that the objects compared have the same attributes as well as as the same object type
		if(this.getClass()==comp.getClass()&&this.getMake().equals(comp.getMake())&&this.getModel().equals(comp.getModel())&&this.getYear()==comp.getYear()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	
	
	
	
	

}
}
