package Qaurter1;

import java.util.Scanner;

public class assignmentThree {

		@SuppressWarnings("resource")
		public static void main(String [] args) {
			@SuppressWarnings("unused")
			Scanner kb = new Scanner(System.in);
			//part 1
			System.out.println("please enter your last name:");
			String last = kb.next();
			System.out.println("please enter your first name:");
			String first = kb.next();
			System.out.println("Good evening, " + first +" " + last + "!");
			//part 2
			
			System.out.println("please enter your smallest random number:");
			int ranlow = kb.nextInt();
			System.out.println("please enter your largest random number:");
			int ranbig = kb.nextInt();
			int dif = ranlow-ranbig;
			if(dif<0)
				dif = dif*-1;
			int first1 = (int) ((Math.random()*dif+1)+ranlow);
			int first2 = (int) ((Math.random()*dif+1)+ranlow);
			int first3 = (int) ((Math.random()*dif+1)+ranlow);
			System.out.println("numbers are: " + first1 + " " + first2 + " " + first3);
			//part 3
			int ranone = (int) ((Math.random()*26)-5);
			if(ranone == 0)
				ranone = (int) ((Math.random()*26)-5);
			int rantwo = (int) ((Math.random()*26)-5);
			if(rantwo == 0)
				rantwo = (int) ((Math.random()*26)-5);
			int ranthree = (int) ((Math.random()*26)-5);
			if(ranthree == 0)
				ranthree = (int) ((Math.random()*26)-5);
			System.out.println("1st random number is: " + ranone);
			System.out.println("2nd random number is: " + rantwo);
			System.out.println("3rd random number is: " + ranthree);
			System.out.println("the equation is " + ranone + "x+" + rantwo + "=" + ranthree);
			double ans = ((double)(ranthree-rantwo)/ranone);
			System.out.println("guess what the rounded version of x is equal to");
			int guess = kb.nextInt();
			if(ans == guess)
				System.out.println("correct! " + guess + " is equal to " + ans);
			else
				System.out.println("wrong, the correct answer was " + ans);
			System.out.println(ans);
			//part 4
			
			System.out.println("what is the area of the square?");
			int square = kb.nextInt();
			double sides = Math.sqrt(square);
			System.out.println("each side of the square is " + sides + " units long");
			//part 5
			
			System.out.println("what is your first name?");
			String namor = kb.next();
			System.out.println("what was the price per gallon the last time you filled up your car?");
			double gas = kb.nextDouble();
			System.out.println("what was the total amount you paid for the fillup?");
			double price = kb.nextDouble();
			System.out.println("what did your odometer read before you filled up?");
			int odom = kb.nextInt();
			System.out.println("what does your odometer read now?");
			int fodom = kb.nextInt();
			int distance = fodom-odom;
			double gasuse = price/gas;
			double mpg = distance/gasuse;
			System.out.println(namor + " you drove " + distance + " miles using up " + gasuse + " gallons of fuel with an mpg of " + mpg);
		}
}
