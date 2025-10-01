package prisonergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class assignmentSeven extends JFrame implements ActionListener {
	private JTextArea Name, GPA, CoursesTaken, Height;
	private ArrayList <String> studentName = new ArrayList();
	private ArrayList <Double> studentHeight = new ArrayList();
	private ArrayList <Double> studentGPA = new ArrayList();
	private ArrayList <Integer> studentCourses = new ArrayList();
	private JTable students;
	private String [] colNames = {"Name", "GPA", "Courses Taken", "Height"};
	private String [][] data = new String[100][4];
	public assignmentSeven() {
		
		super("rocker");
		studentName.add("brody");
		studentName.add("john");
		studentName.add("avery");
		studentHeight.add(72.0);
		studentHeight.add(71.2);
		studentHeight.add(69.42);
		studentGPA.add(3.77);
		studentGPA.add(3.8);
		studentGPA.add(3.5);
		studentCourses.add(4);
		studentCourses.add(3);
		studentCourses.add(5);
		
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JTabbedPane tPane = new JTabbedPane();
			tPane.setBounds(0,0,1000,1000);
			JPanel panel1 = new JPanel();
			Name = new JTextArea("name");
			Name.setBounds(100,100,100,100);
			GPA = new JTextArea("GPA");
			GPA.setBounds(100,100,200,100);
			CoursesTaken = new JTextArea("IB courses taken");
			CoursesTaken.setBounds(100,100,300,100);
			Height = new JTextArea("height in inches");
			Height.setBounds(100,100,400,100);
			JButton add = new JButton("add student");
			add.setBounds(100,100,200,200);
			add.addActionListener(this);
			panel1.add(add);
			panel1.add(Height);
			panel1.add(Name);
			panel1.add(GPA);
			panel1.add(CoursesTaken);
			tPane.add(panel1, "Data entry form");
			
			JPanel panel2 = new JPanel();
			students = new JTable(data, colNames);
			students.setBounds(200,200,200,200);
			students.setBackground(Color.BLACK);
			students.setForeground(Color.WHITE);
			students.setValueAt("name", 0, 0);
			students.setValueAt("GPA", 0, 1);
			students.setValueAt("C#", 0, 2);
			students.setValueAt("Height", 0, 3);
	        for(int i = 0; i < studentName.size(); i++) {
	            students.setValueAt(studentName.get(i), i+1, 0);  
	            students.setValueAt(String.valueOf(studentHeight.get(i)), i+1, 3);
	            students.setValueAt(String.valueOf(studentGPA.get(i)), i+1, 1);    
	            students.setValueAt(String.valueOf(studentCourses.get(i)), i+1, 2); 
	        }
			
			JPanel panel3 = new JPanel();
			JButton sortByG = new JButton("sort by GPA");
			JButton sortByHeight = new JButton("sort by height");
			JButton sortByCourse = new JButton("sort by amount of courses");
			JButton sortByName = new JButton("sort by name");
			JButton save = new JButton("save");
			save.setBounds(100,400,100,100);
			save.addActionListener(this);
			panel3.add(save);
			sortByG.setBounds(100,100,100,100);
			sortByHeight.setBounds(100,100,200,100);
			sortByCourse.setBounds(100,100,300,100);
			sortByName.setBounds(100,100,400,100);
			panel3.add(sortByG);
			panel3.add(sortByHeight);
			panel3.add(sortByCourse);
			panel3.add(sortByName);
			sortByName.addActionListener(this);
			sortByG.addActionListener(this);
			sortByCourse.addActionListener(this);
			sortByHeight.addActionListener(this);
					
			
			
			panel2.add(students);
			
			tPane.add(panel2, "Tables");
			tPane.add(panel3, "sorting");
			add(tPane);
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("save")) {
			PrintWriter outputStream = null;		
			try {
				outputStream = new PrintWriter(new FileOutputStream("Students",true));
				//the true allows it to "append" or to add to something after the last added value
				
			}
			catch(FileNotFoundException e1) {
				System.out.println("Error: file not found");
				System.exit(0);
			}

			outputStream.println("table of students: ");
			for(int y = 0; y <studentHeight.size()+1; y++) {
			for(int x = 0;x<4; x++) {
			outputStream.print(students.getValueAt(y, x)+ "\t ");	

			}
			outputStream.println("");
			}
			

			//have to close a stream, printer, or a scanner after opening it
			outputStream.close();
			System.out.println("we have written to a file");
		}
		
		if(e.getActionCommand().equals("sort by GPA")) {
			ArrayList <String> CopystudentName = (ArrayList<String>) studentName.clone();
			ArrayList <Double> CopystudentHeight = (ArrayList<Double>)studentHeight.clone();
			ArrayList <Double> CopystudentGPA = (ArrayList<Double>)studentGPA.clone();
			ArrayList <Integer> CopystudentCourses = (ArrayList<Integer>)studentCourses.clone();
			
			 for (int i = 0; i < CopystudentGPA.size() - 1; i++) {
		            for (int j = 0; j < CopystudentGPA.size() - i - 1; j++) {
		                if (CopystudentGPA.get(j) < CopystudentGPA.get(j + 1)) {
		                    
		                    Double tempGPA = CopystudentGPA.get(j);
		                    CopystudentGPA.set(j, CopystudentGPA.get(j + 1));
		                    CopystudentGPA.set(j + 1, tempGPA);

		                    
		                    String tempName = CopystudentName.get(j);
		                    CopystudentName.set(j, CopystudentName.get(j + 1));
		                    CopystudentName.set(j + 1, tempName);

		                    
		                    Double tempHeight = CopystudentHeight.get(j);
		                    CopystudentHeight.set(j, CopystudentHeight.get(j + 1));
		                    CopystudentHeight.set(j + 1, tempHeight);

		                    
		                    Integer tempCourses = CopystudentCourses.get(j);
		                    CopystudentCourses.set(j, CopystudentCourses.get(j + 1));
		                    CopystudentCourses.set(j + 1, tempCourses);
		                }
		            }
		        }
			 for (int i = 0; i < CopystudentName.size(); i++) {
		            students.setValueAt(CopystudentName.get(i), i + 1, 0);
		            students.setValueAt(String.valueOf(CopystudentGPA.get(i)), i + 1, 1);
		            students.setValueAt(String.valueOf(CopystudentCourses.get(i)), i + 1, 2);
		            students.setValueAt(String.valueOf(CopystudentHeight.get(i)), i + 1, 3);
		        }
			
		}
		
		if(e.getActionCommand().equals("sort by height")) {
			ArrayList <String> CopystudentName = (ArrayList<String>) studentName.clone();
			ArrayList <Double> CopystudentHeight = (ArrayList<Double>)studentHeight.clone();
			ArrayList <Double> CopystudentGPA = (ArrayList<Double>)studentGPA.clone();
			ArrayList <Integer> CopystudentCourses = (ArrayList<Integer>)studentCourses.clone();
			
			 for (int i = 0; i < CopystudentHeight.size() - 1; i++) {
		            for (int j = 0; j < CopystudentHeight.size() - i - 1; j++) {
		                if (CopystudentHeight.get(j) < CopystudentHeight.get(j + 1)) {
		                    
		                    Double tempGPA = CopystudentGPA.get(j);
		                    CopystudentGPA.set(j, CopystudentGPA.get(j + 1));
		                    CopystudentGPA.set(j + 1, tempGPA);

		                    
		                    String tempName = CopystudentName.get(j);
		                    CopystudentName.set(j, CopystudentName.get(j + 1));
		                    CopystudentName.set(j + 1, tempName);

		                    
		                    Double tempHeight = CopystudentHeight.get(j);
		                    CopystudentHeight.set(j, CopystudentHeight.get(j + 1));
		                    CopystudentHeight.set(j + 1, tempHeight);

		                    
		                    Integer tempCourses = CopystudentCourses.get(j);
		                    CopystudentCourses.set(j, CopystudentCourses.get(j + 1));
		                    CopystudentCourses.set(j + 1, tempCourses);
		                }
		            }
		        }
			 for (int i = 0; i < CopystudentName.size(); i++) {
		            students.setValueAt(CopystudentName.get(i), i + 1, 0);
		            students.setValueAt(String.valueOf(CopystudentGPA.get(i)), i + 1, 1);
		            students.setValueAt(String.valueOf(CopystudentCourses.get(i)), i + 1, 2);
		            students.setValueAt(String.valueOf(CopystudentHeight.get(i)), i + 1, 3);
		        }
			
		}
		if(e.getActionCommand().equals("sort by amount of courses")) {
			ArrayList <String> CopystudentName = (ArrayList<String>) studentName.clone();
			ArrayList <Double> CopystudentHeight = (ArrayList<Double>)studentHeight.clone();
			ArrayList <Double> CopystudentGPA = (ArrayList<Double>)studentGPA.clone();
			ArrayList <Integer> CopystudentCourses = (ArrayList<Integer>)studentCourses.clone();
			
			 for (int i = 0; i < CopystudentCourses.size() - 1; i++) {
		            for (int j = 0; j < CopystudentCourses.size() - i - 1; j++) {
		                if (CopystudentCourses.get(j) < CopystudentCourses.get(j + 1)) {
		                    
		                    Double tempGPA = CopystudentGPA.get(j);
		                    CopystudentGPA.set(j, CopystudentGPA.get(j + 1));
		                    CopystudentGPA.set(j + 1, tempGPA);

		                    
		                    String tempName = CopystudentName.get(j);
		                    CopystudentName.set(j, CopystudentName.get(j + 1));
		                    CopystudentName.set(j + 1, tempName);

		                    
		                    Double tempHeight = CopystudentHeight.get(j);
		                    CopystudentHeight.set(j, CopystudentHeight.get(j + 1));
		                    CopystudentHeight.set(j + 1, tempHeight);

		                    
		                    Integer tempCourses = CopystudentCourses.get(j);
		                    CopystudentCourses.set(j, CopystudentCourses.get(j + 1));
		                    CopystudentCourses.set(j + 1, tempCourses);
		                }
		            }
		        }
			 for (int i = 0; i < CopystudentName.size(); i++) {
		            students.setValueAt(CopystudentName.get(i), i + 1, 0);
		            students.setValueAt(String.valueOf(CopystudentGPA.get(i)), i + 1, 1);
		            students.setValueAt(String.valueOf(CopystudentCourses.get(i)), i + 1, 2);
		            students.setValueAt(String.valueOf(CopystudentHeight.get(i)), i + 1, 3);
		        }
			
		}
		if(e.getActionCommand().equals("sort by name")) {

		    ArrayList<String> CopystudentName = new ArrayList<>(studentName);
		    ArrayList<Double> CopystudentHeight = new ArrayList<>(studentHeight);
		    ArrayList<Double> CopystudentGPA = new ArrayList<>(studentGPA);
		    ArrayList<Integer> CopystudentCourses = new ArrayList<>(studentCourses);


		    ArrayList<Integer> indexOrder = new ArrayList<>();
		    for (int i = 0; i < CopystudentName.size(); i++) {
		        indexOrder.add(i);
		    }


		    indexOrder.sort((i, j) -> CopystudentName.get(i).compareTo(CopystudentName.get(j)));


		    ArrayList<String> sortedNames = new ArrayList<>();
		    ArrayList<Double> sortedHeights = new ArrayList<>();
		    ArrayList<Double> sortedGPAs = new ArrayList<>();
		    ArrayList<Integer> sortedCourses = new ArrayList<>();

		    for (int i : indexOrder) {
		        sortedNames.add(CopystudentName.get(i));
		        sortedHeights.add(CopystudentHeight.get(i));
		        sortedGPAs.add(CopystudentGPA.get(i));
		        sortedCourses.add(CopystudentCourses.get(i));
		    }

		    
		    for (int i = 0; i < sortedNames.size(); i++) {
		        students.setValueAt(sortedNames.get(i), i + 1, 0);
		        students.setValueAt(String.valueOf(sortedGPAs.get(i)), i + 1, 1);
		        students.setValueAt(String.valueOf(sortedCourses.get(i)), i + 1, 2);
		        students.setValueAt(String.valueOf(sortedHeights.get(i)), i + 1, 3);
		    }
		}

	    if(e.getActionCommand().equals("add student")) {
	        Double height = Double.parseDouble(Height.getText());
	        studentHeight.add(height);
	        studentGPA.add(Double.parseDouble(GPA.getText()));
	        studentName.add(Name.getText());
	        studentCourses.add(Integer.parseInt(CoursesTaken.getText()));
	        
	        for(int i = 0; i < studentName.size(); i++) {
	            students.setValueAt(studentName.get(i), i+1, 0);  
	            students.setValueAt(String.valueOf(studentHeight.get(i)), i+1, 3);
	            students.setValueAt(String.valueOf(studentGPA.get(i)), i+1, 1);    
	            students.setValueAt(String.valueOf(studentCourses.get(i)), i+1, 2); 
	        }
	    }
	}

}
