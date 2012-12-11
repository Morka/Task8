import java.lang.reflect.*;
import java.lang.annotation.*;

/**
 * @author Matthias Gusenbauer, Wolfgang Hofer, Alexander Neff
 */

@ClassInformation(author="Alex", date="10.12.2012") 
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bauernhof bauernhof1 = new Bauernhof("Hiasl");

		/*
		 * Estimated output: 0
		 * 
		 * Output is 0 because avgBioTraktor would perform a divide by Zero 
		 * but instead throws a exceptions
		 * */
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

		Bauernbund bauernbund = new Bauernbund(); //Method bauernbund handles the set of Baunerhof's

		Bauernhof bauernhof2 = new Bauernhof("Hoellgraf");
		Bauernhof bauernhof3 = new Bauernhof("Zainzhof");

		bauernhof2.insertTraktor(bio2);
		bauernhof3.insertTraktor(diesel3);
		bauernhof3.insertTraktor(diesel2);

		diesel3.increaseUpHoursFertilizing(5123);
		diesel2.increaseUpHoursFertilizing(234.9);
		diesel3.increaseUpHoursFertilizing(12.34);


		bauernbund.addFarm(bauernhof1);
		bauernbund.addFarm(bauernhof3);
		bauernbund.addFarm(bauernhof2);

		/*
		 * Estimated Output: Hoellgraf
		 * Seriennummer - 2 | Angehaengte Maschine - DrillMaschine: 7
		 * */
		System.out.println(bauernbund.getFarm("Hoellgraf"));
		System.out.println(bauernbund.getFarm("Hoellgraf").getTraktor(2));

		bauernbund.getFarm("Hiasl").getTraktor(2).change(streuer2);
		bauernbund.getFarm("Hiasl").deleteTraktor(bauernbund.getFarm("Hiasl").getTraktor(3));

		/*
		 * Estimated Output after change of Machine: 
		 * Seriennummer - 2 | Angehaengte Maschine - Duengstreuer: 250.0
		 * */
		System.out.println(bauernbund.getFarm("Hiasl").getTraktor(2));

		Set b = bauernbund.getBauernhofSet();

		MyIterator bauernIter = b.iterator();

		System.out.println("\nStatistische Wert berechnen");

		/*Estimated output: 
		 * in Bauernhof "Hiasl":
		 * 	SumOpHours: 5370.24
		 * 	AvgOpHours: 895.04
		 * 	AvgOpHoursFertilize: 895.04
		 * 	SumOpHoursFertilize: 5370.24
		 * 	AvOpHoursDieselTraktor: 1790.08
		 * 	minSwordsDiesel = 7
		 * 	minSwordBio = 3
		 * 	maxSwordBio = 3
		 * 	maxSwordsDiesel = 7
		 * 	AvgCapacityDiesel : 250
		 *  AvgCapacityBio: 375.15
		 *  AvgCapacity: 312.575
		 *  SumCapacity: 1250.3
		 *  rest should be 0
		 *  
		 *  in Bauernhof "Zainzhof":
		 *  SumOpHours: 5370.24
		 *  AvgOpHours: 2685.12
		 *  AvgOpHoursFertilize: 2685.12
		 *  SumOpHoursFertilize: 5370.24
		 *  AvOpHoursDieselTraktor: 2685.12
		 *  minSwordsDiesel: 7.0
		 *  maxSwordsDiesel: 7.0
		 *  AvgCapacityDiesel: 250.0
		 *  AvgCapacity: 250.0
		 *  SumCapacity: 250.0
		 *  rest should be 0
		 *  
		 *  in Bauernhof "Hoellgraf"
		 *  AvgCapacityBio: 250.0
		 *  AvgCapacity: 250.0
		 *	SumCapacity: 250.0
		 *	rest should be 0
		 */
		while(bauernIter.hasNext()){
			Bauernhof tmp = (Bauernhof) bauernIter.next();
			System.out.println(tmp.toString());

			System.out.println("SumOpHours: " + tmp.sumOpHours());
			try {
				System.out.println("AvgBioTraktor: " + tmp.avgBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println("AvgBioTraktor: 0");
			}
			try {
				System.out.println("AvgOpHours: " + tmp.avgOpHours());
			} catch (DivideByZeroException e) {
				System.out.println("AvgOpHours: 0");
			}
			try {
				System.out.println("AvgOpHoursFertilize: " + tmp.avgOpHoursFertilize());
			} catch (DivideByZeroException e) {
				System.out.println("AvgOpHoursFertilize: 0");
			}
			try {
				System.out.println("AvgOpHoursSeed: " + tmp.avgOpHoursSeed());
			} catch (DivideByZeroException e) {
				System.out.println("AvgOpHoursSeed: 0");
			}
			System.out.println("SumOpHoursFertilize: " + tmp.sumOpHoursFertilize());
			System.out.println("SumOpHoursSeed: " + tmp.sumOpHoursSeed());
			try {
				System.out.println("AvOpHoursBioTraktor: " + tmp.avOpHoursBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println("AvOpHoursBioTraktor: 0");
			}
			try {
				System.out.println("AvOpHoursDieselTraktor: " + tmp.avOpHoursDieselTraktor());
			} catch (DivideByZeroException e) {
				System.out.println("AvOpHoursDieselTraktor: 0");
			}
			try {
				System.out.println("AvgDieselTraktorSeed: " + tmp.avgDieselTraktorSeed());
			} catch (DivideByZeroException e) {
				System.out.println("AvgDieselTraktorSeed: 0");
			}
			try {
				System.out.println("AvgDieselTraktorFertilizing: " + tmp.avgDieselTraktorFertilizing());
			} catch (DivideByZeroException e2) {
				System.out.println("AvgDieselTraktorFertilizing: 0");
			}
			try {
				System.out.println("AvgDieselTraktor: "+ tmp.avgDieselTraktor());
			} catch (DivideByZeroException e) {
				System.out.println("AvgDieselTraktor: 0");
			}
			System.out.println("SumDieselTraktor: " + tmp.sumDieselTraktor());
			try {
				System.out.println("AvgBioTraktorSeed: " + tmp.avgBioTraktorSeed());
			} catch (DivideByZeroException e) {
				System.out.println("AvgBioTraktorSeed: 0");
			}
			try {
				System.out.println("AvgBioTraktorFertilizing: " + tmp.avgBioTraktorFertilizing());
			} catch (DivideByZeroException e1) {
				System.out.println("AvgBioTraktorFertilizing: 0");
			}
			try {
				System.out.println("AvgBioTraktor: " + tmp.avgBioTraktor());
			} catch (DivideByZeroException e) {
				System.out.println("AvgBioTraktor: 0");
			}
			System.out.println("SumBioTraktor: " + tmp.sumBioTraktor());
			System.out.println("minSwordsDiesel: " + tmp.minSwordsDiesel());
			System.out.println("minSwordsBio: " + tmp.minSwordsBio());
			System.out.println("maxSwordsDiesel: " + tmp.maxSwordsDiesel());
			System.out.println("maxSwordsBio: " +tmp.maxSwordsBio());
			try {
				System.out.println("AvgCapacityDiesel: " + tmp.avgCapacityDiesel());
			} catch (DivideByZeroException e) {
				System.out.println("AvgCapacityDiesel: 0");
			}
			try {
				System.out.println("AvgCapacityBio: " + tmp.avgCapacityBio());
			} catch (DivideByZeroException e) {
				System.out.println("AvgCapacityBio: 0");
			}
			try {
				System.out.println("AvgCapacity: " + tmp.avgCapacity());
			} catch (DivideByZeroException e) {
				System.out.println("AvgCapacity: 0");
			}
			System.out.println("SumCapacity: "+ tmp.sumCapacity());

		}
				
		Method[] ms = BioTraktor.class.getDeclaredMethods();
		
		
		for(Method m : ms){

			Annotation[] an = m.getAnnotations();
			for(Annotation a : an){
				System.out.println(a);
			}
		}
	}
}