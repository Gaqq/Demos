package part2;

import java.util.Objects;
//
//Assignment 3 
//Question: 1 
//Written by: Jack Fraser 40266009 
//

public class Tarrif implements Cloneable{

	private String destinationCountry;
	private String originCountry;
	private String productCategory;
	private double minimunTariff;
	/**
	 * parameterized constructor
	 * @param destinationCountry 
	 * @param originCountry
	 * @param productCategory
	 * @param minimunTariff
	 */
	public Tarrif(String destinationCountry, String originCountry, String productCategory, double minimunTariff) {
		
		this.destinationCountry = destinationCountry;
		this.originCountry = originCountry;
		this.productCategory = productCategory;
		this.minimunTariff = minimunTariff;
	} 
	/**
	 * copy constructor
	 * @param copy is the object to copy
	 */
	public Tarrif(Tarrif copy) {
		this.destinationCountry=copy.destinationCountry;
		this.originCountry=copy.originCountry;
		this.productCategory=copy.productCategory;
		this.minimunTariff=copy.minimunTariff;
	}
	/**
	 * returns a deep copy of the calling object
	 */
	public Tarrif clone() {
		return new Tarrif(this);
	}

	@Override
	/**
	 * returns a string representation of the object
	 */
	public String toString() {
		return destinationCountry + " " + originCountry
				+ " " + productCategory + " " + minimunTariff ;
		
	}

	
	@Override
	/**
	 * returns true if calling object is equal to obj false otherwise 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarrif other = (Tarrif) obj;
		return Objects.equals(destinationCountry, other.destinationCountry)
				&& Double.doubleToLongBits(minimunTariff) == Double.doubleToLongBits(other.minimunTariff)
				&& Objects.equals(originCountry, other.originCountry)
				&& Objects.equals(productCategory, other.productCategory);
	}

	//getters and setters
	/**
	 * 
	 * @return destination Country
	 */
	public String getDestinationCountry() {
		return destinationCountry;
	}
	/**
	 * sets the destination country = the parameter
	 * @param destinationCountry
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	/**
	 * 
	 * @return origin Country
	 */
	public String getOriginCountry() {
		return originCountry;
	}
	/**
	 * sets the origin country = the parameter
	 * @param originCountry
	 */
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	/**
	 * 
	 * @return product category
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * sets the product category = the parameter
	 * @param productCategory
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * 
	 * @return the minimum tariff
	 */
	public double getMinimunTariff() {
		return minimunTariff;
	}
	/**
	 * sets the minimum tariff = the parameter
	 * @param minimumTariff
	 */
	public void setMinimunTariff(double minimunTariff) {
		this.minimunTariff = minimunTariff;
	}
	
	
	
	
	
	
	
	
	
}
