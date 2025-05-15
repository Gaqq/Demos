// 
// Assignment 1 
// Question: 1 
// Written by: Jack Fraser 40266009
// 


/*
 * this program uses 3 packages to 
 * 
 * 
 * 
 * the program does not add vehicles to Royalrental b when they are initialized you must add them with managment.addvehicle(), this was done because it was not specified.
 */








package driver_pack;

import vehicle_pack.*;
import client_pack.*;
import java.util.Scanner;
public class driver {
	static Scanner input=new Scanner(System.in);
	/**takes input until an input lesser or equal than the parameter is passed
	 * @param integer limit of input
	 */
	static int validinput(int limit) {
	
		int x;
		
			 x=input.nextInt();			
		
		while(x>limit) {
			System.out.println("Invalid input. Try again");
			x=input.nextInt();
		}
		//input.close();
		return x;
		
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		boolean run=true;
		
		System.out.println("|Welcome to Royal Rentals!|\n"
							+"---------------------------");
		System.out.println("Enter 1 to access program menu enter anything else to access testing scenario.");
		
		if(input.nextInt()==1) {
		
		while(run) {
			
			System.out.println("______________________________________________________________________________________"+
			"\nplease select an option below (0-3)"+
			"\n0: Vehicle Managment."+
			"\n1: Client Managment."+
			"\n2: Leasing Operations"+
			"\n3: Find the largest diesel truck"+
			"\n4: Quit");
			
			switch(validinput(4)){
			//vehicle managment
			case 0:
				System.out.println("|Vehicle Managment|\n"
						+"---------------------------\n"+
						"\n0: Add a vehicle"+
						"\n1: Delete a vehicle"+
						"\n2: Update vehicle information"+
						"\n3: List all vehicles by category"+
						"\n4: back");
				switch(validinput(4)) {
				//add vehicle
				case 0:
					System.out.println("Enter vehicle type to add \n(0=gas car, 1=diesel truck, 2=electric car, 3=electric truck)");
					switch(validinput(3)) 
					{
					
					case 0: managment.addvehicle(new gas_car()); System.out.println("gas car added!");break;
					case 1: managment.addvehicle(new diesel_truck()); System.out.println("diesel truck added!");break;
					case 2: managment.addvehicle(new electric_car()); System.out.println("electric car added!");break;
					case 3:	managment.addvehicle(new electric_truck()); System.out.println("electric truck added!");break;
						}
					break;
				//remove vehicle
				case 1:
					System.out.println("Enter the number of the vehicle type followed by the number of the vehicle seperated by a space (# #):");
					managment.printallvehicles();
					int type=input.nextInt();
					int vhcl=input.nextInt();
					
					//this switch statement simply type casts the vehicle to removed so that the appropriate overloaded removeVehicle method can be called
					try {
					switch(type) {
						case 0: managment.removeVehicle((gas_car) managment.getVehiclestock()[type][vhcl]);System.out.println("gas car removed!");break;
						case 1: managment.removeVehicle((diesel_truck) managment.getVehiclestock()[type][vhcl]);System.out.println("diesel truck removed!");break;
						case 2: managment.removeVehicle((electric_car) managment.getVehiclestock()[type][vhcl]);System.out.println("electric car removed!");break;
						case 3: managment.removeVehicle((electric_truck) managment.getVehiclestock()[type][vhcl]);System.out.println("electric truck removed!");break;
					}
					}
					catch(Exception e) {System.out.println("the selected car does not exist");}
					
					break;
				//update vehicle info
				case 2:
					System.out.println("Enter the number of the vehicle type followed by the number of the vehicle seperated by a space (# #):");
					managment.printallvehicles();
					 type=input.nextInt();
					 vhcl=input.nextInt();
					 switch(type) {
						case 0:
							System.out.println("enter new info (make model year maxpassengers)");
							gas_car gcplaceholder=(gas_car)managment.getVehiclestock()[type][vhcl]; 
							gcplaceholder.updatecehicleinfo(input.next(), input.next(), input.nextInt(),input.nextInt());
							System.out.println("info updated!");
							break;
						case 1: 
							System.out.println("enter new info (make model year fuelcapacity maxcapacity)");
							diesel_truck dtplaceholder=(diesel_truck)managment.getVehiclestock()[type][vhcl]; 
							dtplaceholder.updatecehicleinfo(input.next(), input.next(), input.nextInt(),input.nextInt(),input.nextInt());
							System.out.println("info updated!");
							break;
						case 2:
							System.out.println("enter new info (make model year maxrange)");
							electric_car ecplaceholder=(electric_car)managment.getVehiclestock()[type][vhcl]; 
							ecplaceholder.updatecehicleinfo(input.next(), input.next(), input.nextInt(),input.nextInt());
							System.out.println("info updated!");
							break;
						case 3: 
							System.out.println("enter new info (make model year maxrange maxcapacity)");
							electric_truck etplaceholder=(electric_truck)managment.getVehiclestock()[type][vhcl]; 
							etplaceholder.updatecehicleinfo(input.next(), input.next(), input.nextInt(),input.nextInt(),input.nextInt());
							System.out.println("info updated!");
							break;
					 }
					
					break;
				//list vehicle info
				case 3:
					managment.printallvehicles();
					
					break;
				case 4:
					break;
				
				}
				
				
				break;
			case 1:
				System.out.println("|Client Managment|\n"
						+"---------------------------\n"+
						"\n0: Add a Client"+
						"\n1: Delete a Client"+
						"\n2: Edit Client"+
						"\n3: Back"
							);
				switch(validinput(3)) 
				{
					//add client
					case 0:
						System.out.println("enter the name of the client to add:");
						managment.addclient(new client(input.next()));
						System.out.println("client added!");
						break;
					//remove client	
					case 1:
						System.out.println("enter the client number to remove:");
						managment.printclients();
						managment.removeclient(managment.getClientlist()[validinput(managment.getClientlist().length-1)]);
						System.out.println("client removed!");
						break;
					//update client info	
					case 2:
						System.out.println("enter the client number to edit:");
						managment.printclients();
						int x=validinput(managment.getClientlist().length-1);
						System.out.println("Enter new name:");
						managment.getClientlist()[x].setName(input.next());
						System.out.println("client info updated!");
					//back
					case 3:
						break;
				}
				
				
				
				break;
				
			case 2:
				System.out.println("|Leasing Operations|\n"
						+"---------------------------"+
						"\n0: Lease a vehicle to a client"+
						"\n1: Return a lease from a client"+
						"\n2: Show all leases by a client"+
						"\n3: Show all leases by all clients"+ 
						"\n4: Back");
				
				switch(validinput(4)) {
				//lease to client
				case 0:
					if(managment.getClientlist().length==0) {
						System.out.println("no clients registered");
						break;
					}
					else if(managment.getnumberofvehicles()<1) {
						System.out.println("no vehicles available to lease");
						break;
					}
					else {
					System.out.println("select a client number to lease");
					managment.printclients();
					int clientindex=validinput(managment.getClientlist().length-1);
					System.out.println("Enter the number of the vehicle type followed by the number of the vehicle seperated by a space (# #):");
					managment.printallvehicles();
					int vcltype=validinput(3);
					managment.leasetoclient(managment.getClientlist()[clientindex], managment.getVehiclestock()[vcltype][validinput(managment.getVehiclestock()[vcltype].length-1)]);
					System.out.println("Lease sucessfull!");
					break;}
				//return lease
				case 1:
					
					if(managment.getClientlist().length==0) {
						System.out.println("no clients registered");
						break;
					}
					else {
					System.out.println("select a client number to return lease");
					managment.printclients();
					int clientindex=validinput(managment.getClientlist().length-1);
					if(managment.getClientlist()[clientindex].getnumberofvehicles()<1) {
						System.out.println("This client has no leased vehicles");
						break;
					}
					else {
					System.out.println("Enter the number of the vehicle type followed by the number of the vehicle seperated by a space (# #):");
					managment.getClientlist()[clientindex].printallvehicles();
					int vcltype=validinput(3);
					managment.returnlease(managment.getClientlist()[clientindex], managment.getVehiclestock()[vcltype][validinput(managment.getVehiclestock()[vcltype].length-1)]);
					System.out.println("Return sucessfull!");}
					break;
					}
				//show specific client
				case 2:
					System.out.println("select a client number to view");
					managment.printclients();
					int clientindex=validinput(managment.getClientlist().length-1);
					managment.getClientlist()[clientindex].printallvehicles();
					break;
				//show all clients
				case 3:
					managment.printclientlist();
					break;
				case 4:
					break;
				}
				
				break;
				
			case 3:
				
				diesel_truck biggest=(managment.getLargesttruck());
				if(biggest==null) {
					System.out.println("there are not diesel truck in stock!");
				}
				else {
					System.out.println("the diesel truck with the largest capacity is: "+biggest);
				}
						
				break;
			case 4:
				run=false;
				break;
				
			}	
			}
		}
		//test scenario
		else {
			gas_car gascar1=new gas_car("ford","fiesta",2005,5);
			gas_car gascar2=new gas_car("ford","focus",2000,2);
			gas_car gascar3=new gas_car("kia","soul",1980,9);
			
			gas_car[] gcarray= {gascar1,gascar2,gascar3};
			
			diesel_truck dieseltruck1=new diesel_truck("ford","f150",2020,100,90);
			diesel_truck dieseltruck2=new diesel_truck("gmc","truck",1900,200,50);
			diesel_truck dieseltruck3=new diesel_truck("dodge","ram",2002,150,40);
			managment.addvehicle(dieseltruck1);
			managment.addvehicle(dieseltruck2);
			managment.addvehicle(dieseltruck3);
			
			diesel_truck[] dtarray= {dieseltruck1,dieseltruck2,dieseltruck3};
			
			electric_car electriccar1=new electric_car("ford","eco",2020,70);
			electric_car electriccar2=new electric_car("tesla","X",2022,50);
			electric_car electriccar3=new electric_car("lightning","mcqueen",2002,100);
			
			electric_car[] ecarray= {electriccar1,electriccar2,electriccar3};
			
			electric_truck electrictruck1=new electric_truck("tesla","cybertruck",2024,70,1000);
			electric_truck electrictruck2=new electric_truck("tesla","cybertruck",2024,70,1000);
			electric_truck electrictruck3=new electric_truck("tesla","cybertruck",2024,70,1000);
			
			electric_truck[] etarray= {electrictruck1,electrictruck2,electrictruck3};
			
			client client1 = new client("brian");
			client client2 = new client("meg");
			client client3 = new client("peter");
			
			client[] clarray= {client1,client2,client3};

			for(int i=0;i<gcarray.length;i++) {
				System.out.println(gcarray[i]);
			}
			for(int i=0;i<dtarray.length;i++) {
				System.out.println(dtarray[i]);
			}
			for(int i=0;i<ecarray.length;i++) {
				System.out.println(ecarray[i]);
			}
			for(int i=0;i<etarray.length;i++) {
				System.out.println(etarray[i]);
			}
			for(int i=0;i<etarray.length;i++) {
				System.out.println(etarray[i]);
			}
			for(int i=0;i<clarray.length;i++) {
				System.out.println(clarray[i]);
			}
			
			System.out.println(electrictruck3.equals(electriccar2));
			System.out.println(electriccar3.equals(electriccar2));
			System.out.println(electrictruck3.equals(electrictruck2));
			
			System.out.println(managment.getLargesttruck());
			
			electric_truck[] copyarray=managment.copyVehicles(etarray);
			
			for(int i=0;i<copyarray.length;i++) {
				System.out.println(copyarray[i]);
			}
			
		}	
		
		
		
		input.close();
		}
		
		
		
	}
	


