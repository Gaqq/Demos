package vehicle_pack;

public abstract class electric_vehicle extends vehicle{
	
	protected int maxrange;
	
	
	public electric_vehicle(String make, String model, int year,int maxrange) {
		super(make, model, year);
		this.maxrange=maxrange;
	}


	public int getMaxrange() {
		return maxrange;
	}


	public void setMaxrange(int maxrange) {
		this.maxrange = maxrange;
	}
	
	
	/**
	 * updates vehicle info with the given parameters
	 * @param make to change to
	 * @param model to change to
	 * @param year to change to
	 * @param maxrange to change
	 */
	public void updatecehicleinfo(String make,String model,int year,int maxrange) {
		super.updatecehicleinfo(make, model, year);
		this.maxrange=maxrange;
		
	}
	
	
	

	

}
