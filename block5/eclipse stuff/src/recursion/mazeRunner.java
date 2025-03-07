package recursion;

public class mazeRunner {
	private final int TRIED = 88;
	private final int PATH = 44;
	private int [][] grid = { {1,0,1,0,0,1,1,1}, 
							  {1,1,0,1,1,1,0,1},
							  {0,1,1,1,0,0,1,1},
							  {1,1,0,1,1,0,1,0},
							  {0,0,0,0,0,1,1,1}};
	public String toString() {
		String result = "**************************\n";
		for(int row = 0; row < grid.length; row++) {
			for(int column = 0; column <grid[row].length; column ++) {
				result += grid[row][column]+"\t";
				
			}
			result += "\n";
		}
		
		
		return result;
	}
	
	private boolean valid(int row, int column) {
		boolean result = false;
		if(row>=0 && row<grid.length && column>=0 && column<grid[row].length) {
			if(grid[row][column]==1) {
				result = true;
			}
		}
		return result;
	}
	public boolean traverse(int row, int column) {
		boolean done = false;
		if(valid(row, column) == true) 
		{
			grid[row][column] = TRIED;
			if(row == grid.length-1 && column == grid[0].length-1) 
				done = true;
			else 
			{
				done = traverse(row+1, column);
				if(done == false) 
					done = traverse(row, column +1);
				if(done == false) 
						done = traverse(row-1,column);
				if(done == false)
						done = traverse(row, column-1);
			}
			if(done == true) 
				grid[row][column] = PATH;
		}
		return done;
	}
}

	
