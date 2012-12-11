/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012") 
public class BioTraktor extends Traktor {
	
	public BioTraktor(int serialnumber) {
		super(serialnumber);
	}

	private double usedGas;//TODO method to increase this - either +1 or +amountOfUsedGas
	
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of used fuel(bio gas).")
	public double getAmount() {
		
		return this.usedGas;
		
	}
	
	@MethodInformation(author="Matthias", date="11.12.2012", description="Increases the used fuel by amount.")
	public void increaseUsedFuel(double amount) {
		
		this.usedGas = this.usedGas + amount;
		
	}
}