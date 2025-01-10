package quarter4;

public class SelfWork1 {
	public static void main(String [] args) {
		int n = 1000;
		int sum = 0;
		while(n>0) {
			if(n%4 == 0 || n%6 ==0) {
				sum += n;
				n+=-1;;
			}else {
			n+=-1;
			}

		}
		System.out.println(sum);
}
}
