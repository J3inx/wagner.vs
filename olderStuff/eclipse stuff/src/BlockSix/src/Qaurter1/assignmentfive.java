package Qaurter1;

import java.util.Scanner;

public class assignmentfive {

	@SuppressWarnings("resource")
	public static void main(String [] args) {
		
		Scanner kb = new Scanner(System.in);
		//part 1
		System.out.println("please enter your name:");
		String name = kb.next();
		System.out.println("please enter how many classes have been held");
		int held = kb.nextInt();
		System.out.println("please enter how many classes you have attended:");
		int attend = kb.nextInt();
		int atrateone = (held/attend);
		int atratetwo = atrateone*100;
		System.out.println("student name: " + name);
		System.out.println("number of classes held: " + held);
		System.out.println("classes that " + name + " attended: " + attend);
		if(atratetwo >= 75)
			System.out.println(name + " is allowed to retake");
		else
			System.out.println(name + " is not allowed to retake");
		
		//part 2
		
		System.out.println("how much is the toy you are buying:");
		double price = kb.nextDouble();
		System.out.println("how many are you buying?");
		double quant = kb.nextDouble();
		double total = price*quant;
		if(total >= 1000) {
			total = ((total*.10)-total)*-1;
			System.out.println("your total is: " + total);
	}else {
				
			System.out.println("your total is: " + total);
	}
		
		//part 3
		
		System.out.println("do you use military time or standard time? enter s for standard and m for military");
		String timetype = kb.next();
		System.out.println("is it am or pm?");
		String amp = kb.next();
		if(amp .equalsIgnoreCase("am"))
			amp = "am";
		else
			amp = "pm";
		System.out.println("what time is it right now in hours?");
		int timeH = kb.nextInt();
		System.out.println("what time is it in minutes?");
		int timeM = kb.nextInt();
		if(timetype .equalsIgnoreCase("s"))
			if(amp .equals("am"))
				System.out.println("military time is " + timeH + ":" + timeM );
			else if(amp.equals("pm"))
				System.out.println("military time is " + (timeH+12) + ":" + timeM);
		if(timetype .equalsIgnoreCase("m"))
			if(amp .equals("am"))
				System.out.println("standard time is " + timeH + ":" + timeM );
			else if(amp.equals("pm"))
				System.out.println("standard time is " + (timeH-12) + ":" + timeM);
		//part 4
		System.out.println("please enter a year");
		int year = kb.nextInt();
		int valid = 0;
		if (year % 4 == 0)
		    // Except for end-of-century years, which must be divisible by 400
		    if (year % 100 != 0 || year % 400 == 0)
		      valid = 1;
		    else   
		    	valid = 0;
		if(valid == 0)
				System.out.println(year + " is not a leap year");
		else
			System.out.println(year + " is not a leap year");
		//part 5
		System.out.println("how much money do you have?");
		int mon = kb.nextInt();
		int cents = Math.round(mon * 100);
		  int quarters = (int)Math.floor(cents / 25);
		  cents %= 25;
		  System.out.println("you have" + quarters + " quarters");
		  int dimes = (int)Math.floor(cents / 10);
		  cents %= 10;
		  System.out.println("you have " + dimes + " dimes");
		  int nickels = (int)Math.floor(cents / 5);
		  cents %= 5;
		  System.out.println("you have " + nickels + " nickels");
		  int pennies = cents;
		  System.out.println("and you have " + pennies + " cents");		

	}
	
}
