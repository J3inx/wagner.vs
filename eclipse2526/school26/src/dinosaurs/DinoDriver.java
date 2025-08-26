package dinosaurs;



public class DinoDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double largest = 0;
		int placement = 0;
		Dino [] dinos = new Dino[50];
		for(int k = 0; k<dinos.length; k++) {
			dinos[k] = new Dino();
			System.out.println(dinos[k]+ "\n");
			if(dinos[k].getLength() > largest) {
				largest = dinos[k].getLength();
				placement = k;
			}
		}
		System.out.println("\n largest: \n");
		System.out.println(dinos[placement]);
		
	}

}
