package readingFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LotteryNumbersGUI extends JFrame implements ActionListener {
	JLabel date, results;
	JTextArea searcher;
	
	public static void main(String[] args) {
		LotteryNumbersGUI gui = new LotteryNumbersGUI();
		gui.setVisible(true);
	}
	public LotteryNumbersGUI() {
		super("Lottery Numbers and Date");
		setSize(800,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(this);
		searchButton.setBounds(25, 300, 100, 50);
		add(searchButton);
		date = new JLabel("Date: ");
		date.setBounds(25, 20, 200, 100);
		add(date);
		searcher = new JTextArea("00/00/0000");
		searcher.setBounds(200, 20, 200, 200);
		add(searcher);
		results = new JLabel("Results: ");
		results.setBounds(200,200,200,100);
		add(results);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int counted = 0;
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("SEARCH")) {
			System.out.println("searched");
			String csvFile = "Lottery_Powerball.csv";
			String line;
			String csvSplitBy = ",";
			try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
				System.out.println("file found");
				ArrayList <String> records = new ArrayList<>();
				while((line = br.readLine())!=null) {
					String [] values = line.split(csvSplitBy);
					ArrayList <String> record = new ArrayList<>();
					for(String value: values) {
						record.add(value.trim());
					}
					records.addAll(record);
				}
				for(String r: records) {
					
					System.out.println(r);
					if(counted == 1) {
						results.setText("Results: " + r);
						counted++;
					}
					if(r.contains("/") && r.equalsIgnoreCase(searcher.getText())) {
						date.setText("Date: " + r);
						
						counted++;
					}else {
						System.out.println("no dates found");
					}
					
				}
			}
			catch(IOException l) {
				System.out.println("file not found");
			}
		}
		}
	}


