package Quarter2;

import java.util.Scanner;

public class passwordGenerator {
	
	static 	Scanner kb = new Scanner(System.in);
	public static void main(String [] args){
		
		System.out.println("what is your first name?");
		String fN = kb.next();
		System.out.println("please enter your last name");
		String lastN = kb.next();
		System.out.println("please enter the day of the month you were born");
		int date = kb.nextInt();
		String word = passwordio(fN, lastN, date);
		System.out.println(word);
		
	}
	public static String passwordio(String a, String b, int c){
		String pWord = "";
		for(int k=0 ; k<a.length(); k=k+2) {
			pWord= pWord + a.charAt(k);
		}
		for(int j = 0 ; j<b.length(); j = j+3) {
			pWord = pWord + b.charAt(j);
		}
		pWord = pWord + c%4;
		return pWord;
	}
}
