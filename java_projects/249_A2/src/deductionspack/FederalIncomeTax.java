package deductionspack;

public class FederalIncomeTax extends Deductions{

	public FederalIncomeTax() {
		// TODO Auto-generated constructor stub
	}

/**
 * calculates deduction based on gross income
 * @param gross income
 */
	public double calculatetax(double income) {
		double tax=0;
		 if (income > 253414) {
	            tax += (income - 253414) * 0.33;
	            income = 253414;
	        }
	        if (income > 177882) {
	            tax += (income - 177882) * 0.29;
	            income = 177882;
	        }
	        if (income > 114750) {
	            tax += (income - 114750) * 0.26;
	            income = 114750;
	        }
	        if (income > 57375) {
	            tax += (income - 57375) * 0.205;
	            income = 57375;
	        }
	        if (income > 16129) {
	            tax += (income - 16129) * 0.15;
	        }

	        return tax;
		
	}

}
