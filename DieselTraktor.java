/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012")  
public class DieselTraktor extends Traktor {
	
	private int usedGasoline;//TODO method to increase this - either +1 or +amountOfUsedGas
	
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of used fuel(gasoline).")
	public int getAmount() {
		
		return this.usedGasoline;
		
	}
}