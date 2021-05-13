package module02;
/**
 * 
 * @author Brady
 *
 */
public class HydroPowerPlant extends PowerPlant {
	
	private boolean dam;

	public HydroPowerPlant(int capacity, boolean dam) {
		super(capacity);
		this.dam = dam;
	}
	/**
	 * Returns whether or not the Hydro power plant has a dam or not.
	 * @return
	 */
	public boolean hasDam() {
		
		return dam;
	}

	@Override
	public String generatesElectricity() {
		return "generating electricity from water";
	}
}
