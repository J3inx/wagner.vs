package blackJack;

import java.util.Scanner;



public class JackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        setup deck1 = new setup(52);
        
        Scanner kb = new Scanner(System.in);

        deck1.setDeck();

        while(true) {

            System.out.println("(1) Play black jack");

            System.out.println("(2) Shuffle Deck");

            System.out.println("(3) Print Deck");

            System.out.println("(4) Exit Casino");

            int choice = kb.nextInt();

            if (choice==1) {

            	deck1.playBJack();

            } else if (choice==2) {

            	//deck1.shuffle();

//            	System.out.println("Deck Shuffled!");

            } else if (choice==3) {

            	//deck1.printDeck();

            	//System.out.println("Deck Printed!");

            } else if (choice==4) {

            	
            System.out.println("Thanks for playing!");

            	break;

            } else {

            	System.out.println("Invalid Choice Try Again.");
	}

}
	}
}
