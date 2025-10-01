package Qaurter1;

public class hwAssignmentTwo {
	public static void main(String [] args)
	{
		double first = (int)(Math.random()*99+1);
		double second = (int)(Math.random()*99+1);
		double third = (int)(Math.random()*99+1);
		System.out.println("numbers = " + first + " " + second + " " + third);
		double firsto = Math.sqrt(first);
		double secondo = Math.sqrt(second);
		double thirdo = Math.sqrt(third);
		System.out.println("square root versions = " + firsto + " " + secondo + " " + thirdo);
		double test = (Math.random()*49+1);
		int numb = (int)Math.floor(test%10);
		System.out.println("the random number " + test + " is " + (int)test + " with " + numb + " in the ones place");
		double testo = (Math.random()*49+1);
		int numbo = (int)Math.floor(testo%10);
		System.out.println("the random number " + testo + " is " + (int)testo + " with " + numbo + " in the ones place");
		double tests = (Math.random()*49+1);
		int numbs = (int)Math.floor(tests%10);
		System.out.println("the random number " + tests + " is " + (int)tests + " with " + numbs + " in the ones place");
		int largo = (int)(Math.random()*8999+1000);
		System.out.println("the original number is " + largo);
		int tempo = (int)Math.floor(largo%100);
		int thousands = (int)Math.floor(largo % 10000 / 1000);
		int hundreds = (int)Math.floor(largo %1000 / 100);
		int tens = (int)Math.floor(tempo / 10 % 10);
		int ones = (int)Math.floor(largo%10);
		int sub = ones+tens+hundreds+thousands;
		int semifinals = largo-sub;
		int thousand = (int)Math.floor(semifinals % 10000 / 1000);
		int hundred = (int)Math.floor(semifinals % 1000 / 100);
		int ten = (int)Math.floor(semifinals / 10 % 10);
		int one = (int)Math.floor(semifinals % 10);
		System.out.println("the seperate compnents are " +thousands + " " + hundreds + " " + tens + " " + ones);
		System.out.println("add those seperate components together and you get " + (ones+tens+hundreds+thousands));
		System.out.println("subtract those from the original number and you get " + (largo-sub));
		System.out.println("the seperate components of " + (largo-sub) + " are " + thousand + " " + hundred + " " + ten + " " + one);
		System.out.println("add those together and you get " + (hundred + thousand + ten + one));
	}
}
