package blackJack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pokey {
	 private String[] cards; // Now a 1D array
	    private String[] values = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};
	    private String[] actValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
	    private String[] suits = {"\u2660", "\u2661", "\u2662", "\u2663"}; // Spades, Hearts, Diamonds, Clubs	   
	    public int bankStatus = 100;
	    public int bet;
	    public int turns = 0;
	    public int playerCurrentCard = 0;
	    public int oldPlayerCard = 0;
	    public int dealerCurrentCard = 2;
	    public int oldDealerCard = 0;
	    public int standings = 0;
	    public int revolve = 0;
	    public int Drevolve = 0;
	    public int Srevolve = 0;
	    public ArrayList <String> playerHand = new ArrayList<String>();
	    public ArrayList <String> dealerHand = new ArrayList<String>();
	    public Boolean playerFolded = false;
	    private Scanner kb = new Scanner(System.in);
	    private Map<String, Integer> cardValues = new HashMap<>();
	    public String playerCard1T = null;
		public String playerCard2T = null;
		public String playerCard3T = null;
		public int playerCard1 = 0;
		public int playerCard2 = 0;
		public int playerCard3 = 0;
		public String playerCard1s = null;
		public String playerCard2s = null;
		public String playerCard3s = null;
		public String pFlush = null;
		public String dFlush = null;
		public String pStraight = null;
		public String dStraight = null;
		public String pThreek = null;
		public String dThreek = null;
		public String dealerCard1s = null;
		public String dealerCard2s = null;
		public String dealerCard3s = null;

	public Pokey(int x) {
		cards = new String[x];
		setDeck();
		shuffle();
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

   
    public void shuffle() {
    	int x = 5;
    	
    	
    	
    	
    	
    	
    	

    		while(x > 0) {
    	       for (int i = 0; i < cards.length - 1; i++) {
    	            int j = (int) (Math.random() * 51)+1;
    	            String temp = cards[i];
    	            cards[i] = cards[j];
    	            cards[j] = temp;
    	        }
    	        Srevolve = 0;
    	        x+= -1;
    		}
    	}
    
    public void playPoker() {
    	playerChoices();
    	continueChoice();
    }
    
    public void playerChoices() {
    	while(playerCurrentCard < oldPlayerCard + 9 ) {
    		playerHand.add(cards[playerCurrentCard]);
    		if(playerCurrentCard <=49) {
    		playerCurrentCard +=3;
    		}else {
    			if(revolve == 0) {
    				playerCurrentCard = 1;
    				revolve = 1;
    			}else {
    				playerCurrentCard = 0;
    				revolve = 0;
    			}
    		}
    		}
    	System.out.println("your current hand is:");
    	oldPlayerCard = playerCurrentCard;
    	for(int i = 0; i<playerHand.size(); i++) {
    		System.out.println(playerHand.get(i));
    	}
    	}

	public void continueChoice() {
		System.out.println("do you want to play or fold?");
		String choice = kb.next();
		if(choice.contains("p")) {
			dealerChoices(true);
		}else {
			reset(1);
			reset(2);
			dealerChoices(false);
		}
	}
	
	public void dealerChoices(boolean playing) {
		while(dealerCurrentCard < oldDealerCard + 9 ) {
    		dealerHand.add(cards[dealerCurrentCard]);
    		if(dealerCurrentCard <=49) {
    		dealerCurrentCard +=3;
    		}else {
    			if(Drevolve == 0) {
    				dealerCurrentCard = 1;
    				Drevolve = 1;
    			}else {
    				shuffle();
    				dealerCurrentCard = 0;
    				Drevolve = 0;
    			}
    		}
    		}
		if(playing) {
			playerCard1T = playerHand.get(0);
			playerCard2T = playerHand.get(1);
			playerCard3T = playerHand.get(2);
			playerCard1 = 0;
			playerCard2 = 0;
			playerCard3 = 0;
			playerCard1s = null;
			playerCard2s = null;
			playerCard3s = null;
			if(playerCard1T.contains("\u2660")) {
				playerCard1s = "spades";
			}
			if(playerCard1T.contains("\u2661")) {
				playerCard1s = "hearts";
			}
			if(playerCard1T.contains("\u2662")) {
				playerCard1s = "diamonds";
			}
			if(playerCard1T.contains("\u2663")) {
				playerCard1s = "clubs";
			}
			if(playerCard2T.contains("\u2660")) {
				playerCard2s = "spades";
			}
			if(playerCard2T.contains("\u2661")) {
				playerCard2s = "hearts";
			}
			if(playerCard2T.contains("\u2662")) {
				playerCard2s = "diamonds";
			}
			if(playerCard2T.contains("\u2663")) {
				playerCard2s = "clubs";
			}
			if(playerCard3T.contains("\u2660")) {
				playerCard3s = "spades";
			}
			if(playerCard3T.contains("\u2661")) {
				playerCard3s = "hearts";
			}
			if(playerCard3T.contains("\u2662")) {
				playerCard3s = "diamonds";
			}
			if(playerCard3T.contains("\u2663")) {
				playerCard3s = "clubs";
			}
			
			if(playerCard1T.contains("K")|| playerCard1T.contains("J")||  playerCard1T.contains("Q") || playerCard1T.contains("A")) {
				playerCard1 = 11;
				System.out.println("card 1 is a face");
				if(playerCard1T.charAt(0) == 'A') {
					playerCard1 = 12;
					System.out.println("card 1 is an ace");
				}
			}else {
				System.out.println(playerCard1T.substring(0,playerCard1T.length()-1));
				playerCard1 = Integer.parseInt(playerCard1T.substring(0,playerCard1T.length()-1));
			}
			if(playerCard2T.contains("K")|| playerCard2T.contains("J")|| playerCard2T.contains("Q") || playerCard2T.contains("A")) {
				playerCard2 = 11;
				System.out.println("card 2 is a face");
				if(playerCard2T.charAt(0) == 'A') {
					playerCard2 = 12;
					System.out.println("card 2 is an ace");
				}
			}else {
				System.out.println(playerCard2T.substring(0,playerCard2T.length()-1));
				playerCard2 = Integer.parseInt(playerCard2T.substring(0,playerCard2T.length()-1));
			}
			if(playerCard3T.contains("K")|| playerCard3T.contains("J")|| playerCard3T.contains("Q")|| playerCard3T.contains("A")) {
				playerCard3 = 11;
				System.out.println("card 3 is a face");
				if(playerCard3T.charAt(0) == 'A') {
					playerCard3 = 12;
					System.out.println("card 3 is an ace");
				}
			}else {
				System.out.println(playerCard3T.substring(0,playerCard3T.length()-1));
				playerCard3 = Integer.parseInt(playerCard3T.substring(0,playerCard3T.length()-1));
			}
		//System.out.println(playerCard1);
		//System.out.println(playerCard2);
		//System.out.println(playerCard3);
			System.out.println("");
			System.out.println("dealers cards: ");
		results(playerCard1T, playerCard1s, playerCard2T, playerCard2s, playerCard3T, playerCard3s);
		}else {
			
			System.out.println("the dealer had:");
			for(int i = 0; i<dealerHand.size();i++) {
				System.out.println(dealerHand.get(i));
			}
			reset(2);
		}
	}
	public void results(String firstcard,String firstCards, String secondCard, String secondCards, String thirdCard, String thirdCards) {
		String dealerCard1T = dealerHand.get(0);
		String dealerCard2T = dealerHand.get(1);
		String dealerCard3T = dealerHand.get(2);
		int dealerCard1 = 0;
		int dealerCard2 = 0;
		int dealerCard3 = 0;

		if(dealerCard1T.contains("\u2660")) {
			dealerCard1s = "spades";
		}
		if(dealerCard1T.contains("\u2661")) {
			dealerCard1s = "hearts";
		}
		if(dealerCard1T.contains("\u2662")) {
			dealerCard1s = "diamonds";
		}
		if(dealerCard1T.contains("\u2663")) {
			dealerCard1s = "clubs";
		}
		if(dealerCard2T.contains("\u2660")) {
			dealerCard2s = "spades";
		}
		if(dealerCard2T.contains("\u2661")) {
			dealerCard2s = "hearts";
		}
		if(dealerCard2T.contains("\u2662")) {
			dealerCard2s = "diamonds";
		}
		if(dealerCard2T.contains("\u2663")) {
			dealerCard2s = "clubs";
		}
		if(dealerCard3T.contains("\u2660")) {
			dealerCard3s = "spades";
		}
		if(dealerCard3T.contains("\u2661")) {
			dealerCard3s = "hearts";
		}
		if(dealerCard3T.contains("\u2662")) {
			dealerCard3s = "diamonds";
		}
		if(dealerCard3T.contains("\u2663")) {
			dealerCard3s = "clubs";
		}
		//System.out.println(dealerHand.get(0));
		//System.out.println(dealerCard1T);
		if(dealerCard1T.contains("K")|| dealerCard1T.contains("J")|| dealerCard1T.contains("Q") || dealerCard1T.contains("A")) {
			if(dealerCard1T.charAt(0) == 'A') {
				dealerCard1 = 12;
				System.out.println("card 1 is an ace");
			}else {
			dealerCard1 = 11;
			System.out.println("card 1 is a face");
		}
		}else {
			System.out.println(dealerCard1T.substring(0,dealerCard1T.length()-1));
			dealerCard1 = Integer.parseInt(dealerCard1T.substring(0,dealerCard1T.length()-1));
		}
		if(dealerCard2T.contains("K")|| dealerCard2T.contains("J")|| dealerCard2T.contains("Q") || dealerCard2T.contains("A")) {
			if(dealerCard2T.charAt(0) == 'A') {
				dealerCard2 = 12;
				System.out.println("card 2 is an ace");
			}else {
			dealerCard2 = 11;
			System.out.println("card 2 is a face");
		}
		}else {
			System.out.println(dealerCard2T.substring(0,dealerCard2T.length()-1));
			dealerCard2 = Integer.parseInt(dealerCard2T.substring(0,dealerCard2T.length()-1));
		}
		if(dealerCard3T.contains("K")|| dealerCard3T.contains("J")|| dealerCard3T.contains("Q") || dealerCard3T.contains("A")) {
			if(dealerCard3T.charAt(0) == 'A') {
				dealerCard3 = 12;
				System.out.println("card 3 is an ace");
			}else {
			dealerCard3 = 11;
			System.out.println("card 3 is a face");
		}
			
		}else {
			System.out.println(dealerCard3T.substring(0,dealerCard3T.length()-1));
			dealerCard3 = Integer.parseInt(dealerCard3T.substring(0,dealerCard3T.length()-1));
		}
		boolean elligible = false;
		if(playerCard1T.contains("Q")||playerCard1T.contains("k")) {
			elligible = true;
		}
		if(playerCard2T.contains("Q")||playerCard2T.contains("k")) {
			elligible = true;
		}
		if(playerCard3T.contains("Q")||playerCard3T.contains("k")) {
			elligible = true;
		}
		if(elligible = true) {
			straight(playerCard1T.substring(0, playerCard1T.length()-1),playerCard2T.substring(0,playerCard2T.length()-1),playerCard3T.substring(0,playerCard3T.length()-1));
			straight(dealerCard1T.substring(0,dealerCard1T.length()-1),dealerCard2T.substring(0,dealerCard2T.length()-1),dealerCard3T.substring(0,dealerCard3T.length()-1));
			flush(playerCard1T.substring(0,playerCard1T.length()-1),playerCard2T.substring(0,playerCard2T.length()-1),playerCard3T.substring(0,playerCard3T.length()-1), true);
			flush(dealerCard1T.substring(0,dealerCard1T.length()-1),dealerCard2T.substring(0,dealerCard2T.length()-1),dealerCard3T.substring(0,dealerCard3T.length()-1), false);
			twoOfAKind(playerCard1T.substring(0,playerCard1T.length()-1),playerCard2T.substring(0,playerCard2T.length()-1),playerCard3T.substring(0,playerCard3T.length()-1));
			twoOfAKind(dealerCard1T.substring(0,dealerCard1T.length()-1),dealerCard2T.substring(0,dealerCard2T.length()-1),dealerCard3T.substring(0,dealerCard3T.length()-1));
			//HighCard(playerCard1T.substring(0,playerCard1T.length()-1),playerCard2T.substring(0,playerCard1T.length()-1),playerCard3T.substring(0,playerCard1T.length()-1));
			//HighCard(dealerCard1T.substring(0,playerCard1T.length()-1),dealerCard2T.substring(0,playerCard1T.length()-1),dealerCard3T.substring(0,playerCard1T.length()-1));
			
			// then do the comparisons and reset
			
			reset(1);
			reset(2);
		}else {
			System.out.println("dealer was not elligible to play");
		reset(1);
		reset(2);
		}
	}
	private void HighCard(String dealerCard1T, String dealerCard2T, String dealerCard3T) {
		// TODO Auto-generated method stub
		
	}
	private void twoOfAKind(String Card1T2, String Card2T2, String Card3T2) {
		// TODO Auto-generated method stub
		int count = 0;
		if(Card1T2.contains("A") || Card1T2.contains("K") || Card1T2.contains("Q") || Card1T2.contains("J") || Card2T2.contains("A") || Card2T2.contains("K") || Card2T2.contains("Q") || Card2T2.contains("J") || Card3T2.contains("A") || Card3T2.contains("K") || Card3T2.contains("Q") || Card3T2.contains("J")) {
			//face card version
			if(Card1T2.contains("A") || Card1T2.contains("K") || Card1T2.contains("Q") || Card1T2.contains("J")) {
				Card1T2 = "11";
			}
			if(Card2T2.contains("A") || Card2T2.contains("K") || Card2T2.contains("Q") || Card2T2.contains("J")) {
				Card2T2 = "11";
			}
			if(Card3T2.contains("A") || Card3T2.contains("K") || Card3T2.contains("Q") || Card3T2.contains("J")) {
				Card3T2 = "11";
			}
			System.out.println("faced");
			twoOfAKind(Card1T2, Card2T2, Card3T2);
			
		}else {
			if(Card1T2.equals(Card2T2)) {
				count++;
				System.out.println(count);
			}
			if(Card2T2.equals(Card3T2)) {
				count++;
				System.out.println(count);
			}
			if(Card1T2.equals(Card3T2)) {
				count++;
				System.out.println(count);
			}
			if(count >=2) {
				System.out.println("3 of a kind!");
			}else if(count == 1){
				System.out.println("2 of a kind!");
			}else{
				System.out.println("no kind relation");
			}
				

		}
	}
	
	private void flush(String Card1T2, String Card2T2, String Card3T2, boolean player) {
		// TODO Auto-generated method stub
		if(player == true) {
			if(playerCard1s.equals(playerCard2s)&& playerCard2s.equals(playerCard3s) && playerCard3s.equals(playerCard1s)) {
			System.out.println("flush");
		}else {
			System.out.println("not flush");
		}
		}else {
			if(dealerCard1s.equals(dealerCard2s)&& dealerCard2s.equals(dealerCard3s) && dealerCard3s.equals(dealerCard1s)) {
				System.out.println("flush");
			}else {
				System.out.println("not flush");
			}	
		}

		
	}
	private String straight(String Card1T2, String Card2T2, String Card3T2) {
		
		if(Card1T2.contains("A") || Card1T2.contains("K") || Card1T2.contains("Q") || Card1T2.contains("J") || Card2T2.contains("A") || Card2T2.contains("K") || Card2T2.contains("Q") || Card2T2.contains("J") || Card3T2.contains("A") || Card3T2.contains("K") || Card3T2.contains("Q") || Card3T2.contains("J")) {
			//face card version
			if(Card1T2.contains("A") || Card1T2.contains("K") || Card1T2.contains("Q") || Card1T2.contains("J")) {
				Card1T2 = "11";
			}
			if(Card2T2.contains("A") || Card2T2.contains("K") || Card2T2.contains("Q") || Card2T2.contains("J")) {
				Card2T2 = "11";
			}
			if(Card3T2.contains("A") || Card3T2.contains("K") || Card3T2.contains("Q") || Card3T2.contains("J")) {
				Card3T2 = "11";
			}
			System.out.println("faced");
			straight(Card1T2, Card2T2, Card3T2);
			
		}else {
			
			String highest = null;
			String middle = null;
			String low = null;
			highest = Card1T2;
			if(Integer.parseInt(Card1T2)< Integer.parseInt(Card2T2)) {
				middle = Card1T2;
			}else {
				middle = Card2T2;
			}
			if(Integer.parseInt(Card3T2) > Integer.parseInt(middle)) {
				if(Integer.parseInt(Card3T2)>Integer.parseInt(highest)) {
					low = middle;
					middle = highest;
					highest = Card3T2;
				}else {
					low = middle;
					middle = Card3T2;
				}
				
			}else {
				low = Card3T2;
			}
			if(Integer.parseInt(low) +1 == Integer.parseInt(middle) && Integer.parseInt(middle)+1 == Integer.parseInt(highest)) {
				System.out.print("straight");
				//flush(Card1T2, Card2T2, Card3T2, true);
				return("straight");
			}else {
				System.out.println("not straight");
				return("not straight");
			}
		}
		return("not Straight");
	}
	private void threeOfAKind(String Card1T2, String Card2T2, String card3T2) {
		// TODO Auto-generated method stub
		
	}
	private void straightFlush(String Card1T2, String Card2T2, String Card3T2) {
		// TODO Auto-generated method stub

	}
	public void reset(int x) {
		if(x == 1) {
			playerHand.clear();
			oldPlayerCard = 0;
			playerCurrentCard = 0;
			dealerCurrentCard = 0;
			oldDealerCard = 0;
			revolve = 0;
			Drevolve = 0;
			playerCard1T = null;
			playerCard2T = null;
			playerCard3T = null;
			playerCard1 = 0;
			playerCard2 = 0;
			playerCard3 = 0;
			playerCard1s = null;
			playerCard2s = null;
			playerCard3s = null;
			shuffle();
			
		}
		if(x == 2) {
			dealerHand.clear();
		}
	}
}

