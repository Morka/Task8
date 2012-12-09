
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Bauernhof {
	private final String name;
	private Set traktoren;
	
	/*
	 * Precondition: name must be unique
	 */
	public Bauernhof(String name) {
		this.name = name;
	}
	
	protected String getId() {
		return name;
	}

 	 
	public void insertTraktor(Traktor traktor) {
		traktoren.insert(traktor);
	}
	
	public boolean deleteTraktor(Traktor traktor) {
		return traktoren.delete(traktor);
	}
	
	public boolean changeTraktor(Traktor traktor, Maschine maschine) {
		return traktoren.change(traktor, maschine); 
	}
	
	//Summe aller Betriebsstunden aller Traktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all operating hours")
	public double sumOpHours() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {		
			sum += ((Traktor) it.next()).getOpHours();
		}
		
		return sum;
	}
	
	//duchschnittliche Anzahl der Betriebsstunden aller Traktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours")
	public double avgOpHours() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {		
			sum += ((Traktor) it.next()).getOpHours();
			count ++;
		}
		
		return sum/count;
	}
	
	//duchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Einsatzart Düngen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all duengen operating hours")
	public double avgOpHoursFertilize() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursDuengen();
			count ++;
		}
		
		return sum/count;
	}
	
	//duchschnittliche Anzahl der Betriebsstunden aller Traktoren mit Einsatzart Säen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all saeen operating hours")
	public double avgOpHoursSeed() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		int count = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursSaeen();
			count ++;
		}
		
		return sum/count;
	}
	
	//Summe aller Traktoren mit Einsatzart Düngen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all fertilize operating hours")
	public double sumOpHoursFertilize() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursDuengen();
		}
		
		return sum;
	}
		
	//Summe aller Traktoren mit Einsatzart Säen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all seed operating hours")
	public double sumOpHoursSeed() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sum = 0;
		
		while(it.hasNext()) {
			sum += ((Traktor) it.next()).getOpHoursSaeen();
		}
		
		return sum;
	}
	
	
	
	
	//durchschnittliche Anzahl der Betriebsstunden aller Bio-Traktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours of all BioTraktor")
	public double avOpHoursBioTraktor() {
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
		
		return sum/count;
	}
	
	//durchschnittliche Anzahl der Betriebsstunden aller Bio-Traktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all operating hours of all DieselTraktor")
	public double avOpHoursDieselTraktor() {
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
		
		return sum/count;
	}
	
	//Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs mit Einsatzart Säen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all seeding DieselTraktor")
	public double avgDieselTraktorSeed() {
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
		
		return sum/count;
	}
	
	//Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs mit Einsatzart Düngen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all fertilizing DieselTraktor")
	public double avgDieselTraktorFertilizing() {
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
	
	//Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Diesel of all DieselTraktor")
	public double avgDieselTraktor() {
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
		
		return sum/count;
	}
	
	//Der gesamte Dieselverbrauch aller Diesetraktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all used Diesel of all DieselTraktor")
	public double sumDieselTraktor() {
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
	
	//Der durchschnittliche Gasverbrauch aller Biotraktoren eines Bauernhofs mit Einsatzart Säen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all seeding BioTraktor")
	public double avgBioTraktorSeed() {
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
		
		return sum/count;
	}
		
	//Der durchschnittliche Gasverbrauch aller Biotraktoren eines Bauernhofs mit Einsatzart Düngen
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all fertilizing BioTraktor")
	public double avgBioTraktorFertilizing() {
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
		
		return sum/count;
	}
	
	//Der durchschnittliche Gasverbrauch aller Biotraktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average of all used Gas of all BioTraktor")
	public double avgBioTraktor() {
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
		
		return sum/count;
	}
	
	//Der gesamte Gasverbrauch aller Biotraktoren eines Bauernhofs
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of all used Gas of all BioTraktor")
	public double sumBioTraktor() {
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
	
	//liefert die minimale Anzahl an Säscharen aufgeschlüsselt nach Dieseltraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the minimum number of swords to plowshares of all DieselTraktor")
	public double minSwordsDiesel() {
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
		
	//liefert die minimale Anzahl an Säscharen aufgeschlüsselt nach Biotraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the minimum number of swords to plowshares of all BioTraktor")
	public double minSwordsBio() {
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
	
	//liefert die maximale Anzahl an Säscharen aufgeschlüsselt nach Dieseltraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the maximum number of swords to plowshares of all DieselTraktor")
	public double maxSwordsDiesel() {
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
			
	//liefert die maximale Anzahl an Säscharen aufgeschlüsselt nach Biotraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the maximum number of swords to plowshares of all BioTraktor")
	public double maxSwordsBio() {
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
	
	//liefert die durchschnittliche Fassungskapazität des Düngerbehälters aller Dieseltraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all DieselTraktor")
	public double avgCapacityDiesel(){
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
		return sum/count; 
	}
	
	//liefert die durchschnittliche Fassungskapazität des Düngerbehälters aller Biotraktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all BioTraktor")
	public double avgCapacityBio(){
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
		return sum/count; 
	}
	
	//liefert die durchschnittliche Fassungskapazität des Düngerbehälters aller Traktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the average carrying capacity of all Traktor")
	public double avgCapacity(){
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
		return sum/count; 
	}
	
	//liefert die gesamte Fassungskapazität des Düngerbehälters aller Traktoren
	@MethodInformation(author="Wolfgang", date="09.12.2012", description="Gives back a double that describes the sum of carrying capacity of all Traktor")
	public double sumCapacity(){
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
		