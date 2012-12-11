/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012") 
public class BioTraktor extends Traktor {
	
	private double usedGas;//TODO method to increase this - either +1 or +amountOfUsedGas
	
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of used fuel(bio gas).")
	public double getAmount() {
		
		return this.usedGas;
		
	}
	
	public void increaseUsedFuel(double amount) {
		
		this.usedGas = this.usedGas + amount;
		
	}
}