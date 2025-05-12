package part2;
import java.io.*;
import java.util.*;

//
//Assignment 3 
//Question: 1 
//Written by: Jack Fraser 40266009 
//
public class TradeManager {
	
	
	/**
	 * reads the tariffs from a given text file and adds the data to the given Tarifflist object
	 * @param list
	 * @param filename
	 */
	public static void readTariffList(TariffList list, String filename) {
		Scanner input =null;
		try {
			input=new Scanner(new FileInputStream(filename));
		}
		catch(IOException e) {
			System.out.println("Input file not accessible");
			System.exit(0);
		}
		//DestinationCountry OriginCountry ProductCategory MinimumTariff 
while(input.hasNextLine()) {
			
			
			
			try{
				Tarrif toadd=new Tarrif(input.next(),input.next(),input.next(),input.nextDouble());
				if(!list.contains(toadd.getDestinationCountry(), toadd.getOriginCountry(), toadd.getProductCategory())) 
				{list.addtostart(toadd);}
				
			}
			catch(Exception e) {
				
			}
			
		}
		input.close();
		
	}
	
	/**
	 * reads from the trade request text file and adds each line as elements of an array list object that is returned 
	 * @param filename
	 * @return arraylist<string> of lines 
	 */
	public static ArrayList<String> readTariffRequests( String filename) {
		Scanner input =null;
		try {
			input=new Scanner(new FileInputStream(filename));
		}
		catch(IOException e) {
			System.out.println("Input file not accessible");
			System.exit(0);
		}
		ArrayList<String> requests=new ArrayList<String>();
		//RequestID OriginCountry DestinationCountry ProductCategory TradeValue ProposedTariff  
while(input.hasNextLine()) {
			requests.add(input.nextLine());
		}
		input.close();
		return requests;
	}
	/**
	 * processes the requests from the given ArrayList and outputs the appropriate messages regarding trade acceptance status 
	 * @param traderequests
	 * @param tarriflist
	 */
	public static void processRequests(ArrayList<String> requests,TariffList list) {
		
		for(String line: requests) {
			String status;
			String[] info =line.split(" ");
			String destination=info[2];
			String origin=info[1];
			String category=info[3];
			String id=info[0];
			double minimumTariff=0;
			double proposedTariff=Double.parseDouble(info[5]);
			double tradevalue=Double.parseDouble(info[4]);
			
			
			try {
				
				minimumTariff=list.find(destination, origin, category).getTarrif().getMinimunTariff();
			 status=list.evaluateTrade(proposedTariff,minimumTariff);
			
			}
			catch(NullPointerException e) {
				status="accepted";//this is if the provided tarrif is not found in the list then we assume the trade is accepted 
				
			}
			if(status.equals("accepted")) {
				System.out.println(id+" - "+status
					+"\nProposed tariff meets or exceeds the minimum requirement.");
			}//surcharge=Trade Value × ((Minimum Tariff - Proposed Tariff) / 100)
			else if(status.equals("conditionally accepted")) {
				double surcharge=(tradevalue*(minimumTariff-proposedTariff)/100);
				System.out.println(id+" - "+status
						+"\nProposed tariff "+proposedTariff+"% is within 20% of the required minimum tariff "+minimumTariff
						+"%\na surcharge of "+surcharge+" is applied");
			}
			else if(status.equals("rejected")) {
				
				System.out.println(id+" - "+status
						+"\nProposed tariff "+proposedTariff+"% is more that 20% below the required minimum tariff "+proposedTariff+"%");
			}
			}
		
		
	}
	
/**
 * inserts 2 enter lines of space in the console 
 */
public static void doublespace() {
	System.out.println("\n\n");
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("A3,part 1, Jack Fraser, 40266009, \nWelcome");
		TariffList list=new TariffList();
		
		
		TariffList list2=new TariffList();
		readTariffList(list,"Required files\\Tariffs.txt");
		
		ArrayList<String> requests=readTariffRequests("Required files\\TradeRequests.txt");
		
		processRequests(requests,list);
		doublespace();
				 
		//functionalities shown 
		list2.addtostart(new Tarrif("china","brazil","Dairy",5));
		list2.printlist();
		doublespace();
		list2.deleteFromStart();
		list2.printlist();
		doublespace();
		
		list2.addtostart(new Tarrif("mexico","germany","electronics",5));
		list2.addtostart(new Tarrif("usa","germany","meat",5));
		list2.addtostart(new Tarrif("india","austria","fruit",5));
		list2.printlist();
		doublespace();
		list2.insertAtindex(new Tarrif("india","austria","fruit",5), 1);
		
		list2.deleteFromindex(3);
		list2.printlist();
		doublespace();
		System.out.println(list2.contains("india","austria","fruit"));
		System.out.println(list2.contains("not","in","list"));
		doublespace();
		processRequests(requests,list2);
		
	
	
	
	
	
		//enter and use find() to return corresponding tariff with number of iterations
		//runs 4 times
				Scanner input = new Scanner(System.in);
				for(int i=0;i<4;i++) {
				System.out.println("\nenter new tarrifs (DestinationCountry OriginCountry ProductCategory)");
				Tarrif tarrif=new Tarrif(input.next(),input.next(),input.next(),0);
				//I am forced to call the same find function twice because it must return a node which i cant create a instance variable of because it has to be private 
				if(!(list.find(tarrif.getDestinationCountry(),tarrif.getOriginCountry(),tarrif.getProductCategory())==null)) {
				System.out.println("The tarrif: "+list.find(tarrif.getDestinationCountry(),tarrif.getOriginCountry(),tarrif.getProductCategory()).getTarrif()+" was found in "+list.getiterations()+" iterations");
				}
				else {
					System.out.println("the tarrif: "+tarrif+" was not found in. "+list.getiterations()+" iterations");
				}
				}
				input.close();
			System.out.println("thanks for using tarrif list calculator!");

	}
}