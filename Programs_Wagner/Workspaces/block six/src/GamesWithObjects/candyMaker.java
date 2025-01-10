package GamesWithObjects;

public class candyMaker {
	public static void main(String [] agrs) {
		//array of objects
		candy [] c = new candy[100];
		//100 memory locations for candy
		for(int k = 0; k<150; k++) {
			c[k] = new candy();
			System.out.println(c[k]);
		}
		
	}
}
