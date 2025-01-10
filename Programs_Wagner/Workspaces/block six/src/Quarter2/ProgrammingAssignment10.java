package Quarter2;

import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

@SuppressWarnings("unused")
public class ProgrammingAssignment10 {
	@SuppressWarnings("resource")
	static 	Scanner kb = new Scanner(System.in);
	public static void main(String [] args)
	{

		String result = "yes";
		while(result.equalsIgnoreCase("yes") || result.equalsIgnoreCase("y")) {
			System.out.println("***************************");
			System.out.println("1. min max");
			System.out.println("***************************");
			System.out.println("2. double min max");
			System.out.println("***************************");
			System.out.println("3. apple to pear");
			System.out.println("***************************");
			System.out.println("4. coin flip");
			System.out.println("***************************");
			System.out.println("5. quiz score");
			System.out.println("***************************");
			System.out.println("6. gymnast score");
			System.out.println("***************************");
			System.out.println("what would you like to do");
			System.out.println("***************************");
			int choice = kb.nextInt();
			if(choice == 1) {
				minMax();
			}
			if(choice == 2) {
				doubleMinMax();
			}
			if(choice == 3) {
				pearApple();
			}
			if(choice == 4) {
				coinFlip();
			}
			if(choice ==5) {
				quizScore();
			}
			if(choice ==6) {
				gymnastScore();
			}
			System.out.println("Run again?");
			result = kb.next();
		}
		System.out.println("have a good day");
	}
	public static void minMax(){	
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter the size of the array:");
		int u = kb.nextInt();
		int max = 0;
		int min = 100;
		int [ ] tempo = new int [u];
		for(int k =0; k<tempo.length; k++) {
			tempo[k] = (int)(Math.random()*52+23);
			System.out.println(k+1 + ": " + tempo[k]);
			if(tempo[k]>max) {
				max = tempo[k];
			}
			if(tempo[k]<min) {
				min = tempo[k];
			}
		}
		System.out.println(max + " is the largest in the array and " + min + " is the smallest in the array");
		kb.close();
		
	}
	public static void doubleMinMax() {
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter the size of the array:");
		int u = kb.nextInt();
		int f = 0;
		int h = 0;
		double [ ] tempo = new double [u];
		tempo[0]=(Math.random()*200+1);
		System.out.println(1 + ": " + tempo[0]);
		double max = tempo[0];
		double min = tempo[0];
		for(int k =1; k<tempo.length; k++) {
			tempo[k] = (Math.random()*200+1);
			System.out.println(k+1 + ": " + tempo[k]);
			if(tempo[k]>max) {
				max = tempo[k];
				h=k;
			}
			if(tempo[k]<min) {
				min = tempo[k];
				f = k;
			}
		}
		System.out.println("the largest element is in spot " + h + " and the smallest is in spot " + f);
	}
	public static void pearApple() {
		@SuppressWarnings("unused")
		int counter = 0;
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("how big do you want your array to be?");
		int a = kb.nextInt();
		String [] words = new String [a];
		for(int k = 0; k< words.length; k++ ) {
			System.out.println("please enter the word you want for position " + (k+1) + " in the array:");
			words[k] = kb.next();
		}
		for(int L = 0; L<words.length; L++) {
			if(words[L].equalsIgnoreCase("apple")) {
				System.out.print("pear ");
			}else {
			System.out.print(" "+words[L]);
			}
		}
		for(int k = 0; k<words.length; k++) {
			System.out.println(words[k]);
		}
		for(int k = 0; k<words.length; k++) {
			if(words[k].equalsIgnoreCase("dinosaur")) {
				counter +=1;
			}
			
		}

		}
	public static void coinFlip() {
	@SuppressWarnings("resource")
	Scanner kb = new Scanner(System.in);
	Random random = new Random();
	int temp = 0;
	temp = random.nextInt(2);
	int oldTemp = 0;
	int counter = 0;
	int countersCounter = 0;
	System.out.println("how many times would you like to flip the coin?");
	int numb = kb.nextInt();
	String [] sides = new String [numb];
	for(int k = 0; k<sides.length; k++) {
		oldTemp = temp;
		temp = random.nextInt(2);
		if(temp==1) {
			sides[k] = "heads";
		}else {
			sides[k] = "tails";
		}
		if(temp==oldTemp) {
			counter++;
            if (counter >= 3) {
                countersCounter += 1;
            }
        } else {
            counter = 0; // Reset the counter when the streak is broken
        }
	}
	for(int k = 0; k<sides.length; k++) {
		System.out.print(sides[k]+ " ");
	}
	System.out.println("");
	System.out.println("you had " + countersCounter + " three streaks");
	}
	public static void quizScore(){
		int temp = 10000;
		int tempo = 0;
		int tempthree = 0;
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("how many grades do you want to enter?");
		int l = kb.nextInt();
		int [] scores = new int [l];
		for(int k = 0; k<scores.length ; k++) {
			System.out.println("please enter the score you got for quiz " + (k+1) + ":");
			scores[k] = kb.nextInt();
			if(scores[k]< temp) {
				temp = scores[k];
				tempo = k;
			}
			
		}
		for(int k = 0; k<scores.length; k++) {
			if(scores[k] == tempo) {
				
			}else {
				tempthree+=scores[k];
			}
			
		}
		System.out.println("without your lowest score of " + temp + " your average quiz score is " + (tempthree/scores.length));

	}
	public static void gymnastScore(){
		double temp = 10000;
		double tempo = 0;
		double tempthree = 0;
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		double [] scores = new double [5];
		for(int k = 0; k<scores.length; k++) {
			System.out.println("please enter score" + (k+1));
			scores[k] = kb.nextDouble();
			if(scores[k]< temp) {
				temp = scores[k];
			}
			if(scores[k]> tempo) {
				tempo = scores[k];
			}

		}
		double fin = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]-(temp+tempo))/3;
		System.out.println("without your lowest score of " + temp + " and your highest score of " + tempo+ " your average score comes out to " + (fin));

	}

}
