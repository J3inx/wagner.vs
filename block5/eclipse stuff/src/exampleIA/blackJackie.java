package exampleIA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class blackJackie {
	
	    private String[] cards; // Now a 1D array
	    private String[] values = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
	    private String[] actValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	    private String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"}; // Spades, Hearts, Diamonds, Clubs

	    private ArrayList<String> playerHand = new ArrayList<>(); 
	    private ArrayList<String> cpu1Hand = new ArrayList<>();
	    public Boolean cpu1stood = false;
	    private ArrayList<String> cpu2Hand = new ArrayList<>();
	    public Boolean cpu2stood = false;
	    private ArrayList<String> cpu3Hand = new ArrayList<>();
	    public Boolean cpu3stood = false;
	    private ArrayList<String> DealerHand = new ArrayList<>();
	    public Boolean dealerstood = false;
	    private gamesGUI gui; 

	    public int bankStatus = 100;
	    public int bet;
	    public int turns = 0;
	    public int currentCard = 10;
	    public int standings = 0;
	    public Boolean playerStood = false;
	    private Scanner kb = new Scanner(System.in);
	    private Map<String, Integer> cardValues = new HashMap<>();

	   
	    public blackJackie(gamesGUI gui) {
	    	cards = new String[52];
	    	this.gui = gui;
	    	
	    }
	    

	    public void setDeck() {
	        int index = 0;
	        for (String suit : suits) {
	            for (String value : values) {
	                cards[index] = value + "" + suit; // Format: ACE of ♠, 2 of ♡, etc.
	                index++;
	            }
	        }
	        cardValues.put("ACE", 11);  // Default, but will be adjusted in the game logic
	        cardValues.put("2", 2);
	        cardValues.put("3", 3);
	        cardValues.put("4", 4);
	        cardValues.put("5", 5);
	        cardValues.put("6", 6);
	        cardValues.put("7", 7);
	        cardValues.put("8", 8);
	        cardValues.put("9", 9);
	        cardValues.put("10", 10);
	        cardValues.put("JACK", 10);
	        cardValues.put("QUEEN", 10);
	        cardValues.put("KING", 10);
	    }

	    // Shuffle the deck (Fisher-Yates shuffle)
	    public void shuffle() {
	        for (int i = cards.length - 1; i > 0; i--) {
	            int j = (int) (Math.random() * (i + 1));
	            String temp = cards[i];
	            cards[i] = cards[j];
	            cards[j] = temp;
	        }
	    }

	    
	    public void playBJack() {
	    	cards = new String[52];
	        setDeck();
	        shuffle();
	        Dealer(1); // Start the game with shuffled deck
	    }
	        //ai generated, it told me about hashmaps but still dont really know how to use those

	    


	    public void printDeck() {
	        for (String card : cards) {
	            System.out.println(card);
	        }
	    }
	    

	    public int getCardValue(String card) {
	        for (int i = 0; i < values.length; i++) {
	            if (card.contains(values[i])) {
	                return Integer.parseInt(actValues[i]);
	            }
	        }
	        return -1; // Should never happen
	    }
	 // Add this method to your setup class:

	    public int getHandValue(ArrayList<String> hand) {
	        int value = 0;
	        int aceCount = 0; // Track aces separately

	        for (String card : hand) {
	            // Extract the rank (remove the suit)
	            String rank = card.replaceAll("[^A-Za-z0-9]", ""); // Removes any non-alphanumeric character

	            if (cardValues.containsKey(rank)) {
	                int cardValue = cardValues.get(rank);
	                if (rank.equals("ACE")) {
	                    aceCount++;  // Count the number of aces
	                } else {
	                    value += cardValue;
	                }
	            } else {
	                System.out.println("Invalid card value: " + rank);
	            }
	        }

	        // Adjust ace values: Make some aces 1 if needed to avoid busting
	        while (aceCount > 0) {
	            if (value + 11 <= 21) {
	                value += 11;  // Keep ace as 11 if it doesn't cause a bust
	            } else {
	                value += 1;   // Otherwise, treat ace as 1
	            }
	            aceCount--;
	        }

	        return value;
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
	    public void hit() {
	    	Dealer(3);
	    }
	    public void stand() {
	    	Dealer(4);
	    }
	    public void Dealer(int action) { 
	        if (action == 1) {
	            int turn = 0;
	            int cardIndex = 0; // Tracks dealt cards

	            while (cardIndex < 10) {
	                if (turn == 0) { // Player's turn
	                    if (playerHand.size() < 2) {
	                        playerHand.add(cards[cardIndex]); // Assign card from deck
	                        cardIndex++;
	                    }
	                    if (playerHand.size() == 2) turn++; // Move to next player
	                } 
	                else if (turn == 1) { // CPU 1
	                    if (cpu1Hand.size() < 2) {
	                        cpu1Hand.add(cards[cardIndex]);
	                        cardIndex++;
	                    }
	                    if (cpu1Hand.size() == 2) turn++;
	                } 
	                else if (turn == 2) { // CPU 2
	                    if (cpu2Hand.size() < 2) {
	                        cpu2Hand.add(cards[cardIndex]);
	                        cardIndex++;
	                    }
	                    if (cpu2Hand.size() == 2) turn++;
	                } 
	                else if (turn == 3) { // CPU 3
	                    if (cpu3Hand.size() < 2) {
	                        cpu3Hand.add(cards[cardIndex]);
	                        cardIndex++;
	                    }
	                    if (cpu3Hand.size() == 2) turn++;
	                } 
	                else if (turn == 4) { // Dealer
	                    if (DealerHand.size() < 2) {
	                        DealerHand.add(cards[cardIndex]);
	                        cardIndex++;
	                    }
	                    if (DealerHand.size() == 2) turn = 0; // Restart or stop
	                }
	            }

	            // Print player's hand
	            gui.write("Player has: " + playerHand.get(0) + " and " + playerHand.get(1));
	            gui.write("cpu1 has : " + cpu1Hand.get(0));
	            gui.write("cpu2 has : " + cpu2Hand.get(0));
	            gui.write("cpu3 has : " + cpu3Hand.get(0));
	            gui.write("and the dealer has: " + DealerHand.get(0));
	            Dealer(2);
	        }
	        if(action == 2 && playerStood == false) {
	        	if(turns == 0) {
	        		String card1 = playerHand.get(0);
	            	
	            	String card2 = playerHand.get(1);
	            	
	            	if(card1.charAt(0) == card2.charAt(0)){
	            		
	        	System.out.println("would you like to hit or stand?");
	        	String choice = kb.next();
	        	if(choice.equalsIgnoreCase("h")) {
	        		Dealer(3);
	        	}else if(choice.equalsIgnoreCase("s")) {
	        		Dealer(4);
	        	}else {
	        		Dealer(8);
	        	}
	        }
	        }
	        if(action ==3) {
	        	/*hit
	        	playerHand.add(cards[currentCard]);
	        	if(getHandValue(playerHand)>21) {
	        		System.out.println("you drew a " + cards[currentCard] );
	        		System.out.println("you bust!");
	        		playerStood = true;
	        		aiTurns();
	        	}else {
	        		System.out.println("you drew a " + cards[currentCard] );
	            	currentCard++;
	            	turns++;
	            	Dealer(7);
	        	}
	        	
	        }
	        */
	        if(action ==4) {
	        	//stand
	        	standings++;
	        	playerStood=true;
	        	aiTurns();
	        }
	        if(action == 5) {
	        	playerHand.add(cards[currentCard]);
	        	System.out.println("you drew a " + cards[currentCard] );
	        	currentCard++;
	        	standings ++;
	        	bet = bet*2;
	        	playerStood=true;
	        	aiTurns();
	        }
	        if(action == 6) {
	        	//TO DO
	        }
	        if(action == 7) {
	        	aiTurns();
	        	Dealer(2);
	        }
	        if(action == 8) {
	        	System.out.print("player 1 has: ");
	        	for(int i = 0; i<playerHand.size(); i++) {
	        		System.out.print(playerHand.get(i) + " ");
	        	}
	        	System.out.println("");
	        	System.out.print("cpu1 has: ");
	        	for(int i = 0; i<cpu1Hand.size(); i++) {
	        		if(!(i==1)) {
	        		System.out.print(cpu1Hand.get(i) + " ");
	        		}else {
	        			System.out.print("hidden ");
	        		}
	        	}
	        	System.out.println("");
	        	System.out.print("cpu2 has: ");
	        	for(int i = 0; i<cpu2Hand.size(); i++) {
	        		if(!(i==1)) {
	        		System.out.print(cpu2Hand.get(i) + " ");
	        		}else {
	        			System.out.print("hidden ");
	        		}
	        	}
	        	System.out.println("");
	        	System.out.print("cpu3 has: ");
	        	for(int i = 0; i<cpu3Hand.size(); i++) {
	        		if(!(i==1)) {
	        		System.out.print(cpu3Hand.get(i) + " ");
	        		}else {
	        			System.out.print("hidden ");
	        		}
	        	}
	        	System.out.println("");
	        	System.out.print("dealer has: ");
	        	for(int i = 0; i<DealerHand.size(); i++) {
	        		if(!(i==1)) {
	        		System.out.print(DealerHand.get(i) + " ");
	        		}else {
	        			System.out.print("hidden ");
	        		}
	        	}
	        	System.out.println("");
	        	Dealer(2);
	        }
	        if (action == 9) {
	            int playerValue = getHandValue(playerHand);
	            int cpu1Value = getHandValue(cpu1Hand);
	            int cpu2Value = getHandValue(cpu2Hand);
	            int cpu3Value = getHandValue(cpu3Hand);
	            int dealerValue = getHandValue(DealerHand);

	            int highest = 0;
	            int winner = -1;
	            List<String> winningHand = null;

	            // Compare player hand values with AI and dealer
	            if (playerValue <= 21 && playerValue > highest) {
	                highest = playerValue;
	                winner = 0;
	                winningHand = playerHand;
	            }
	            if (cpu1Value <= 21 && cpu1Value > highest) {
	                highest = cpu1Value;
	                winner = 1;
	                winningHand = cpu1Hand;
	            }
	            if (cpu2Value <= 21 && cpu2Value > highest) {
	                highest = cpu2Value;
	                winner = 2;
	                winningHand = cpu2Hand;
	            }
	            if (cpu3Value <= 21 && cpu3Value > highest) {
	                highest = cpu3Value;
	                winner = 3;
	                winningHand = cpu3Hand;
	            }
	            if (dealerValue <= 21 && dealerValue > highest) {
	                highest = dealerValue;
	                winner = 4;
	                winningHand = DealerHand;
	            }
	            if(winningHand == playerHand) {
	            	bankChanges(bet);
	            }else {
	            	bankChanges((bet*-1));
	            }

	            // Output winner result
	            String winnerName = "";
	            if (winner == 0) {
	                winnerName = "Player";
	            } else if (winner == 1) {
	                winnerName = "CPU 1";
	            } else if (winner == 2) {
	                winnerName = "CPU 2";
	            } else if (winner == 3) {
	                winnerName = "CPU 3";
	            } else if (winner == 4) {
	                winnerName = "Dealer";
	            }

	            System.out.println(winnerName + " wins with a hand value of " + highest + "!");
	            
	            // Print the winning hand
	            if (winningHand != null) {
	                System.out.print(winnerName + "'s hand: ");
	                for (String card : winningHand) {
	                    System.out.print(card + " ");
	                }
	                System.out.println("your new bank balance is: " + bankChanges());
	            }

	            // Prompt to play another hand
	            System.out.println("Would you like to play another hand? y/n?");
	            String choice = kb.next();
	            if (choice.equalsIgnoreCase("y")) {
	                resetDeck();
	            } else {
	                System.exit(1);
	            }
	        }
	        }
	        }


	    }
	    public void aiTurns() {
	        boolean singleTurn = !playerStood; // If the player hasn't stood, AI only takes one action per call.

	        while (standings < 5) {
	            boolean actionTaken = false; // Track if any AI took an action this round

	            // CPU 1 Turn
	            if (!cpu1stood) {
	                int cpu1Value = getHandValue(cpu1Hand);
	                if (cpu1Value > 21) {
	                    System.out.println("cpu1 has bust");
	                    standings++;
	                    printHand(cpu1Hand, "cpu1");
	                    cpu1stood = true;
	                } else if (cpu1Value < 15) {
	                    if (currentCard < cards.length) {
	                        cpu1Hand.add(cards[currentCard]);
	                        System.out.println("cpu1 drew a " + cards[currentCard]);
	                        currentCard++;
	                    } else {
	                        System.out.println("Deck is empty!");
	                    }
	                } else {
	                    cpu1stood = true;
	                    System.out.println("cpu1 has stood");
	                    standings++;
	                }
	                actionTaken = true;
	            }

	            // CPU 2 Turn
	            if (!cpu2stood) {
	                int cpu2Value = getHandValue(cpu2Hand);
	                if (cpu2Value > 21) {
	                    System.out.println("cpu2 has bust");
	                    standings++;
	                    printHand(cpu2Hand, "cpu2");
	                    cpu2stood = true;
	                } else if (cpu2Value < 15) {
	                    if (currentCard < cards.length) {
	                        cpu2Hand.add(cards[currentCard]);
	                        System.out.println("cpu2 drew a " + cards[currentCard]);
	                        currentCard++;
	                    } else {
	                        System.out.println("Deck is empty!");
	                    }
	                } else {
	                    cpu2stood = true;
	                    System.out.println("cpu2 has stood");
	                    standings++;
	                }
	                actionTaken = true;
	            }

	            // CPU 3 Turn
	            if (!cpu3stood) {
	                int cpu3Value = getHandValue(cpu3Hand);
	                if (cpu3Value > 21) {
	                    System.out.println("cpu3 has bust");
	                    standings++;
	                    printHand(cpu3Hand, "cpu3");
	                    cpu3stood = true;
	                } else if (cpu3Value < 15) {
	                    if (currentCard < cards.length) {
	                        cpu3Hand.add(cards[currentCard]);
	                        System.out.println("cpu3 drew a " + cards[currentCard]);
	                        currentCard++;
	                    } else {
	                        System.out.println("Deck is empty!");
	                    }
	                } else {
	                    cpu3stood = true;
	                    System.out.println("cpu3 has stood");
	                    standings++;
	                }
	                actionTaken = true;
	            }

	            // Dealer Turn
	            if (!dealerstood) {
	                int dealerValue = getHandValue(DealerHand);
	                if (dealerValue > 21) {
	                    System.out.println("Dealer has bust");
	                    standings++;
	                    printHand(DealerHand, "Dealer");
	                    dealerstood = true;
	                } else if (dealerValue < 15) {
	                    if (currentCard < cards.length) {
	                        DealerHand.add(cards[currentCard]);
	                        System.out.println("Dealer drew a " + cards[currentCard]);
	                        currentCard++;
	                    } else {
	                        System.out.println("Deck is empty!");
	                    }
	                } else {
	                    dealerstood = true;
	                    System.out.println("Dealer has stood");
	                    standings++;
	                }
	                actionTaken = true;
	            }

	            // If the player hasn't stood, only allow a single AI move before returning to them.
	            if (singleTurn && actionTaken) {
	                Dealer(2);
	                return;
	            }

	            // If all players (including the dealer) are done, determine the winner.
	            if (standings >= 5) {
	                Dealer(9);
	                return;
	            }
	        }
	    }

	    private void printHand(List<String> hand, String playerName) {
	        System.out.print(playerName + " had: ");
	        for (int i = 0; i < hand.size(); i++) {
	            System.out.print(hand.get(i) + " ");
	        }
	        System.out.println("");
	    }
	    public void resetDeck(){
	    	turns = 0;
	  	  currentCard = 10;
	  	  standings = 0;
	  	  playerStood = false;
	  	  cpu1stood = false;
	  	  cpu2stood = false;
	  	  cpu3stood = false;
	  	  dealerstood = false;
	    	playerHand.clear();
	    	cpu1Hand.clear();
	    	cpu2Hand.clear();
	    	cpu3Hand.clear();
	    	DealerHand.clear();
	    	shuffle();
	    	playBJack();
	    		
	    	
	    }
	}

