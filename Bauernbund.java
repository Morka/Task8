/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
@ClassInformation(author="Wolfgang", date="11.12.2012") 

public class Bauernbund {
	private Set bauernhoefe;
	
	public Bauernbund(){
		bauernhoefe = new Set();
	}
	
	/*
	 * Precondition: bauernhof-element must not exist in Set bauerhoefe
	 * Postcondition: bauernhof is inserted in the Set bauerhoefe
	 */
	@MethodInformation(author="Wolfgang", date="11.12.2012", description="inserts bauernhof in set bauernhoefe")
	protected void addFarm(Bauernhof bauernhof) {
		bauernhoefe.insert(bauernhof);
	}
	
	/*
	 * Precondition: bauernhof-element must exist in Set bauerhoefe
	 * Postcondition: bauernhof is deleted in the Set bauerhoefe
	 */
	@MethodInformation(author="Wolfgang", date="11.12.2012", description="deletes bauernhof from set bauernhoefe")
	protected void deleteFarm(Bauernhof bauernhof) {
		bauernhoefe.delete(bauernhof);
	}
	
	@MethodInformation(author="Alex", date="11.12.2012", description="returns set bauernhoefe")
	protected Set getBauernhofSet(){
		return bauernhoefe;
	}
	
	/*
	 * Postcondition: delivers farm with declared number
	 * null, if farm with declared number is not found
	 */
	@MethodInformation(author="Wolfgang", date="11.12.2012", description="gives back farm with declared name")
	protected Bauernhof getFarm(String name) {
		MyIterator it = (MyIterator) bauernhoefe.iterator();
		Bauernhof ret = null;
		while(it.hasNext()) {
			ret = (Bauernhof) it.next();
			if(ret.getId() == name)
				return ret;
		}
		return null;
	}
	
}