package deductionspack;

public class QPP extends Deductions{

	public QPP() {
		// TODO Auto-generated constructor stub
	}

	final private double fraction=10.8/100;
	final private double capsal=71300;
	final private double captax=7700.40;
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
