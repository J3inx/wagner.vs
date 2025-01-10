package Qaurter1;

import java.util.Scanner;

public class stringMethods {
	
	public static void main(String [] args) {
		
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		/*System.out.println("Please enter in how many cats you own?");
		int AMTcats = kb.nextInt();
		System.out.println(AMTcats + " cats");
		if(AMTcats > 5)
			System.out.println("you are a cat lady/man");
		else
			if(AMTcats <=5)
				System.out.println("you are not a cat lady/man"); */
		System.out.println("enter in your name:"); 
		String name = kb.next();
		/*System.out.println("you entered " + name);
		if(name.equalsIgnoreCase ("william"))
			System.out.println("your name is in the top 10 most popular names " + name + "!");
		else
			System.out.println("not william"); */
		String subName = name.substring(1,5);	
		//number in the parenthesis will take the place of that character in the word and only display that and everything afterwards, ie william, 2, illiam
		//first letter = 0 second is 1 third is 2 and so on and so on
		//doing number,number will start at the first letter and go till just before the last letter
		System.out.println(subName);
		
	}

}
