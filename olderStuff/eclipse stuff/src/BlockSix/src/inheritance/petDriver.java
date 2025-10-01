package inheritance;

public class petDriver 
{
	public static void main(String [] args) {
		pet eve = new pet("Mr. Snyder", 10000, false);
		System.out.println(eve);
		pet grayson = new pet("Loafy", 3, true);
		System.out.println(grayson);
		//complication
		pet nick = new pet();
		System.out.println(nick);
		//inheritance
		snappingTurtle paul = new snappingTurtle("Crush", 4, true, .314159);
		System.out.println(paul);
	}
}
