package Qaurter1;

import java.util.Scanner;
@SuppressWarnings("resource")
public class assignmentsix {
	

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		String ans = "yes";
		while(ans.equalsIgnoreCase("yes"))
		{
			System.out.println("enter in a program number");
			int choice = kb.nextInt();
			if(choice == 1)
				probone();
			if(choice == 2)
				probtwo();
			if(choice == 3)
				probthree();
			if(choice == 4)
				probfour();
			if(choice == 5)
				probfive();
				System.out.println("would you like to run again?");
				ans = kb.next();
			



	}
	}

	public static void probone() {

		int count = 1;
		int temp = 1;
		while(count <= 1000)
		{
			temp=temp+count;
			System.out.println(temp);
			count++;
		}
			
	}
	public static void probtwo() {
	       Scanner kb = new Scanner(System.in);
	        
	        System.out.println("Please enter the first number:");
	        int firsto = kb.nextInt();
	        System.out.println("Please enter the second number:");
	        int secondo = kb.nextInt();
	        
	        int largo, smallo;
	        if (firsto > secondo) {
	            largo = firsto;
	            smallo = secondo;
	        } else {
	            largo = secondo;
	            smallo = firsto;
	        }

	        int sum = 0;
	        for (int i = smallo; i <= largo; i++) {
	            if (i % 2 != 0) { // Check if the number is odd
	                sum += i;
	            }
	        }

	        System.out.println("The sum of odd numbers between " + smallo + " and " + largo + " is " + sum + ".");


		

	}
	public static void probthree() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter in a positive number:");
        int numbo = kb.nextInt();

        if (numbo < 0) {
            System.out.println("Negative numbers are not allowed to be entered.");
        } else {
            int temp = numbo;
            int ans = 1;

            while (temp > 0) {
                ans *= temp;
                temp--;
            }

            System.out.println(numbo + " factorial is " + ans);
        }

  
	}
	public static void probfour() {
		int count = 10;
		int temp = 0;
		do {
			if(count%9 == 0)
				temp += count;
			count++;
		}
		while(count < 1000);

		System.out.println("the sum of all numbers from 1 to 1000 is " + temp);
	}
	//for some reason when problem 5 is run it also runs problem 4(figured it out, it was because there were semicolons after the if statement cuasing them to be forced to run no matter what
	public static void probfive() {
		Scanner kb = new Scanner(System.in);
	      System.out.println("please enter a number");
	      int numbo = kb.nextInt();
	      String stars = "*";
	      int count = numbo;
	      while(count > 0) {
	        System.out.println(stars);
	        stars += "*";
	        count--;
	       }

		
	}
}
