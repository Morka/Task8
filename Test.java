import java.lang.reflect.Method;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Traktor fendtVarioBitch = new BioTraktor();
		Method[] ms = BioTraktor.class.getDeclaredMethods();
		
		for(Method m : ms){
			
			System.out.println(m.toString());
			
		}
		
		System.out.println(ms.length);
		System.out.println(ms[0]);
			
		Bauernhof bauernhof1 = new Bauernhof("Hiasl");
		System.out.println(bauernhof1.avgBioTraktor()); //gives out NaN

		BioTraktor bio1 = new BioTraktor();
		BioTraktor bio2 = new BioTraktor();
		BioTraktor bio3 = new BioTraktor();
		DieselTraktor diesel1 = new DieselTraktor();
		DieselTraktor diesel2 = new DieselTraktor();
		DieselTraktor diesel3 = new DieselTraktor();
		
		DrillMaschine drill1 = new DrillMaschine(3);
		DrillMaschine drill2 = new DrillMaschine(7);
		Duengstreuer streuer1 = new Duengstreuer(500.3);
		Duengstreuer streuer2 = new Duengstreuer(250);
		
		bio1.change(drill1);
		bio2.change(drill2);
		bio3.change(streuer1);
		diesel1.change(streuer2);
		diesel2.change(drill2);
		diesel3.change(streuer2);
		
		bauernhof1.insertTraktor(bio1);
		bauernhof1.insertTraktor(bio2);
		bauernhof1.insertTraktor(bio3);
		bauernhof1.insertTraktor(diesel1);
		bauernhof1.insertTraktor(diesel2);
		bauernhof1.insertTraktor(diesel3);
		
		
		System.out.println(bauernhof1.avgBioTraktor());
		
		Bauernhof bauernhof2 = new Bauernhof("Hoellgraf");
		Bauernhof bauernhof3 = new Bauernhof("Zainzhof");
		Set bauernhoefe1 = new Set();
		
		bauernhoefe1.insert(bauernhof1);
		bauernhoefe1.insert(bauernhof2);
		bauernhoefe1.insert(bauernhof3);
		
		Bauernhof tmp = bauernhoefe1.getBauernhof("Hoellgraf", null);
		
		System.out.println(tmp.toString());
		
		System.out.println("\nStatistische Wert berechnen");
		
		
		
	}
}