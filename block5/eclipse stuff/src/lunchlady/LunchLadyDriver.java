package lunchlady;

import java.util.Scanner;

public class LunchLadyDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("do you want a stack or a queue?");
		String answer = kb.next();
		if(answer.equalsIgnoreCase("stack")) {
			stack list = new stack();
			int x = 0;
			while(x!=6) {
				System.out.println("Please select the following\n"
						+ "1. To Pop\n"
						+ "2. To Push\n"
						+ "3. To Peek at front\n"
						+ "4. Is the line full\n"
						+ "5. Print out list\n"
						+ "6. End the day\n"
						+ "");
				x = kb.nextInt();
				if(x ==1) {
					//remove studen
					list.DeQueue();
					
					
				}
				if(x ==2) {
					System.out.println("what is the name fo the student you want to add?:");
					String name = kb.next();
					list.EnQueue(name);
				}
				if(x == 3) {
					list.peek();
				}
				if(x == 4) {
					boolean output = list.IsFull();
					if(output) {
						System.out.println("the line is full");
					}else{
						System.out.println("the line is not full");
					}
				}
				if(x == 5) {
					list.printLine();
				}
				if(x == 6) {
					System.out.println("day ended");
					x = 8;
					break;
				}
			}
		}else if(answer.equalsIgnoreCase("queue")) {
			queue list = new queue();
			int x = 0;
			while(x!=6) {
				System.out.println("Please select the following\n"
						+ "1. To Pop\n"
						+ "2. To Push\n"
						+ "3. To Peek at front\n"
						+ "4. Is the line full\n"
						+ "5. Print out list\n"
						+ "6. End the day\n"
						+ "");
				x = kb.nextInt();
				if(x ==1) {
					//remove studen
					list.DeQueue();
					
					
				}
				if(x ==2) {
					System.out.println("what is the name fo the student you want to add?:");
					String name = kb.next();
					list.EnQueue(name);
					//add student
				}
				if(x == 3) {
					list.peek();
				}
				if(x == 4) {
					boolean output = list.IsFull();
					if(output) {
						System.out.println("the line is full");
					}else{
						System.out.println("the line is not full");
					}
				}
				if(x == 5) {
					list.printLine();
				}
				if(x == 6) {
					System.out.println("day ended");
					x = 8;
					break;
				}
			}
		

}
	}
}