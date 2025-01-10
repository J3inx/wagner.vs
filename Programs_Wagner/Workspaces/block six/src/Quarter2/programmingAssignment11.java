package Quarter2;

import java.util.Scanner;

public class programmingAssignment11 {
	static int elp = 2;
	public static void main(String [] args) {

		String [] words = {"hello", "help", "desk", "music", "games", "video", "scorpion", "ocean", "drive", "car"};
		String x = words[(int)(Math.random()*10)];
		String [] choice = {x};
		String [] bar = new String [choice[0].length()];
		method(x);
	}
	public static void method(String x) {
	    int chances = 10;
	    int correct = 0;
	    int count2 = 0;
	    int oldCount = 0;
	    
	    while (elp > 1) {
	        String[] choice = { x };
	        String[] bar = new String[choice[0].length()];
	        
	        for (int k = 0; k < choice[0].length(); k++) {
	            bar[k] = "*";
	        }

	        String entered = "hello";

	        while (chances > 0) {
	            Scanner kb = new Scanner(System.in);
	            System.out.println(choice[0].length());

	            for (int k = 0; k < choice[0].length(); k++) {
	                System.out.print(bar[k]);
	            }

	            System.out.println("");
	            System.out.println("enter in a letter");
	            entered = kb.next();

	            for (int k = 0; k < choice[0].length(); k++) {
	                System.out.println(chances + " " + correct);
	                System.out.println(entered);

	                if (choice[0].substring(k, k + 1).equalsIgnoreCase(entered)) {
	                    correct++;
	                    bar[k] = entered;
	                    count2++;
	                }
	            }

	            for (int i = 0; i < choice[0].length(); i++) {
	                if (choice[0].charAt(i) == '*') {
	                    oldCount = count2;
	                    count2++;
	                }
	            }

	            if (count2 == choice[0].length()) {
	                System.out.println("e");
	                endWin();
	            } else {
	                if (chances == 0 && count2 != choice[0].length()) {
	                    endLoss();
	                }
	            }

	            chances--;

	            if (elp <= 1) {
	                break; // exit the loop when elp is less than or equal to 1
	            }
	        }
	    }
	}
	public static void endWin() {
		System.out.println("you won!");
		elp--;
	}
	public static void endLoss() {
		System.out.println("you lost");
		elp--;
	}

}


		
	

