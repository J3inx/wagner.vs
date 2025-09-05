package classGrades;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter; 
public class analyzerDriver {
	private static double[] grades = {0.01, 0.02, 0.99, 0.56};
	private static double[] gradesTwo = {0.10, 0.80, 0.99, 0.56};
	private static double[] gradesThree = {0.80, 0.30, 0.49, 0.76};
	public static void main(String[] args) {
		student [] students = new student[5];
		// TODO Auto-generated method stub
		students[0] = new student("chris");
		students[1] = new student("colin", 1);
		students[2] = new student("brayden", 2, grades);
		students[3] = new student("mason", 3, gradesTwo);
		students[4] = new student("atticus", 4, gradesThree);
		
		for(int i = 0; i<=4; i++) {
			for(int k = 0; k<=4; k++) {
			students[k].addGrade(Math.random()*10);
			}
		}
		gradeStatistics graded = new gradeStatistics(students);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("\nThis is " + students[i].getName() + " their average grade is " + students[i].calculateAverage() + ", their lowest grade is " + students[i].getLowestGrade() + ", their highest grade is " + students[i].getHighestGrade());
			
		}
		System.out.println("\nThe highest performing student is " + graded.getTopStudent());
		System.out.println("\nThe lowest performing student is " + graded.getLowestStudent());
		System.out.println("\nThe class average is " + graded.calculateClassAverage());
		System.out.println("\nThe class median is " + graded.calculateMedianGrade());
		
		 
		      
		      
		    
		 try {
			FileWriter myObj = new FileWriter("filename.txt");
			for(int i = 0; i<4; i++) {
				
				myObj.write("Student " + (i+1) + " is named " + students[i].getName() + ". Their lowest grade is " + students[i].getLowestGrade() + ". Their highest grade is " + students[i].getHighestGrade() + ". And their average grade is " + students[i].calculateAverage() + "\n");
				
			}
				myObj.close();
		      System.out.println("Successfully wrote to the file.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
