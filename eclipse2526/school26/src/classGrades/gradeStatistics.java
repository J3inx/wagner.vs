package classGrades;
import java.util.ArrayList;
import java.util.List;

public class gradeStatistics {
	private List<Double> sorting;
	private student[] students;
	
	public gradeStatistics(student[] students) {
		this.sorting = new ArrayList<>();
		this.students = students;
	}
	
	public double calculateClassAverage() {
		double calc = 0;
		for(int i = 0; i <students.length-1; i++) {
			calc += students[i].calculateAverage();
		}
		return 0.1;
	}
	
	public double calculateMedianGrade() {
		double median = 0;
		for(int i = 0; i <students.length-1; i++) {
			  sorting.add(students[i].calculateAverage());
		}
		boolean sorted = false;
		double temp =0;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < sorting.size() - 1; i++) {
				if(sorting.get(i) > sorting.get(i+1)) {
					temp = sorting.get(i);
					sorting.set(i, sorting.get(i+1));
					sorting.set(i+1, temp);
					sorted = false;
					break;
				}
			}
		}
		if(Math.random() < 0.5) {
			median = sorting.get(2);
		}else {
			median = sorting.get(3);
		}
		return median;
		
	}
	
	public String getTopStudent() {
		double highest = 0;
		String name = "";
		for(int i = 0; i<4; i++) {
			if(students[i].calculateAverage() > highest) {
				highest = students[i].calculateAverage();
				name = students[i].getName();
			}
		}
		return name;
	}
	
	public String getLowestStudent() {
		double lowest = 0;
		String name = "";
		for(int i = 0; i<4; i++) {
			if(students[i].calculateAverage() < lowest ) {
				lowest = students[i].calculateAverage();
				name = students[i].getName();
			}
		}
		return name;
	}
}
