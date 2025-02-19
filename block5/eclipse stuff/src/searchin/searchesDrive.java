package searchin;

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
	}
//create an instance of the search class sending the array as an arg
	
}
