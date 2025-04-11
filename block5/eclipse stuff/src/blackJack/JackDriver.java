package blackJack;

import java.util.Scanner;

import javax.swing.JFrame;



public class JackDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        setup deck1 = new setup(52);
        Yahtzee yaht = new Yahtzee();
        
        Scanner kb = new Scanner(System.in);

        deck1.setDeck();
        Pokey poker = new Pokey(52);
        poker.setDeck();
        System.out.println("do you want to play poker blackjack or yahtzee? b/p/y?");
        String choiced = kb.next();
        if(choiced.equalsIgnoreCase("b")) {
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

//                 	System.out.println("Deck Shuffled!");

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
        }else if(choiced.equalsIgnoreCase("p")) {
        	 while(true) {

                 System.out.println("(1) Play 3 card poker");

                 System.out.println("(2) Shuffle Deck");

                 System.out.println("(3) Print Deck");

                 System.out.println("(4) Exit Casino");

                 int choice = kb.nextInt();

                 if (choice==1) {
                	 poker.shuffle();
                 	poker.playPoker();

                 } else if (choice==2) {

                 	poker.shuffle();

                	System.out.println("Deck Shuffled!");

                 } else if (choice==3) {

                 	//poker.printDeck();

                 	//System.out.println("Deck Printed!");

                 } else if (choice==4) {

                 	
                 System.out.println("Thanks for playing!");

                 	break;

                 } else {

                 	System.out.println("Invalid Choice Try Again.");
     	}

     }
        }else {
        	 while(true) {

                 System.out.println("(1) Play yahtzee");

                 System.out.println("(2) Shuffle Deck");

                 System.out.println("(3) play visual yahtzee");

                 System.out.println("(4) Exit Casino");

                 int choice = kb.nextInt();

                 if (choice==1) {
                	 Yahtzee game = new Yahtzee();
                	
                	 try {
						yaht.play();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 	

                 } else if (choice==2) {

                 	//poker.shuffle();

                	System.out.println("Deck Shuffled!");

                 } else if (choice==3) {

                 	//visual yahtzee                	 
                	 VYahtzee game = new VYahtzee();
                	 

                 } else if (choice==4) {

                 	
                 System.out.println("Thanks for playing!");

                 	break;

                 } else {

                 	System.out.println("Invalid Choice Try Again.");
     	}

     }
        }

       
	}
}
