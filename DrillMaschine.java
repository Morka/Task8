/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
//DrillMaschine ist Undertyp of Maschine
@ClassInformation(author="Alex", date="09.12.2012") 
public class DrillMaschine implements Maschine {
	//Invariant: numberOfSaeschare > 0
	private int numberOfSaeschare; 
	
	//Precondition: numberOfSaeschare > 0 
	//Postcondition: this.numberOfSaeschare is set to numberOfSaeschare
	public DrillMaschine(int numberOfSaeschare){
		this.numberOfSaeschare = numberOfSaeschare;
	}
	
	/**
	 * @return a double value which contains the numbers of Saeschare's used
	 * */
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back numberOfSaeschare")
	public double getDetailOfMaschine(){
		return numberOfSaeschare;
	}
	
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back a String describing the DrillMaschine")
	public String toString(){
		return "DrillMaschine: " + numberOfSaeschare;
	}
}