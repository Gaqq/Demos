package deductionspack;


public class ProvincialIncomeTax extends Deductions{

	public ProvincialIncomeTax() {
		
	}
	

	/**
	 * calculates deduction based on gross income
	 * @param gross income
	 */
	public double calculatetax(double income) {
		
		
		double tax=0.0;
		
		
		 if (income > 129590) {
	            tax += (income - 129590) * 0.2575;
	            income = 129590;
	        }
	        if (income > 106495) {
	            tax += (income - 106495) * 0.24;
	            income = 106495;
	        }
	        if (income > 53255) {
	            tax += (income - 53255) * 0.19;
	            income = 53255;
	        }
	        if (income > 18571) {
	            tax += (income - 18571) * 0.14;
	        }

	        return tax;
		
	}

	
}
