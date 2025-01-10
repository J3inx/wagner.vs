package inheritance;

public class pet 
{
	private int amtEyes;
	private String name;
	private boolean mouth;
	//constructor
	public pet(String a, int b, boolean c)
	{
	name = a;
	amtEyes = b;
	mouth = c;
	}
	//polymorphism is meaning more than 1 with the ability to change
	//polymorphism
	public pet() 
	{
		name = "Mollie";
		amtEyes = 2;
		mouth = true;
	}
	public pet(int a) {
		name = "Mom";
		amtEyes = a;
		mouth = true;
	}
	public String toString()
	{
		return "NAME: " + name + "\nMOUTH: " + mouth + "\nAmt of eyes: " + amtEyes; 
	}
	
}
