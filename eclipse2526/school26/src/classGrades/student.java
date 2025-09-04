package classGrades;
import java.util.ArrayList;
import java.util.List;
public class student {
	private String name;
	private int id;
	private List<Double> grades;
	
	public student(String name) {
		this.name = name;
		this.grades = new ArrayList<>();
	}
	public student(String name, int id) {
		this.name = name;
		this.id = id;
		this.grades = new ArrayList<>();
	}
	public student(String name, int id, double [] grades) {
		this.name = name;
		this.id = id;
		this.grades = new ArrayList<>();
		for(int i = 0; i< grades.length; i++) {
			this.grades.add(grades[i]);
		}
	}
	public String getName() {
		return name;
	}
	public void addGrade(double toadd) {
		grades.add(toadd);
	}
	
	public double calculateAverage() {		
	        double sum = 0;
	        for (double g : grades) {
	            sum += g;
	        }
	        return sum / grades.size();
	}
	public double getHighestGrade() {
		 double max = grades.get(0);
	        for (int i = 0; i< grades.size(); i++) {
	            if (grades.get(i) > max) {
	            	max = grades.get(i);
	            }
	        }
	        return max;
	    }
	
	
	public double getLowestGrade() {
		double min = grades.get(0);
        for (int i = 0; i< grades.size(); i++) {
            if (grades.get(i) < min) {
            	min = grades.get(i);
            }
        }
        return min;
	}
}
