package searchin;

import java.util.Scanner;

public class searchesDrive {

	
	public static void main(String[] args) {
		//create an array that holds 100 integers
		//fill that array with the numbers 1-100
		int rocker[] = new int[100] ;
		for(int i = 0; i<rocker.length; i++) {
			rocker[i] = i+1;
		}
		searches object1 = new searches(rocker);
		object1.printoutarray();
		object1.shufflearray();
		Scanner kb = new Scanner(System.in);
		System.out.println("enter a number to look for:");
		int input = kb.nextInt();
		object1.linearsearch(input);
		object1.bubblesort();
		System.out.println("enter a number to binary search for:");
		 input = kb.nextInt();
		object1.binarysearch(input);
	}
//create an instance of the search class sending the array as an arg
	
}
