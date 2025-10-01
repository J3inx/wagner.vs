package Quarter2;

public class Arraysdaytwo {
	public static void main(String [] args) {
		
		find5s();
		
		
	}
	public static void find5s() {
		int[] arr = new int [6];
		arr[0] = 18;
		arr[1] = 5;
		arr[2] = 19;
		arr[3] = 55;
		arr[4] = 5;
		arr[5] = -5;
		for(int k = 0; k<6; k++) {
			if(arr[k] == 5) {
				System.out.println("it's a five");
			}
		}
		int[] arr2 = new int[1000];
		for(int k = 0; k<arr2.length; k++) {
			arr2[k] = (int)(Math.random()*1000);
			if(arr2[k] == 5) {
				System.out.println("it's a five");
			}
		}
		
	}
}
