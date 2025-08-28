package Countries;

public class CountriesDriver {
	public static void main(String [] args) {
		Country england = new Country("england");
		Country france = new Country("france");
		Country bulgaria = new Country("bulgaria");
		Country usa = new Country("usa");
		double turn = Math.random();
		double choice = Math.random();
		int attack = 0;
		while(england.getLifeCounter()> 0 && france.getLifeCounter() > 0 && usa.getLifeCounter() > 0 && bulgaria.getLifeCounter() > 0) {
			if( turn < 0.25) {
				if(england.getLifeCounter() > 0) {
				//england goes first
				choice = Math.random();
				attack = (int)(Math.random()*england.getOffense()-1)+1;
				
				System.out.println("england's turn");
				if( choice < 0.25) {
					System.out.println("england attacks france");
					attack = attack - (int)(Math.random()*france.getDefense()-1)+1;
					france.setLifeCounter(attack);
				}else if (choice < 0.5) {
					System.out.println("england attacks bulgaria");
					attack = attack - (int)(Math.random()*bulgaria.getDefense()-1)+1;
					bulgaria.setLifeCounter(attack);
				}else  {
					System.out.println("england attacks usa");
					attack = attack - (int)(Math.random()*usa.getDefense()-1)+1;
					usa.setLifeCounter(attack);	
				}
				
				
				System.out.println(england.toString());
				System.out.println(usa.toString());
				System.out.println(bulgaria.toString());
				System.out.println(france.toString() + "\n");
				turn = Math.random();
				}
			}else if (turn < 0.5) {
				//france goes
				if(france.getLifeCounter() > 0) {
				choice = Math.random();
				attack = (int)(Math.random()*france.getOffense()-1)+1;
				System.out.println("france's turn");
				if( choice < 0.25) {
					System.out.println("france attacks england");
					attack = attack - (int)(Math.random()*england.getDefense()-1)+1;
					england.setLifeCounter(attack);
				}else if (choice < 0.5) {
					System.out.println("france attacks bulgaria");
					attack = attack - (int)(Math.random()*bulgaria.getDefense()-1)+1;
					bulgaria.setLifeCounter(attack);
				}else {
					System.out.println("france attacks usa");
					attack = attack - (int)(Math.random()*usa.getDefense()-1)+1;
					usa.setLifeCounter(attack);	
				}
				
				turn = Math.random();
				System.out.println(england.toString());
				System.out.println(usa.toString());
				System.out.println(bulgaria.toString());
				System.out.println(france.toString() + "\n");
				}
			}else if(turn < 0.75) {
				//usa turn
				if(usa.getLifeCounter() > 0) {
					
					attack = (int)(Math.random()*usa.getOffense()-1)+1;
				choice = Math.random();
				System.out.println("usa's turn");
				if( choice < 0.25) {
					System.out.println("usa attacks france");
					attack = attack - (int)(Math.random()*france.getDefense()-1)+1;
					france.setLifeCounter(attack);
				}else if (choice < 0.5) {
					System.out.println("usa attacks bulgaria");
					attack = attack - (int)(Math.random()*bulgaria.getDefense()-1)+1;
					bulgaria.setLifeCounter(attack);
				}else  {
					System.out.println("usa attacks england");
					attack = attack - (int)(Math.random()*england.getDefense()-1)+1;
					england.setLifeCounter(attack);	
				}
				
				turn = Math.random();
				System.out.println(england.toString());
				System.out.println(usa.toString());
				System.out.println(bulgaria.toString());
				System.out.println(france.toString() + "\n");
				}
			}else {
				if(bulgaria.getLifeCounter() > 0) {
					attack = (int)(Math.random()*bulgaria.getOffense()-1)+1;
				choice = Math.random();
				System.out.println("bulgaria's turn");
				if( choice < 0.25) {
					System.out.println("bulgaria attacks france");
					attack = attack - (int)(Math.random()*france.getDefense()-1)+1;
					france.setLifeCounter(attack);
				}else if (choice < 0.5) {
					System.out.println("bulgaria attacks england");
					attack = attack - (int)(Math.random()*england.getDefense()-1)+1;
					england.setLifeCounter(attack);
				}else {
					System.out.println("bulgaria attacks usa");
					attack = attack - (int)(Math.random()*usa.getDefense()-1)+1;
					usa.setLifeCounter(attack);	
				}
				
				turn = Math.random();
				System.out.println(england.toString());
				System.out.println(usa.toString());
				System.out.println(bulgaria.toString());
				System.out.println(france.toString() + "\n");
				}
			}
		}
		if(usa.getLifeCounter() > 0) {
			System.out.println("\n usa won");
		} else if(bulgaria.getLifeCounter() > 0) {
			System.out.println("\n bulgaria won");
		} else if(england.getLifeCounter() > 0) {
			System.out.println("\n england won");
		}else if(france.getLifeCounter() > 0) {
			System.out.println("\n france won");
		}
	}
}
