// 
// Assignment 2 
// Question: 1
// Written by: Jack Fraser 40266009

import deductionspack.*;


public class Employee {

	private static Employee[] Employees= {};
/**
 * returns the static list of all employees
 * @return employee list
 */
	public static Employee[] getEmployees() {
		return Employees;
	}
	
	


	/**
	 * adds an employee to the Employees array
	 * @param Employee to add
	 */
	private void addtoEmployees(Employee toadd) {
		
		Employee[] templist=new Employee[Employees.length+1];
		for(int i=0;i<Employees.length;i++) {
			templist[i]=Employees[i];
		}
		templist[Employees.length]=toadd;
		Employees=templist;
	}
	
	private long employeenumber;
	private String firstname;
	private String lastname;
	private double hoursworked;
	private double hourlywage;
	private double grosssalary;
	private double netsalary;
	
	/**
	 * calculates deduction based on gross income
	 * @param gross income
	 */
	public double gettax() {
		Deductions[] deductions= {new EI(),new QPP(),new QPIP(),new FederalIncomeTax(),new ProvincialIncomeTax()};
		double tax=0;
		
		for(int i=0; i<deductions.length;i++) {
			
			tax+=deductions[i].calculatetax(this.grosssalary);


		}
		
		return tax;
	}
	/**
	 * parametrized contructor
	 * @param employeenumber
	 * @param firstname
	 * @param lastname
	 * @param hoursworked
	 * @param hourlywage
	 */
	public Employee(long employeenumber, String firstname, String lastname, double hoursworked, double hourlywage) {
		
		this.employeenumber = employeenumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.hoursworked = hoursworked;
		this.hourlywage = hourlywage;
		this.grosssalary = hoursworked*hourlywage*52;
		this.netsalary=grosssalary-gettax();
		addtoEmployees(this);
	}

	/**
	 * returns formated string of object
	 */
	public String toString() {
		return  employeenumber + "\t" + firstname + "\t" + lastname
				+ "\t" + hoursworked + "\t" + hourlywage + "\t" + grosssalary
				;
	}


//getters and setters
	/**
	 * returns the employee number of the object
	 * @return employee number
	 */
	public long getEmployeenumber() {
		return employeenumber;
	}



	/**
	 * returns the firstname of the object
	 * @return employee number
	 */
	public String getFirstname() {
		return firstname;
	}



	/**
	 * returns the lastname of the object
	 * @return employee number
	 */
	public String getLastname() {
		return lastname;
	}



	/**
	 * returns the hours worked of the object
	 * @return employee number
	 */
	public double getHoursworked() {
		return hoursworked;
	}



	/**
	 * returns the hourly wage of the object
	 * @return employee number
	 */
	public double getHourlywage() {
		return hourlywage;
	}



	/**
	 * returns the gross salary of the object
	 * @return employee number
	 */
	public double getGrosssalary() {
		return grosssalary;
	}



	/**
	 * returns the net salary of the object
	 * @return employee number
	 */
	public double getNetsalary() {
		return netsalary;
	}
	
	
	

}
