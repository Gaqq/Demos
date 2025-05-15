package client_pack;
import vehicle_pack.*;

abstract public class managment {
//this class is abstract because there is only one managment body 
	private static client[] clientlist= {};
	
	
	
	private static vehicle[][] vehiclestock={new gas_car[0],new diesel_truck[0],new electric_car[0],new electric_truck[0]};
	
	
	
	
	/**
	 * gives the 2d array of all vehicles.
	 * it is an array of 4 arrays each one containing a different vehicle type 
	 * 0=gas cars, 1=diesel trucks, 2=electric cars, 3=electric trucks
	 * not this array does not contain all exisiting vehicles just the ones added to the vehiclestock
	 * @return vehiclestock
	 */
	public static vehicle[][] getVehiclestock() 
	{
	return vehiclestock;
	}
	
	/**
	 * gives the array of all clients under managment
	 * note that this is not the array of all existing clients but just the ones that were added to the clientlist array
	 * @return clientlist
	 */
	public static client[] getClientlist() 
	{
		return clientlist;
	}
	
	/**
	 * prints to console a formated list of all clients along with there vehicles 
	 */
	public static void printclientlist() {
		for(int i=0;i<clientlist.length;i++) {
			System.out.println(i+"-"+clientlist[i]);
		}	
	}
	/**
	 * prints to console a formated list of all clients 
	 */
	public static void printclients() {
		for(int i=0;i<clientlist.length;i++) {
			System.out.println(i+"-"+clientlist[i].getName());
		}	
	}
	
	/**
	 * Prints to console a list of all the vehicles under managment
	 */
	public static void printallvehicles() {
		
		String[] types= {"Gas Cars:","Diesel Trucks:","Electric Cars:","Electric Trucks:"};
		for(int type=0;type<4;type++) {
			System.out.println("\n"+type+"-"+types[type]);
					
					for(int i=0; i<managment.getVehiclestock()[type].length;i++) {
						
						System.out.println("|\t"+i+"-"+managment.getVehiclestock()[type][i]);
						
					}		
				}
			}
	
	

	/**
	 * moves the vehicle passed as a parameter from the managment vehiclestock to the client vehiclestock
	 * @param leaser is the client to move the vehicle to
	 * @param lease is the vehicle to move
	 */
	public static void leasetoclient(client leaser,vehicle lease) 
	{
		
		
		
		if(lease.getClass()==gas_car.class) {
			gas_car placeholder=(gas_car)lease;
			leaser.addvehicle(placeholder);
			managment.removeVehicle(placeholder);
		}
		else if(lease.getClass()==diesel_truck.class) {
			diesel_truck placeholder=(diesel_truck)lease;
			leaser.addvehicle(placeholder);
			managment.removeVehicle(placeholder);
		}
		else if(lease.getClass()==electric_car.class) {
			electric_car placeholder=(electric_car)lease;
			leaser.addvehicle(placeholder);
			managment.removeVehicle(placeholder);
		}
		else if(lease.getClass()==electric_truck.class) {
			electric_truck placeholder=(electric_truck)lease;
			leaser.addvehicle(placeholder);
			managment.removeVehicle(placeholder);
		}
		
	}
	/**
	 * moves the vehicle passed as a parameter from the client vehiclestock to the managment vehiclestock
	 * @param leaser is the client to move the vehicle from
	 * @param lease is the vehicle to move
	 */
	public static void returnlease(client leaser,vehicle lease) 
	{
		if(lease.getClass()==gas_car.class) {
			gas_car placeholder=(gas_car)lease;
			managment.addvehicle(placeholder);
			leaser.removeVehicle(placeholder);
		}
		else if(lease.getClass()==diesel_truck.class) {
			diesel_truck placeholder=(diesel_truck)lease;
			managment.addvehicle(placeholder);
			leaser.removeVehicle(placeholder);
		}
		else if(lease.getClass()==electric_car.class) {
			electric_car placeholder=(electric_car)lease;
			managment.addvehicle(placeholder);
			leaser.removeVehicle(placeholder);
		}
		else if(lease.getClass()==electric_truck.class) {
			electric_truck placeholder=(electric_truck)lease;
			managment.addvehicle(placeholder);
			leaser.removeVehicle(placeholder);
		}
	}
	
