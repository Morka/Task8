/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012") 
public class BioTraktor extends Traktor {

	private double usedGas; //Invariant: usedGas >= 0
	
	//Precondition: serialnumber != 0
	//Postcondition: calls super constructor which sets this.snr = serialnumber - cannot be undone
	public BioTraktor(int serialnumber) {
		super(serialnumber);
	}
	
	//Postcondition: returns this.usedGas
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of used fuel(bio gas).")
	public double getAmount() {
		
		return this.usedGas;
		
	}
	
	//Precondition: amount > 0
	//Postcondition: increases this.usedGas by amount
	@MethodInformation(author="Matthias", date="11.12.2012", description="Increases the used fuel by amount.")
	public void increaseUsedFuel(double amount) {
		
		this.usedGas = this.usedGas + amount;
		
	}
}