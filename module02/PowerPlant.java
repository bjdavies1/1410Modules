package module02;
/**
 * 
 * @author Brady
 *
 */
public class PowerPlant {
	
	private int capacity;
	
	public PowerPlant(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * Returns if the power plant is generating electricity, and if so how.
	 * @return
	 */
	public String generatesElectricity() {
		
		return "generating electricity";
	}

	@Override
	public String toString() {
		
		return this.getClass().getSimpleName().substring(0, 1).toLowerCase()
		+ this.getClass().getSimpleName().substring(1) + ": " 
		+ this.getClass().getSimpleName() + " "+ capacity + "MW";
	}
	
	

}
