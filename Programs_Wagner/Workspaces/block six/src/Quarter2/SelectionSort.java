package Quarter2;

public class SelectionSort {
 public static void main(String [] args) {
	 
	 int arr [] = new int [10];
	 for(int k = 0; k<arr.length; k++) {
		 arr[k] = (int)(Math.random()*40);
	 }
	 for(int x:arr) {
		 System.out.println(x);
	 }
	for(int i = 0; i<arr.length-1; i++) {
		
		int index = i;
		for(int j = i+1; j<arr.length; j++){
			index = j;
			//find the spot of the largest number;
			int large = arr[index];
			arr[index] = arr[arr.length-1];
			arr[arr.length-1] = large;
		}

		System.out.print(arr[index] + ", ");
	}
	
 }
}
