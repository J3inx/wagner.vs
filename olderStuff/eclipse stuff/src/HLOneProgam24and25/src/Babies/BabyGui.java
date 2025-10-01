package Babies;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class BabyGui extends JFrame implements ActionListener{
	String [] years = {null, "2007", "2008", "2009", "2010"};
	String [] gender = {"gender", "M", "F", "any"};
	private static JComboBox yearBox, genderBox;
	private JButton searchButton,splitButton, sortButton;
	private static ArrayList <Babies> b =  new ArrayList<>();
	private JTable table;
	private JTextArea nameSearch;
	private String [][]data = new String [10][2]; //10 rows 2 columns
	private String [] col = {"name and gender", "count"};
	private int x = 0;
	public BabyGui() {
		super("future names of tyler's babies");
		setSize(800,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		nameSearch = new JTextArea();
		nameSearch.setBounds(100,100,100,100);
		add(nameSearch);
		yearBox = new JComboBox(years);
		yearBox.addActionListener(this);
		yearBox.setBounds(10,10,100,20);
		genderBox = new JComboBox(gender);
		genderBox.addActionListener(this);
		genderBox.setBounds(10,10,200,20);
		add(yearBox);
		searchButton = new JButton("Search File");
		searchButton.addActionListener(this);
		searchButton.setBounds(200,10,100,20);
		add(searchButton);
		splitButton = new JButton("Split File");
		splitButton.addActionListener(this);
		splitButton.setBounds(300,10,100,20);
		add(splitButton);
		sortButton = new JButton("Sort File");
		sortButton.addActionListener(this);
		sortButton.setBounds(400,10,100,20);
		add(sortButton);
		table = new JTable(data,col);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.white);
		JScrollPane scrollTable = new JScrollPane(table);
		scrollTable.setBounds(400,100,400,400);
		add(genderBox);
		add(scrollTable);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Search File")) {
			x++;
			searchFile();
		}
		if(e.getActionCommand().equals("Split File")) {
			
			splitFile();
			table.setValueAt(b.get(0).getName()+" ", 0,0);
			table.setValueAt(b.get(1).getCount()+ " ", 0, 1);
			splitButton.setEnabled(false);
		}
	    if (e.getActionCommand().equals("Sort File")) {
	        sortTableByCount();
	    }
	
		
	}
	
	public static void splitFile() {
		String answer = yearBox.getSelectedItem().toString();
		System.out.println(answer);
		String line = "";
		String splitBy = ",";
		try {
			//parse a csv file into a bufferedReader file
			BufferedReader br = new BufferedReader(new FileReader("bnames2007.csv"));
			//skip the first line
			br.readLine();
			while((line = br.readLine())!=null) {
				String [] info = line.split(splitBy);
				System.out.println("YEAR: " + info[0]+ "NAME: " + info[1]);//+ "AMOUNT: " + info[4]);
				b.add(new Babies(info[1],info[3],Integer.parseInt(info[4])));
				
			}
		}
		catch(IOException | NumberFormatException e){
			e.printStackTrace();
		}
		
		
		
	}
	public void searchFile() {
		String searched = genderBox.getSelectedItem().toString();
		String answer = yearBox.getSelectedItem().toString();
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader("bnames2007.csv"));
			br.readLine();
			int count = 0;
			int row = 1;
			while((line = br.readLine())!=null) {
				String [] info = line.split(splitBy);
				if(info[0].equals(answer)) {
				if(info[1].equalsIgnoreCase(nameSearch.getText())) {
				if(info[3].equals(searched)|| searched.equals("any")) {
					count+= Integer.parseInt(info[4]);
					row++;
				}
				}
				}
			}

			table.setValueAt(nameSearch.getText()+ " " + genderBox.getSelectedItem().toString(), x,0);
			table.setValueAt(count+ " ", x, 1);
		}
		catch(IOException | NumberFormatException e){
			e.printStackTrace();
		}
		
		
	}
	public void sortTableByCount() {
	  
	    ArrayList<String[]> tableData = new ArrayList<>();
	    for (int i = 0; i < table.getRowCount(); i++) {
	        String nameAndGender = (String) table.getValueAt(i, 0);
	        String count = (String) table.getValueAt(i, 1);
	        if (nameAndGender != null && count != null) {
	            tableData.add(new String[]{nameAndGender, count});
	        }
	    }

	 
	    tableData.sort((a, b) -> {
	       
	        int countA = Integer.parseInt(a[1].trim());
	        int countB = Integer.parseInt(b[1].trim());
	        return Integer.compare(countB, countA); 
	    });

	   
	    for (int i = 0; i < tableData.size(); i++) {
	        table.setValueAt(tableData.get(i)[0], i, 0); 
	        table.setValueAt(tableData.get(i)[1], i, 1); 
	    }
	}
	
	
	
	
	
	
}
