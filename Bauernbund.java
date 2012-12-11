/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Bauernbund {
	Set bauernhoefe = new Set();
	
	protected void addFarm(Bauernhof bauernhof) {
		bauernhoefe.insert(bauernhof);
	}
	
	protected void deleteFarm(Bauernhof bauernhof) {
		bauernhoefe.delete(bauernhof);
	}
	
	/*
	 * Postcondition: delivers farm with declared number
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