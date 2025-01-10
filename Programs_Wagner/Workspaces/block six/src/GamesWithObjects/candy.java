package GamesWithObjects;

public class candy {
	public int sugar;
	public candy() {
		this.sugar = (int)(Math.random()*45);
		
	}
	public String toString() {
		return "SUGAR: " + sugar;
	}
}
