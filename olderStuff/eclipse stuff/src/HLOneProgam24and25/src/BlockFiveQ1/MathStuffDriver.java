package BlockFiveQ1;

import java.util.Scanner;

public class MathStuffDriver {
	static Scanner kb = new Scanner(System.in);
	static MathStuff obj = new MathStuff();
	static String choice ="y";
	static boolean list = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		while(list = true) {
			printOutList();
			int ch = kb.nextInt();
			if(ch == 1) {
				list = false;
				System.out.println("have a nice day and smile");
			}else {
				if(ch == 2) {
					System.out.println(obj.question1());
				}else {
					if(ch == 3) {
						System.out.println(obj.program1());
					}else {
						if(ch == 4) {
							System.out.println(obj.program2());
						}else {
							if(ch == 5) {
								System.out.println(obj.program3());
							}else {
								if(ch ==6) {
									System.out.println(obj.program4());
								}
							}
						}
						
					}
				}
			}
			System.out.println("would you like to run another program? \tY/N");
			choice = kb.next();
			if(choice.equalsIgnoreCase("n")) {				
				System.out.println("have a nice day and smile");
				break;
			}
			}
			
		}
	
	public static void printOutList() {
		System.out.println("weclome to the math machine");
		System.out.println("please select a number");
		System.out.println("\tselect 1 to exit");
		System.out.println("\tselect 2 to print my favorite number");
		System.out.println("\tselect 3 to run progam 1");
		System.out.println("\tselect 4 to run progam 2");
		System.out.println("\tselect 5 to run progam 3");
		System.out.println("\tselect 6 to run program 4");
	}

}
