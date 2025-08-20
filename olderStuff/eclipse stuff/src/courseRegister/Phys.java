package courseRegister;
import java.util.ArrayList;
import java.util.Scanner;
public class Phys {

	Scanner kb = new Scanner(System.in);
	String chart[][] = {
			{"empty", "empty", "empty", "empty", "empty"}, 
			{"empty", "empty", "empty", "empty", "empty"},
			{"empty", "empty", "empty", "empty", "empty"},
			{"empty", "empty", "empty", "empty", "empty"}
	};
	ArrayList waitlist = new ArrayList<String>();
	
	public void removeStudent() {
		boolean kill = false;
		System.out.println("do you want to remove a specific student?");
		String choice = kb.next();
		if(choice.contains("y")|| choice.contains("Y")) {
			System.out.println("who do you want to remove?");
			String student = kb.next();
			
			for(int k = 0; k<4; k++) {
				if(kill == false){
				for(int i = 0; i< chart[k].length; i++) {
					if(false != (chart[k][i].equalsIgnoreCase("empty"))) {
						
					}else if(chart[k][i].equalsIgnoreCase(student)) {
						
						System.out.println("removed " + chart[k][i] + " from the class");
						chart[k][i] = "empty";
						kill = true;
						
						break;
					}
				}


				}
			}
		}else {
			
			System.out.println("ok defaulting to deleting first seated student");
			for(int k = 0; k<4; k++) {
				if(kill == false) {
				for(int i = 0; i< chart[k].length; i++) {
					
					if(false != (chart[k][i].equalsIgnoreCase("empty"))) {
						
					}else {
						System.out.println("removed " + chart[k][i] + " from the class");
						chart[k][i] = "empty";
						kill = true;
						
						break;
					}
				}


				}
			}
		}

	}
	public void addStudent(String name) {
		boolean kill = false;
		int count = 0;
		for(int k = 0; k<4; k++) {
			for(int i = 0; i<chart[k].length; i++) {
				if(chart[k][i].equalsIgnoreCase("empty")) {
					count++;
				}
			}
		}
		if(count != 0 && kill == false) {
		for(int k = 0; k<4; k++) {
			if(!kill) {
			for(int i = 0; i<chart[k].length; i++) {
				if(chart[k][i].equalsIgnoreCase("empty")) {
					chart[k][i]= name;
					kill = true;
					break;
				}
			}
		}
		}
		}else {
			System.out.println("class is full, would you like to remove someone?");
			String choice = kb.next();
			if(choice.equalsIgnoreCase("y")) {
				removeStudent();
			}
		}
		
	}
	public void peek() {
		int l = 0;
		for(int k = 0; k<4; k++) {
		for(int i = 0; i<chart[k].length; i++) {
			if(false != (chart[k][i].equalsIgnoreCase("empty"))) {
				
			}else {
				System.out.println("the first seated student in the class is " + chart[k][i]);
				i = 10;
				l = 1;
				break;
			}
			
		}
	}
		if(l == 0) {
		System.out.println("the class is empty");
		}
	}
	public boolean IsFull() {
		boolean full = true;
		for(int k = 0; k<3; k++) {
		for(int i = 0; i<chart.length; i++) {
			if(chart[k][i].equalsIgnoreCase("empty")) {
				return false;
			}
		}
		}
		
		return full;
	}
	public void printSeatingChart() {
		for(int k = 0; k<4; k++) {
			if(waitlist.size()>0) {
			for(int i = 0; i<chart[k].length; i++) {
				if(chart[k][i].equalsIgnoreCase("empty") && waitlist.size()>0) {
					chart[k][i] = (String) waitlist.get(0);
					waitlist.remove(0);
				}
			}
		}
		}
		int check = 0;
	for(int k = 0; k<4; k++) {
		for(int i = 0; i<chart[k].length; i++) {
			if(check !=k) {
				System.out.println("");
				System.out.print(chart[k][i] + "	");
				check = k;
			}else {
			System.out.print(chart[k][i] + "	");
			}
			
		}
	}
	System.out.println("");
	System.out.println("");
	}
	public void AddWaitlist() {
		// TODO Auto-generated method stub
		System.out.println("do you want to add or remove from the waitlist?");
		String decision = kb.next();
		if(decision.contains("a")) {
		System.out.println("waitlist is currently " + waitlist.size() + " places long, would you like to add a student?");
		String choice = kb.next();
		if(choice.equalsIgnoreCase("y")) {
			System.out.println("who do you want to add?");
			String name = kb.next();
			waitlist.add(name);
		}else {
			System.out.println("ok");
		}
		
	}else {
		System.out.println("currently in the list there is:");
		for(int i = 0; i<waitlist.size();i++) {
		System.out.print("[" + waitlist.get(i) + "] " );	
		}
		System.out.println("what place would you like to remove? ");
		int placement = kb.nextInt();
		System.out.println("removed " + waitlist.get(placement-1) + " from the waitlist");
		waitlist.remove(placement-1);
		
	}
	}
	
	
}
