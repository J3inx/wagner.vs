package Qaurter1;

import java.util.Scanner;

public class assignmentFour {
	@SuppressWarnings("resource")
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		//part 1
		System.out.println("please enter a number, negative or positive:");
		int numb = kb.nextInt();
		if(numb > 0)
			System.out.println("your number is positive");
		else
			System.out.println("your number is negative");
		//part 2
		System.out.println("please enter a number for part a of a quadratic equation:");
		double a = kb.nextInt();
		System.out.println("now enter a number for b:");
		double b = kb.nextInt();
		System.out.println("finally please enter a number for c:");
		double c = kb.nextInt();
		System.out.println("variable a is " + a + " variable b is " + b + " and variable c is " + c);
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The root is " + root);
        } else {
            System.out.println("The equation has no real roots.");
        }
		//part 3
		System.out.println("please enter the first number");
		int numone = kb.nextInt();
		System.out.println("please enter the two number");
		int numtwo = kb.nextInt();
		System.out.println("please enter the third number");
		
		int numthree = kb.nextInt();
		@SuppressWarnings("unused")
		int large = Math.max(Math.max(numone,numtwo), numthree);
		if(numthree < numone)
			if(numone<numtwo)
				System.out.println(numtwo + " is the largest");
			else
				if(numone < numtwo)
					System.out.println(numtwo + " is the largest");
				else 
					System.out.println(numone + " is the largest");
		else
			if(numtwo<numthree)
				System.out.println(numthree + " is the largest");
			else
				System.out.println(numtwo + " is the largest");
		//part 4
		System.out.println("please enter a number 1-7:");
		int day = kb.nextInt();
		if(day == 1)
			System.out.println("that is sunday");
		else
			if(day == 2)
				System.out.println("that is monday");
			else
				if(day == 3)
					System.out.println("that is tuesday");
				else
					if(day == 4)
						System.out.println("that is wednesday");
					else
						if(day == 5)
							System.out.println("that is thursday");
						else
							if(day == 6)
								System.out.println("that is friday");
							else
								if(day == 7)
									System.out.println("that is saturday");
		//part 5
		System.out.println("please enter in your score for test 1");
		int test1 = kb.nextInt();
		System.out.println("please enter in your score for test 2");
		int test2 = kb.nextInt();
		System.out.println("please enter in your score for test 3");
		int test3 = kb.nextInt();
		double average = (test1+test2+test3)/3.0;
		if(average<64)
			System.out.println("you got a f");
		else if(average<=69 && average>=65)
				System.out.println("you got a d");
			else if(average<=79 && average>=70)
					System.out.println("you got a c");
				else if(average<=89 && average>=80)
						System.out.println("you got a b");
					else if(average<=100 && average>=90)
							System.out.println("you got an a");
		
		//part 6
		System.out.println("what is the capital of virginia:");
		String cap = kb.next();
		if(cap.equalsIgnoreCase("richmond"))
			System.out.println("correct!");
		else 
			System.out.println("wrong, the capital is richmond");
			

			

		
        

	}

}
