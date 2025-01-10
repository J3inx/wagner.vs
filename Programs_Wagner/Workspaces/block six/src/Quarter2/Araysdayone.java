package Quarter2;

public class Araysdayone {
	public static void main(String [] args) {
		
		fillArray1();
		fillArray2();
		fillArray3();
		
	}
	public static void fillArray1() {
		String [] vacations = {"barbados","nebraska","new york","tahiti",};
		System.out.println(vacations[0]);
		System.out.println(vacations[1]);
		System.out.println(vacations[2]);
		System.out.println(vacations[3]);
	}
	public static void fillArray2() {
		int [] siblings = new int [6];
		siblings [0] =1;
		siblings [1] = 10;
		siblings [2] = 2;
		siblings [3] = 3;
		siblings [4] = 4;
		siblings [5] =5;
		System.out.println(""+siblings[0]+ " " + siblings[1]+ " " + siblings[2]+ " " + siblings[3]+ " " + siblings[4]+ " " + siblings[5]);
	}
	public static void fillArray3() {
		int [] randomNumbers = new int[10000];
		for(int k = 0; k<randomNumbers.length; k++) {
			randomNumbers[k] = (int)(Math.random()*50+1);
			System.out.println(k+1 +": " + randomNumbers[k]);
		}
	}
}
