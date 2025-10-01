package prisonergui;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrisonerDilemma extends JFrame implements ActionListener {
	private JLabel option1label;
	public PrisonerDilemma() {
		super("Prisoner's Dilemma");
		setSize(1000,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JButton henryQuietButton = new JButton("not speaking");
			henryQuietButton.addActionListener(this);
			henryQuietButton.setForeground(Color.BLUE);
			henryQuietButton.setVisible(true);
			henryQuietButton.setBounds(100, 75, 134, 29);
			add(henryQuietButton);
		option1label = new JLabel("henry 5 years prison");
			option1label.setForeground(Color.blue);
			option1label.setVisible(false);
			option1label.setBounds(100,105,134,29);
			add(option1label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("not speaking")) {
			option1label.setVisible(true);
		}
			
	}
	
}
