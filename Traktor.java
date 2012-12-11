/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
@ClassInformation(author="Matthias", date="09.12.2012") 
public class Traktor {
	
	private final int snr; //Invariant: cannot be changed
	private Maschine machine;
	private double upHoursFertilizing, upHoursSeeding; //Invariant: upHoursFertilizing and upHoursSeeding >= 0
	
	//Precondition: serialnumber != 0
	//Postcondition: this.snr = serialnumber - cannot be undone
	public Traktor(int serialnumber) {
		
		this.snr = serialnumber;
		
	}
	@MethodInformation(author="Alex", date="10.12.2012", description="increases Fertilizing Time")
	public void increaseUpHoursFertilizing(double fertilizingTime){
		this.upHoursFertilizing += fertilizingTime;
	}
	
	@MethodInformation(author="Alex", date="10.12.2012", description="increases Seeding Time")
	public void increaseUpHoursSeeding(double seedingTime){
		this.upHoursFertilizing += seedingTime;
	}
	
	//Precondition: maschine != null
	//Postcondition: sets this.machine to maschine
	@MethodInformation(author="Matthias", date="09.12.2012", description="Changes the purpose of the tractor.")
	protected void change(Maschine maschine) {
		
		this.machine = maschine;
		
	}
	
	//Postcondition: returns total amount of upHoursFertilizing and upHoursSeeding
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return total amount of uptime.")
	protected double getOpHours() {
		
		return this.upHoursFertilizing + this.upHoursSeeding;
		
	}
	
	//Postcondition: returns the value of upHoursFertilizing
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of fertilizing time.")
	protected double getOpHoursDuengen() {
		
		return this.upHoursFertilizing;
		
	}
	
	//Postcondition: returns the value of upHoursSeeding
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return amount of seeding time.")
	protected double getOpHoursSaeen() {
		
		return this.upHoursSeeding;
		
	}
	
	//Postcondition: returns the machine object in this.machine
	@MethodInformation(author="Matthias", date="09.12.2012", description="Return type of the equipped machine.")
	protected Maschine getMaschine() {
		
		return this.machine;
		
	}
	
	//Postcondition: returns the value in this.snr
	@MethodInformation(author="Matthias", date="11.12.2012", description="Returns the serial number of the tractor.")
	protected int getSNR() {
		
		return this.snr;
		
	}
	
	//Postcondition: returns a string representation containing this.snr and this.machine
	@MethodInformation(author="Matthias", date="11.12.2012", description="Generates and returns a readable string of the tractor containing serialnumber and mounted machine.")
	public String toString() {
		
		return "Seriennummer - " + this.snr + " | Angehaengte Maschine - " + this.machine.toString();
		
	}
		
}