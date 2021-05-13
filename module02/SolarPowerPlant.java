package module02;
/**
 * 
 * @author Brady
 *
 */
public class SolarPowerPlant extends PowerPlant {

	public SolarPowerPlant(int capacity) {
		super(capacity);
	}

	@Override
	public String generatesElectricity() {
		return "generating electricity from the sun";
	}
}
