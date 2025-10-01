package prisonergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tables extends JFrame implements ActionListener {
	private String [] colNames = {"Student Name", "GPA", "Favorite Animal","Sport"};
	private String [][] data = {{"Brayden","4.4","cheetah","soccer"},
								{"Greyson","2.2","guineafoulpufferfish","cross country"},
								{"Isabelle", "17", "Seal", "Run, not on a team"}
								};
	private JTable dataTable;
	
	public Tables() {
		super("Table Example");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		dataTable = new JTable(data,colNames);
		JScrollPane scrollTable = new JScrollPane(dataTable);
			scrollTable.setBounds(50,50,400,200);
			dataTable.setBackground(Color.BLACK);
			dataTable.setForeground(Color.WHITE);
		add(scrollTable);
		JButton changeButton = new JButton("change");
			changeButton.addActionListener(this);
			changeButton.setBounds(500,10,100,20);
		add(changeButton);
	}
	
	public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("change")) {
		if(dataTable.getValueAt(2, 0).equals("Isabelle")) {
			dataTable.setValueAt("Batman", 2, 0);
		}
	}
		
	}
	
}
