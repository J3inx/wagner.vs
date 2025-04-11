package exampleIA;
import java.util.Scanner;
public class aHiLowGame {

		private String[][] cards;
	    private String[] values = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
	    private String[] actValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	    private int currentIndex = 0;
	    private String[] currentCard;
	    private String[] nextCard;
	    private String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"}; // Spades, Hearts, Diamonds, Clubs
	    public int bankStatus = 100;
	    public int bet;
	    private gamesGUI gui; 

	       
	        
	        public aHiLowGame(gamesGUI gui) {
	            this.gui = gui;  
	            starter();
	        }
	    public void starter() {
	    	//gui.write("test");
	    	cards = new String[52][2];
	        setDeck();
	        shuffle();
	    }
	    public void handleHiLoChoice(String response) {
	        gui.showHiLoButtons(false); // hide buttons again

	        int firstVal = getCardValue(currentCard[0]);
	        int nextVal = getCardValue(nextCard[0]);

	        gui.write("Next card was " + nextCard[0] + " " + nextCard[1]);
	        gui.write("new bank balance is: " + bankChanges());

	        boolean correct = false;
	        if (response.equalsIgnoreCase("h") && nextVal > firstVal) {
	            correct = true;
	        } else if (response.equalsIgnoreCase("l") && nextVal < firstVal) {
	            correct = true;
	        }

	        if (correct) {
	            gui.write("Correct!");
	            failure(false, bet);
	        } else {
	            gui.write("Wrong!");
	            failure(true, bet);
	        }

	        currentIndex++; // move to next card
	        askHiLoNextCard(); // go again
	    }

	    public void askHiLoNextCard() {
	        if (currentIndex >= cards.length - 1) {
	            gui.write("No more cards in the deck!");
	            return;
	        }

	        currentCard = cards[currentIndex];
	        nextCard = cards[currentIndex + 1];
	        gui.write("Current card is " + currentCard[0] + " " + currentCard[1]);
	        gui.write("Will the next card be higher or lower?");

	        // Show buttons to let user choose
	        gui.showHiLoButtons(true);
	    }

	    public void setDeck() {
	        int index = 0;
	        for (int k = 0; k < 4; k++) {
	            for (int i = 0; i < values.length; i++) {
	                cards[index][0] = values[i];  
	                cards[index][1] = suits[k];   
	                index++;
	            }
	        }
	    }

	    public void shuffle() {
	        for (int i = cards.length - 1; i > 0; i--) {
	            int j = (int) (Math.random() * (i + 1));
	            String[] temp = cards[i];
	            cards[i] = cards[j];
	            cards[j] = temp;
	        }
	    }

	    public void printDeck() {

	        for (String[] card : cards) {
	            System.out.println(card[0] + " " + card[1]);
	        }
	    }
	    public void HiLo() {
	        // Set up the initial state and display
	        gui.write("How much would you like to bet? Current balance is: " + bankChanges() + " (put $ after you're done)");

	
	        gui.write("Please place your bet by entering an amount in the text field and clicking Submit.");
	    }

	    public void handleSubmitBet() {
	        String input = gui.respond().trim();

	        bet = parseInt(input);
	        
	        if (bet == -1) {
	            gui.write("Invalid bet. Please enter a valid bet.");
	            return;  
	        }

	   
	        gui.write("You placed a bet of $" + bet + ". Let's play!");

	
	       

	        currentIndex = 0;
	        askHiLoNextCard();
	    }


	    private void playGameRound() {
	    
	    	boolean betted = false;
	        Scanner kb = new Scanner(System.in);
	        for (int k = 0; k < 4; k++) {
	            for (int i = 0; i < values.length; i++) {
	            	if(!betted) {
	                //System.out.println("How much would you like to bet? Current balance is: " + bankChanges());
	                //bet = kb.nextInt();
	                betted = true;
	            	}else {
	            		//System.out.println("would you like to keep the current bet at " + bet + "? y/n, Current balance is: " + bankChanges());	
	            		//if(kb.next().equalsIgnoreCase("n")) {
	            			
	            		}
	            	
	            	
	                

	                String[] firstCard = cards[k * values.length + i];
	                gui.write("The first card in the deck is " + firstCard[0] + " " + firstCard[1] + ". Will the next card be higher or lower? (h/l)");
	               
	                String response = "";
	                while(response.length() < 1) {
	                	response =  gui.getAnswer("", false);
	                }

	                if (k * values.length + i + 1 >= cards.length) {
	                    gui.write("No more cards in the deck!");
	                    break;
	                }

	                String[] nextCard = cards[k * values.length + i + 1];
	                System.out.println("The next card in the deck is " + nextCard[0] + " " + nextCard[1]);

	                int firstValue = getCardValue(firstCard[0]);
	                int nextValue = getCardValue(nextCard[0]);

	                boolean correctGuess = false;
	                
	                if (response.equalsIgnoreCase("h")) {
	                    if (nextValue > firstValue) {
	                        correctGuess = true;
	                    }
	                } else if (response.equalsIgnoreCase("l")) {
	                    if (nextValue < firstValue) {
	                        correctGuess = true;
	                    }
	                }

	                if (!correctGuess) {
	                	gui.write("Wrong!");
	                    failure(true, bet);
	                    gui.write("new bank balance is: " + bankChanges());
	                } else {
	                	gui.write("You won!");
	                    failure(false, bet);
	                    gui.write("new bank balance is: " + bankChanges());
	                }
	            }
	        }
	        }
	    


	  private int parseInt(String respond) {
	        if (respond == null || respond.trim().isEmpty()) {
	            gui.write("Please enter a valid number.");
	            return -1; 
	        }
	        try {
	            return Integer.parseInt(respond);
	        } catch (NumberFormatException e) {
	            gui.write("Invalid number. Please try again.");
	            return -1;
	        }
	    }

		public int getCardValue(String card) {
	        for (int i = 0; i < values.length; i++) {
	            if (values[i].equalsIgnoreCase(card)) {
	                return Integer.parseInt(actValues[i]);
	            }
	        }
	        return -1; // Should never happen
	    }

	    public void failure(boolean lost, int bet) {
	        if (!lost) {
	            bankChanges(bet);
	        } else {
	            bankChanges(-bet);
	        }
	    }

	    public int bankChanges() {
	        return bankStatus;
	    }

	    public void bankChanges(int x) {
	        bankStatus += x;
	    }
	    //public String printCard() {
	    	//return cards[0][0] + cards[0][1];
	   // }
}
