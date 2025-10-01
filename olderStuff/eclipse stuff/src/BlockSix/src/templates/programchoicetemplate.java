package templates;

import java.util.Scanner;

public class programchoicetemplate {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		String result = "yes";
		while(result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y")) {
			
			System.out.println("***************************");
			System.out.println("1. prob 1");
			System.out.println("***************************");
			System.out.println("2. prob 2");
			System.out.println("***************************");
			System.out.println("3. prob 3");
			System.out.println("***************************");
			System.out.println("4. prob 4");
			System.out.println("***************************");
			System.out.println("5. prob 5");
			System.out.println("***************************");
			System.out.println("6. prob 6");
			System.out.println("***************************");
			System.out.println("what would you like to do");
			System.out.println("***************************");
			int choice = kb.nextInt();
			if(choice == 1) {
				
			}
			if(choice == 2) {
				
			}
			if(choice == 3) {
				
			}
			if(choice == 4) {
				
			}
			if(choice ==5) {
				
			}
			if(choice ==6) {
				
			}
			System.out.println("Run again?");
			result = kb.next();
		}
		System.out.println("have a good day");
	}
}
