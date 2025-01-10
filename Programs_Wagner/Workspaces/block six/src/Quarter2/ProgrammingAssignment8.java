package Quarter2;

import java.util.Scanner;

public class ProgrammingAssignment8{ 
 @SuppressWarnings("resource")
public static void main(String[] args) { 
	 Scanner kb = new Scanner(System.in);

	String result = "yes";

	while(result.equalsIgnoreCase("yes")) {
		System.out.println("please enter your name");
		String name = kb.next();
		char letter = firstInitial(name);
	 	System.out.println(letter); // R
	 	System.out.println("please type in a number that is greater than 9");
	 	String numbo = kb.next();
		int num = convertStringToInteger(numbo);
		System.out.println(num); // 123 
		int tens = findTensDigit(123);
		System.out.println(tens); // 2 
		int output = removeOnesDigit(123);
		System.out.println(output); // 12 
		System.out.println("would you like to run the progam again?");
		result = kb.next();
	}
 }
 // end of main method 

// end of Scratchwork class 
// precondition - word will have a length greater than 0 
// postcondition - returns very first character of word.  
// For example, if the parameter was “Robert” then “R” would be returned. 

public static char firstInitial(String word) {
	char hellos =  word.charAt(0);
	return hellos;
}
// precondition - num will be a set of digits that can be turned into an integer.  // For example, the String could be "123" but it would not be "$123" or  // "one hundred twenty-three" 
// postcondition - returns the integer formed by converting num to an int public static int convertStringToInteger(String num) 
{ 
}
// precondition - num > 9 
// postcondition - returns the tens digit of num 
public static int convertStringToInteger(String num) { 
	int output = Integer.parseInt(num);
	return output;
}




public static int findTensDigit(int num) { 
	int temp = num/10;
	while(temp>10) {
		temp = temp - 10;
	}
	return temp;
} 
// precondition - num > 9 
// postcondition - returns the integer formed by removing the ones digit of num public static int removeOnesDigit(int num) 

public static int removeOnesDigit(int num) { 
	int bellows = num/10;
	return bellows;
}
}


