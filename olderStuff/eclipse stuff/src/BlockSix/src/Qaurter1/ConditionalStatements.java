package Qaurter1;

import java.util.Scanner;

public class ConditionalStatements {
	
	public static void main(String [] args) {
		
		@SuppressWarnings("resource")
		Scanner kb  = new Scanner(System.in);
		System.out.println("enter in your favorite whole number: ");
		int numb = kb.nextInt();
			if(numb == 12)
				System.out.println("You agree with billy");
			else
				System.out.println("billy thinks you are wrong");
			System.out.println("how much money do you think you have?");
			double money = kb.nextDouble();
			if(money<=100)
				System.out.println("you need a new job");
			else
				System.out.println("you can afford a tesla");
			System.out.println("Do you like tea?");
			String answer = kb.next();
			if(answer .equalsIgnoreCase("yes"))
				System.out.println("tea is good");
			else
				System.out.println("tea tastes horrible");
	}
}
