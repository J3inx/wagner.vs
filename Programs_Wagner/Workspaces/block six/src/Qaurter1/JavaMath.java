package Qaurter1;

public class JavaMath {
	
	public static void main(String [] args)
	{
		//3 primitve data types
		boolean eve = true;
		System.out.println("Eve thinks brody is smart = " + eve);
		int PairOfPants = 70000;
		System.out.println("william owns " + PairOfPants + " pants");
		double size = 238.914;
		System.out.println("size of an ant's brain = " + size + " grams");
		int varA = 16;
		int varB = 19;
		int varC = Math.addExact(varA, varB);
		System.out.println(varA + " + " + varB + " = " + varC);
		//or
		System.out.println(varA + " - " + varB + " = " + (varA-varB));
		System.out.println(varA + " / " + varB + " = " + (varA/varB));
		int varC2 = Math.floorDiv(varA, varB);
		System.out.println(varA + " / " + varB + " = " + varC2);
		System.out.println(varA + " / " + varB + " = " + (varA%varB));
	}
}

