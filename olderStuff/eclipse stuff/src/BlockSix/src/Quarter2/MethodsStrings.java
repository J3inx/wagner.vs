package Quarter2;

import java.util.Scanner;

public class MethodsStrings {

	@SuppressWarnings("resource")
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("enter in your name");
		String name = kb.next();
		char letter = secondLetter(name);
		System.out.println(letter);
		String newName = pigName(name);
		System.out.println(newName);
	}
	
	
	public static char secondLetter(String n){
		Scanner kb = new Scanner(System.in);
		System.out.println("please find the place value of the letter you want to print");
		int count = kb.nextInt();
		char sign = n.charAt(count);
		kb.close();
		return sign;
	
	}
	public static String pigName(String n) {
		String temp = "";
		//drop the first letter and add ioe to the end
		temp = n.substring(1,4)+"ioe";
		return temp;
		
		
	}
	
}
