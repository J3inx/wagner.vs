package Qaurter1;

public class ThreeLoops {
	
	public static void main(String [] args) {
		
		//loop is called a for loop
		//i = index(not required)
		//for((int (starting number); (intname) <= (stopping point); (increment by)
		// int+=num add something to in then set int to that
		for(int i = 100; i>=0; i-=1)
		{
			double k = Math.random()*100;
			int l = (int) k;
			System.out.println(l);
		}
		
		//2nd loop is called a while loop
		
		int j = 100;
		while(j<=0)
		{
			System.out.println(j);
			j--;
		}
		
		//do while loop
		int x = 99;
		do{
			x--;
			System.out.println(x);
		}while(x>=66);
		//does whatever is inside, then checks whatever is on the outside of the bottom bracket then repeats
	}

}
