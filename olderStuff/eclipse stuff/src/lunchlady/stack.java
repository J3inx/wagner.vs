package lunchlady;

public class stack {
	String student[] = {"empty", "empty", "empty", "empty", "empty"};
	public void DeQueue() {
		for(int i = 4; i>0; i--) {
			if(false != (student[i].equalsIgnoreCase("empty"))) {
				
			}else {
				System.out.println("removed " + student[i] + " from the queue");
				student[i] = "empty";
				
				break;
			}
			
			for (int k = 0; k < student.length; k++) {
			    
			    if (student[k].equals("empty")) {
			        for (int j = k + 1; j < student.length; j++) {
			            if (!student[j].equals("empty")) {
			                String temp = student[k];
			                student[k] = student[j];
			                student[j] = temp;
			                break; 
			            }
			        }
			    }
			}

		}
	}
	public void EnQueue(String name) {
		int count =0;
		for(int k = 0; k<student.length; k++) {
			if(student[k].equalsIgnoreCase("empty")) {
				count++;
			}
			
			}
		if(count == 0) {
			System.out.println("queue is full, cannot add new student");
		}else {
		for(int i = 0; i<student.length; i++) {
			if(student[i].equalsIgnoreCase("empty")) {
				student[i] = name;
				break;
			}else {
				
			}
		}
		}
	}
	public void peek() {
		int l = 0;
		for(int i = 0; i<student.length; i++) {
			if(false != (student[i].equalsIgnoreCase("empty"))) {
				
			}else {
				System.out.println("the first student in the queue is " + student[i]);
				i = 10;
				l = 1;
				break;
			}
			
		}
		if(l == 0) {
		System.out.println("the queue is empty");
		}
	}
	public boolean IsFull() {
		boolean full = true;
		for(int i = 0; i<student.length; i++) {
			if(student[i].equalsIgnoreCase("empty")) {
				return false;
			}
		}
		
		return full;
	}
	public void printLine() {
		for (int k = 0; k < student.length; k++) {
		    
		    if (student[k].equals("empty")) {
		        for (int j = k + 1; j < student.length; j++) {
		            if (!student[j].equals("empty")) {
		                String temp = student[k];
		                student[k] = student[j];
		                student[j] = temp;
		                break; 
		            }
		        }
		    }
		}
		for(int i = 0; i<student.length; i++) {
			System.out.println(student[i]);
		}
	}
}
