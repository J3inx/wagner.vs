package dinosaurs;

public class Dino {
	double length;
	int age;
	String species;
	boolean isCarnivore;
	public Dino() {
	isCarnivore = false;
	species = "titanosaurus";
	length = (Math.random()*(12-9)+9);
	age = (int)(Math.random()*(150-1)+1);
	}
	
	public double getLength() {
		return length;
	}
	public int getAge() {
		return age;
	}
	public String toString() {
		return("species: " + species + " age: " + age + " is carnivore: " + isCarnivore + " length: " + length);
	}
}
