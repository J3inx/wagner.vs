package BlockFiveQ1;

public class MathStuff {
	//method that returns an int
	public int question1() {
		return 7;
	}
	
	public int program1(){
		System.out.println("The sum of Multiples of 3, 5, and 7 less than 1000 is: ");
		int x = 0;
		for(int i = 1;i < 1000; i++) {
			if(i%3 == 0 || i%5 == 0 || i%7 == 0)
				x+=i;
		}
		return x;
	}
	public int program2() {
		System.out.println("The sum of Fibonacci Numbers less than 100000 is: ");
	    int x = 1; 
	    int l = 1; 
	    int i = 1; 

	    for (; i < 100000;) {
	        int next = i + l; 
	        if (next >= 100000) break; 
	        x += next; 
	        l = i; 
	        i = next; 
	    }

	    return x;
	}

	public int program3() {
		System.out.println("The sum of Palindrome Numbers between 300 and 500 is: ");
		int x = 0;
		int temp = 0;
		for(int i = 300; i<500; i++) {
		    int reverse = 0;
		    temp = i;
		    while (temp != 0) {
		        reverse = (reverse * 10) + (temp % 10);
		        temp = temp / 10;
		    }
		    if(reverse == i) {
		    	x+=reverse;
		    }
		    
		}
		return x;
	}
	public int program4() {
		System.out.println("The sum of Prime Numbers less than 100 is: ");
	    int sum = 2; 
	    for(int i = 3; i < 100; i++) {
	        if (i % 2 != 0) { 
	            boolean isPrime = true;
	            for (int l = 3; l * l <= i; l += 2) {
	                if (i % l == 0) {
	                    isPrime = false; 
	                    break; 
	                }
	            }
	            if (isPrime) {
	                sum += i;
	            }
	        }
	    }
	    return sum;
	}

}
