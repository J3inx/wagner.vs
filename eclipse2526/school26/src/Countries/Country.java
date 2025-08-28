package Countries;

public class Country {
	int offense;
	int deffense;
	String Name;
	int lifeCounter;
	
	
	public Country(String name) {
		offense = (int)(Math.random()*99+1);
		deffense = (offense-100)*-1;
		Name = name;
		lifeCounter = 1000;
		if(name.equalsIgnoreCase("usa") || name.equalsIgnoreCase("england")){
			offense = offense * 2;
		}else {
			deffense = deffense *2;
		}
	}
	
	public int getOffense(){
		return offense;
	}


	public int getDefense() {
		return deffense;
	}


	public void setLifeCounter(int loss) {
		if(loss > 0) {
		lifeCounter = lifeCounter - loss;
		if(lifeCounter < 500) {
			if(Math.random() < 0.25) {
				lifeCounter+=100;
				System.out.println(Name + " healed itself for 100");
			}
		}
		}else {
			System.out.println(Name + " took no damage");
		}
	}


	public int getLifeCounter() {
		return lifeCounter;
	}
	
	public String toString() {
		return(Name + ": " + "offense: " + offense + " deffense: " + deffense + " life: " + lifeCounter);
	}

}
