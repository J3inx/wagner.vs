package absenceThing;

import java.util.Scanner;

public class DeckDriver {

	public static void main(String[] args) {
		//class is a blueprint for an object
		//object is an instance of a class
		

		   

		        Deck deck1 = new Deck(52);

		        Scanner kb = new Scanner(System.in);

		        deck1.setDeck();

		        while(true) {

		            System.out.println("(1) Play Hi/Low");

		            System.out.println("(2) Shuffle Deck");

		            System.out.println("(3) Print Deck");

		            System.out.println("(4) Exit Casino");

		            int choice = kb.nextInt();

		            if (choice==1) {

		            	deck1.HiLo();

		            } else if (choice==2) {

		            	deck1.shuffle();

		            	System.out.println("Deck Shuffled!");

		            } else if (choice==3) {

		            	deck1.printDeck();

		            	System.out.println("Deck Printed!");

		            } else if (choice==4) {

		            	System.out.println("Thanks for playing!");

		            	break;

		            } else {

		            	System.out.println("Invalid Choice Try Again.");

}
		        }
	}
}
