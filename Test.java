import java.lang.reflect.Method;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

@ClassInformation(author="Alex", date="10.12.2012") 
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
		try {
			System.out.println(bauernhof1.avgBioTraktor());
		} catch (DivideByZeroException e) {
			System.out.println(0);
		} 

		BioTraktor bio1 = new BioTraktor(1);
		BioTraktor bio2 = new BioTraktor(2);
		BioTraktor bio3 = new BioTraktor(3);
		DieselTraktor diesel1 = new DieselTraktor(4);
		DieselTraktor diesel2 = new DieselTraktor(5);
		DieselTraktor diesel3 = new DieselTraktor(6);
		
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
		
		try {
			System.out.println(bauernhof1.avgBioTraktor());
		} catch (DivideByZeroException e) {
			System.out.println("No BioTraktor");
		}

		
		Bauernbund bauernbund = new Bauernbund(); //Method bauernbund handles the set of Baunerhof's
			
		Bauernhof bauernhof2 = new Bauernhof("Hoellgraf");
		Bauernhof bauernhof3 = new Bauernhof("Zainzhof");
		
		bauernhof2.insertTraktor(bio2);
		
		bauernbund.addFarm(bauernhof1);
		bauernbund.addFarm(bauernhof3);
		bauernbund.addFarm(bauernhof2);
		
		System.out.println(bauernbund.getFarm("Hoellgraf"));
		System.out.println(bauernbund.getFarm("Hoellgraf").getTraktor(2));
		
		bauernbund.getFarm("Hiasl").getTraktor(2).change(streuer2);
		bauernbund.getFarm("Hiasl").deleteTraktor(bauernbund.getFarm("Hiasl").getTraktor(3));
		
		System.out.println(bauernbund.getFarm("Hiasl").getTraktor(2));
		
		Set b = bauernbund.getBauernhofSet();
		
		MyIterator bauernIter = b.iterator();
		
		System.out.println("\nStatistische Wert berechnen");
		
		while(bauernIter.hasNext()){
			Bauernhof tmp = (Bauernhof) bauernIter.next();
			System.out.println(tmp.toString());
			System.out.println(tmp.sumOpHours());
			
			try {
				System.out.println(tmp.avgBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgOpHours());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgOpHoursFertilize());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgOpHoursSeed());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			System.out.println(tmp.sumOpHoursFertilize());
			System.out.println(tmp.sumOpHoursSeed());
			try {
				System.out.println(tmp.avOpHoursBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avOpHoursDieselTraktor());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgDieselTraktorSeed());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgDieselTraktorFertilizing());
			} catch (DivideByZeroException e2) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgDieselTraktor());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			System.out.println(tmp.sumDieselTraktor());
			try {
				System.out.println(tmp.avgBioTraktorSeed());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgBioTraktorFertilizing());
			} catch (DivideByZeroException e1) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			System.out.println(tmp.sumBioTraktor());
			System.out.println(tmp.minSwordsDiesel());
			System.out.println(tmp.minSwordsBio());
			System.out.println(tmp.maxSwordsDiesel());
			System.out.println(tmp.maxSwordsBio());
			try {
				System.out.println(tmp.avgCapacityDiesel());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgCapacityBio());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			try {
				System.out.println(tmp.avgCapacity());
			} catch (DivideByZeroException e) {
				System.out.println(0);
			}
			System.out.println(tmp.sumCapacity());
			
		}
	}
}