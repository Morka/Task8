/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012")  
public class DieselTraktor extends Traktor {

	private int usedGasoline; //Invariant: usedGasoline >= 0

	//Precondition: serialnumber != 0
	//Postcondition: calls super constructor which sets this.snr = serialnumber - cannot be undone
	public DieselTraktor(int serialnumber) {
		super(serialnumber);
	}
	
	//Postcondition: returns this.usedGasoline
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of used fuel(gasoline).")
	public int getAmount() {
		
		return this.usedGasoline;
		
	}
	
	//Precondition: amount > 0
	//Postcondition: increases this.usedGasoline by amount
	@MethodInformation(author="Matthias", date="11.12.2012", description="Increases the used fuel by amount.")
	public void increaseUsedFuel(double amount) {
		
		this.usedGasoline = (int) (this.usedGasoline + amount);
		
	}
}