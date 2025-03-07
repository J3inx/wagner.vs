package absenceThing;

public class Deck {
	//class variable
	private String [][] cards;
	private String [] values = {"ACE,2,3,4,5,6,7,8,9,10,JACK,QUEEN,KING"};
	private String [] suits = {/*spades*/"\u2660", /*hearts*/ "\u2661",/*diamonds*/ "\u2662",/*clubs*/ "\u2663"};//goes black then white
	//empty constructor
	public Deck() {
		cards = new String[52][2];
	}
	//constructor with argument
	public Deck(int x) {
		cards = new String[x][2];
	}
	public void setDeck() {
		cards = new String[52][4];
		for(int k = 0; k<4; k++) {
		for(int i = 0; i<values.length; i++){
		cards[k][i] = (suits[k] + values[i]+ suits[k]);	
		}
		}
		//fill deck with ace-king and the four suits
		for(int k = 0; k<4; k++) {
		for(int i = 0; i<values.length; i++){
		System.out.println(cards[k][i]);	
		}
		}
	}
}
