
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Bauernhof {
	private final String name;
	private Set traktoren;
	
	/*
	 * Precondition: name must be unique
	 * Postcondition: traktoren contains only elements of Traktoren (+ Undertyps)
	 * Postcondition: name is final
	 */
	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Set();
	}
	
	/*
	 * Postcondition: delivers traktor with declared number
	 */
	@MethodInformation(author="Wolfgang", date="11.12.2012", description="gives back tractor with declared number")
	protected Traktor getTraktor(int nr) {
		MyIterator it = (MyIterator) traktoren.iterator();
		Traktor ret = null;
		while(it.hasNext()) {
			ret = (Traktor) it.next();
			if(ret.getSNR() == nr)
				return ret;
		}
		
		return null;
	}
	
	/*
	 * Postcondition: delivers unique name of the Farm
	 */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="gives back name of farm")
	protected String getId() {
		return name;
	}

 	 
	/*
	 * Precondition: traktor must not exist in Set traktoren
	 * Postcondition: traktor is inserted in the Set traktoren
	 */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="inserts tractor in Set")
	protected void insertTraktor(Traktor traktor) {
		traktoren.insert(traktor);
	}
	
	/*
	 * Precondition: traktor-element must exist in Set traktoren
	 * Postcondition: traktor is deleted in the Set traktoren
	 */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="deletes tractor from Set")
	protected boolean deleteTraktor(Traktor traktor) {
		return traktoren.delete(traktor);
	}
	
	/*
	 * Precondition: traktor-element must exist in Set traktoren
	 * Postcondition: current machine is changed in traktor
	 */
	@MethodInformation(author="Wolfgang", date="07.12.2012", description="changes current machine of tractor")
	protected boolean changeTraktor(Traktor traktor, Maschine maschine) {
		return traktoren.change(traktor, maschine); 
	}
	
	/*
	 * Postcondition: all operating hours of all tractors on farm are summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all operating hours")
	protected double sumOpHours() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {		
			sum += ((Traktor) it.next()).getOpHours();
		}
		
		return sum;
	}
	
	/*
	 * Postcondition: average operating hours of all tractors on farm are calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours")
	protected double avgOpHours() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {		
			sum += ((Traktor) it.next()).getOpHours();
			count ++;
		}
		
		if(count == 0)
			throw new DivideByZeroException();

		return sum/count;
	}
	
	/*
	 * Postcondition: average operating hours of all tractors on farm with operating mode fertilize are calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all fertilize operating hours")
	protected double avgOpHoursFertilize() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursDuengen();
			count ++;
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average operating hours of all tractors on farm with operating mode sow are calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all sowing operating hours")
	protected double avgOpHoursSeed() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursSaeen();
			count ++;
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: all operating hours of all tractors on farm with operating mode fertilize are summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all fertilize operating hours")
	protected double sumOpHoursFertilize() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursDuengen();
		}
		
		return sum;
	}
		
	/*
	 * Postcondition: all operating hours of all tractors on farm with operating mode sow are summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all seed operating hours")
	protected double sumOpHoursSeed() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursSaeen();
		}
		
		return sum;
	}
	
	
	
	/*
	 * Postcondition: average operating hours of all bio-tractors on farm are calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours of all BioTraktor")
	protected double avOpHoursBioTraktor() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj =  (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				sum += obj.getOpHours();
				count++;
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average operating hours of all diesel-tractors on farm are calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours of all DieselTraktor")
	protected double avOpHoursDieselTraktor() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj =  (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				sum += obj.getOpHours();
				count++;
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average diesel consumption of all diesel-tractors on farm with operating mode sow is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all sowing DieselTraktor")
	protected double avgDieselTraktorSeed() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				if(obj.getMaschine() instanceof DrillMaschine) {
					sum += ((DieselTraktor)obj).getAmount();
					count++;
				}
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average diesel consumption of all diesel-tractors on farm with operating mode fertilize is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all fertilizing DieselTraktor")
	protected double avgDieselTraktorFertilizing() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				if(obj.getMaschine() instanceof Duengstreuer) {
					sum += ((DieselTraktor)obj).getAmount();
					count++;
				}
			}
		}
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average diesel consumption of all diesel-tractors on farm is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all DieselTraktor")
	protected double avgDieselTraktor() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				sum += ((DieselTraktor)obj).getAmount();
				count++;
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: total diesel consumption of all diesel-tractors on farm is summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all used Diesel of all DieselTraktor")
	protected double sumDieselTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				sum += ((DieselTraktor)obj).getAmount();
			}
		}
		
		return sum;
	}
	
	/*
	 * Postcondition: average gas consumption of all bio-tractors on farm with operating mode sow is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all sowing BioTraktor")
	protected double avgBioTraktorSeed() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				if(obj.getMaschine() instanceof DrillMaschine) {
					sum += ((BioTraktor)obj).getAmount();
					count++;
				}
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
		
	/*
	 * Postcondition: average gas consumption of all bio-tractors on farm with operating mode fertilize is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all fertilizing BioTraktor")
	protected double avgBioTraktorFertilizing() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				if(obj.getMaschine() instanceof Duengstreuer) {
					sum += ((BioTraktor)obj).getAmount();
					count++;
				}
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: average gas consumption of all bio-tractors on farm is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all BioTraktor")
	protected double avgBioTraktor() throws DivideByZeroException {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				sum += ((BioTraktor)obj).getAmount();
				count++;
			}
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count;
	}
	
	/*
	 * Postcondition: total gas consumption of all bio-tractors on farm is summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all used Gas of all BioTraktor")
	protected double sumBioTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				sum += ((BioTraktor)obj).getAmount();
			}
		}
		
		return sum;
	}
	
	/*
	 * Postcondition: minimum number of swords to plowshare for all diesel-tractors is found out
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the minimum number of swords to plowshares of all DieselTraktor")
	protected double minSwordsDiesel() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double min = -1;
		
		while(it.hasNext()) {
				Traktor obj = (Traktor) it.next();
			
			
			if(obj.getMaschine() instanceof DrillMaschine )
			{
				double anz = obj.getMaschine().getDetailOfMaschine();
				
				if(obj instanceof DieselTraktor) {
				
					if((anz < min) || (min == -1))
						min = anz;
				}
			}
		}
		
		return min;
	}	
		
	/*
	 * Postcondition: minimum number of swords to plowshare for all bio-tractors is found out
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the minimum number of swords to plowshare of all BioTraktor")
	protected double minSwordsBio() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double min = -1;
		
		while(it.hasNext()) {
					Traktor obj = (Traktor) it.next();
			
			
			if(obj.getMaschine() instanceof DrillMaschine )
			{
				double anz = obj.getMaschine().getDetailOfMaschine();
				
				if(obj instanceof BioTraktor) {
				
					if((anz < min) || (min == -1))
						min = anz;
				}
			}
		}
		
		return min;
	}	
	
	/*
	 * Postcondition: maximum number of swords to plowshare for all diesel-tractors is found out
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the maximum number of swords to plowshares of all DieselTraktor")
	protected double maxSwordsDiesel() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double max = -1;
		
		while(it.hasNext()) {
				Traktor obj = (Traktor) it.next();
			
			
			if(obj.getMaschine() instanceof DrillMaschine )
			{
				double anz = obj.getMaschine().getDetailOfMaschine();
				
				if(obj instanceof DieselTraktor) {
				
					if((anz > max) || (max == -1))
						max = anz;
				}
			}
		}
		
		return max;
	}	
			
	/*
	 * Postcondition: maximum number of swords to plowshare for all bio-tractors is found out
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the maximum number of swords to plowshares of all BioTraktor")
	protected double maxSwordsBio() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double max = -1;
		
		while(it.hasNext()) {
					Traktor obj = (Traktor) it.next();
			
			
			if(obj.getMaschine() instanceof DrillMaschine )
			{
				double anz = obj.getMaschine().getDetailOfMaschine();
				
				if(obj instanceof BioTraktor) {
				
					if((anz > max) || (max == -1))
						max = anz;
				}
			}
		}
		
		return max;
	}
	
	/*
	 * Postcondition: average fertilizer carrying capacity of all diesel-tractors is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all DieselTraktor")
	protected double avgCapacityDiesel() throws DivideByZeroException{
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()){
			Traktor tractor = (Traktor) it.next(); //I don't know which way is the better :/
			
			if(tractor instanceof DieselTraktor){
				if(tractor.getMaschine() instanceof Duengstreuer){
					sum += tractor.getMaschine().getDetailOfMaschine();
					count++;
				}
			}	
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count; 
	}
	
	/*
	 * Postcondition: average fertilizer carrying capacity of all bio-tractors is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all BioTraktor")
	protected double avgCapacityBio() throws DivideByZeroException{
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()){
			Traktor tractor = (Traktor) it.next(); //I don't know which way is the better :/
			
			if(tractor instanceof BioTraktor){
				if(tractor.getMaschine() instanceof Duengstreuer){
					sum += tractor.getMaschine().getDetailOfMaschine();
					count++;
				}
			}	
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count; 
	}
	
	/*
	 * Postcondition: average fertilizer carrying capacity of all tractors is calculated
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all Traktor")
	protected double avgCapacity() throws DivideByZeroException{
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()){
			Traktor tractor = (Traktor) it.next(); //I don't know which way is the better :/
			
			if(tractor.getMaschine() instanceof Duengstreuer){
				sum += tractor.getMaschine().getDetailOfMaschine();
				count++;
			}	
		}
		
		if(count == 0)
			throw new DivideByZeroException();
		
		return sum/count; 
	}
	
	/*
	 * Postcondition: fertilizer carrying capacity of all tractors is summed up
	 */
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of carrying capacity of all Traktor")
	protected double sumCapacity(){
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()){
			Traktor tractor = (Traktor) it.next(); //I don't know which way is the better :/
			
			if(tractor.getMaschine() instanceof Duengstreuer){
				sum += tractor.getMaschine().getDetailOfMaschine();
			}	
		}
		return sum; 
	}
}
		