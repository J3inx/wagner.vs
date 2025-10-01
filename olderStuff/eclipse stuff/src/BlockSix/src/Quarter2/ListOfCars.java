package Quarter2;

import java.util.ArrayList;

public class ListOfCars {
	public static void main(String [] args) {
	
		String [] cars = {"mercedes benz", "BMX", "Jeep", "Ferrari"};
		cars[1] = "volvo";
		for(String x:cars) {
			System.out.print(x+" , ");
		}
		//array lists
		
		ArrayList<String>autos = new ArrayList<String>();
		autos.add("Honda");
		autos.add("Subraru");
		autos.add("Toyota");
		System.out.println(autos);
		autos.remove(0);
		System.out.println(autos);
		System.out.println(autos.get(1));
		autos.add("Ford");
		System.out.println(autos);
		
	}
	
}
