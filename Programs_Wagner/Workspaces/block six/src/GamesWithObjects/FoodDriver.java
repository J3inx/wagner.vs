package GamesWithObjects;

public class FoodDriver {
	
	public  static void main(String [] args) {
		
		
		//hard one, when class and constructor dont match
		Food a2 = new AnimalProducts();
		//animalproducts are food, but food is not an animal product
		//since animal products extends food its allows food to go down to animal products then go up to food
		System.out.println(a2.carbo);
		// i have access to carbo in food but not protein in animal products
		//System.out.println(a2.);
		
		
		
		
		Food f = new Food();
		System.out.println(f.carbo);
		System.out.println("####");
		AnimalProducts a = new AnimalProducts();
		//go to animal class then go to constructor, and make an object
		System.out.println(a.protein);
		//can see stuff in parent class above it since animal class extends food and uses super
		System.out.println(a.carbo);
		System.out.println("####");
		VeganProducts v = new VeganProducts();
		System.out.println(v.sun);
		System.out.println(v.carbo);
		System.out.println("####");
		
		
	}
	
}
