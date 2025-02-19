package searchin;

public class searches {
	private int [] numbers;
	private int temp, temp2;
	

	public searches(int[] numbers) {
		this.numbers = numbers;
		for(int i = 0; i<numbers.length; i++) {
			//printoutarray(numbers[i]);
		}
	}
	public void printoutarray() {
		//System.out.println(numbo);
		for(int x:numbers) {
			System.out.println(x + " ");
			
		}

	}
	public void shufflearray() {
		for(int i =0; i<numbers.length; i++) {
			temp = numbers[i];
			int place = (int)((Math.random()*(numbers.length-1)+1));
			temp2 = numbers[place];
			numbers[i] = temp2;
			numbers[place] = temp;
		}
		for(int i = 0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
	public void linearsearch(int k) {
		for(int i = 0; i <numbers.length; i++) {
			if(numbers[i] == k) {
				System.out.println("i found number " + k + " in index " + i + " and it took me " + (i+1) + " if statements to find it");
				break;
			}
		}
	}
	public void bubblesort() {
		for(int i=0; i<numbers.length; i++) {
			
			for(int l = 0; l< numbers.length; l++) {
				if(l<99 && numbers[l]>numbers[l+1]) {
					int temp = numbers[l];
					int temp2 = numbers[l+1];
					numbers[l]=temp2;
					numbers[l+1]=temp;
					//swap
				}
			}
		}
		printoutarray();
	}
	public void binarysearch(int k) {
		int left = numbers[0];
		int right = numbers.length-1;
		int middle = (left+right)/2;
		while(numbers[middle] !=k) {
		if (numbers[middle] == k){
			
			System.out.println("we found it");
		}else if(k<numbers[middle]) {
			left = left;
			right = middle-1;
			middle = (left+right)/2;
		}else {
			left = middle+1;
			right = right;
			middle = (left + right)/2;
		}
		}
	}
	
}
