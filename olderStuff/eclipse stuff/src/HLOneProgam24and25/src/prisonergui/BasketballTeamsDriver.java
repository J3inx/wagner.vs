package prisonergui;

import java.util.ArrayList;

public class BasketballTeamsDriver {

	public static void main(String[] args) {
		ArrayList <BasketballTeams> teams = new ArrayList< >();
		teams.add(new BasketballTeams());
		teams.add(new BasketballTeams());
		teams.add(new BasketballTeams("NOVA",17));
		for(int k = 0; k<teams.size(); k++) {
			teams.get(k).getCity();
			System.out.println(teams.get(k).getCity());
		}

	}

}
