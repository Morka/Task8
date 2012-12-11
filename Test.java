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
		
		System.out.println(bauernhof1.avgBioTraktor());

		
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
		
		Set b = bauernbund.getBauernhofSet();
		
		MyIterator bauernIter = b.iterator();
		
		while(bauernIter.hasNext()){
			Bauernhof tmp = (Bauernhof) bauernIter.next();
			System.out.println(tmp.toString());
			System.out.println(tmp.sumOpHours());
			System.out.println(tmp.avgBioTraktor());
			System.out.println(tmp.avgOpHours());
			System.out.println(tmp.avgOpHoursFertilize());
			System.out.println(tmp.avgOpHoursSeed());
			System.out.println(tmp.sumOpHoursFertilize());
			System.out.println(tmp.sumOpHoursSeed());
			System.out.println(tmp.avOpHoursBioTraktor());
			System.out.println(tmp.avOpHoursDieselTraktor());
			System.out.println(tmp.avgDieselTraktorSeed());
			System.out.println(tmp.avgDieselTraktorFertilizing());
			System.out.println(tmp.avgDieselTraktor());
			System.out.println(tmp.sumDieselTraktor());
			System.out.println(tmp.avgBioTraktorSeed());
			System.out.println(tmp.avgBioTraktorFertilizing());
			System.out.println(tmp.avgBioTraktor());
			System.out.println(tmp.sumBioTraktor());
			System.out.println(tmp.minSwordsDiesel());
			System.out.println(tmp.minSwordsBio());
			System.out.println(tmp.maxSwordsDiesel());
			System.out.println(tmp.maxSwordsBio());
			System.out.println(tmp.avgCapacityDiesel());
			System.out.println(tmp.avgCapacityBio());
			System.out.println(tmp.avgCapacity());
			System.out.println(tmp.sumCapacity());
		}
		
		System.out.println("\nStatistische Wert berechnen");

	}
}