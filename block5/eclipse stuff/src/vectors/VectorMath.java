package vectors;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VectorMath extends JFrame implements ActionListener {
	private JTextField x1Field, y1Field, z1Field, x2Field, y2Field, z2Field;
	private JTable table;
	private String [][]data =  new String [5][4];
	private String [] colnames = {"field 1","field 2","dotProduct","magnitude"};
	public VectorMath() {
		super("Vector Mathematics");
		setSize(1000,400);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane  tabbedPanels = new JTabbedPane();
			tabbedPanels.setBounds(50,50,900,300);
			JPanel panel1 = new JPanel();
				panel1.setLayout(null);
				JLabel x1label = new JLabel("Enter in first x component:");
				x1label.setBounds(10,10,200,25);
				panel1.add(x1label);
				JLabel y1label = new JLabel("Enter in first y component:");
				y1label.setBounds(10,40,200,25);
				panel1.add(y1label);
				JLabel z1label = new JLabel("Enter in first z component:");
				z1label.setBounds(10,70,200,25);
				panel1.add(z1label);
			x1Field = new JTextField(10);
			x1Field.setBounds(200,10,75,25);
			panel1.add(x1Field);
			y1Field = new JTextField(10);
			y1Field.setBounds(200,40,75,25);
			panel1.add(y1Field);
			z1Field = new JTextField(10);
			z1Field.setBounds(200,70,75,25);
			panel1.add(z1Field);
			JLabel x2label = new JLabel("Enter in second x component:");
			x2label.setBounds(10,110,200,25);
			panel1.add(x2label);
			JLabel y2label = new JLabel("Enter in second y component:");
			y2label.setBounds(10,140,200,25);
			panel1.add(y2label);
			JLabel z2label = new JLabel("Enter in second z component:");
			z2label.setBounds(10,170,200,25);
			panel1.add(z2label);
			JButton DoProduct = new JButton("Do Product");
			DoProduct.setBounds(10,200,100,25);
			DoProduct.addActionListener(this);
			panel1.add(DoProduct);
			
		x2Field = new JTextField(10);
		x2Field.setBounds(200,110,75,25);
		panel1.add(x2Field);
		y2Field = new JTextField(10);
		y2Field.setBounds(200,140,75,25);
		panel1.add(y2Field);
		z2Field = new JTextField(10);
		z2Field.setBounds(200,170,75,25);
		panel1.add(z2Field);
	
			tabbedPanels.add(panel1,"Add vector values");
			JPanel panel2 = new JPanel();
			panel2.setLayout(null);
			tabbedPanels.add(panel2,"Table of Values");
			
			panel2.setBounds(10,10,600,300);
			table = new JTable(data,colnames);
			
			JScrollPane tablePlane = new JScrollPane(table);
			
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			table.setVisible(true);
			table.setBounds(10,10,600,300);
			
			table.setValueAt(colnames[0],0,0);
			table.setValueAt(colnames[1],0,1);
			table.setValueAt(colnames[2],0,2);
			table.setValueAt(colnames[3],0,3);
			
			panel2.add(table);
			
			
			
		add(tabbedPanels);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Do Product")) {
			table.setValueAt("<" + x1Field.getText()+ "," + y1Field.getText() + "," + z1Field.getText() + ">",1,0);
			table.setValueAt("<" + x2Field.getText()+ "," + y2Field.getText() + "," + z2Field.getText() + ">",1,1);
			//table.setValueAt("test", 2, 2);
			int doProduct = Integer.parseInt(x1Field.getText().trim())*Integer.parseInt(x2Field.getText().trim()) +
					Integer.parseInt(y1Field.getText().trim())*Integer.parseInt(y2Field.getText().trim()) +
					Integer.parseInt(z1Field.getText().trim())*Integer.parseInt(z2Field.getText().trim()); 
			
			double magnA = (Math.sqrt(Math.pow(Integer.parseInt(x1Field.getText()), 2) + Math.pow(Integer.parseInt(y1Field.getText()),2)+ Math.pow(Integer.parseInt(z1Field.getText()),2)));
			double magnb = (Math.sqrt(Math.pow(Integer.parseInt(x2Field.getText()), 2) + Math.pow(Integer.parseInt(y2Field.getText()),2)+ Math.pow(Integer.parseInt(z2Field.getText()),2)));
			System.out.println(magnA);
			System.out.println(magnb);
			table.setValueAt(String.format("%.2f", doProduct / (magnA * magnb)), 1, 3);
		}
	}
}
