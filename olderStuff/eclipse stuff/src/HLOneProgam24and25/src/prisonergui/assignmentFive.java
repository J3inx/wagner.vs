package prisonergui;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
//new longest code written entirely by me
public class assignmentFive extends JFrame implements ActionListener {
	private JTextArea inst, question, dateEnter;
	private JButton submit;
	private String date;
	private int currentQuestion = 1, temp;
	private String questionOne = "the earth is round";
	private String questionTwo = "your computer is charged";
	private String questionThree = "aaron brings a gatorade bottle to class";
	private String questionFour = "the time is 12:01";
	private String questionFive = "we already finished our unit on networks";
	private String questionSix = "brayden always finishes his work on time";
	private String questionSeven = "we cant have our phones during class";
	private String questionEight = "the admin team blocked roblox";
	private String questionNine = "roblox is good";
	private String questionTen = "john get his work done on time";
	private int score = 0;
	private JTextArea results;
	private JTable table;
	private JButton falth, truth;
	private Scanner kb = new Scanner(System.in);
	
	
	private String myResponseOne, myResponseTwo, myResponseThree, myResponseFour, myResponseFive, myResponseSix, myResponseSeven, myResponseEight, myResponseNine, myResponseTen;	
	private String [] colNames = {"question number", "question text", "correct answer", "your answer", "result"};
	private String [][] data = new String[11][5];
	
