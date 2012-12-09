/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
@ClassInformation(author="Alex", date="09.12.2012") 
public class Duengstreuer implements Maschine {
	//Invariant: capacity > 0
	private double capacity;
	
	//Precondition: capacity > 0
	public Duengstreuer(double capacity){
		this.capacity = capacity;
	}
	
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back capacity of this Duengstreuer")
	public double getDetailOfMaschine(){
		return capacity;
	}
	
	@MethodInformation(author="Alex", date="09.12.2012", description="Gives back a String that describes the Duengstreuer")
	public String toString(){
		return "" + capacity;
	}
}