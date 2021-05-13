package module02;
/**
 * 
 * @author Brady
 *
 */
public class Module02App {

	public static void main(String[] args) {
		PowerPlant[] powerPlants = new PowerPlant[]{new PowerPlant(100), new SolarPowerPlant(200), 
			new	HydroPowerPlant(900, true)};
		
		for(PowerPlant el: powerPlants) {
			System.out.println(el);
			System.out.println(el.generatesElectricity());
			if(el instanceof HydroPowerPlant) {
				if(((HydroPowerPlant) el).hasDam()) {
					System.out.println("hydroPowerPlant has a dam");
				}
			}
			System.out.println();
		}
	}
}
