package Notes;

public class Runner {
	//this is the blueprint for the object of a runner
	private double stamina;
	private int speed;
	private String team;
	//methods: constructor
	public Runner() {
		stamina = Math.random()*100;
		speed = (int)(Math.random()*15+1);
		team = "Meridian High School";
	}
	public String toString() {
		return("TEAM: " + team + "\nSPEED: " + speed + "\nSTAMINA: " + stamina);
	}
}
