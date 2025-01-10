package Quarter2;

public class correctSelctionSort {
	public static void main(String[] args) {
		int [] nums = new int[10];
		for(int k = 0; k<nums.length; k++) {
			nums[k] = (int) (Math.random()*40);
		}
		for(int x:nums) {
			System.out.print(x+ ", ");
			
		}
	System.out.println("");	
	for(int j = nums.length-1; j>0; j--) {
		int largest = nums[0];
		int spot = 0;
		for(int i = 0; i<=j; i++) {
			if(nums[i]>largest) {
				largest = nums[i];
				spot = i;
		
			}
		}
		//swap
		nums[spot] = nums[j];
		nums[j] = largest;
		
	}
	
	for(int x:nums) {
		System.out.print(x+ ", ");
		
	}
	}
}
