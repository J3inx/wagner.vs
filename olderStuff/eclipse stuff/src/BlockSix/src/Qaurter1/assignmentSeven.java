package Qaurter1;

import java.util.Scanner;

public class assignmentSeven {
	
	static String hello;
	static int test;
	static double average;
	static int mom;
	static int dad;
	static String gender;
	static int numb;
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter the number coresponding to the letter of the program");
		numb = kb.nextInt();
		if(numb == 1) {
		as();	
		}
		if(numb == 2) {
			bs();
		}
		
	}
	public static void as() {
		setName();
	}
	public static void bs() {
	@SuppressWarnings("resource")
	Scanner kb = new Scanner(System.in);
	System.out.println("what is your name:");
	hello = kb.next();
	setGender();
	
	}
	public static void setName() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter your name: ");
		hello = kb.next();
		setTest();
	}
	public static void setTest() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		int count = 1;
		int score = 0;
		String answer = "yes";
		while(answer.equalsIgnoreCase("yes")) {
		System.out.println(hello + " please enter your test score for test " + count + ": ");
		score += kb.nextInt();
		System.out.println("would you like to enter another test?");
		answer = kb.next();
		count++;
		}
		test = count;
		average  = (double)score/((double)count-1);
		findAverage();
		
		
	}
	public static void findAverage() {
	@SuppressWarnings({ "unused", "resource" })
	Scanner kb = new Scanner(System.in);
	System.out.println(average);
	Replay();
	
	}
	public static void heightBoy() {
		int tempo = mom + dad;
		tempo += 5;
		System.out.println("your estimated adult height height is around " + tempo/2 + " inches, give or take 4 inches");
		Replay();
	}
	public static void heightGirl() {
		int tempo = mom + dad;
		tempo -= 5;
		System.out.println("your estimated adult wheight is around " + tempo/2 + " inches, give or take 4 inches");
		Replay();
	}
	public static void setGender() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("are you a girl or a boy:");
		gender = kb.next();
		setHeight();
	}
	public static void setHeight() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("how tall was your birth mother in inches?");
		mom = kb.nextInt();
		System.out.println("how tall was your birth father in inches?");
		dad = kb.nextInt();
		if(gender.equalsIgnoreCase("boy")) {
			heightBoy();
		}else {
			heightGirl();
		}	
	}
	public static void Replay() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("would you like to play the program again?");
		String answer = kb.next();
		if(answer.equalsIgnoreCase("yes")) {
			if(numb == 1) {
				as();	
				}
				if(numb == 2) {
					bs();
				}		
		}else {
			System.out.println("have a good day");
		}
	}
}
