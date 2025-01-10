package Qaurter1;

import java.util.Scanner;

public class MethodsTwo {
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		String ans = "yes";
		while(ans.equalsIgnoreCase("yes"))
		{
			System.out.println("what number?:");
			int num = kb.nextInt();
			if(num == 1)
				method1();
			System.out.println("would you like to run again?");
			ans = kb.next();
		}
		kb.close();
		
		
	}
	public static void method1() {
		int counter = 0;
		int students = 0;
		Scanner kb = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			System.out.println("how many pets do you own?");
			int pets = kb.nextInt();
			counter += pets;
			students++;
			
		}
		System.out.println(counter/students);
		kb.close();
	}
}
