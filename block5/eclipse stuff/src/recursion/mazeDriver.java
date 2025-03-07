package recursion;

public class mazeDriver {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mazeRunner labyrinth = new mazeRunner();
		System.out.println(labyrinth);
		if(labyrinth.traverse(0,0) == true) {
			System.out.println("the maze was solved successfully");
		}else {
			System.out.println("there is no possible end");
		}
		System.out.println(labyrinth);
	}

}
