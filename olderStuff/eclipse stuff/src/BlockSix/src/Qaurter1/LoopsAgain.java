package Qaurter1;

import java.util.Scanner;

public class LoopsAgain {
	//main method because it uses main
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
			//object oriented programming(oop)

		//parentheses mean method, ie Mehtod/Function(code);

		int ans = kb.nextInt();
		if(ans==1)
			loopWith4s();
		else
			whileHello();
		kb.close();

	}
	public static void loopWith4s() {
		
		for(int i = 10; i < 1000; i++)
			if(i%5==0)
				System.out.println(i);
		
	}
	public static void whileHello() {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter your greeting");
		String word = kb.next();
		while(!(word.equalsIgnoreCase("hello")))
			System.out.println("bad greeting");
		kb.close();
		
	}

}
