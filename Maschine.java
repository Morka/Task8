/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */
 
public interface Maschine {
	
	public String toString();
	
	public double getDetailOfMaschine(); //I decided to make it return a double value, although "DrillMaschine" gives back an int. There
										 //is no loss in precision... so i think it is okay :/
}