	public assignmentFive() {
		super("rocker");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JTabbedPane tPane = new JTabbedPane();
			tPane.setBounds(0,0,1000,1000);
			JPanel panel1 = new JPanel();
				inst = new JTextArea();
				inst.setBounds(150,100,100,100);
				panel1.add(inst);
				inst.setBackground(Color.black);
				inst.setForeground(Color.WHITE);
				inst.setText("Welcome to the Random Trivia Quiz! \n You will be asked 10 random trivia questions.\n For each question, select or type your answer and press submit.\n After each submission, you will know if your answer was correct or incorrect,\n and your results will be recorded in a table");
				tPane.add("instructions", panel1);
				
			JPanel panel2 = new JPanel();
				 truth = new JButton("true");
				truth.setBounds(450,500,100,100);
				truth.addActionListener(this);
				 falth = new JButton("false");
				falth.setBounds(550,500,100,100);
				falth.addActionListener(this);
				question = new JTextArea();
				question.setText(questionOne);
				question.setBounds(150,100,100,100);
				panel2.add(question);
				panel2.add(truth);
				panel2.add(falth);
				
			tPane.add("quiz",panel2);
			
			JPanel panel3 = new JPanel();
				results = new JTextArea();
				JButton refresher = new JButton("refresh");
				JButton reset = new JButton("reset");
				JButton save = new JButton("save");
				save.setBounds(200,100,100,100);
				refresher.setBounds(150,100,100,100);
				reset.setBounds(100,100,100,100);
				table = new JTable(data,colNames);
				table.setBounds(250,250, 900, 500);
				table.setBackground(Color.BLACK);
				table.setForeground(Color.WHITE);
				table.setValueAt("#", 0, 0);
				table.setValueAt("value", 0, 1);
				table.setValueAt("correct answer", 0, 2);
				table.setValueAt("your answer", 0, 3);
				table.setValueAt("outcome", 0, 4);
				panel3.add(table);
				dateEnter = new JTextArea();
				dateEnter.setBounds(200,100,200,200);
				panel3.add(dateEnter);
				submit = new JButton("submit");
				submit.setBounds(150,100,200,200);
				panel3.add(submit);
				refresher.addActionListener(this);
				reset.addActionListener(this);
				save.addActionListener(this);
				submit.addActionListener(this);
				panel3.add(save);
				panel3.add(refresher);
				panel3.add(results);
				panel3.add(reset);
				submit.setEnabled(false);
				dateEnter.setEnabled(false);
				submit.setVisible(false);
				dateEnter.setVisible(false);
			tPane.add("results", panel3);
			add(tPane);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("refresh")) {
			results.setText("you got " + score + "/10!");
		}
		if(e.getActionCommand().equals("submit")) {
			PrintWriter outputStream = null;
			date = dateEnter.getText();
			temp = 0;
			try {
				outputStream = new PrintWriter(new FileOutputStream("TestScores",true));
				//the true allows it to "append" or to add to something after the last added value
				
			}
			catch(FileNotFoundException e1) {
				System.out.println("Error: file not found");
				System.exit(0);
			}
			outputStream.println("date of test:");
			outputStream.println(date);
			outputStream.println("table of your answers: ");
			for(int y = 0; y <11; y++) {
			for(int x = 0;x<4; x++) {
			outputStream.print(table.getValueAt(y, x)+ "\t ");	
			}
			outputStream.println("");
			}
			
			outputStream.println("your score:");
			outputStream.println(score);
			//have to close a stream, printer, or a scanner after opening it
			outputStream.close();
			kb.close();
			System.out.println("we have written to a file");
				
			
			
			
		}
		if(e.getActionCommand().equals("save")) {
	
			
			dateEnter.setText("please enter the date in MM/DD/YY format:");
			
				submit.setEnabled(true);
				dateEnter.setEnabled(true);
				submit.setVisible(true);
				dateEnter.setVisible(true);
				
				while(temp == 1) {
					
				}
			System.out.println("please enter the date in MM/DD/YY format: ");
			


		}
		if(e.getActionCommand().equals("reset")) {
			currentQuestion = 1;
			question.setText(questionOne);
			score = 0;
			results.setText("");
			falth.setEnabled(true);
			falth.setVisible(true);
			truth.setEnabled(true);
			truth.setEnabled(true);
			table.removeAll();
			for(int i =1; i<11; i++) {
				table.setValueAt("", i, 0);
				table.setValueAt("", i, 1);
				table.setValueAt("", i, 2);
				table.setValueAt("", i, 3);
				table.setValueAt("", i, 4);
			}
		}
		if(e.getActionCommand().equals("true")||e.getActionCommand().equals("false")) {
			if(e.getActionCommand().equals("true")) {
				if(currentQuestion == 1) {
					score++;
					myResponseOne = "true";
					table.setValueAt("1", 1, 0);
					table.setValueAt(questionOne, 1, 1);
					table.setValueAt("true", 1, 2);
					table.setValueAt(myResponseOne, 1, 3);
					table.setValueAt("right", 1, 4);
					currentQuestion = 2;
					question.setText(questionTwo);
				}else {
					if(currentQuestion == 2) {
						score++;
						myResponseTwo = "true";
						currentQuestion = 3;
						table.setValueAt("2", 2, 0);
						table.setValueAt(questionTwo, 2, 1);
						table.setValueAt("true", 2, 2);
						table.setValueAt(myResponseTwo, 2, 3);
						table.setValueAt("right", 2, 4);
						question.setText(questionThree);
					}else {
						if(currentQuestion == 3) {
							currentQuestion = 4;
							myResponseThree = "true";
							table.setValueAt("3", 3, 0);
							table.setValueAt(questionThree, 3, 1);
							table.setValueAt("false", 3, 2);
							table.setValueAt(myResponseThree, 3, 3);
							table.setValueAt("wrong", 3, 4);
							question.setText(questionFour);
						}else {
							if(currentQuestion == 4) {
								currentQuestion = 5;
								myResponseFour = "true";
								table.setValueAt("4", 4, 0);
								table.setValueAt(questionFour, 4, 1);
								table.setValueAt("false", 4, 2);
								table.setValueAt(myResponseFour, 4, 3);
								table.setValueAt("wrong", 4, 4);
								question.setText(questionFive);
							}else {
								if(currentQuestion == 5) {
									currentQuestion = 6;
									myResponseFive = "true";
									table.setValueAt("5", 5, 0);
									table.setValueAt(questionFive, 5, 1);
									table.setValueAt("false", 5, 2);
									table.setValueAt(myResponseFive, 5, 3);
									table.setValueAt("wrong", 5, 4);
									question.setText(questionSix);
								}else {
									if(currentQuestion == 6) {
										currentQuestion = 7;
										myResponseSix = "true";
										table.setValueAt("6", 6, 0);
										table.setValueAt(questionOne, 6, 1);
										table.setValueAt("false", 6, 2);
										table.setValueAt(myResponseSix, 6, 3);
										table.setValueAt("wrong", 6, 4);
										question.setText(questionSeven);
									}else {
										if(currentQuestion == 7) {
											score++;
											currentQuestion = 8;
											myResponseSeven = "true";
											table.setValueAt("7", 7, 0);
											table.setValueAt(questionSeven, 7, 1);
											table.setValueAt("true", 7, 2);
											table.setValueAt(myResponseSeven, 7, 3);
											table.setValueAt("right", 7, 4);
											question.setText(questionEight);
										}else {
											if(currentQuestion == 8) {
												score++;
												currentQuestion = 9;
												myResponseEight = "true";
												table.setValueAt("8", 8, 0);
												table.setValueAt(questionEight, 8, 1);
												table.setValueAt("true", 8, 2);
												table.setValueAt(myResponseEight, 8, 3);
												table.setValueAt("right", 8, 4);
												question.setText(questionNine);
											}else {
												if(currentQuestion == 9) {
													score++;
													currentQuestion = 10;
													myResponseNine = "true";
													table.setValueAt("9", 9, 0);
													table.setValueAt(questionOne, 9, 1);
													table.setValueAt("true", 9, 2);
													table.setValueAt(myResponseNine, 9, 3);
													table.setValueAt("right", 9, 4);
													question.setText(questionTen);
												}else {
													if(currentQuestion == 10) {
														score++;
														myResponseTen = "true";
														table.setValueAt("10", 10, 0);
														table.setValueAt(questionTen, 10, 1);
														table.setValueAt("true", 10, 2);
														table.setValueAt(myResponseTen, 10, 3);
														table.setValueAt("right", 10, 4);
														question.setText("the quiz is finished, go to the results tab to see your results!");
														currentQuestion = 11;
														falth.setEnabled(false);
														falth.setVisible(false);
														truth.setEnabled(false);
														truth.setEnabled(false);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if(e.getActionCommand().equals("false")) {
				if(currentQuestion == 1) {
					currentQuestion = 2;
					myResponseOne = "false";
					question.setText(questionTwo);
					table.setValueAt("1", 1, 0);
					table.setValueAt(questionOne, 1, 1);
					table.setValueAt("true", 1, 2);
					table.setValueAt(myResponseOne, 1, 3);
					table.setValueAt("wrong", 1, 4);
				}else {
					if(currentQuestion == 2) {
						currentQuestion = 3;
						myResponseTwo = "false";
						table.setValueAt("2", 2, 0);
						table.setValueAt(questionTwo, 2, 1);
						table.setValueAt("true", 2, 2);
						table.setValueAt(myResponseTwo, 2, 3);
						table.setValueAt("wrong", 2, 4);
						question.setText(questionThree);
					}else {
						if(currentQuestion == 3) {
							score++;
							myResponseTwo = "false";
							currentQuestion = 4;
							table.setValueAt("3", 3, 0);
							table.setValueAt(questionThree, 3, 1);
							table.setValueAt("false", 3, 2);
							table.setValueAt(myResponseThree, 3, 3);
							table.setValueAt("right", 3, 4);
							question.setText(questionFour);
						}else {
							if(currentQuestion == 4) {
								score++;
								currentQuestion = 5;
								myResponseFour = "false";
								table.setValueAt("4", 4, 0);
								table.setValueAt(questionFour, 4, 1);
								table.setValueAt("false", 4, 2);
								table.setValueAt(myResponseFour, 4, 3);
								table.setValueAt("right", 4, 4);
								question.setText(questionFive);
							}else {
								if(currentQuestion == 5) {
									score++;
									myResponseFive= "false";
									currentQuestion = 6;
									table.setValueAt("5", 3, 0);
									table.setValueAt(questionFive, 5, 1);
									table.setValueAt("false", 5, 2);
									table.setValueAt(myResponseFive, 5, 3);
									table.setValueAt("right", 5, 4);
									question.setText(questionSix);
								}else {
									if(currentQuestion == 6) {
										score++;
										myResponseSix= "false";
										currentQuestion = 7;
										table.setValueAt("6", 6, 0);
										table.setValueAt(questionSix, 6, 1);
										table.setValueAt("false", 6, 2);
										table.setValueAt(myResponseSix, 6, 3);
										table.setValueAt("right", 6, 4);
										question.setText(questionSeven);
									}else {
										if(currentQuestion == 7) {
											currentQuestion = 8;
											myResponseSeven= "false";
											table.setValueAt("7", 7, 0);
											table.setValueAt(questionSeven, 7, 1);
											table.setValueAt("true", 7, 2);
											table.setValueAt(myResponseSeven, 7, 3);
											table.setValueAt("wrong", 7, 4);
											question.setText(questionEight);
										}else {
											if(currentQuestion == 8) {
												currentQuestion = 9;
												myResponseEight= "false";
												table.setValueAt("8", 8, 0);
												table.setValueAt(questionEight, 8, 1);
												table.setValueAt("true", 8, 2);
												table.setValueAt(myResponseEight, 8, 3);
												table.setValueAt("wrong", 8, 4);
												question.setText(questionNine);
											}else {
												if(currentQuestion == 9) {
													currentQuestion = 10;
													myResponseNine= "false";
													table.setValueAt("9", 9, 0);
													table.setValueAt(questionNine, 9, 1);
													table.setValueAt("true", 9, 2);
													table.setValueAt(myResponseNine, 9, 3);
													table.setValueAt("wrong", 9, 4);
													question.setText(questionTen);
												}else {
													if(currentQuestion == 10) {
														myResponseTen= "false";
														table.setValueAt("10", 10, 0);
														table.setValueAt(questionTen, 10, 1);
														table.setValueAt("true", 10, 2);
														table.setValueAt(myResponseTen, 10, 3);
														table.setValueAt("wrong", 10, 4);
														question.setText("the quiz is finished, go to the results tab to see your results!");
														currentQuestion = 11;
														falth.setEnabled(false);
														falth.setVisible(false);
														truth.setEnabled(false);
														truth.setEnabled(false);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
