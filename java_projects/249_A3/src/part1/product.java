package part1;
import java.util.*;

//
//Assignment 3 
//Question: 1 
//Written by: Jack Fraser 40266009 
//
public class product implements Comparable<product>{

	private String ProductName;
	private String Country;
	private String Category;
	private double InitialPrice;
	private double TariffedPrice;
	private static ArrayList<product> products= new ArrayList<product>(0);
	
	
	/**
	 * calculates the correct terriff value and assigns it to TarrifedPrice and returns it 
	 * @return TarrifedPrice, or -1 if no tariff was applied
	 */
	public double gettarriff() {
		if(this.Country.toLowerCase().equals("china")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.25; return this.TariffedPrice;
			}
		//usa
		else if(this.Country.toLowerCase().equals("usa")&&this.Category.toLowerCase().equals("electronics")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.1; return this.TariffedPrice;
		}
		//japan
		else if(this.Country.toLowerCase().equals("japan")&&this.Category.toLowerCase().equals("automobile")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.15; return this.TariffedPrice;
				}
		//india
		else if(this.Country.toLowerCase().equals("india")&&this.Category.toLowerCase().equals("agriculture")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.05; return this.TariffedPrice;
		}
		//south korea
		else if(this.Country.toLowerCase().equals("south korea")&&this.Category.toLowerCase().equals("electronics")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.08; return this.TariffedPrice;
		}
		//saudi arabia
		else if(this.Country.toLowerCase().equals("saudi arabia")&&this.Category.toLowerCase().equals("energy")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.12; return this.TariffedPrice;
		}
		//germany
		else if(this.Country.toLowerCase().equals("germany")&&this.Category.toLowerCase().equals("manufacturing")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.06; return this.TariffedPrice;
		}
		//bangledesh
		else if(this.Country.toLowerCase().equals("bangledesh")&&this.Category.toLowerCase().equals("textile")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.04; return this.TariffedPrice;
		}
		//brazil
		else if(this.Country.toLowerCase().equals("brazil")&&this.Category.toLowerCase().equals("agriculture")) {
			this.TariffedPrice=this.InitialPrice+this.InitialPrice*0.09; return this.TariffedPrice;
		}
		//return -1 is a way to show that nothing was applied
		else {return -1;}
		
		
		
	}
	
	/**
	 * paramerterized constructor
	 * @param productName
	 * @param country
	 * @param category
	 * @param initialPrice
	 */
	public product(String productName, String country, String category, double initialPrice) {
		
		this.ProductName = productName;
		this.Country = country;
		this.Category = category;
		this.InitialPrice = initialPrice;
		this.gettarriff();
		products.add(this);
		
		Collections.sort(products);
		
	}
	//getters and setters
	/**
	 * @return product name
	 */
	public String getProductName() {
		return ProductName;
	}

/**
 * sets product name
 * @param productName
 */
	public void setProductName(String productName) {
		ProductName = productName;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * sets country
	 * @param country
	 */
	public void setCountry(String country) {
		Country = country;
	}

	/**
	 * @return Category
	 */
	public String getCategory() {
		return Category;
	}

	/**
	 * sets category
	 * @param category
	 */
	public void setCategory(String category) {
		Category = category;
	}

	/**
	 * @return CateInitialPricegory
	 */
	public double getInitialPrice() {
		return InitialPrice;
	}

	/**
	 * sets the initial price
	 * @param initialPrice
	 */
	public void setInitialPrice(double initialPrice) {
		InitialPrice = initialPrice;
	}

	/**
	 * @return TariffedPrice
	 */
	public double getTariffedPrice() {
		return TariffedPrice;
	}


	


	@Override
	/**
	 * returns formated string
	 */
	public String toString() {
		return   ProductName + "," + Country + "," + Category
				+ "," + TariffedPrice;
	}
/**
 * 
 * @return static list of products
 */
	public static ArrayList<product> getProducts() {
		return products;
	}


	@Override
	/**
	 * campares 2 products and returns the product with the name that is alphebetically greater
	 */
	public int compareTo(product o) {
		
		return this.ProductName.compareTo(o.ProductName);
	}


	



	
	
	
	
	

}
