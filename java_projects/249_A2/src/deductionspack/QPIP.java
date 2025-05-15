package deductionspack;

public class QPIP extends Deductions{

	final private double fraction=0.494/100;
	final private double capsal=98000;
	final private double captax=484.12;
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
