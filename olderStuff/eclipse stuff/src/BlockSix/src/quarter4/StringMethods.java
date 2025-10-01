package quarter4;

public class StringMethods {

	public static void main(String[] args) {
		String nba = "The Lakers used to be from";
		String place = " Minnesota";
		System.out.println(nba + place);
		System.out.println(nba.concat(place));
		System.out.println("NBA has: " + nba.length());
		System.out.println(7/4);
		for(int i = 0;i<place.length();i++)
		{
			System.out.println(place.charAt(i));
		}
		for(int l = 0; l< nba.length()+1; l++) {
			System.out.println(nba.substring(0,l));
		}
		for(int l = nba.length()-1; l>0; l+=-1) {
			System.out.println(nba.substring(0,l));
		}

	}
	
}
