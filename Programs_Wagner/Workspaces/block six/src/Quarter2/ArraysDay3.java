package Quarter2;

public class ArraysDay3 {
	public static void main(String [] args) {
		int [] pirate = {6, 10, 13, 5, 9};
		for(int k = 0; k<pirate.length; k++) {
			System.out.println(pirate[k]);
		}
		System.out.println("break");
		int l = pirate[pirate.length-1]; // l = 9
		int p = pirate[0]; // p = 6
		pirate[0] = l; // {9 10 13 5 9}
		pirate[pirate.length-1] = p; //{9 10 13 5 6}
		for(int k = 0; k<pirate.length; k++) {
			System.out.println(pirate[k]);
		}
	}
	

}
