package GUIS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TriangleGUI extends JFrame implements ActionListener{
	public static void main(String [] args) {
		TriangleGUI gui = new TriangleGUI();
		gui.setVisible(true);
		
		}
	public TriangleGUI() {
		setSize(500,400);
		setTitle("triangle identifier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
