package TwoDArrays;

import java.util.Scanner;

public class TicTacToe {
	/*String a = new String("WTG");
	String b = new String("Dave");
	b=a;
	System.out.println(b);*/
	static String [][] board = {{"Empty", "Empty", "Empty"},
						{"Empty", "Empty", "Empty"},
						{"Empty", "Empty", "Empty"}}; 
	//two brackets means two dimensions arrays
	public static void main(String [] args) {
		
		Scanner kb = new Scanner(System.in);
		int turn = 5;
		while(true) {
			System.out.println("rows " + board.length);
			System.out.println("columns " + board[0].length);
		if(turn >= 1) {
		System.out.println("Player X, what row?");
		int temprow = kb.nextInt()-1;
		System.out.println("Player X, what col?");
		int tempcol = kb.nextInt()-1;
		int row =0;
		int col =0;
		if(board[temprow][tempcol] == "Empty") {
		 row = temprow;
		 col = tempcol;
		board[row][col] = "X";
		turn+=(-10);
		}else {
			System.out.println("that point is taken try again");
		}
		
		}else {
			System.out.println("Player O, what row?");
			int temprow = kb.nextInt()-1;
			System.out.println("Player O, what col?");
			int tempcol = kb.nextInt()-1;
			int row =0;
			int col =0;
			if(board[temprow][tempcol] == "Empty") {
			 row = temprow;
			 col = tempcol;
			 board[row][col] = "O";
			 turn+=(10);
			}else {
				System.out.println("that point is taken try again");
			}
			
		}
		printBoard();
		
		}
	}
	public static void printBoard() {
		for(int row = 0; row<3; row++) {
			for(int col = 0; col<3; col++) {
				System.out.print(board[row][col]+ "\t");
			}
			System.out.println("");
		}
	}
}
