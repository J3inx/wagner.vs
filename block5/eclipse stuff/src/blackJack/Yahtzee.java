package blackJack;

import java.util.Scanner;

public class Yahtzee {
	Scanner kb = new Scanner(System.in);
	public int [] Pdice = {0, 0, 0, 0, 0,0 };
	public int score = 0;
	public int [] PdiceKeeper = {0,0,0,0,0};
	public int [] PTWOdice = {0, 0, 0, 0, 0 };
	public int rollCount = 1;
	
	public void play() throws InterruptedException{
		for(int p = 0; p<15; p++) {
			System.out.println("");
		}
		
		for(int p = 0; p<10; p++) {
			System.out.println("");
		}
		for(int x = 0; x< 5; x++) {					
		for(int i = 0; i<Pdice.length-1; i++) {
			Pdice[i] = (int)(Math.random()*6)+1;
			System.out.print(getDice(Pdice[i]) + " ");
		}
		
		for(int p = 0; p<5; p++) {
			System.out.println("");
		}
		Thread.sleep(500); // Just to give the user a chance to see "hello".
		

    
	}
		int count = 0;
		for(int i = 0; i<Pdice.length-1; i++) {
			if(Pdice[i] == 6) {
				count ++;
			}
		}
		if(count == 5) {
			yahtzee();
		}else {
		continues();
	}
	}

	private void yahtzee() {
		// TODO Auto-generated method stub
		System.out.println("you got yahtzee! +30 points!");
		score+=30;
	}

	private void continues() throws InterruptedException {
		// TODO Auto-generated method stub
		
		int x = 0;
		System.out.println("do you want to keep a dice, roll or finish the round? 1-3");
		int chooser = kb.nextInt();
		if( chooser == 1) {
			x=1;
			while(x==1) {
			
			
		System.out.println("are there any dice you want to keep 1-6? else type 7");
		int choice = kb.nextInt();
		if(choice <=6) {
		PdiceKeeper[choice-1] = 1;
			
		}
			else{
				x = 2;
				continues();
			}
			}
	
	}else if(chooser ==2) {
		Proll();
	}else {
		rounder();
	}
}

	private void rounder() {
		// TODO Auto-generated method stub
		for(int p = 0; p<10; p++) {
			System.out.println("");
		}
		System.out.println("what dice number do you want to start counting for? 1-6");
		int dicer = kb.nextInt()-1;
		int count = 0;
		for(int i =0; i<Pdice.length-1; i++) {
			if(Pdice[i] == Pdice[dicer]) {
			count++;
			}
		}
		System.out.println("current score for " + Pdice[dicer] + "'s is " + (Pdice[dicer]*count));
		score += Pdice[dicer]*count;
		System.out.println("total score is " + score);
		
	}

	public void Proll() throws InterruptedException {
		// TODO Auto-generated method stub
		
		if(rollCount <3) {
			
		for(int p = 0; p<15; p++) {
			System.out.println("");
		}
		
		for(int p = 0; p<10; p++) {
			System.out.println("");
		}
		for(int x = 0; x< 5; x++) {					
		for(int i = 0; i<Pdice.length-1; i++) {
			if(PdiceKeeper[i] == 1) {
				System.out.print(getDice(Pdice[i]) + " ");
			}else {
			Pdice[i] = (int)(Math.random()*6)+1;
			System.out.print(getDice(Pdice[i]) + " ");
		}
		}
		
		for(int p = 0; p<5; p++) {
			System.out.println("");
		}
		Thread.sleep(500); // Just to give the user a chance to see "hello".
		

    
	}
		rollCount++;
		continues();
	}else {
		System.out.println("you cant roll anymore, end your turn");
		continues();
	}
	}
	

	private String getDice(int i) {
		// TODO Auto-generated method stub
		if(i == 1) {
			return("⚀");
		}else {
			if(i ==2) {
				return("⚁");
			}else {
				if(i ==3) {
					return("⚂");
				}else {
					if( i ==4) {
						return("⚃");
					}else {
						if(i == 5) {
							return("⚄");
						}else {
							if( i == 6) {
								return("⚅");
							}
						}
					}
				}
			}
		}
		return null;
	}
}
	
	