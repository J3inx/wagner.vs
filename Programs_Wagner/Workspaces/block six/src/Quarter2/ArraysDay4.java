package Quarter2;

public class ArraysDay4 {
	public static void main(String [] args) {
		int [] arr = {5,25,4,7,8,10,4};
		//array printing method 1
		for(int k = 0; k<arr.length; k++) {
			System.out.println(arr[k]);
		}
		//array printing method 2 (enhanced for loop)
		for(int x:arr) {
			System.out.println(x);
			if(x%2==0) {
				System.out.println(x + " is an even number");
			}
		}
		
	}
}
