/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public class Traktor {
	
	private Maschine machine;
	private int upHoursFertilizing, upHoursSeeding;
	
	//wechselt Maschine aus
	@MethodInformation(author="Matthias", date="09.12.2012", description="Changes the purpose of the tractor.")
	protected boolean change(Maschine maschine) {
		
		this.machine = maschine;
		return false;//WARUM BOOLEAN??? WTF??
	}
	
	//liefert Betriebsstunden
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return total amount of uptime.")
	protected double getOpHours() {
		
		return this.upHoursFertilizing + this.upHoursSeeding;
		
	}
	
	//liefert Betriebsstungen fuers Duengen
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of fertilizing time.")
	protected double getOpHoursDuengen() {
		
		return this.upHoursFertilizing;
		
	}
	
	//liefert Betriebsstungen fuers Saeen
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of seeding time.")
	protected double getOpHoursSaeen() {
		
		return this.upHoursSeeding;
		
	}
	
	//liefert momentan eingesetzte Maschine
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return type of the equipped machine.")
	protected Maschine getMaschine() {
		
		return this.machine;
		
	}
		
}