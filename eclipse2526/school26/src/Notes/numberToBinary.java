package Notes;

import java.util.Scanner;

public class numberToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter number to binarify");
		int choice = kb.nextInt();
		int max = 0;
		double accumulator = 0;
		for(int i = 0; Math.pow(2.0, (double)i) < choice; i++) {
			max = i;
		}
		for(int i = max; i >= 0; i--) {
			//System.out.println(Math.pow(2.0, (double)i));
			accumulator += Math.pow(2.0, (double)i);
			if(Math.pow(2.0, (double)i) <= choice) {
				choice -= Math.pow(2.0, (double)i);
				System.out.println("I");
			}else {
				System.out.println("0");
			}
		}
		System.exit(0);
	}

}
