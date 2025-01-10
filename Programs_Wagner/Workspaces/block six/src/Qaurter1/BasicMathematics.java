package Qaurter1;

public class BasicMathematics {
	public static void main(String [] args)
	{
		
		System.out.println("NY Mets");
		System.out.print("Win the world series");
		System.out.println("\n\t\t\t\"The Yankees are the worst\"");
		int a = 19;
		int b = 3;
		int c = a/b;
		System.out.print("C is " + c);
		//truncates = dropped the decimal
		int a2 = 19;
		double b2 = 3;
		double c2 = a2/b2;
		System.out.println("\nC without truncating it " + c2);
		
		System.out.println("a+b is " + a+b);
		System.out.println(a+b + " = a+b");
		//if the computer see the quotations marks it thinks everything else is going to be a string
		System.out.println("a+b is " + (a+b));
		//putting parentheses tells the computer you are doing math
		int money = (int)22.37;
		//casting
		System.out.println(money);
		
		int a3 = 37;
		int b3 = 16;
		
		System.out.println(a + " ounces is equal to " + (a3/b3) + " pounds and " + (a3%b3) + " ounces");
		
	}

}
