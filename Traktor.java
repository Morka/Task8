/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Traktor {
	
	//wechselt Maschine aus
	protected boolean change(Maschine maschine) {
		return false;
	}
	
	//liefert Betriebsstunden
	protected double getOpHours() {
		return 0;
	}
	
	//liefert Betriebsstungen fuers Duengen
	protected double getOpHoursDuengen() {
		return 0;
	}
	
	//liefert Betriebsstungen fuers Saeen
	protected double getOpHoursSaeen() {
		return 0;
	}
	
	//liefert momentan eingesetzte Maschine
	protected Maschine getMaschine() {
		return null;
	}
		
}