import java.util.Scanner;



import java.io.*;
import deductionspack.*;




/*
 * the program reads the data from the input file checks its validity and outputs the valid data with 
 * the appropriate calculations. Each line of the input file is read as a string and separated by the \t
 * character thus if the data in the input is not seperated by \t it will be unvalide and outputed to the errorfile. each line of the 
 * input file is separated and added to a String[] variable. the data from this array is parsed to the correct type
 * and is used to instantiate a Employee object. upon instantiation each employee is added to the static array Employees.
 * Before the Employee object is instantiated the validity of its input are checked if unvalide they will be printed to the error file.
 * The Employees array is then used with a loop to print line by line the appropriate data to the output file.  
 */

public class driver {

	
	public static double isUnderwage(double wage) throws MinimumWageException {
		
		if(wage<15.75) {throw  new MinimumWageException("wage is below legal minimum");}
		return wage;
	}
	public static void writepayroll(Employee[] employee) {
		PrintWriter payroll=null;
		try {
		payroll=new PrintWriter(new FileOutputStream("payrollReport.txt"));
		payroll.println("\t\t\t\tidroidsolutions"
					+  "\n\t\t\t\t------------"
				+"\nEmployee #\tFirst Name\tLast Name\tGross Salary\tDeductions\tNet salary"
				+"\n----------------------------------------------------------------------------------------------------------");
		for(int i=0;i<employee.length;i++) {
		payroll.println(employee[i].getEmployeenumber()+"\t\t"+employee[i].getFirstname()+"\t\t"+employee[i].getLastname()+"\t\t"+employee[i].getGrosssalary()+"\t\t"+employee[i].gettax()+"\t"+employee[i].getNetsalary());
		}
		payroll.close();
		}
		catch(IOException e){System.out.print("File does not exist");System.exit(0);}
	}
	
	public static void readPayroll() {
		System.out.println(">Opening file payroll");
		Scanner payroll=null;
		PrintWriter errorlist=null;
		try {
			payroll=new Scanner(new FileInputStream("payroll.txt"));
			 errorlist=new PrintWriter("errorlist.txt");
			String errors="";
			int nbrlines=0;
			int nbrerrors=0;
			while(true) {
				if(!payroll.hasNextLine()) {break;}
				
				String[] line;
				
				String linewords=payroll.nextLine();
				line=linewords.split("\t");
				try {
					nbrlines++;
				new Employee(Long.parseLong(line[0]), line[1],line[2],Double.parseDouble(line[3]), isUnderwage(Double.parseDouble(line[4])));
				}
				catch(NumberFormatException |MinimumWageException e) {
					nbrerrors++;
					errorlist.println(linewords);
					errors+=linewords+"\n";
				}
			}
			System.out.println(">Error lines found: \n"+errors);
			System.out.println(">"+nbrlines+" lines read from file payroll"
					+"\n>"+nbrerrors+" lines written to error file");
			payroll.close();
			errorlist.close();
			
		} catch (FileNotFoundException e) {System.out.println("File does not exist");System.exit(0);}
			
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	System.out.println("Welcome to Idroid solutions:");
	readPayroll();
	writepayroll(Employee.getEmployees());
	System.out.println("Thanks, goodbye.");

	

}
}
