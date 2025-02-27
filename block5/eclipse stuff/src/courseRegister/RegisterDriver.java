package courseRegister;

import java.util.Scanner;
public class RegisterDriver {
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.println("do you want to register for physics or calculus?");
		String answer = kb.next();
		if(answer.equalsIgnoreCase("calculus")) {
			Calculus Course = new Calculus();
			int x = 0;
			while(x!=7) {
				System.out.println("Please select the following\n"
						+ "1. To remove a student\n"
						+ "2. To add a student\n"
						+ "3. To see the first student\n"
						+ "4. Is the class full\n"
						+ "5. Print out Course seating chart\n"
						+ "6. Add a student to the waitlist\n"
						+ "7. End the day\n"
						+ "");
				x = kb.nextInt();
				if(x ==1) {
					//remove studen
					Course.removeStudent();
					
					
				}
				if(x ==2) {
					System.out.println("what is the name fo the student you want to add?:");
					String name = kb.next();
					Course.addStudent(name);
					//add student
				}
				if(x == 3) {
					Course.peek();
				}
				if(x == 4) {
					boolean output = Course.IsFull();
					if(output) {
						System.out.println("the class is full");
					}else{
						System.out.println("the class is not full");
					}
				}
				if(x == 5) {
					Course.printSeatingChart();
				}
				if(x == 6) {
					Course.AddWaitlist();
				}
				if(x == 7) {
					System.out.println("day ended");
					x = 8;
					break;
				}
			}
			
		}else if(answer.equalsIgnoreCase("physics")) {
			Phys Course = new Phys();
			int x = 0;
			while(x!=7) {
				System.out.println("Please select the following\n"
						+ "1. To remove a student\n"
						+ "2. To add a student\n"
						+ "3. To see the first student\n"
						+ "4. Is the class full\n"
						+ "5. Print out Course seating chart\n"
						+ "6. Add a student to the waitlist\n"
						+ "7. End the day\n"
						+ "");
				x = kb.nextInt();
				if(x ==1) {
					//remove studen
					Course.removeStudent();
					
					
				}
				if(x ==2) {
					System.out.println("what is the name fo the student you want to add?:");
					String name = kb.next();
					Course.addStudent(name);
					//add student
				}
				if(x == 3) {
					Course.peek();
				}
				if(x == 4) {
					boolean output = Course.IsFull();
					if(output) {
						System.out.println("the class is full");
					}else{
						System.out.println("the class is not full");
					}
				}
				if(x == 5) {
					Course.printSeatingChart();
				}
				if(x == 6) {
					Course.AddWaitlist();
				}
				if(x == 7) {
					System.out.println("day ended");
					x = 8;
					break;
				}
			}
		

}
	}
}
