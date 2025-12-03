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
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		System.out.println("please enter number to debinarify");
		double chooser = kb.nextDouble();
		double accumulatoro = 0;
		for(int i = 0; i < (chooser + "").length(); i++) {
			if(("" + chooser).charAt(i) == '1') {
				System.out.println(i);
				accumulatoro += Math.pow(2.0, i);
			}else {
				accumulatoro += 0;
			}
		}
		System.out.println("debinarified double is: " + accumulatoro);
		
		System.out.println("please enter number to hexify");
		int num = kb.nextInt();

		String hexDigits = "0123456789ABCDEF";
		String hex = "";
		if (num == 0) {
		    hex = "0";
		}
		while (num > 0) {
		    int remainder = num % 16;         
		    hex = hexDigits.charAt(remainder) + hex;  
		    num = num / 16;
		}
		System.out.println("Hex value: " + hex);
		System.exit(0);
	}

}
