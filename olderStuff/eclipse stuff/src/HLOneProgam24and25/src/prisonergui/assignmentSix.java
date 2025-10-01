package prisonergui;

import javax.swing.JOptionPane;

public class assignmentSix{
	private int hp;
	private String carName;
	private boolean cool;

	public assignmentSix( String carName, int hp, boolean cool) {
		this.hp = hp;
		this.carName = carName;
		this.cool = cool;
	}	
	public assignmentSix() {
		setName();
		setHP();
		
		setCool();
	}
	private void setHP() {
		hp = Integer.parseInt(JOptionPane.showInputDialog("horsepower?"));
	}
	private void setName() {
		carName = JOptionPane.showInputDialog("name of car?");
	}
	private void setCool() {
		cool = Boolean.valueOf(JOptionPane.showInputDialog("cool or not? true/false"));
		
	}
	public int getHP() {
		return hp;
		
	}
	public String getName() {
		return carName;
	}
	public boolean getCool() {
		return cool;
	}
}
