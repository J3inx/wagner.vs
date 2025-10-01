package Qaurter1;

import java.util.Scanner;

public class inputtingData {
	
	@SuppressWarnings("unused")
	public static void main(String [] args)
	{
		int x =33;

		@SuppressWarnings("resource")
		Scanner kbs = new Scanner(System.in);
		System.out.println("what is your name? ");
		String name = kbs.next();
		System.out.println("good afternoon " + name);
		System.out.println("how old are you? ");
		int age = kbs.nextInt();
		System.out.println(name + " is " + age + " years old");
		System.out.println("what is your shoe size");
		double size = kbs.nextDouble();
		System.out.println(name + " is " + age + " years old " + " with a shoes size of " + size);
		int c = 5;

		int d = 6;

		c += 3;

		d--;

		double num = c;

		System.out.println( num /= d);
	
	}

}
