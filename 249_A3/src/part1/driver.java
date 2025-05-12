package part1;
import java.util.*;

import java.io.*;

//
//Assignment 3 
//Question: 1 
//Written by: Jack Fraser 40266009 
//

public class driver {
/**
 * reads the TradeData.txt file and instantiates each line of products in the file to product objects and adds them to the static products array
 * if a line in the file is inputed invalidly then it is ignored  
 * exits file if not found
 */
	public static void readfile() {
		Scanner input =null;
		try {
			input=new Scanner(new FileInputStream("Required files\\TradeData.txt"));
		}
		catch(IOException e) {
			System.out.println("Input file not accessible");
			System.exit(0);
		}
		while(input.hasNextLine()) {
			
			String[] line=input.nextLine().split(",");
			
			try{
				
				new product(line[0],line[1],line[2],Double.parseDouble(line[3]));
				
			}
			catch(Exception e) {
				
			}
			
		}
		input.close();
		
	}
	
	/**
	 * writes the static products array to UpdatedTradeData after calculating the correct deductions
	 * exits program if file is not found
	 */
	public static void writefile() {
		PrintWriter output=null;
		try {
			output=new PrintWriter(new FileOutputStream("Required files\\UpdatedTradeData.txt"));
		}
		catch(IOException e) {
			System.out.println("Ouput file not acessible");
			System.exit(0);
		}
		
		for(int i=0; i<product.getProducts().size();i++) {
			output.println(product.getProducts().get(i));
		}
		output.close();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("A3,part 1, Jack Fraser, 40266009, \nWelcome");	
		readfile();
		
		
		writefile();
		System.out.println("process compleated");
	}

}
