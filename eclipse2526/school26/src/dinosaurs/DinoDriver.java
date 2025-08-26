package dinosaurs;



public class DinoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double largest = 0;
		double avg = 0;
		int placement = 0;
		Dino [] dinos = new Dino[50];
		for(int k = 0; k<dinos.length; k++) {
			dinos[k] = new Dino();
			System.out.println(dinos[k]+ "\n");
			avg += dinos[k].getLength();
			if(dinos[k].getLength() > largest) {
				largest = dinos[k].getLength();
				placement = k;
			}
		}
		avg = avg/50;
		System.out.println("\n largest: \n");
		System.out.println(dinos[placement]);
		System.out.println("\n avg length is: " + avg);
	}

}
