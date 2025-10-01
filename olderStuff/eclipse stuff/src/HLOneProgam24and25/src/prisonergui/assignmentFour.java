package prisonergui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class assignmentFour extends JFrame implements ActionListener {
	private JButton p1steal, p1split, p2steal, p2split, reset;
	private boolean p1stealing, p2stealing;
	private boolean end1,end2, end = false;
	private JTextArea result, inst;
	private JTable dataTable;
	private String [] colNames = {"Player 1 action", "Player 2 action", "Result"};
	private String [][] data = new String[100][3];
	private int round = 0;
	public assignmentFour(){
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
				inst.setText("This game calls to mind\n the cooperative nature of the prisoners' dialemma\n if both participants pick split,\n they get to split the prize, if one chooses split\n while the other chooses steal, the one who chose steal\n gets everything, and if they both choose steal\n they both get nothing");
				reset = new JButton("reset");
				reset.setBounds(150, 300, 100, 100);
				reset.addActionListener(this);
				panel1.add(reset);
				
				tPane.add("instructions", panel1);
			JPanel panel2 = new JPanel();
			p1steal = new JButton("player 1 steal");
			p1steal.addActionListener(this);
			p1steal.setBounds(100,100,100,100);
			//x = 100, y = 100, width = 100, height = 100
			panel2.add(p1steal);
			p1split = new JButton("player 1 split");
			p1split.addActionListener(this);
			p1steal.setBounds(200,100,100,100);
			panel2.add(p1split);
			tPane.add("player1 move", panel2);
			
			JPanel panel3 = new JPanel();
			p2steal = new JButton("player 2 steal");
			p2steal.addActionListener(this);
			p2steal.setBounds(100,100,100,100);
			//x = 100, y = 100, width = 100, height = 100
			panel3.add(p2steal);
			p2split = new JButton("player 2 split");
			p2split.addActionListener(this);
			p2steal.setBounds(200,100,100,100);
			panel3.add(p2split);
			tPane.add("player2 move", panel3);
			
			JPanel panel4 = new JPanel();
			result = new JTextArea();
			result.setBounds(150,100,100,100);
			panel4.add(result);
			result.setBackground(Color.black);
			result.setForeground(Color.WHITE);
			tPane.add("results table", panel4);
			
			JPanel panel5 = new JPanel();
			dataTable = new JTable(data,colNames);
			JScrollPane scrollTable = new JScrollPane(dataTable);
				scrollTable.setBounds(50,50,400,200);
				dataTable.setBackground(Color.BLACK);
				dataTable.setForeground(Color.WHITE);
				panel5.add(scrollTable);
			tPane.add("table table", panel5);
		add(tPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("reset")) {
			p1stealing = false;
			p2stealing = false;
			p1split.setEnabled(true);
			p1steal.setEnabled(true);
			p2split.setEnabled(true);
			p2steal.setEnabled(true);
			result.setText("");
			inst.setText("This game calls to mind\n the cooperative nature of the prisoners' dialemma\n if both participants pick split,\n they get to split the prize, if one chooses split\n while the other chooses steal, the one who chose steal\n gets everything, and if they both choose steal\n they both get nothing");
			end = false;
			end1 = false;
			end2 = false;
		}
		if(e.getActionCommand().equals("player 1 steal")) {
			p1stealing = true;
			p1split.setEnabled(false);
			p1steal.setEnabled(false);
			end1 = true;
		}
		if(e.getActionCommand().equals("player 1 split")) {
			p1stealing = false;
			p1split.setEnabled(false);
			p1steal.setEnabled(false);
			end1 = true;
		}
		if(e.getActionCommand().equals("player 2 steal")) {
			p2stealing = true;
			p2split.setEnabled(false);
			p2steal.setEnabled(false);
			end2 = true;
		}
		if(e.getActionCommand().equals("player 2 split")) {
			p2stealing = false;
			p2split.setEnabled(false);
			p2steal.setEnabled(false);
			end2 = true;
		}
		if(end1&&end2) {
			end = true;
		}
		if(end) {
		if(p1stealing && p2stealing) {
			result.setText("both people stole, you both get nothing");
			dataTable.setValueAt("player 1 stole", round, 0);
			dataTable.setValueAt("player 2 stole", round, 1);
			dataTable.setValueAt("you both get nothing", round, 2);
			round++;
		}else {
			if(!p1stealing && !p2stealing) {
				result.setText("both players split");
				dataTable.setValueAt("player 1 split", round, 0);
				dataTable.setValueAt("player 2 split", round, 1);
				dataTable.setValueAt("both players split", round, 2);
				round++;
			}else {
				if(p1stealing && !p2stealing) {
				result.setText("player 1 stole all of the money");
				dataTable.setValueAt("player 1 stole", round, 0);
				dataTable.setValueAt("player 2 split", round, 1);
				dataTable.setValueAt("player 1 stole all of the money", round, 2);
				round++;
				}else {
					result.setText("player 2 stole all of the money");
					dataTable.setValueAt("player 1 split", round, 0);
					dataTable.setValueAt("player 2 stole", round, 1);
					dataTable.setValueAt("player 2 stole all of the money", round, 2);
					round++;
				}
			}
		}
	}
	}
	
}
