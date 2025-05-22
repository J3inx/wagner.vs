package secondAbsenceThing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Graphics;


public class Triangular extends JFrame implements ActionListener, ChangeListener{
	private JPanel box;
	JButton setPoint;
	JSlider ex, why;
	JTextArea exes, whys, stat;
	int x1,y1,x2,y2,x3,y3;
	 public static void main(String [] args) {
		 Triangular gui = new Triangular();
		 gui.setVisible(true);
	 }
	 public Triangular() {
		 setTitle("make triangles");
			setSize(1000,700);
			setLayout(null);
			setBackground(new Color(220,190,150));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box = new JPanel();
			box.setBackground(new Color(210,180,140));
			box.setBounds(50,100,900,500);
		add(box);
		setPoint = new JButton("set point 1");
			setPoint.setBounds(900,50,100,25); 
			setPoint.setVisible(true);
			setPoint.addActionListener(this);
		add(setPoint);
		ex = new JSlider(0,210);
			ex.setBounds(35,10,300,50);
			ex.addChangeListener(this);
		 	ex.setMajorTickSpacing(25);
		 	ex.setPaintTicks(true);
		 	ex.addChangeListener(this);
		add(ex);
		exes = new JTextArea();
			exes.setBounds(350,20,100,25);
			exes.setText("x: 50");
			exes.setEditable(false);
		add(exes);
		why = new JSlider(0,180);
			why.setBounds(35,50,300,50);
			why.addChangeListener(this);
			why.setMajorTickSpacing(25);
			why.setPaintTicks(true);
			why.addChangeListener(this);
		add(why);
		whys = new JTextArea();
			whys.setBounds(350,60,100,25);
			whys.setText("y: 50");
			whys.setEditable(false);
			
		add(whys);
		stat = new JTextArea();
			stat.setBounds(500,20,150,50);
			stat.setText("status:");
			stat.setEditable(false);
		
		add(stat);
		Graphics g = box.getGraphics();
			}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Graphics g = box.getGraphics();
		if(e.getActionCommand().equals("set point 1")) {
			x1 = ex.getValue();
			y1 = why.getValue();
			setPoint.setText("set point 2");
			stat.setText("status:\npoint 1 has been set");
		}else if(e.getActionCommand().equals("set point 2")) {
			x2 = ex.getValue();
			y2 = why.getValue();
			setPoint.setText("set point 3");
			stat.setText("status:\npoint 2 has been set");
		}else if(e.getActionCommand().equals("set point 3")) {
			x3 = ex.getValue();
			y3 = why.getValue();
			setPoint.setText("reset");
			stat.setText("status:\npoint 3 has been set");
			draw();
		}else if(e.getActionCommand().equals("reset")) {
			setPoint.setText("set point 1");
			stat.setText("status:\npoints have been reset");
			g.clearRect(0, 0, 1000, 700);
		}
	}
	public void draw() {
		Graphics g = box.getGraphics();
		int point1x = x1;
		int point1y = y1;
		int point2x = x2;
		int point2y = y2;
		int point3x = x3;
		int point3y = y3;
		double magnA = (Math.sqrt(Math.pow((point1x-point2x),2)+ Math.pow((point1y-point2y),2)));
		double magnb = (Math.sqrt(Math.pow((point2x-point3x),2)+ Math.pow((point2y-point3y),2)));
		int doProduct = (point1x *point1y) + (point2x*point2y);
		System.out.println(doProduct / (magnA * magnb));
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		g.setColor(new Color(red, green, blue));
		g.fillOval(point1x-1, point1y, 5,5);
		g.fillOval(point2x-1, point2y, 5,5);
		g.fillOval(point3x-1, point3y, 5,5);
		g.drawLine(point1x-1, point1y+2, point2x-1,point2y+2);
		g.drawLine(point2x-1, point2y+2, point3x-1,point3y+2);
		g.drawLine(point1x-1, point1y+2, point3x-1,point3y+2);
		if((doProduct / (magnA * magnb))%1 == 0) {
			System.out.println("right");
		}else if(doProduct / (magnA * magnb)>10) {
			System.out.println("obtuse");
			
		}else if(doProduct / (magnA * magnb) < 10){
			System.out.println("acute");
		}
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		whys.setText("y: " + why.getValue());
		exes.setText("x: " + ex.getValue());
	}
}
