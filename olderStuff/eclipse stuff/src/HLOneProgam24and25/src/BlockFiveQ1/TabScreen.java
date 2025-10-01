package BlockFiveQ1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabScreen extends JFrame implements ActionListener {
	private JLabel aLabel;
	public TabScreen() {
		super("Split Screen Mode");
		setSize(1000,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JTabbedPane tPane = new JTabbedPane();
		
			tPane.setBounds(0,0,1000,500);
			JPanel panel1 = new JPanel();
				JButton aButton = new JButton("A Button");
				aButton.addActionListener(this);
				aButton.setBounds(500,200,30,90);
				panel1.add(aButton);
			tPane.add("hannah's tab", panel1);
			JPanel panel2 = new JPanel();
				 aLabel = new JLabel("A Label"); //private variable atm
				aLabel.setBounds(100,200,50,300);
				panel2.add(aLabel);
			tPane.add("isabel's Tab",panel2);
		add(tPane);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("A Button")) {
			aLabel.setText("Colin");
		}
		
	}
	
}
