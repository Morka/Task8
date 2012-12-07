
/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Bauernhof {
	final String name;
	Set traktoren;
	
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
	
	//duchschnittle Anzahl der Betriebsstunden aller Traktoren
	//eines Bauernhofs, alle Traktoren zusammen und zusätzlich 
	//aufgeschlüsselt nach Einsatzarten (Saeen oder Duengen)
	public double[] avOpHours() {
		
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumSaeen = 0;
		double sumDuengen = 0;
		int countSaeen = 0;
		int countDuengen = 0;
		
		while(it.hasNext()) {
			Object obj = it.next();
			
			if(((Traktor)obj).getMaschine() instanceof Saeen) {
				sumSaeen += ((Traktor)obj).getOpHoursSaeen();
				countSaeen++;
			} else {
				sumDuengen += ((Traktor)obj).getOpHoursDuengen();
				countDuengen ++;
			}
		}
		
		double[] ret = {sumDuengen+sumSaeen,(sumDuengen+sumSaeen)/(countDuengen+countSaeen),sumDuengen/countDuengen, sumSaeen/countSaeen};
		
		return ret;
	}
	
	//durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines Bauernhofs aufgeschlüsselt nach Art des Traktors
	public double[] avOpHoursTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumBio = 0;
		double sumDiesel = 0;
		int countBio = 0;
		int countDiesel = 0;
		
		while(it.hasNext()) {
			Object obj = it.next();
			
			if(obj instanceof BioTraktor) {
				sumBio += ((BioTraktor)obj).getOpHours();
				countBio++;
			} else {
				sumDiesel += ((DieselTraktor)obj).getOpHours();
				countDiesel ++;
			}
		}
		
		double[] ret = {sumDiesel/countDiesel, sumBio/countBio};
		
		return ret;
	}
	
	
	
	public double[] getCapacity() {
		return new double[] {0,0};
	}
	
}