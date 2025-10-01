package Qaurter1;
//Brody Wagner
//Last update 8/30/23
public class variables
{

	public static void main(String [] args)
	{
	System.out.println("Welcome to the new Mustang Block");
	System.out.print("Washington");
	System.out.println("capitals");
	System.out.println("Washington Capitals");
	
	
	// \n = escape clause, working only in between the 2 quotations
	System.out.println("Washington \n Capitals");
	System.out.println(" Big \n Bang \n Theory");
	//escape clause \n means new line
	
	
	//String Literal = anything between two quotation marks
	//escape clause \t
	System.out.println("hello \t im \t brody");
	//escape clause \t = hitting tab basically
	
	
	System.out.println("\"hold onto your deams, the future is made of dreams\".");
	// \" = give it quotes without stopping the other quotes
	
	//variables
	String FavTeacher = "Snyder";
	String LeastTeacher = "Ronco";
	
	//using variables
	System.out.println("Favorite: "+FavTeacher + ", " + "Least Favorite" + ", " + LeastTeacher);
	//concatenation
	
	//three types of primitive data type
	
	//three basic variable types dont include strings
	
	//whole numbers and decimal numbers
	//whole numbers = int (integer)
	//decimals = double
	//boolean = true/false
	
	int EveAge = 17;
	double EveGpa = 4.98;
	boolean EveDL = false;
	System.out.println("AGE: " + EveAge + "\nGPA: " + EveGpa + "\nDrivers license" + EveDL);
	
	//final = variable you can't change
	
	final double pie = 3.14157;
	
	System.out.println(pie);
	}
	
}
