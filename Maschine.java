/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

@ClassInformation(author="Alex", date="09.12.2012") 
public interface Maschine {
	
	public String toString();
	
	@MethodInformation(author="Alex", date="09.12.2012", description="gives Back details of a machine")
	public double getDetailOfMaschine();
}