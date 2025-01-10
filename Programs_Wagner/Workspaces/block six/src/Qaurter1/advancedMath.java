package Qaurter1;

public class advancedMath {
	public static void main(String [] args)
	{
		
		int tree = 52;
		int branch = 43;
		System.out.println(tree+branch);
		System.out.println("52 + 43 = " + tree+branch);
		System.out.println("52 + 43 = " + (tree+branch));
		System.out.println(tree + branch+"=52+43");
		double g = Math.sqrt(tree);
		System.out.println(g);
		//math.sqrt does the number a square root
		double h = Math.pow(tree, 3);
		System.out.println(h);
		//math.pow multiplies (number, power)
		//what is the fourth root of 22
		double e = Math.pow(22,.25);
		System.out.println(e);
		int p = Math.max(17, 11);
		int d = Math.min(17, 11);
		System.out.println(d + "+" + p);
		//math.random contains the numbers [0,1)    [ = can be this    ) = can never be this
		int w = (int)(Math.random()*91+10);
		//91 numbers between 10 and 100  and add the lowest number
		System.out.println(w);
		
		}
		
	}
	
	

