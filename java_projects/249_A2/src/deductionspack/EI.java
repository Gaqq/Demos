package deductionspack;

public class EI extends Deductions{

	public EI() {};
	final private double fraction=1.64/100;
	final private double capsal=65700;
	final private double captax=1077.48;
	/**
	 * calculates deduction based on gross income
	 * @param gross income
	 */
	public double calculatetax(double annualsalary) {
		
		double tax =annualsalary*fraction;
		if(annualsalary>capsal) {
			tax= captax;
		}
		return tax;
		
	}

	

	

}
