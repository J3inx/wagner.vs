package prisonergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class finishButtons extends JFrame implements ActionListener {
	private JButton greyson, colin;
	private JTextArea resultArea;
	public finishButtons() {
		super("The Title of the gui");
		setSize(1000,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JTabbedPane tPane = new JTabbedPane();
			tPane.setBounds(0,0,1000,500);
			JPanel panel1 = new JPanel();
			greyson = new JButton("GREYSON");
			greyson.addActionListener(this);
			greyson.setBounds(100,100,100,100);
			//x = 100, y = 100, width = 100, height = 100
			panel1.add(greyson);
			tPane.add("Date", panel1);
			colin = new JButton("COLIN");
			colin.addActionListener(this);
			colin.setBounds(200,100,100,100);
			panel1.add(colin);
			JPanel panel2 = new JPanel();
				resultArea = new JTextArea(10,10);
				resultArea.setBounds(100,100,100,100);
				resultArea.setBackground(Color.blue);
				resultArea.setForeground(Color.WHITE);
				panel2.add(resultArea);
				
			tPane.add("results",panel2);				
		
		
		add(tPane);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("GREYSON")) {
			resultArea.setText("hannah is happy colin is sad");
			greyson.setEnabled(false);
			colin.setEnabled(false);
			
		}else {
			
			greyson.setEnabled(true);
			colin.setEnabled(false);
		}
		
	}

}
