package TwoDArrays;

import java.util.Scanner;

public class TheaterSeating {
	static String [][] seats = new String [10][5];
	static String [][] prices = new String [10][5];
//two brackets means two dimensions arrays
	 public static void main(String[] args) {
		 	setup();
		 	String input = "";
	        Scanner kb = new Scanner(System.in);
	        int turn = 5;
	        while (true) {

	            int row = 0, col = 0;
	            printseats();
	            if (turn >= 1) {
	                System.out.println("What seat would you like? [100-149]");
	                int choice = kb.nextInt();
	                for (row = 0; row < 10; row++) {
	                    for (col = 0; col < 5; col++) {
	                        if (seats[row][col].contains(Integer.toString(choice))) {
                                if (seats[row][col].contains("x")) 
                                { // Check if the seat is not already taken
                               
                                	System.out.println("That seat is already taken. Please choose another seat.");
                                } else 
                                {
                                	System.out.println("Would you like this seat? It is: " + prices[row][col] + "?");
    	                            input = kb.next(); 
                                  
                                
                                }
	                            
	                            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) 
	                            {

	                                if (seats[row][col].contains("x")) 
	                                { // Check if the seat is not already taken
	                               
	                                	
	                                } else 
	                                {
	                                    
	                                    System.out.println("Seat " + choice + " has been reserved.");
	                                    seats[row][col] += ":x";
	                                
	                                }

	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public static void setup() {
	        int price = 900;
	        int num = 100;
	        for (int prow = 0; prow < 10; prow++) {
	            for (int pcol = 0; pcol < 5; pcol++) {
	                prices[prow][pcol] = Integer.toString(price);
	            }
	            price -= 75; // Decrease the price
	        }
	        System.out.println("**********************************STAGE**********************************");
	        for (int row = 0; row < 10; row++) {
	            for (int col = 0; col < 5; col++) {
	                seats[row][col] = Integer.toString(num);
	                System.out.print(seats[row][col] + "\t");
	                num++;
	            }
	            System.out.println("");
	        }
	    }
	    public static void printseats() {
		        System.out.println("**********************************STAGE**********************************");
		        for (int row = 0; row < 10; row++) {
		            for (int col = 0; col < 5; col++) {
		                System.out.print(seats[row][col] + "\t");
		               
		            }
		            System.out.println("");
		        }
	    }
	}

