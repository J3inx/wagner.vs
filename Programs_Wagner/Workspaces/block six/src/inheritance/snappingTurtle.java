package inheritance;

public class snappingTurtle extends pet
{
	private double HardnessOfShell;
	public snappingTurtle(String a, int b, boolean c, double d) {
		//super means go to class above it, in this case being pet because of the extends pet
		super(a,b,c);
		HardnessOfShell = d;
	}
	public String toString() {
		return super.toString() + "\nHardness of SHELL: " + HardnessOfShell;
	}

}
