package Quarter2;

import java.util.Scanner;

public class TwoMethods {
	public static void main(String [] args) {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		String result = "yes";
		while(result.equalsIgnoreCase("yes")) {
			System.out.println("***************************");
			System.out.println("1. print a three");
			System.out.println("2. print a different three");
			System.out.println("***************************");
			System.out.println("3. print a random number");
			System.out.println("***************************");
			System.out.println("4. print out another three");
			System.out.println("***************************");
			System.out.println("what would you like to do");
			System.out.println("***************************");
			int choice = kb.nextInt();
			if(choice == 1) {
				printThree();
			}
			if(choice == 2) {
				print3("billy", 3);
				//inside callin the method, tell it what is being sent
			}
			if(choice == 3) {
				print3("william", (int)(Math.random()*100));
			}
			if(choice == 4) {
				int temp = backThree();
				System.out.println(temp);
			}
			System.out.println("Run again?");
			result = kb.next();
		}
		System.out.println("have a good day");
		
	}
	public static void printThree(){
		System.out.println("3");
	}
	public static void print3(String name, int x) {
		//in the method define what everything is that is being sent
		System.out.println(name + " is a " + x);
	}
	public static int backThree() {
		//if void is replaced with int in the method, the last line always has to say return with an int aftewards
		return 4;
	}
}
