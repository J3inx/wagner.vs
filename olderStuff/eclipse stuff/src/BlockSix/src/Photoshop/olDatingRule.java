package Photoshop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class olDatingRule extends JFrame implements ActionListener{
	private JTextField nameField, ageField;
	private JTextArea dataArea, outputArea;
	public static void main(String [] args) throws IOException
	{
		olDatingRule gui = new olDatingRule();
		gui.setVisible(true);
		
	}
	public olDatingRule() throws IOException
	{
		super("Old Dating Rules");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JLabel nameLabel = new JLabel("NAME: ");
		nameLabel.setBounds(10,10,100,50);
		add(nameLabel);
		JLabel ageLabel = new JLabel("AGE: ");
		ageLabel.setBounds(10,110,200,50);
		add(ageLabel);
		nameField = new JTextField(10);//number is how many capital W will fit inside
		nameField.setBounds(110,10,100,50);
		add(nameField);
		ageField = new JTextField(10);//number is how many capital W will fit inside
		ageField.setBounds(110,110,100,25);
		add(ageField);
		dataArea = new JTextArea(10,10);
		dataArea.setBounds(10,100,200,200);
		add(dataArea);
		dataArea.setBackground(Color.red);
		JButton goButton = new JButton("Go");
		goButton.setBounds(200,50,75,25);
		goButton.addActionListener(this);
		add(goButton);
		outputArea = new JTextArea(10,10);
		outputArea.setBounds(300,100,200,200);
		add(outputArea);
		outputArea.setBackground(Color.gray);
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Go")) {
			String ageString = ageField.getText();
			int age = Integer.parseInt(ageString);
			if((age/2)+7 >= 18) {
				//set text in box to say min
				//set max to (age-7)*2
				outputArea.setText("minimum age: " + ((age/2)+7) +  ("\n maximum age: ") + (age-7)*2 );
			}else {
				//set the text to 18
				//set max to (age-7)*2
				outputArea.setText("minimum age: " + (age-1) +  ("\n maximum age: ") + (age-7)*2 );
				
			}
			
		}
		
	}

	
	
}
