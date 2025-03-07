package recursion;

public class TowersClass {
	private int totalDisks;
	public TowersClass(int disks) {
		totalDisks = disks;
	}
	public void solve() {
		moveTowers(totalDisks, 1, 3, 2);
	}
	private void moveTowers(int numDisks, int start, int end, int temp) {
		if(numDisks == 1) 
			moveOneDisk(start,end);
		else
		{
			moveTowers(numDisks-1,start,temp,end);
			moveOneDisk(start,end);
			moveTowers(numDisks-1, temp, end, start);
		}
	}
	private void moveOneDisk(int start, int end) {
		System.out.println("Move one disk from " + start + " to " + end);
		
	}
	
}
