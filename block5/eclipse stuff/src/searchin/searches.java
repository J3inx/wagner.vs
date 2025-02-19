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
}
