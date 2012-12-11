/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
@ClassInformation(author="Alex", date="09.12.2012") 
public class DrillMaschine implements Maschine {
	//Invariant: numberOfSaeschare > 0
	private int numberOfSaeschare; 
	
	//Precondition: numberOfSaeschare > 0 
	public DrillMaschine(int numberOfSaeschare){
		this.numberOfSaeschare = numberOfSaeschare;
	}
	
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back numberOfSaeschare")
	public double getDetailOfMaschine(){
		return numberOfSaeschare;
	}
	
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back a String describing the DrillMaschine")
	public String toString(){
		return "DrillMaschine: " + numberOfSaeschare;
	}
}