	/**
	 * adds a client to managments static array clientlist
	 * @param  client to add
	 */
	public static void addclient(client toadd) {
		
		client[] newarr=new client[clientlist.length+1];
		
		for(int i=0;i<clientlist.length;i++) {
			newarr[i]=clientlist[i];
		}
		newarr[newarr.length-1]=toadd;	
		clientlist=newarr;
	}
	/**
	 * removes a client from managments static array clientlist
	 * @param  client to remove
	 */
	public static boolean removeclient(client toremove) {
		try	{
		client[] newarr=new client[clientlist.length-1];
		int n=0;
		for(int i=0;i<clientlist.length;i++) {
			if(toremove!=clientlist[i]) {
			newarr[n]=clientlist[i];
			n++;
			}
		}
		clientlist=newarr;
		return true;
	}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
	
	/**
	 * adds a vehicle to managments static array vehiclestock
	 * @param toadd
	 */
	public static void addvehicle(gas_car toadd) {
		int type=0;
		
		gas_car[] newarr=new gas_car[vehiclestock[type].length+1];
		for(int i=0;i<vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			gas_car addition =(gas_car) vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		gas_car toaddition=(gas_car) toadd;
		newarr[newarr.length-1]=toaddition;
		vehiclestock[type]=newarr;
			
	}
	
	/**
	 * adds a vehicle to managments static array vehiclestock
	 * @param toadd
	 */
	public static void addvehicle(diesel_truck toadd) {
		int type=1;
		
		diesel_truck[] newarr=new diesel_truck[vehiclestock[type].length+1];
		for(int i=0;i<vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			diesel_truck addition =(diesel_truck) vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		diesel_truck toaddition=(diesel_truck) toadd;
		newarr[newarr.length-1]=toaddition;
		vehiclestock[type]=newarr;
			
	}
	/**
	 * adds a vehicle to managments static array vehiclestock
	 * @param toadd
	 */
	public static void addvehicle(electric_car toadd) {
		int type=2;
		
		electric_car[] newarr=new electric_car[vehiclestock[type].length+1];
		for(int i=0;i<vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			electric_car addition =(electric_car) vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		electric_car toaddition=(electric_car) toadd;
		newarr[newarr.length-1]=toaddition;
		vehiclestock[type]=newarr;
			
	}
	
	/**
	 * adds a vehicle to managments static array vehiclestock
	 * @param toadd
	 */
	public static void addvehicle(electric_truck toadd) {
		int type=3;
		
		electric_truck[] newarr=new electric_truck[vehiclestock[type].length+1];
		for(int i=0;i<vehiclestock[type].length;i++) {
			//type casting the element being added to the new list to be the corresponding type and not type vehicle so it can be added to the new array
			electric_truck addition =(electric_truck) vehiclestock[type][i];
			newarr[i]=addition;
		}
		//type cast the vehicle toadd to the correct type so it can be added to the new array  
		electric_truck toaddition=(electric_truck) toadd;
		newarr[newarr.length-1]=toaddition;
		vehiclestock[type]=newarr;
			
	}
	
	/**
	 * removes a given vehicle from the vehicle stock 
	 * @param toremove is the vehicle to remove
	 * @return false if given paramter to remove is not in vehicle stock array
	 */
	public static boolean removeVehicle(gas_car toremove) 
		{
		int type=0;
		
		try {
		vehicle[] newarr=new vehicle[vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<vehiclestock[type].length;i++ ) {
			if(toremove!=vehiclestock[type][i]) {
				newarr[n]=vehiclestock[type][i];
				n++;
			}
			
		}
		vehiclestock[type]=newarr;
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
	public static boolean removeVehicle(diesel_truck toremove) 
		{
		int type=1;
		
		try {
		vehicle[] newarr=new vehicle[vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<vehiclestock[type].length;i++ ) {
			if(toremove!=vehiclestock[type][i]) {
				newarr[n]=vehiclestock[type][i];
				n++;
			}
			
		}
		vehiclestock[type]=newarr;
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
	public static boolean removeVehicle(electric_car toremove) 
		{
		int type=2;
		
		try {
		vehicle[] newarr=new vehicle[vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<vehiclestock[type].length;i++ ) {
			if(toremove!=vehiclestock[type][i]) {
				newarr[n]=vehiclestock[type][i];
				n++;
			}
			
		}
		vehiclestock[type]=newarr;
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
	public static boolean removeVehicle(electric_truck toremove) 
		{
		int type=3;
		
		try {
		vehicle[] newarr=new vehicle[vehiclestock[type].length-1];
		int n=0;
		for(int i=0;i<vehiclestock[type].length;i++ ) {
			if(toremove!=vehiclestock[type][i]) {
				newarr[n]=vehiclestock[type][i];
				n++;
			}
			
		}
		vehiclestock[type]=newarr;
		return true;
		}
		catch(Exception e){
			return false;
		}
		}
	
	
	/**
	 * creates a deep copy of the given array of electric_trucks 
	 * @param model is the array to copy
	 * @return copies is the deep copy of the array
	 */
	public static electric_truck[] copyVehicles(electric_truck[] model) {
		electric_truck[] copies=new electric_truck[model.length];
		for(int i=0; i<model.length;i++) {
			copies[i]=new electric_truck(model[i]);
		}
		return copies;
		
		
	}
	/**
	 * gives the diesel_truck with the largest maximum capacity
	 * @return largesttruck is the truck with the largest capacity
	 * @return null if no diesel_trucks currently exist
	 */
	public static diesel_truck getLargesttruck() {
		int type=1;
		
		
		try {
		diesel_truck largest=(diesel_truck)vehiclestock[type][0];
		
			for(int i=0;i<vehiclestock[type].length;i++ ) {
				diesel_truck placeholder=(diesel_truck) vehiclestock[type][i];
				if(placeholder.getMaxcapacity()>largest.getMaxcapacity()) {
					largest=placeholder;
				}
				
			}
			return largest;
		}
		catch(Exception e) {
			return null;
		}
		
	
		
		
	}
	/**
	 * returns the number of vehicles in managments stock
	 * @return number of vehicles
	 */
	public static int getnumberofvehicles() {
		return vehiclestock[0].length+vehiclestock[1].length+vehiclestock[2].length+vehiclestock[3].length;
	}
}
	

