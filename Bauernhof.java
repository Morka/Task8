/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Bauernhof {
	final String name;
	//Container traktoren;
	
	public Bauernhof(String name) {
		this.name = name;
	}
 	 
	public void insertTraktor(Traktor traktor) {
		//insert Traktor
	}
	
	public void deleteTraktor(Traktor traktor) {
		//delete Traktor
	}
	
	public void changeTraktor(Maschine maschine) {
		
	}
	
	public double avOpHours() {
		return 0;
	}
	
	public double avOpHoursDiesel() {
		return 0;
	}
	
	public double avGasBio() {
		return 0;
	}
	
	public double avOpHoursDieselSaen() {
		return 0;
	}
	
	public double avOpHoursDieselDuengen() {
		return 0;
	}
	
	public double avGasBioSaen() {
		return 0;
	}
	
	public double avGasBiolDuengen() {
		return 0;
	}
	
	public double[] getCapacity() {
		return new double[] {0,0};
	}
	
}