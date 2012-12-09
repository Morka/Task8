
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
	
	//duchschnittliche Anzahl der Betriebsstunden aller Traktoren
	//eines Bauernhofs, alle Traktoren zusammen und zusaetzlich 
	//aufgeschluesselt nach Einsatzarten (Saeen oder Duengen)
	public double[] avOpHours() {
		
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumSaeen = 0;
		double sumDuengen = 0;
		int countSaeen = 0;
		int countDuengen = 0;
		
		while(it.hasNext()) {
			Object obj = it.next();
			
			if(((Traktor)obj).getMaschine() instanceof DrillMaschine) {
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
	
	//durchschnittliche Anzahl der Betriebsstunden aller Traktoren eines Bauernhofs aufgeschluesselt nach Art des Traktors
	public double[] avOpHoursTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumBio = 0;
		double sumDiesel = 0;
		int countBio = 0;
		int countDiesel = 0;
		
		while(it.hasNext()) {
			Object obj =  it.next();
			
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
	
	public double[] avCapacity(){
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumBio = 0;
		double sumDiesel = 0;
		int countBio = 0;
		int countDiesel = 0;
		while(it.hasNext()){
			Traktor tractor = (Traktor) it.next(); //I don't know which way is the better :/
			
			if(tractor instanceof BioTraktor){
				if(tractor.getMaschine() instanceof Duengstreuer){
					sumBio += tractor.getMaschine().getDetailOfMaschine();
					countBio++;
				}
			}else if(tractor instanceof DieselTraktor){
				if(tractor.getMaschine() instanceof Duengstreuer){
					sumDiesel += tractor.getMaschine().getDetailOfMaschine();
					countDiesel++;
				}
			}
		}
		
		//return durchschn. Anzahl der Betriebsstunden DieselTraktor, durchschn. Anzahl der Betriebsstunden BioTraktor
		double[] ret = {sumDiesel/countDiesel, sumBio/countBio};
		
		return ret; // CHANGE IT!
	}
	
	//Der durchschnittliche Dieselverbrauch aller Diesetraktoren eines Bauernhofs
	//alle zusammen und zusätzlich aufgeschlüsselt nach den Einsatzarten (Säen oder Düngen)
	public double[] avgDieselTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumsaeen = 0;
		double sumduengen = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof DieselTraktor) {
				if(obj.getMaschine() instanceof Duengstreuer)
					sumduengen += ((DieselTraktor)obj).getAmount();
				else
					sumsaeen += ((DieselTraktor)obj).getAmount();
				
				count ++;
			}
		}
		
		//return: gesamter Dieselverbrauch / gesamter Dieselverbrauch Saeen / gesamter Dieselverbraucht Duengen / 
		//duchschn. Dieselverbrauch gesamt / durchschn.Dieselverbrauch Saeen / durchschn. Dieselverbrauch Duengen 
		double[] ret = {sumduengen+sumsaeen, sumsaeen, sumduengen, (sumduengen+sumsaeen)/(count), (sumsaeen/count), (sumduengen/count)};
		
		return ret;
	}
	
	
	//Der durchschnittliche Gasverbrauch aller Diesetraktoren eines Bauernhofs
	//alle zusammen und zusätzlich aufgeschlüsselt nach den Einsatzarten (Säen oder Düngen)
	public double[] avgBioTraktor() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double sumsaeen = 0;
		double sumduengen = 0;
		int count = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			if(obj instanceof BioTraktor) {
				if(obj.getMaschine() instanceof Duengstreuer)
					sumduengen += ((BioTraktor)obj).getAmount();
				else
					sumsaeen += ((BioTraktor)obj).getAmount();
				
				count ++;
			}
		}
		
		//return: gesamter Dieselverbrauch / gesamter Dieselverbrauch Saeen / gesamter Dieselverbraucht Duengen / 
		//duchschn. Dieselverbrauch gesamt / durchschn.Dieselverbrauch Saeen / durchschn. Dieselverbrauch Duengen 
		double[] ret = {sumduengen+sumsaeen, sumsaeen, sumduengen, (sumduengen+sumsaeen)/(count), (sumsaeen/count), (sumduengen/count)};
		
		return ret;
	}
	
	//Die minimale und maximale Anzahl an Säscharen insgesamt und aufgeschlüsselt nach Art des Traktors (Dieseltraktor oder Biogastraktor)
	public double[] minmaxScharen() {
		MyIterator it = (MyIterator) traktoren.iterator();
		double minbio = -1;
		double mindiesel = -1;
		double maxbio = 0;
		double maxdiesel = 0;
		
		while(it.hasNext()) {
			Traktor obj = (Traktor) it.next();
			
			
			if(obj.getMaschine() instanceof DrillMaschine )
			{
				double anz = obj.getMaschine().getDetailOfMaschine();
				
				if(obj instanceof BioTraktor) {
				
					if((minbio < anz) || (minbio == -1))
						minbio = anz;
				
					if(maxbio > anz)
						maxbio = anz;
				} else {
					if((mindiesel < anz) || (mindiesel == -1))
						mindiesel = anz;
					
					if(maxdiesel > anz)
						maxdiesel = anz;
				}		
			}
		}
		
		//return: min. Anzahl Saescharen BioTraktor / max. Anzahl Saescharen BioTraktor / min. Anzahl Saescharen DieselTraktor / max. Anzahl DieselTraktor
		double[] ret = {minbio, maxbio, mindiesel, maxdiesel};
		
		return ret;
	}	
}