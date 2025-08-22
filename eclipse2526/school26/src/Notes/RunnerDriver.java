package Notes;

public class RunnerDriver {

	public static void main(String[] args) {
		Runner ty = new Runner();
		System.out.println(ty);
		Runner george = new Runner();
		System.out.println("\n" + george);
		
		System.out.println("\n");
		
		Runner [] runners = new Runner[75];
		for(int k = 0; k<runners.length; k++) {
			runners[k] = new Runner();
			System.out.println(runners[k]+ "\n");
		}
		
	}

}
