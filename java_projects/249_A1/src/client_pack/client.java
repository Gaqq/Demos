package client_pack;

import vehicle_pack.*;

public class client {
	
	private String name;
	
	private vehicle[][] vehiclestock={new gas_car[0],new diesel_truck[0],new electric_car[0],new electric_truck[0]};
	
	//constructors
	/**
	 * paramterized constructor
	 * @param name of client
	 */
	public client(String name) {
		
		
		this.name=name;
	}
	/**
	 * copy constructor
	 * @param copy
	 */
	public client(client copy) {
			
			this.name=copy.name;
			this.vehiclestock=copy.vehiclestock;
	}
	/**
	 * default constructor
	 */
	public client() {
		
		this.name="NA";
		
	}
	/**
	 * changes the clients name
	 * @param newname
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * gives the clients name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * returns the number of vehicles currently in the client vehiclestock 
	 * @return number of vehicles
	 */
	public int getnumberofvehicles() {
		return this.vehiclestock[0].length+this.vehiclestock[1].length+this.vehiclestock[2].length+this.vehiclestock[3].length;
	}
	
	/**
	 * returns a formated string of all the clients information
	 */
	public String toString() 
	{
		 String vehicles="";
		
		String[] types= {"Gas Cars:","Diesel Trucks:","Electric Cars:","Electric Trucks:"};
		for(int type=0;type<4;type++) {
			vehicles+="\n|\t"+types[type];
					
					for(int i=0; i<this.vehiclestock[type].length;i++) {
					
						vehicles+="\n|\t|\t-"+this.vehiclestock[type][i];
				}		
				}
		return this.name+":"+vehicles;
		
	}
	
	/**
	 * adds a vehicle to clients array vehiclestock
	 * @param toadd
	 */
	public void addvehicle(gas_car toadd) {
		int type=0;
		
		gas_car[] newarr=new gas_car[this.vehiclestock[type].length+1];
		for(int i=0;i<this.vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			gas_car addition =(gas_car) this.vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		gas_car toaddition=(gas_car) toadd;
		newarr[newarr.length-1]=toaddition;
		this.vehiclestock[type]=newarr;
			
	}
	/**
	 * adds a vehicle to clients array vehiclestock
	 * @param toadd
	 */
	public void addvehicle(diesel_truck toadd) {
		int type=1;
		
		diesel_truck[] newarr=new diesel_truck[this.vehiclestock[type].length+1];
		for(int i=0;i<this.vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			diesel_truck addition =(diesel_truck) this.vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		diesel_truck toaddition=(diesel_truck) toadd;
		newarr[newarr.length-1]=toaddition;
		this.vehiclestock[type]=newarr;
			
	}
	/**
	 * adds a vehicle to clients array vehiclestock
	 * @param toadd
	 */
	public void addvehicle(electric_car toadd) {
		int type=2;
		
		electric_car[] newarr=new electric_car[this.vehiclestock[type].length+1];
		for(int i=0;i<this.vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			electric_car addition =(electric_car) this.vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		electric_car toaddition=(electric_car) toadd;
		newarr[newarr.length-1]=toaddition;
		this.vehiclestock[type]=newarr;
			
	}
	/**
	 * adds a vehicle to clients array vehiclestock
	 * @param toadd
	 */
	public void addvehicle(electric_truck toadd) {
		int type=2;
		
		electric_truck[] newarr=new electric_truck[this.vehiclestock[type].length+1];
		for(int i=0;i<this.vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			electric_truck addition =(electric_truck) this.vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		electric_truck toaddition=(electric_truck) toadd;
		newarr[newarr.length-1]=toaddition;
		this.vehiclestock[type]=newarr;
			
	}
	
	/**
	 * removes a given vehicle from the vehicle stock 
	 * @param toremove is the vehicle to remove
	 * @return false if given paramter to remove is not in vehicle stock array
	 */
	public boolean removeVehicle(gas_car toremove) 
		{
		int type=0;
		
		try {
		vehicle[] newarr=new vehicle[this.vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<this.vehiclestock[type].length;i++ ) {
			if(toremove!=this.vehiclestock[type][i]) {
				newarr[n]=this.vehiclestock[type][i];
				n++;
			}
			
		}
		this.vehiclestock[type]=newarr;
		return true;
		}
		catch(Exception e){
			return false;
		}
		}

	
	/**
	 * removes a given vehicle from the vehicle stock 
	 * @param toremove is the vehicle to remove
	 * @return false if given paramter to remove is not in vehicle stock array
	 */
	public boolean removeVehicle(diesel_truck toremove) 
		{
		int type=1;
		
		try {
		vehicle[] newarr=new vehicle[this.vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<this.vehiclestock[type].length;i++ ) {
			if(toremove!=this.vehiclestock[type][i]) {
				newarr[n]=this.vehiclestock[type][i];
				n++;
			}
			
		}
		this.vehiclestock[type]=newarr;
		return true;
		}
		catch(Exception e){
			return false;
		}
		}
	/**
	 * removes a given vehicle from the vehicle stock 
	 * @param toremove is the vehicle to remove
	 * @return false if given paramter to remove is not in vehicle stock array
	 */
	public boolean removeVehicle(electric_car toremove) 
		{
		int type=1;
		
		try {
		vehicle[] newarr=new vehicle[this.vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<this.vehiclestock[type].length;i++ ) {
			if(toremove!=this.vehiclestock[type][i]) {
				newarr[n]=this.vehiclestock[type][i];
				n++;
			}
			
		}
		this.vehiclestock[type]=newarr;
		return true;
		}
		catch(Exception e){
			return false;
		}
		}
	/**
	 * removes a given vehicle from the vehicle stock 
	 * @param toremove is the vehicle to remove
	 * @return false if given paramter to remove is not in vehicle stock array
	 */
	public boolean removeVehicle(electric_truck toremove) 
		{
		int type=1;
		
		try {
		vehicle[] newarr=new vehicle[this.vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<this.vehiclestock[type].length;i++ ) {
			if(toremove!=this.vehiclestock[type][i]) {
				newarr[n]=this.vehiclestock[type][i];
				n++;
			}
			
		}
		this.vehiclestock[type]=newarr;
		return true;
		}
		catch(Exception e){
			return false;
		}
		}
	
		/**
		 * prints to console all the vehicles in the given clients vehiclestock 
		 */
		public void printallvehicles() {
		
		String[] types= {"Gas Cars:","Diesel Trucks:","Electric Cars:","Electric Trucks:"};
		for(int type=0;type<4;type++) {
			System.out.println("\n"+type+"-"+types[type]);
					
					for(int i=0; i<this.vehiclestock[type].length;i++) {
						
						System.out.println("|\t"+i+"-"+this.vehiclestock[type][i]);
						
					}		
				}
			}
	
	
}

