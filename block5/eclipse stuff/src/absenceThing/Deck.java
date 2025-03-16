package absenceThing;

import java.util.Scanner;

public class Deck {
    private String[][] cards;
    private String[] values = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
    private String[] actValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
    private String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"}; // Spades, Hearts, Diamonds, Clubs
    public int bankStatus = 100;
    public int bet;

    public Deck(int x) {
        cards = new String[x][2];
        setDeck();
    }

    public void setDeck() {
        int index = 0;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < values.length; i++) {
                cards[index][0] = values[i];  // Card value
                cards[index][1] = suits[k];   // Card suit
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
    	boolean betted = false;
        Scanner kb = new Scanner(System.in);
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < values.length; i++) {
            	if(!betted) {
                System.out.println("How much would you like to bet? Current balance is: " + bankChanges());
                bet = kb.nextInt();
                betted = true;
            	}else {
            		System.out.println("would you like to keep the current bet at " + bet + "? y/n, Current balance is: " + bankChanges());	
            		if(kb.next().equalsIgnoreCase("n")) {
            			
            		}
            	}
            	
                

                String[] firstCard = cards[k * values.length + i];
                System.out.println("The first card in the deck is " + firstCard[0] + " " + firstCard[1] + ". Will the next card be higher or lower? (h/l)");
                String response = kb.next();

                if (k * values.length + i + 1 >= cards.length) {
                    System.out.println("No more cards in the deck!");
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
                    System.out.println("Wrong!");
                    failure(true, bet);
                } else {
                    System.out.println("You won!");
                    failure(false, bet);
                }
            }
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
}
