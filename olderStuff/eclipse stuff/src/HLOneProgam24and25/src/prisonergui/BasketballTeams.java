package prisonergui;

import javax.swing.JOptionPane;

public class BasketballTeams {
	//class variables = instance variables
	private String city;
	//private = encapsulation
	private int championships;
	//constructor that receives arguments
	//constructor blue can only be seen by constructor
	public BasketballTeams(String city, int championships) {
		this.city = city;
		this.championships = championships;
	}
	public BasketballTeams() {
		setCity();
		setChampionships();
	}
	//private void can not be called by anything else
	//setter method
	private void setCity() {
		city = JOptionPane.showInputDialog("city?");
	}
	//JOptionPane only takes strings
	private void setChampionships() {
		championships = Integer.parseInt(JOptionPane.showInputDialog("Cp's"));
	}
	public String getCity(){
		return city;
	}
	public int getChampionships() {
		return championships;
	}
	
}
